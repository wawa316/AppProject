package quest.server;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import static java.lang.System.exit;

public class Server {
    public static List<PlayerConnection> players;
    public static DataOutputStream dos;
    DataInputStream dis;
    private int numberOfPlayers;

    private String scenario;

    Server(int numberOfPlayers, String scenario) {

        System.out.println("Server");
        String name;
        Socket client;
        System.out.println("Number of players: " + numberOfPlayers);
        System.out.println("Scenario" + scenario);
        players = new ArrayList<PlayerConnection>();

        try {
            ServerSocket servSock = new ServerSocket(10001);

//            this is where players connect, we will have to make sure this properly sets their name and type(i.e human or a.i.)
//            the server will also need a gui to initiate the game with parameters (i.e which version of the game and number of players)
            while (true) {
                client = servSock.accept();
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());

                name = dis.readUTF();
                PlayerConnection user = new PlayerConnection(name, dos, dis);
                System.out.println("Connected : " + name);
                players.add(user);

                String enter_message = "{ \"name\" : \"" + "[ SERVER NOTICE ]" + "\", \"message\" : \"" + name + " Connected" + "\"}";
                System.out.println(enter_message);
                List<PlayerConnection> entry = Server.players;
                for (PlayerConnection cli : entry) {
                    DataOutputStream edos = cli.getDos();
                    edos.writeUTF(enter_message);
                }

                System.out.println("[Current User : " + Server.players.size() + "]");

            }
        } catch (IOException E) {
            E.printStackTrace();
        }

    }

}
