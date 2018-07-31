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
        return playerOne.score().description() +"-"+ playerTwo.score().description();
    }

    public void pointWonBy(Player playerOne) {
        playerOne.scorePoint();
    }
}
