import java.util.HashMap;

/**
 * Created by sree on 31/7/18.
 */
public abstract class TennisGame {
    protected Player playerOne;
    protected Player playerTwo;
    protected HashMap<Player, Score> playerScores = new HashMap<>();

    public TennisGame(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        playerScores.put(playerOne, new Score());
        playerScores.put(playerTwo, new Score());
    }

    public abstract String score();

    public void pointWonBy(Player player) {
        getPlayerScore(player).pointScored();
    }

    public abstract boolean isComplete();

    public Player leadingPlayer(){
        Score playerOneScore = getPlayerScore(playerOne);
        Score playerTwoScore = getPlayerScore(playerTwo);

        return playerOneScore.isMoreThan(playerTwoScore) ? playerOne : playerTwo;
    }

    protected Score getPlayerScore(Player player){
        return this.playerScores.get(player);
    }

    protected Score playerOneScore(){
        return getPlayerScore(playerOne);
    }

    protected Score playerTwoScore(){
        return getPlayerScore(playerTwo);
    }
}
