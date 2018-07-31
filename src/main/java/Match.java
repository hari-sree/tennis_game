/**
 * Created by sree on 25/7/18.
 */
public class Match {

    private final String playerOne;
    private final String playerTwo;

    public Match(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void pointWonBy(String player) {
    }

    public Score score() {
        return new Score();
    }
}
