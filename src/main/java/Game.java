import java.util.HashMap;

/**
 * Created by sree on 31/7/18.
 */
public class Game extends TennisGame{
    public Game(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
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

    public boolean isComplete() {
        boolean playerOneLeadsByTwoPoint = playerOneScore().isTwoMoreThan(playerTwoScore());
        boolean playerTwoLeadsByTwoPoint = playerTwoScore().isTwoMoreThan(playerOneScore());

        boolean anyPlayerHasAtLeastFourPoints = playerOneScore().isAtleastFourPoints() || playerTwoScore().isAtleastFourPoints();
        boolean anyPlayerHasTwoPointMoreThanOther = playerOneLeadsByTwoPoint || playerTwoLeadsByTwoPoint;

        return anyPlayerHasAtLeastFourPoints && anyPlayerHasTwoPointMoreThanOther;
    }

    private boolean IsDeuce(){
        boolean playersHaveSameScore = playerOneScore().equals(playerTwoScore());
        boolean eachPlayerHasAtLeastThreePoints = playerOneScore().isAtleastThreePoints() && playerTwoScore().isAtleastThreePoints();
        return playersHaveSameScore && eachPlayerHasAtLeastThreePoints;
    }

    private boolean IsAdvantage(){
        boolean eachPlayerHasAtLeastThreePoints = playerOneScore().isAtleastThreePoints() && playerTwoScore().isAtleastThreePoints();
        boolean playerOneLeadsByOnePoint = playerOneScore().isOneMoreThan(playerTwoScore());
        boolean playerTwoLeadsByOnePoint = playerTwoScore().isOneMoreThan(playerOneScore());

        boolean anyPlayerHasOnePointMoreThanOther = playerOneLeadsByOnePoint || playerTwoLeadsByOnePoint;

        return eachPlayerHasAtLeastThreePoints && anyPlayerHasOnePointMoreThanOther;
    }
}
