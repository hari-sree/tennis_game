/**
 * Created by sree on 31/7/18.
 */
public class Game {
    private Player playerOne;
    private Player playerTwo;

    public Game(Player playerOne, Player playerTwo) {

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public boolean isComplete() {
        Score playerOneScore = playerOne.score();
        Score playerTwoScore = playerTwo.score();

        boolean playerOneLeadsByTwoPoint = playerOneScore.isTwoMoreThan(playerTwoScore);
        boolean playerTwoLeadsByTwoPoint = playerTwoScore.isTwoMoreThan(playerOneScore);

        boolean anyPlayerHasAtLeastFourPoints = playerOneScore.isAtleastFourPoints() || playerTwoScore.isAtleastFourPoints();
        boolean anyPlayerHasTwoPointMoreThanOther = playerOneLeadsByTwoPoint || playerTwoLeadsByTwoPoint;

        return anyPlayerHasAtLeastFourPoints && anyPlayerHasTwoPointMoreThanOther;
    }

    public Player leadingPlayer(){
        Score playerOneScore = playerOne.score();
        Score playerTwoScore = playerTwo.score();

        return playerOneScore.isMoreThan(playerTwoScore) ? playerOne : playerTwo;
    }

    public String score() {
        Score playerOneScore = playerOne.score();
        Score playerTwoScore = playerTwo.score();

        boolean playersHaveSameScore = playerOneScore.equals(playerTwoScore);
        boolean eachPlayerHasAtLeastThreePoints = playerOneScore.isAtleastThreePoints() && playerTwoScore.isAtleastThreePoints();
        if(playersHaveSameScore && eachPlayerHasAtLeastThreePoints){
            return "Deuce";
        }
        boolean playerOneLeadsByOnePoint = playerOneScore.isOneMoreThan(playerTwoScore);
        boolean playerTwoLeadsByOnePoint = playerTwoScore.isOneMoreThan(playerOneScore);

        boolean anyPlayerHasOnePointMoreThanOther = playerOneLeadsByOnePoint || playerTwoLeadsByOnePoint;
        if(eachPlayerHasAtLeastThreePoints && anyPlayerHasOnePointMoreThanOther){
            return "Advantage "+ (playerOneLeadsByOnePoint ? playerOne.getName() : playerTwo.getName());
        }

        return playerOneScore.description() +"-"+playerTwoScore.description();
    }

    public void pointWonBy(Player player) {
        player.scorePoint();
    }
}
