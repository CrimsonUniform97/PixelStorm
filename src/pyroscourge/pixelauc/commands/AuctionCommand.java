package pyroscourge.pixelauc.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spongepowered.api.Server;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;

import pyroscourge.pixelauc.PixelmonAuctions;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

public class AuctionCommand implements CommandCallable {
	private final Server server;
	private static final Text CMD_USAGE = new Text.Literal(TextColors.WHITE, TextStyles.NONE, ImmutableList.of(), null /* TODO Add clickAction (suggest this command) */, null, null, "/<command> <pixelmon|p> <slot> [price] [increment] [time] OR /<command> <item|i> [amount] [price] [increment] [time]");
	private static final Optional<Text> SHORT_DESC = Optional.of(new Text.Literal(TextColors.WHITE, TextStyles.NONE, ImmutableList.of(), null, null, null, "Creates a new auction"));
	private static final Optional<Text> CMD_HELP = Optional.of(new Text.Literal(TextColors.WHITE, TextStyles.NONE, ImmutableList.of(), null, null, null, "Creates a new auction of either a Pixelmon or an item. If it is an item, the held item will be auctioned. <slot> is the slot of the Pixelmon. [price] is the minimum price. [increment] is the minimum price increment. [time] is how many seconds the item/pixelmon will be auctioned for."));
	private static final Map<Integer, List<String>> SUGGESTIONS = new HashMap<>();
	
	static {
		SUGGESTIONS.put(0, Arrays.asList(new String[] {"pixelmon", "item"}));
	}
	
	public AuctionCommand(Server server) {
		this.server = server;
	}
	
	@Override
	public Optional<CommandResult> process(CommandSource source, String arguments) throws CommandException {
		return null;	// TODO Incomplete
	}

	@Override
	public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
		return SUGGESTIONS.get(arguments.length());
	}

	@Override
	public boolean testPermission(CommandSource source) {
		return source.hasPermission(String.format("%s.%s", PixelmonAuctions.PLUGIN_ID, "auction"));
	}

	@Override
	public Optional<Text> getShortDescription(CommandSource source) {
		return SHORT_DESC;
	}

	@Override
	public Optional<Text> getHelp(CommandSource source) {
		return CMD_HELP;
	}

	@Override
	public Text getUsage(CommandSource source) {
		return CMD_USAGE;
	}

}
