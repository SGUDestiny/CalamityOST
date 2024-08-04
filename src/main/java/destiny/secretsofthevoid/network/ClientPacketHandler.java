package destiny.secretsofthevoid.network;

import destiny.secretsofthevoid.init.CapabilitiesInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class ClientPacketHandler
{
    public static void handleUpdateBreathingPacket(UpdateBreathingPacket packet)
    {
        getPlayer().ifPresent(
                player -> player.getCapability(CapabilitiesInit.BREATHING).ifPresent(
                        cap -> {
                            cap.setOxygen(packet.oxygen);
                            cap.setMaxOxygen(packet.maxOxygen);
                            cap.setOxygenModifier(packet.oxygenModifier);
                        })
        );
    }


    public static Optional<Level> getLevel()
    {
        Minecraft minecraft = Minecraft.getInstance();

        return minecraft.level == null ? Optional.empty() : Optional.of(Minecraft.getInstance().level);
    }

    public static Optional<LocalPlayer> getPlayer()
    {
        Minecraft minecraft = Minecraft.getInstance();

        return minecraft.player == null ? Optional.empty() : Optional.of(Minecraft.getInstance().player);
    }
}
