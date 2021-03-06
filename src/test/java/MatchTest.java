/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchTest {

    //  This test tests the desired output for the sample inputs described in the problem statement
    @Test
    public void matchShouldReturnScoreForProblemSampleInputs(){
        Match match = new Match("player 1", "player 2");
        match.pointWonBy("player 1");
        match.pointWonBy("player 2");
        // this will return "0-0, 15-15"
        match.score();
        assertEquals("0-0, 15-15", match.score());

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        // this will return "0-0, 40-15"
        match.score();
        assertEquals("0-0, 40-15", match.score());

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        // this will return "0-0, Deuce"
        match.score();
        assertEquals("0-0, Deuce", match.score());

        match.pointWonBy("player 1");
        // this will return "0-0, Advantage player 1"
        match.score();
        assertEquals("0-0, Advantage player 1", match.score());

        match.pointWonBy("player 1");
        // this will return "1-0"
        match.score();

        assertEquals("1-0", match.score());
    }

    @Test
    public void matchShouldReturnScoreForNoPointsScored(){
        Match match = new Match("player 1", "player 2");

        assertEquals("0-0, 0-0", match.score());
    }

    @Test
    public void matchShouldReturnScoreWhenOneGameIsWonByPlayer(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        assertEquals("1-0", match.score());
    }
    @Test
    public void matchShouldReturnScoreWhenTwoGamesIsWonByPlayer(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        assertEquals("1-1", match.score());
    }

    @Test
    public void matchShouldReturnScoreWhenSecondGameIsOnGoing(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 2");
        match.pointWonBy("player 1");
        match.pointWonBy("player 2");

        assertEquals("1-0, 30-30", match.score());
    }

    @Test
    public void matchShouldStartTieBrakerGameInCaseof6to6Score(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");


        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        // Tie breaker match begins
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        assertEquals("6-6, 0-5", match.score());
    }

    @Test
    public void matchShouldBeCompleteWhenAPlayerLeadsBy2GamesAndaScoreOf6Games(){
        Match match = new Match("player 1", "player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");
        match.pointWonBy("player 2");

        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");
        match.pointWonBy("player 1");

        assertTrue(match.isComplete());
    }
}
