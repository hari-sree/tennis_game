import java.util.HashMap;

/**
 * Created by sree on 25/7/18.
 */
public class Match {
    private final String playerOne;
    private final String playerTwo;

    private HashMap<String, Integer> playerScores = new HashMap<>();

    public Match(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        this.playerScores.put(this.playerOne, 0);
        this.playerScores.put(this.playerOne, 0);
    }

    public void pointWonBy(String player) {
        this.playerScores.put(this.playerOne, this.playerScores.get(player) + 1);
    }

    public PlayerScores score() {
        return new PlayerScores(0, 0);
    }
}
