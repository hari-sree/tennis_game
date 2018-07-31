/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class TieBreakerGameTest {
    @Test
    public void shouldReturnFalseWhenGameIsNotComplete() {
        Player playerOne = new Player("player 1");
        Player playerTwo = new Player("player 2");

        TieBreakerGame game = new TieBreakerGame(playerOne, playerTwo);

        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);

        assertFalse(game.isComplete());
    }
    @Test
    public void shouldReturnTrueWhenGameIsCompleteWithSevenPoints() {
        Player playerOne = new Player("player 1");
        Player playerTwo = new Player("player 2");

        TieBreakerGame game = new TieBreakerGame(playerOne, playerTwo);

        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);

        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerOne);


        assertTrue(game.isComplete());
    }
    @Test
    public void scoreShouldReturnRawScoreForTiebreaker() {
        Player playerOne = new Player("player 1");
        Player playerTwo = new Player("player 2");

        TieBreakerGame game = new TieBreakerGame(playerOne, playerTwo);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerTwo);
        game.pointWonBy(playerOne);

        game.pointWonBy(playerTwo);
        game.pointWonBy(playerOne);
        game.pointWonBy(playerTwo);

        game.pointWonBy(playerTwo);

        assertEquals("3-4", game.score());
    }
}
