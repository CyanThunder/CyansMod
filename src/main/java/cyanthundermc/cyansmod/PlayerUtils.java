package cyanthundermc.cyansmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class PlayerUtils {
    public static void sendChat(EntityPlayer player, String chatMessage) {
        player.addChatMessage(new ChatComponentText(chatMessage));
    }
}
