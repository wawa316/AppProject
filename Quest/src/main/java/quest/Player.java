package quest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


enum Rank {SQUIRE, KNIGHT, CHAMPION_KNIGHT, KNIGHT_OF_THE_ROUND_TABLE;
    public Rank next()
    {
        if(ordinal() >= Rank.values().length)
        {
            return null;
        }
        else
        {
            return Rank.values()[ordinal() + 1];
        }
    }
}

public class Player {

    private static final Logger logger = LogManager.getLogger(App.class);

    private String playerName;
    private int battlePoints;
    private int shields;
    private int currentBid;
    private Rank playerRank;
    private ArrayList<AdventureCard> cardsOnTable = new ArrayList<>();
    private ArrayList<AdventureCard> cardsInHand = new ArrayList<>();

    Player(String paramName){
        playerName = paramName ;
        shields = 0;
        battlePoints =0;
        currentBid = 0;
        playerRank = Rank.SQUIRE;
        logger.info("Successfully called : Player constructor.");
    }

    public ArrayList<AdventureCard> getCardsOnTable()
    {
        logger.info("Returning " + this.playerName+ " cards on table.");
        return cardsOnTable;
    }

    public ArrayList<AdventureCard> getCardsInHand()
    {
        logger.info("Returning " + this.playerName+ " cards on hand.");
        return cardsInHand;
    }

    public String getPlayerName()
    {
        logger.info("Returning " + this.playerName+ ".");
        return playerName;
    }
    
    public int getShields()
    {
        logger.info("Returning " + this.playerName+ " # shields.");
        return shields;
    }
    
    public Rank getPlayerRank()
    {
        logger.info("Returning " + this.playerName+ " rank.");
        return playerRank;
    }
    
    public int getNumCardsInHand()
    {
        logger.info("Returning " + this.playerName+ " number of card on hand.");
        return cardsInHand.size();
    }

    public void addBonusPoint (int paramBonusPoint)
    {
        logger.info("Adding" + paramBonusPoint + " bonus point to " + this.playerName);
        battlePoints += paramBonusPoint;
    }
    
    public void resetBattlePoints ()
    {
        logger.info("Resetting " + this.playerName+ " battle points.");
        battlePoints = 0;
    }

    public int getBattlePoints()
    {
        logger.info("Returning" + this.playerName+ " battle points : " + battlePoints + ".");
        return battlePoints;
    }

    public int getCurrentBid()
    {
        logger.info("Returning " + this.playerName+ " bids:" +currentBid+" .");
        return currentBid;
    }

    public void setCardsOnTable(ArrayList<AdventureCard> cardsOnTable)
    {
        logger.info("Set " + this.playerName+ " cards on table.");
        this.cardsOnTable = cardsOnTable;
    }

    public void setCurrentBid(int currentBid)
    {
        logger.info("Set " + this.playerName+ " bids.");
        this.currentBid = currentBid;
    }

    public void setShields(int paramShields)
    {
        logger.info("Set " + this.playerName+ " shields.");
        shields = paramShields;
    }
    
    public void setPlayerRank(Rank paramRank){
        logger.info("Set " + this.playerName+ " rank.");
        playerRank = paramRank;
    }

    public void addCardToHand(AdventureCard paramCard){
        logger.info("Adding the following card "+ paramCard.getName()+" to " + this.playerName+ " hand.");
        cardsInHand.add(paramCard);
    }
    
    public void addCardToTable(AdventureCard paramCard){
        logger.info("Adding the following card "+ paramCard.getName()+" to " + this.playerName+ " cards on the table.");
        cardsOnTable.add(paramCard);
    }
    
//    public void addCardToPlaying(AdventureCard paramCard){
//        cardsPlaying.addCard(paramCard);
//    }

    public void removeCardFromHand(AdventureCard paramCard){
        logger.info("Removing the following card "+ paramCard.getName()+" from " + this.playerName+ " hand.");
        cardsInHand.remove(paramCard);
    }
    
    public void removeCardFromTable(AdventureCard paramCard){
        logger.info("Removing the following card "+ paramCard.getName()+" from " + this.playerName+ " cards on the table.");
        cardsOnTable.remove(paramCard);
    }
    
//    public void removeCardFromPlaying(AdventureCard paramCard){
//        cardsPlaying.removeCard(paramCard);
//    }

    public boolean tooManyCards(){
        logger.info("Verifying if " + this.playerName +" has more than 12 cards.");
        return cardsInHand.size() > 12;
    }

    int calculateCardsBattlePoints(ArrayList<AdventureCard> paramCardList) {
        int totalBattlePoints = 0;
        for(AdventureCard adventureCard : paramCardList) {
            totalBattlePoints += adventureCard.getBattlePoints();
        }

        return totalBattlePoints;

    }

    public int calculateBattlePoints() {
        switch (playerRank){
            case SQUIRE:
                battlePoints += 5;
                break;
            case KNIGHT:
                battlePoints += 10;
                break;
            case CHAMPION_KNIGHT:
                battlePoints += 20;
                break;
            default:
                break;
        }
        battlePoints += calculateCardsBattlePoints(this.cardsOnTable);
        logger.info("Returning " + this.playerName +" calculated battle points :" + battlePoints+ " .");
        return battlePoints;
    }

    private int getRequiredShieldsForNextRank() {
        switch(playerRank)
        {
            case SQUIRE:
                logger.info("Returning the number of shields needed for "+this.playerName +" to proceed to the next rank. ");
                return 5;
            case KNIGHT:
                logger.info("Returning the number of shields needed for "+this.playerName +" to proceed to the next rank. ");
                return 7;
            case CHAMPION_KNIGHT:
                logger.info("Returning the number of shields needed for "+this.playerName +" to proceed to the next rank. ");
                return 10;
            default:
                logger.info("Default case for "+this.playerName +" rank. ");
                return 99;
        }
    }

    public void confirmRank() {
        int requiredShields = this.getRequiredShieldsForNextRank();
        if(playerRank != Rank.KNIGHT_OF_THE_ROUND_TABLE && shields >= requiredShields){
            playerRank = playerRank.next();
            shields -= requiredShields;
        }
        logger.info("Confirming " + this.playerName +" rank.");
    }
}
