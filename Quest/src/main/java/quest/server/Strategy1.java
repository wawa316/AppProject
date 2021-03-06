package quest.server;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quest.client.App;

class Strategy1 extends AbstractAI {

    private static final Logger logger = LogManager.getLogger(App.class);

    Strategy1(String paramName)
    {
        super(paramName);
        this.strategy ="Strategy 1 was used";
        this.TournamentAnswer = new DoIParticipateInTournamentStrategy1();
        this.nextBid= new NextBidStrategy1();
        this.quest= new DoIParticipateInQuestStrategy1();
        this.sponsorQuest = new DoISponsorAQuestStrategy1();

        logger.info("Successfully called : AI Strategy 1 constructor for"+this.getPlayerName()+".");
    }
}
