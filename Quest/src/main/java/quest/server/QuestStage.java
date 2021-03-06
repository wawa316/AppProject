package quest.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quest.client.App;

import java.util.ArrayList;

public abstract class QuestStage {

    private static final Logger logger = LogManager.getLogger(App.class);

    private ArrayList<Player> participatingPlayers;
    QuestStage(){}
    QuestStage(ArrayList<Player> participatingPlayers){
        logger.info("Successfully called : questStage constructor.");
        logger.info("Setting quest stage participants");
        this.participatingPlayers = participatingPlayers;
    }

    public ArrayList<Player> getParticipatingPlayers() {
        logger.info("Returning quest stage participants");
        return participatingPlayers;
    }
    public void setParticipatingPlayers(ArrayList<Player> participatingPlayers){
        this.participatingPlayers = participatingPlayers;
    }

}
