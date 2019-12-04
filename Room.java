import java.util.*;
import java.io.*;
public class Room {
    
    private int x1, x2, y1, y2;
    private ArrayList<Room> ccl = new ArrayList<Room>();
    
    public Room (int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
    public int getx1() {
        return this.x1;
    }
    
    public int getx2() {
        return this.x2;
    }
    
    public int gety1() {
        return this.y1;
    }
    
    public int gety2() {
        return this.y2;
    }
    
    public int getxFirst() {
        return this.x1-this.x2;
    }
    
    public int getyFirst() {
        return this.y1-this.y2;
    }
    
    public int getxSecond() {
        return this.getxFirst()+this.x2*2;
    }
    
    public int getySecond() {
        return this.getyFirst()+this.y2*2;
    }
    
    public int getWidth() {
        return this.getxSecond()-this.getxFirst();
    }
    
    public int getHeight() {
        return this.getySecond()-this.getyFirst();
    }
    
    public int getWidthUnits() {
        return this.getWidth()/25;
    }
    
    public int getHeightUnits() {
        return this.getHeight()/25;
    }
    
    public ArrayList<Room> getccl() {
        return this.ccl;
    }
    
    public void cclAdd(Room room) {
        this.ccl.add(room);
    }
}