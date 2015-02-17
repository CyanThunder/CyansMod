package cyanthundermc.cyansmod;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cyanthundermc.cyansmod.lib.Constants;
import io.netty.buffer.ByteBuf;

public class PacketHandler{

    public static SimpleNetworkWrapper networkWrapper;

    public static void init() {
        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MODID);
        networkWrapper.registerMessage(PacketHandler.MyMessage.Handler.class, PacketHandler.MyMessage.class, 0, Side.SERVER);
    }

    public static class MyMessage implements IMessage {

        private String text;

        public MyMessage() {}

        public MyMessage(String text) {
            this.text = text;
        }

        @Override
        public void fromBytes(ByteBuf buf) {
            text = ByteBufUtils.readUTF8String(buf);
        }

        @Override
        public void toBytes(ByteBuf buf) {
            ByteBufUtils.writeUTF8String(buf, text);
        }

        public static class Handler implements IMessageHandler<MyMessage, IMessage> {

            @Override
            public IMessage onMessage(MyMessage message, MessageContext ctx) {
                //System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
                return null;
            }
        }
    }
}