package cyanthundermc.cyansmod;

import cyanthundermc.cyansmod.proxy.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

    public final static String EXT_PROP_NAME = "CMExtPlayer";
    private final EntityPlayer player;
    private boolean AntiWitherEffect;

    public ExtendedPlayer(EntityPlayer player) {
        this.player = player;
        this.AntiWitherEffect = false;
    }

    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
    }

    public static ExtendedPlayer get(EntityPlayer player) {
        return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound prop = new NBTTagCompound();

        prop.setBoolean(PropTypes.AntiWitherEffect, this.AntiWitherEffect);

        compound.setTag(EXT_PROP_NAME, prop);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound prop = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);

        this.AntiWitherEffect = prop.getBoolean(PropTypes.AntiWitherEffect);
    }

    @Override
    public void init(Entity entity, World world) {

    }

    public boolean getProperty(String prop) {
        return BProp(prop);
    }

    public boolean BProp(String prop) {
        if (prop == PropTypes.AntiWitherEffect) {
            return this.AntiWitherEffect;
        }
        return false;
    }

    public void toggleProperty(String prop) {
        if (prop == PropTypes.AntiWitherEffect) {
            this.AntiWitherEffect = !this.AntiWitherEffect;
        }
    }

    private static String getSaveKey(EntityPlayer player) {
        return player.getDisplayName() + ":" + EXT_PROP_NAME;
    }

    public static void saveProxyData(EntityPlayer player) {
        ExtendedPlayer playerData = ExtendedPlayer.get(player);
        NBTTagCompound savedData = new NBTTagCompound();

        playerData.saveNBTData(savedData);
        CommonProxy.storeEntityData(getSaveKey(player), savedData);
    }

    public static void loadProxyData(EntityPlayer player) {
        ExtendedPlayer playerData = ExtendedPlayer.get(player);
        NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

        if(savedData != null) {
            playerData.loadNBTData(savedData);
        }
        playerData.syncProperties();
    }

    public void syncProperties() {
    }

    public static class PropTypes {
        public final static String AntiWitherEffect = "AntiWitherEffect";
    }
}
