package world.anhgelus.biotechnica;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import world.anhgelus.biotechnica.command.TrackCommand;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;

public class BioTechnica implements ModInitializer {

    public static final String MOD_ID = "biotechnica";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("foo")
            .executes(TrackCommand::register)));
    }
}
