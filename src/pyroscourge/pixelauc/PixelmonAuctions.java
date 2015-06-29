package pyroscourge.pixelauc;

import net.minecraftforge.fml.common.Mod.EventHandler;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandMapping;

import pyroscourge.pixelauc.auction.AuctionQueue;
import pyroscourge.pixelauc.commands.AuctionCommand;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.pixelmonmod.pixelmon.api.events.ThrowPokeballEvent;

@Plugin(id = PixelmonAuctions.PLUGIN_ID, name = PixelmonAuctions.PLUGIN_NAME, version = PixelmonAuctions.PLUGIN_VERSION)
public class PixelmonAuctions {
	public static final String PLUGIN_ID = "pixelauc";
	public static final String PLUGIN_NAME = "Pixelmon Auctions";
	public static final String PLUGIN_VERSION = "${version}";
	
	public static AuctionQueue queue;
	
	@Inject
	private Logger logger;
	@Inject
	private Game game;
	private CommandService cmdService;
	
	@Subscribe
	public void onInitialization(InitializationEvent event) {
		logger.info("{} - Version {}", PLUGIN_NAME, PLUGIN_VERSION);
		cmdService = game.getCommandDispatcher();
		queue = new AuctionQueue(game.getScheduler(), game.getServer());
		registerCommand(new AuctionCommand(queue), "auction", "auc");
	}
	
	@EventHandler
	public void onThrowPokeball(ThrowPokeballEvent event) {
		logger.info("A player threw a Pokéball!");
	}
	
	private Optional<CommandMapping> registerCommand(CommandCallable command, String... alias) {
		if (alias.length < 1)
			return null;
		logger.debug("Adding Command: \"{}\"", alias[0]);
		return this.cmdService.register(this, command, alias);
	}
}