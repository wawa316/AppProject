package quest;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

//import java.util.ResourceBundle;
//import java.awt.*;

import static quest.Rank.KNIGHT_OF_THE_ROUND_TABLE;

//GAMEPLAN FOR TOMORROW
//ALL GAME APP HAS TO DO IS LAUNCH THE APP< NOTHING ELSE THE REST IS IN HERE
//1: make game model class track its gurrent state
//2: controller init method that creates a new game with players
//3: START MAKING METHODS FOR EACH GAME SCENARIO IE SHOW QUEST CARDS ETC LETS GO


public class Controller {

    private Model game = new Model();

    @FXML
    private BorderPane mainBorderPane ;
    @FXML
    private GridPane handGridPane ;
    @FXML
    private HBox alliesHbox ;
    @FXML
    private HBox weaponHbox;
    @FXML
    private HBox foesHbox;
    @FXML
    private VBox playerStatsVbox;

    //
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Label player3Label;
    @FXML
    private Label player4Label;

    public void update(){

    }

    private ArrayList<Player> finalTournament(ArrayList<Player> tournamentParticipants){
        Tournament knightsOfTheRoundTableTournament = new Tournament("Knights of the Round Table Tournament", "", tournamentParticipants);
        return knightsOfTheRoundTableTournament.getTournamentWinner();
    }

    private ArrayList<Player> getWinningPlayers(Model model) {
        ArrayList<Player> winningPlayers;
        ArrayList<Player> knightsOfTheRoundTable = new ArrayList<>();
        for(Player player : model.getPlayers()){
            if (player.getPlayerRank() == KNIGHT_OF_THE_ROUND_TABLE) {
                knightsOfTheRoundTable.add(player);
            }
        }
        if (knightsOfTheRoundTable.size() == 1){
            winningPlayers = knightsOfTheRoundTable;
        } else {
            winningPlayers = finalTournament(knightsOfTheRoundTable);
        }
        return winningPlayers;
    }

    public void initialize() {
       // player1Label.setText(game.getPlayers());


    }
}