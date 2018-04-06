package quest.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quest.client.App;

public class Ally extends AdventureCard {

    private static final Logger logger = LogManager.getLogger(App.class);
    String affectedEntity;
    public Ally(String paramName, String paramImageFilename, int paramBattlePoints, int paramBids, int paramBonusBattlePoints, int paramBonusBids, String paramAffectedEntities)
    {
        super(paramName, paramImageFilename);
        battlePoints = paramBattlePoints;
        bids = paramBids;
        bonusBattlePoints = paramBonusBattlePoints;
        bonusBids = paramBonusBids;
        affectedEntity = "";
        logger.info("Successfully called : Ally Card constructor");

    }

    public String getAffectedEntity() {
        return affectedEntity;
    }
    @Override
    public void setWasUsed(boolean state) {}

}