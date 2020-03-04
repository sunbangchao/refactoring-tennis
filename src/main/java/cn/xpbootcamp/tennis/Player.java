package cn.xpbootcamp.tennis;

public class Player {
    private String playerName;
    private int point;

    public Player(String playerName) {
        this.playerName = playerName;
        this.point = 0;
    }

    public void wonPoint(){
        this.point++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
