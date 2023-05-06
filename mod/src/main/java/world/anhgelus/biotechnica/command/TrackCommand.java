package world.anhgelus.biotechnica.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import world.anhgelus.biotechnica.BioTechnica;

public class TrackCommand {
    public static int register(CommandContext<ServerCommandSource> context) {
        final ServerCommandSource source = context.getSource();
        final var player = source.getPlayer();
        if (player == null) {
            return -1;
        }
        player.sendMessage(Text.translatable(BioTechnica.MOD_ID + ".command.track.searching"));
        source.
        return 0;
    }
}
