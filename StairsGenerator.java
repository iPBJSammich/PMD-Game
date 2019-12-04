import java.util.*;
import java.io.*;
public class StairsGenerator {
    
    private ArrayList<Room> roomList = new ArrayList<Room>();
    
    public StairsGenerator(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }
    
    public Stairs createStairs() {
        Random rand = new Random();
        int num = (rand.nextInt(this.roomList.size()));
        Room stairsRoom = this.roomList.get(num);
        
        int stairsx = stairsRoom.getxFirst()+25*(rand.nextInt(stairsRoom.getWidthUnits() - 2) + 1);
        int stairsy = stairsRoom.getyFirst()+25*(rand.nextInt(stairsRoom.getHeightUnits() - 2) + 1);
        Stairs sta = new Stairs(stairsx,stairsy);
        return sta;
    }
    
    public void drawStairs(Stairs sta) {
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.rectangle(sta.getx()+12.5,sta.gety()+12.5,12.5,12.5);
    }
}