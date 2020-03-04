package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    private String score;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        updateScore();
    }

    public void wonPoint(int playerNum) {
        if(playerNum == 1){
            player1.wonPoint();
        }else{
            player2.wonPoint();
        }
        updateScore();
    }

    private void updateScore(){
        score = "";
        int tempScore = 0;
        if (player1.getPoint() == player2.getPoint()) {
            switch (player1.getPoint()) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1.getPoint() >= 4 || player2.getPoint() >= 4) {
            int minusResult = player1.getPoint() - player2.getPoint();
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1.getPoint();
                else {
                    score += "-";
                    tempScore = player2.getPoint();
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
    }

    public String getScore() {
        return this.score;
    }
}