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
        return false;
    }

    public String score() {
        Score playerOneScore = playerOne.score();
        Score playerTwoScore = playerTwo.score();

        boolean playersHaveSameScore = playerOneScore.equals(playerTwoScore);
        boolean eachPlayerHasAtleastThreePoints = playerOneScore.isAtleastThreePoints() && playerTwoScore.isAtleastThreePoints();
        if(playersHaveSameScore && eachPlayerHasAtleastThreePoints){
            return "Deuce";
        }
        return playerOneScore.description() +"-"+playerTwoScore.description();
    }

    public void pointWonBy(Player playerOne) {
        playerOne.scorePoint();
    }
}
