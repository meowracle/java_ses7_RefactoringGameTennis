public class TennisGame {

    public static final int THIRD_POINT = 3;
    public static final int SECOND_POINT = 2;
    public static final int FIRST_POINT = 1;
    public static final int ZERO_POINT = 0;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String scoreDisplay = "";
        int scoreCount = 0;
        if (player1Score == player2Score) {
            scoreDisplay = callDrawPoint(player1Score);
        } else if (player1Score > THIRD_POINT || player2Score > THIRD_POINT) {
            scoreDisplay = callAdvantageAndWin(player1Score, player2Score);
        } else {
            scoreDisplay = callPoint(player1Score, player2Score, scoreDisplay);
        }
        return scoreDisplay;
    }

    private static String callPoint(int player1Score, int player2Score, String scoreDisplay) {
        int scoreCount;
        for (int i = 1; i < 3; i++) {
            if (i == 1) scoreCount = player1Score;
            else {
                scoreDisplay += "-";
                scoreCount = player2Score;
            }
            switch (scoreCount) {
                case ZERO_POINT:
                    scoreDisplay += "Love";
                    break;
                case FIRST_POINT:
                    scoreDisplay += "Fifteen";
                    break;
                case SECOND_POINT:
                    scoreDisplay += "Thirty";
                    break;
                case THIRD_POINT:
                    scoreDisplay += "Forty";
                    break;
            }
        }
        return scoreDisplay;
    }

    private static String callAdvantageAndWin(int player1Score, int player2Score) {
        String scoreDisplay;
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) scoreDisplay = "Advantage player1";
        else if (scoreDifference == -1) scoreDisplay = "Advantage player2";
        else if (scoreDifference >= 2) scoreDisplay = "Win for player1";
        else scoreDisplay = "Win for player2";
        return scoreDisplay;
    }

    private static String callDrawPoint(int player1Score) {
        String scoreDisplay;
        switch (player1Score) {
            case ZERO_POINT:
                scoreDisplay = "Love-All";
                break;
            case FIRST_POINT:
                scoreDisplay = "Fifteen-All";
                break;
            case SECOND_POINT:
                scoreDisplay = "Thirty-All";
                break;
            case THIRD_POINT:
                scoreDisplay = "Forty-All";
                break;
            default:
                scoreDisplay = "Deuce";
                break;

        }
        return scoreDisplay;
    }
}
