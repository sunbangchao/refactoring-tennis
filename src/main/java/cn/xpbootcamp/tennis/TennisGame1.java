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
        int p1_point = player1.getPoint();
        int p2_point = player2.getPoint();
        if(Math.max(p1_point,p2_point) > 3){
            switch (p1_point - p2_point){
                case 0:
                    score = "Deuce";
                    break;
                case 1:
                    score = "Advantage player1";
                    break;
                case 2:
                case 3:
                case 4:
                    score = "Win for player1";
                    break;
                case -1:
                    score = "Advantage player2";
                    break;
                case -2:
                case -3:
                case -4:
                    score = "Win for player2";
                    break;
            }
        }else{
            String[] point = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            if(p1_point == p2_point && p1_point == 3){
                score = "Deuce";
            }else{
                score = point[p1_point];
                score += "-";
                score += p1_point == p2_point ? "All" : point[p2_point];
            }
        }
    }

    public String getScore() {
        return this.score;
    }
}