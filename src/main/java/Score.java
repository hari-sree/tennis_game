import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sree on 31/7/18.
 */
public class Score {
    private List<Integer> pointsDescription = Arrays.asList(0, 15, 30, 40, 60);
    private int points;

    public Score() {
        this.points = 0;
    }
    public Score(int points) {
        this.points = points;
    }

    public int points() {
        return this.points;
    }

    public int description() {
        return this.pointsDescription.get(this.points());
    }
}
