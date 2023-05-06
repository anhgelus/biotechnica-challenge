package world.anhgelus.biotechnica.command;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtIntArray;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.List;

public class TrackCommand {
    public static int register(CommandContext<ServerCommandSource> context) {
        final ServerCommandSource source = context.getSource();
        final var player = source.getPlayer();
        if (player == null) {
            return -1;
        }
        player.sendMessage(Text.translatable("Searching for the nearest player..."));
        final var list = source.getServer().getPlayerManager().getPlayerList();
        if (list.size() < 2) {
            player.sendMessage(Text.translatable("No player was found."));
            return 0;
        }
        final var focusList = list.stream().filter(p -> !p.equals(player)).toList();
        if (focusList.isEmpty()) {
            player.sendMessage(Text.literal("No player was found."));
            return 0;
        }
        final ServerPlayerEntity[] closest = {focusList.get(0)};
        focusList.forEach(p -> {
            if (!p.isPlayer()) {
                return;
            }
            final var focus = (ServerPlayerEntity) p;
            final var distance = player.getPos().distanceTo(focus.getPos());
            if (distance < player.getPos().distanceTo(closest[0].getPos())) {
                closest[0] = focus;
            }
        });
        player.sendMessage(Text.literal("The closest player is " + closest[0].getDisplayName().getString() + "."));
        final var is = new ItemStack(Items.COMPASS);
        if (!player.getInventory().contains(is)) {
            player.getInventory().offerOrDrop(is);
        };
        final var index = player.getInventory().indexOf(is);
        final var item = player.getInventory().getStack(index);
        if (!item.isOf(Items.COMPASS)){
            return -3;
        }
        final var nbt = item.getOrCreateNbt();
        nbt.putString("LodestoneDimension", closest[0].getEntityWorld().getRegistryKey().getValue().toString());
        nbt.putString("LodestoneTracked", "1");
        final var coords = new NbtIntArray(List.of((int) closest[0].getPos().getX(), (int) closest[0].getPos().getY(), (int) closest[0].getPos().getZ()));
        nbt.put("LodestonePos", coords);
        player.sendMessage(Text.literal("Coords set!"));
        return 1;
    }
}
