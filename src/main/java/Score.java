import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public void pointScored() {
        this.points += 1;
    }

    public boolean isAtleastThreePoints() {
        return this.points() >= 3;
    }

    public boolean isOneMoreThan(Score score) {
        return this.points() - score.points() ==1;
    }

    public boolean isTwoMoreThan(Score score) {
        return this.points() - score.points() >=2;
    }

    public boolean isAtleastFourPoints() {
        return this.points() >= 4;
    }

    public boolean isAtleastSevenPoints() {
        return this.points() >= 7;
    }

    public boolean isMoreThan(Score score) {
        return this.points() > score.points();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Score score = (Score) obj;

        return Objects.equals(points, score.points);
    }

}
