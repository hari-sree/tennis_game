import java.util.HashMap;

/**
 * Created by sree on 31/7/18.
 */
public class Game {
    private Player playerOne;
    private Player playerTwo;
    private HashMap<Player, Score> playerScores = new HashMap<>();

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        playerScores.put(playerOne, new Score());
        playerScores.put(playerTwo, new Score());
    }

    public String score() {
        if(IsDeuce()){
            return "Deuce";
        }

        if(IsAdvantage()){
            return "Advantage "+ leadingPlayer().getName();
        }

        return playerOneScore().description() +"-"+playerTwoScore().description();
    }

    public void pointWonBy(Player player) {
        getPlayerScore(player).pointScored();
    }

    private Score getPlayerScore(Player player){
        return this.playerScores.get(player);
    }
    public boolean isComplete() {
        boolean playerOneLeadsByTwoPoint = playerOneScore().isTwoMoreThan(playerTwoScore());
        boolean playerTwoLeadsByTwoPoint = playerTwoScore().isTwoMoreThan(playerOneScore());

        boolean anyPlayerHasAtLeastFourPoints = playerOneScore().isAtleastFourPoints() || playerTwoScore().isAtleastFourPoints();
        boolean anyPlayerHasTwoPointMoreThanOther = playerOneLeadsByTwoPoint || playerTwoLeadsByTwoPoint;

        return anyPlayerHasAtLeastFourPoints && anyPlayerHasTwoPointMoreThanOther;
    }

    public Player leadingPlayer(){
        Score playerOneScore = getPlayerScore(playerOne);
        Score playerTwoScore = getPlayerScore(playerTwo);

        return playerOneScore.isMoreThan(playerTwoScore) ? playerOne : playerTwo;
    }

    private boolean IsDeuce(){
        boolean playersHaveSameScore = playerOneScore().equals(playerTwoScore());
        boolean eachPlayerHasAtLeastThreePoints = playerOneScore().isAtleastThreePoints() && playerTwoScore().isAtleastThreePoints();
        return playersHaveSameScore && eachPlayerHasAtLeastThreePoints;
    }

    private Score playerOneScore(){
        return getPlayerScore(playerOne);
    }

    private Score playerTwoScore(){
        return getPlayerScore(playerTwo);
    }

    private boolean IsAdvantage(){
        boolean eachPlayerHasAtLeastThreePoints = playerOneScore().isAtleastThreePoints() && playerTwoScore().isAtleastThreePoints();
        boolean playerOneLeadsByOnePoint = playerOneScore().isOneMoreThan(playerTwoScore());
        boolean playerTwoLeadsByOnePoint = playerTwoScore().isOneMoreThan(playerOneScore());

        boolean anyPlayerHasOnePointMoreThanOther = playerOneLeadsByOnePoint || playerTwoLeadsByOnePoint;

        return eachPlayerHasAtLeastThreePoints && anyPlayerHasOnePointMoreThanOther;
    }
}
