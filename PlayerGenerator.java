import java.util.*;
import java.io.*;
public class PlayerGenerator {
    
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private String color = "";
    private Stairs sta = new Stairs(0,0);
    
    public PlayerGenerator(ArrayList<Room> roomList, Stairs sta, String color) {
        this.roomList = roomList;
        this.color = color;
        this.sta = sta;
    }
    
    public Player createPlayer() {
        Random rand = new Random();
        int r = rand.nextInt(this.roomList.size());
        Room spawnRoom = this.roomList.get(r);
        int playerx, playery = 0;
        do {
            playerx = spawnRoom.getxFirst()+25*(rand.nextInt(spawnRoom.getWidthUnits() - 2) + 1);
            playery = spawnRoom.getyFirst()+25*(rand.nextInt(spawnRoom.getHeightUnits() - 2) + 1);
        } while (playerx == sta.getx() && playery == sta.gety());
        Player player = new Player(playerx,playery,this.color);
        return player;
    }
    
    public void drawPlayer(Player player) {
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledRectangle(player.getx()+12.5, player.gety()+12.5, 8, 8);
    }
        
}