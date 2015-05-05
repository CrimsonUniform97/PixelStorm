package pyroscourge.pixelauc;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.entity.player.PlayerJoinEvent;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.service.command.CommandService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.title.Title;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandMapping;

import pyroscourge.pixelauc.commands.AuctionCommand;

import com.google.common.base.Optional;
import com.google.inject.Inject;

public class PixelmonAuctions {
	public static final String PLUGIN_ID = "pixelauc";
	public static final String PLUGIN_NAME = "Pixelmon Auctions";
	public static final String PLUGIN_VERSION = "${version}";
	
	@Inject
	private Logger logger;
	@Inject
	private Game game;
	@Inject
	private CommandService cmdService;
	
	@Subscribe
	public void onInitialization(InitializationEvent event) {
		registerCommand(new AuctionCommand(game.getServer()), "auction", "auc");
	}
	
	@Subscribe
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendTitle(new Title(new Text.Literal(TextColors.AQUA, TextStyles.NONE, null, null, null, null, "Welcome!"), new Text.Literal(TextColors.GOLD, TextStyles.NONE, null, null, null, null, "Day " + event.getPlayer().getWorld().getWeather().getName()), 20, 100, 20, true, false));
	}
	
	private Optional<CommandMapping> registerCommand(CommandCallable command, String... alias) {
		if (alias.length < 1)
			return null;
		logger.debug("Adding Command: \"{}\"", alias[0]);
		return this.cmdService.register(this, command, alias);
	}
}