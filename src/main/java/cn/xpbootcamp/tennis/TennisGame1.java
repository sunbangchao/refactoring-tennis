package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    private String score;

    private static final String[] pointString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private static final String DUECE = "Duece";
    private static final String P1_WIN = "Win for player1";
    private static final String P2_WIN = "Win for player2";
    private static final String P1_ADVANTAGE = "Advantage player1";
    private static final String P2_ADVANTAGE = "Advantage player2";

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
        int p1_point = player1.getPoint();
        int p2_point = player2.getPoint();
        if(Math.max(p1_point,p2_point) > 3){
            switch (p1_point - p2_point){
                case 0:
                    score = DUECE;
                    break;
                case 1:
                    score = P1_ADVANTAGE;
                    break;
                case 2:
                case 3:
                case 4:
                    score = P1_WIN;
                    break;
                case -1:
                    score = P2_ADVANTAGE;
                    break;
                case -2:
                case -3:
                case -4:
                    score = P2_WIN;
                    break;
            }
        }else{
            if(p1_point == p2_point && p1_point == 3){
                score = DUECE;
            }else{
                score = pointString[p1_point];
                score += "-";
                score += p1_point == p2_point ? "All" : pointString[p2_point];
            }
        }
    }

    public String getScore() {
        return this.score;
    }
}