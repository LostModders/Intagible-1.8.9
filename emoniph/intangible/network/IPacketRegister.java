package emoniph.intangible.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.relauncher.Side;

public abstract interface IPacketRegister
{
  public abstract <REQ extends IMessage, REPLY extends IMessage> void registerPacket(Class<? extends IMessageHandler<REQ, REPLY>> paramClass, Class<REQ> paramClass1, Side paramSide);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/network/IPacketRegister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */