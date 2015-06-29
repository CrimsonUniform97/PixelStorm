package pyroscourge.pixelauc.auction;

import java.util.List;

import org.spongepowered.api.Server;
import org.spongepowered.api.service.scheduler.SchedulerService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import com.google.common.collect.ImmutableList;

public class AuctionQueue {
	private final SchedulerService scheduler;
	private final Server server;
	private List<Auction> queue;
	private Auction currentAuction;
	
	private Runnable startAuction;
	
	public AuctionQueue(SchedulerService scheduler, Server server) {
		this.scheduler = scheduler;
		this.server = server;
		
		this.startAuction = () -> {
			server.getBroadcastSink().sendMessage(new Text.Literal(TextColors.BLUE, TextStyles.NONE, ImmutableList.of(), null, null, null, "Blah blah blah, player, blah, item, blah blah blah blah, price, etc"));
			// TODO Get time left for auction, schedule announceTimeLeft, schedule decrementTime
			// TODO Schedule end & stuff
		};
	}
	
	public boolean addToQueue(Auction auction) {
		if (queue.size() > 2)
			return false;
		queue.add(auction);
		return true;
	}
	
	// TODO Replace all these with Runnables defined by Lambda Expressions (because why not?)
	private void announceTimeLeft() {
		
	}
	
	private void decrementTimeLeft() {
		
	}
	
	private void endAuction() {
		
	}
}