/**
 * Created by sree on 25/7/18.
 */
public class PlayerScores {
    private int playerOneScore;
    private int playerTwoScore;

    public PlayerScores(int playerOneScore, int playerTwoScore){

        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int playerOne() {
        return this.playerOneScore;
    }
    public int playerTwo() {
        return this.playerTwoScore;
    }
}
