import java.util.HashMap;

/**
 * Created by sree on 31/7/18.
 */
public class Game {
    private Player playerOne;
    private Player playerTwo;
    private HashMap<Player, Score> playerScores = new HashMap<>();

    public Game(Player playerOne, Player playerTwo) {
        //TODO : REFACTOR
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        playerScores.put(playerOne, new Score());
        playerScores.put(playerTwo, new Score());
    }

    private Score getPlayerScore(Player player){
        return this.playerScores.get(player);
    }
    public boolean isComplete() {
        Score playerOneScore = getPlayerScore(playerOne);
        Score playerTwoScore = getPlayerScore(playerTwo);

        boolean playerOneLeadsByTwoPoint = playerOneScore.isTwoMoreThan(playerTwoScore);
        boolean playerTwoLeadsByTwoPoint = playerTwoScore.isTwoMoreThan(playerOneScore);

        boolean anyPlayerHasAtLeastFourPoints = playerOneScore.isAtleastFourPoints() || playerTwoScore.isAtleastFourPoints();
        boolean anyPlayerHasTwoPointMoreThanOther = playerOneLeadsByTwoPoint || playerTwoLeadsByTwoPoint;

        return anyPlayerHasAtLeastFourPoints && anyPlayerHasTwoPointMoreThanOther;
    }

    public Player leadingPlayer(){
        Score playerOneScore = getPlayerScore(playerOne);
        Score playerTwoScore = getPlayerScore(playerTwo);

        return playerOneScore.isMoreThan(playerTwoScore) ? playerOne : playerTwo;
    }

    public String score() {
        //TODO : REFACTOR
        Score playerOneScore = getPlayerScore(playerOne);
        Score playerTwoScore = getPlayerScore(playerTwo);

        boolean playersHaveSameScore = playerOneScore.equals(playerTwoScore);
        boolean eachPlayerHasAtLeastThreePoints = playerOneScore.isAtleastThreePoints() && playerTwoScore.isAtleastThreePoints();
        if(playersHaveSameScore && eachPlayerHasAtLeastThreePoints){
            return "Deuce";
        }
        boolean playerOneLeadsByOnePoint = playerOneScore.isOneMoreThan(playerTwoScore);
        boolean playerTwoLeadsByOnePoint = playerTwoScore.isOneMoreThan(playerOneScore);

        boolean anyPlayerHasOnePointMoreThanOther = playerOneLeadsByOnePoint || playerTwoLeadsByOnePoint;
        if(eachPlayerHasAtLeastThreePoints && anyPlayerHasOnePointMoreThanOther){
            return "Advantage "+ (playerOneLeadsByOnePoint ? playerOne.getName() : playerTwo.getName());
        }

        return playerOneScore.description() +"-"+playerTwoScore.description();
    }

    public void pointWonBy(Player player) {
        getPlayerScore(player).pointScored();
    }
}
