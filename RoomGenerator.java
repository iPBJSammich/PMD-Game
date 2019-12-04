import java.util.*;
import java.io.*;
public class RoomGenerator {
    
    private int width = 1000;
    private int height = 1000;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    
    
    public boolean doesOverlap(Room room) {
        int x1 = room.getx1()-room.getx2();
        int xSecond = room.getx2()*2+x1;
        int y1 = room.gety1()-room.gety2();
        int ySecond = room.gety2()*2+y1;
        
        int prevx1, prevxSecond, prevy1, prevySecond = 0;
        
        for (int i=0;i<this.rooms.size();i++) {
            prevx1 = this.rooms.get(i).getx1()-this.rooms.get(i).getx2();
            prevxSecond = this.rooms.get(i).getx2()*2+prevx1;
            prevy1 = this.rooms.get(i).gety1()-this.rooms.get(i).gety2();
            prevySecond = this.rooms.get(i).gety2()*2+prevy1;
            //bottom left corner overlaps
            if (x1 >= prevx1 && y1 >= prevy1 && x1 <= prevxSecond && y1 <= prevySecond)
                return true;
            //top left corner overlaps
            if (x1 >= prevx1 && x1 <= prevxSecond && ySecond >= prevy1 && ySecond <= prevySecond)
                return true;
            //bottom right corner overlaps
            if (xSecond >= prevx1 && xSecond <= prevxSecond && y1 >= prevy1 && y1 <= prevySecond)
                return true;
            //top right corner overlaps
            if (xSecond >= prevx1 && xSecond <= prevxSecond && ySecond >= prevy1 && ySecond <= prevySecond)
                return true;
            //new box bigger than previous, overlaps on bottom side
            if (x1 <= prevx1 && xSecond >= prevxSecond && y1 >= prevy1 && y1 <= prevySecond)
                return true;
            //new box bigger than previous, overlaps on top side
            if (x1 <= prevx1 && xSecond >= prevxSecond && ySecond >= prevy1 && ySecond <= prevySecond)
                return true;
            //new box bigger than previous, overlaps on left side
            if (x1 >= prevx1 && x1 <= prevxSecond && y1 <= prevy1 && ySecond >= prevySecond)
                return true;
            //new box bigger than previous, overlaps on right side
            if (xSecond >= prevx1 && xSecond <= prevxSecond && y1 <= prevy1 && ySecond >= prevySecond)
                return true;
            //new box entirely inside previous
            if (x1 >= prevx1 && xSecond <= prevxSecond && y1 >= prevy1 && ySecond <= prevySecond)
                return true;
            //new box entirely eclipses previous
            if (x1 <= prevx1 && xSecond >= prevxSecond && y1 <= prevy1 && ySecond >= prevySecond)
                return true; 
        }
        return false;
    }
    
    public boolean isOutofBounds(int x1, int y1, int x2, int y2) {
        if ((x1-x2)+2*x2 >= this.width || (y1-y2)+2*y2 >= this.height)
            return true;
        if (x1-x2 <= 0 || y1-y2 <= 0)
            return true;
        return false;
    }
    
    public Room createRoom() {
        while (true) { 
            Random rand = new Random();
            int x1 = 50*(rand.nextInt(this.width/25 + 1));
            int x2 = 25*(rand.nextInt((5 - 2) + 1) + 2);
            int y1 = 50*(rand.nextInt(this.height/25 + 1));
            int y2 = 25*(rand.nextInt((5 - 2) + 1) + 2);
            Room newRoom = new Room(x1,x2,y1,y2);
            if (!doesOverlap(newRoom) && !isOutofBounds(x1,y1,x2,y2)) {
                this.rooms.add(newRoom);
                return newRoom;
            }
        }
    }
    
    public void drawRoom(Room room) {
        
        int x1 = room.getx1();
        int x2 = room.getx2();
        int y1 = room.gety1();
        int y2 = room.gety2();
        
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(x1,y1,x2,y2);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.rectangle(x1,y1,x2,y2);
        
    }
    
    public ArrayList<Room> getRoomList() {
        return this.rooms;
    }
    
    }

