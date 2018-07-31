import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Match {
    private final Player playerOne;
    private final Player playerTwo;
    private Game currentGame;

    private HashMap<String, Player> playersByName = new HashMap<>();
    private List<Game> games = new ArrayList<>();

    public Match(String playerOne, String playerTwo) {
        this.playerOne = new Player(playerOne);
        this.playerTwo = new Player(playerTwo);

        this.playersByName.put(playerOne, this.playerOne);
        this.playersByName.put(playerTwo, this.playerTwo);

        this.currentGame = new Game(this.playerOne, this.playerTwo);
        this.games.add(currentGame);
    }

    private Player getPlayerByName(String playerName){
        return this.playersByName.get(playerName);
    }

    public void pointWonBy(String playerName) {
        if (this.currentGame.isComplete()){
            this.createNextGame();
        }
        Player player = this.getPlayerByName(playerName);
        this.currentGame.pointWonBy(player);
    }

    private void createNextGame(){
        this.currentGame = new Game(this.playerOne, this.playerTwo);
        this.games.add(currentGame);
    }

    public String matchScore(){
        long playerOneWins = games.stream().filter(game -> game.isComplete() && game.leadingPlayer().equals(playerOne)).count();
        long playerTwoWins = games.stream().filter(game -> game.isComplete() && game.leadingPlayer().equals(playerTwo)).count();

        return String.format("%1$d-%2$d", playerOneWins, playerTwoWins);
    }

    public String score() {
        if(this.currentGame.isComplete()){
            return this.matchScore();
        }
        return String.format("%1$s, %2$s", this.matchScore(), this.currentGame.score());
    }
}
