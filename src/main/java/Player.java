/**
 * Created by sree on 31/7/18.
 */
public class Player {
    private String name;
    private Score score = new Score();

    public Player(String name) {
        this.name = name;
    }

    public Score score() {
        return this.score;
    }

    public void scorePoint() {
        this.score.pointScored();
    }

    public String getName() {
        return name;
    }
}
