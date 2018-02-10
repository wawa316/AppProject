package quest;

import java.util.ArrayList;

public class GameModel
{
    ArrayList<Player> players = new ArrayList<>();
    GameState state;
    int currentTurnIndex = 0;

    CardCollection adventureDeck = new CardCollection();
    CardCollection storyDeck = new CardCollection();

    public GameModel()
    {
        players.add(new Player("Cody"));
        players.add(new Player("Jay"));
        players.add(new Player("Jeremy"));
        players.add(new Player("Robert"));

        state = new GameState();

//        adventureDeck.fillWithAdventureCards();
//        storyDeck.fillWithStoryCards();
    }

    public void startGame()
    {
        if(players.size() > 0)
        {
            shuffleAndDeal();
            state.setCurrentTurnPlayer(players.get(currentTurnIndex));
            startTurn();
        }
        else
        {
            endGame();
        }
    }

    public void endGame()
    {
        System.out.println("Game over");
    }

    public void nextTurn()
    {
        state.setCurrentStory(null);
        if(players.size() == 0)
        {
            endGame();
            return;
        }
        if(++currentTurnIndex >= players.size())
        {
            currentTurnIndex = 0;
        }
        state.setCurrentTurnPlayer(players.get(currentTurnIndex));
        startTurn();
    }

    public void shuffleAndDeal()
    {
        adventureDeck.shuffle();
        storyDeck.shuffle();
        for(int i = 0; i < players.size(); ++i)
        {
            players.get(i).drawCards(12, adventureDeck);
        }
    }

    public void startTurn()
    {
        //Notify view that a new turn has started
    }

    public void ready()
    {
        drawStoryCard();
    }

    public void selectCard(Card card)
    {
        state.getCurrentTurnPlayer().selectCard(card);
    }

    public void drawStoryCard()
    {
        state.setCurrentStory(storyDeck.drawCard());
    }

    public GameState getState() {return state;}
}
