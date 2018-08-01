import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Match {
    private final Player playerOne;
    private final Player playerTwo;
    private TennisGame currentGame;

    private HashMap<String, Player> playersByName = new HashMap<>();
    private List<TennisGame> games = new ArrayList<>();

    public Match(String playerOne, String playerTwo) {
        this.playerOne = new Player(playerOne);
        this.playerTwo = new Player(playerTwo);

        this.playersByName.put(playerOne, this.playerOne);
        this.playersByName.put(playerTwo, this.playerTwo);
        this.createNextGame();
    }

    public void pointWonBy(String playerName) {
        if (this.currentGame.isComplete()){
            this.createNextGame();
        }
        Player player = this.getPlayerByName(playerName);
        this.currentGame.pointWonBy(player);
    }

    public String matchScore(){
        return String.format("%1$d-%2$d", playerOneWins(), playerTwoWins());
    }

    public String score() {
        if(this.currentGame.isComplete()){
            return this.matchScore();
        }
        return String.format("%1$s, %2$s", this.matchScore(), this.currentGame.score());
    }

    public boolean isComplete(){
        boolean hasAtleastOnePlayerHasSixGames = playerOneWins() >= 6 || playerTwoWins() >= 6;
        boolean hasTwoGameMargin = Math.abs(playerOneWins() - playerTwoWins()) >=2;

        return hasTwoGameMargin && hasAtleastOnePlayerHasSixGames;
    }

    private void createNextGame(){
        this.currentGame = createNewGame();
        this.games.add(currentGame);
    }

    private Player getPlayerByName(String playerName){
        return this.playersByName.get(playerName);
    }

    private TennisGame createNewGame(){
        return isATie() ? new TieBreakerGame(this.playerOne, this.playerTwo): new Game(this.playerOne, this.playerTwo);
    }
    private boolean isATie() {
        return playerOneWins() == 6 &&  playerTwoWins() == 6;
    }

    private long playerOneWins(){
        return games.stream().filter(game -> game.isComplete() && game.leadingPlayer().equals(playerOne)).count();
    }

    private long playerTwoWins(){
        return games.stream().filter(game -> game.isComplete() && game.leadingPlayer().equals(playerTwo)).count();
    }
}
