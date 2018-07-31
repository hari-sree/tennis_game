import java.util.HashMap;

/**
 * Created by sree on 31/7/18.
 */
public class TieBreakerGame extends TennisGame{

    public TieBreakerGame(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    public String score() {
        return playerOneScore().points() +"-"+playerTwoScore().points();
    }

    public void pointWonBy(Player player) {
        getPlayerScore(player).pointScored();
    }

    public boolean isComplete() {
        boolean playerOneLeadsByTwoPoint = playerOneScore().isTwoMoreThan(playerTwoScore());
        boolean playerTwoLeadsByTwoPoint = playerTwoScore().isTwoMoreThan(playerOneScore());

        boolean anyPlayerHasAtLeastSevenPoints = playerOneScore().isAtleastSevenPoints() || playerTwoScore().isAtleastSevenPoints();
        boolean anyPlayerHasTwoPointMoreThanOther = playerOneLeadsByTwoPoint || playerTwoLeadsByTwoPoint;

        return anyPlayerHasAtLeastSevenPoints && anyPlayerHasTwoPointMoreThanOther;
    }
}
