import java.util.*;
import java.io.*;
public class CorridorGenerator {
    
    private ArrayList<Room> roomList = new ArrayList<Room>();
    private ArrayList<Corridor> corridorList = new ArrayList<Corridor>();
    
    public CorridorGenerator(ArrayList<Room> roomList){
        this.roomList = roomList;
    }
    
    
    public ArrayList<Corridor> createCorridors() {
        for (int f=0;f<this.roomList.size();f++) {
            Room currentRoom = this.roomList.get(f);
            for (int h=0;h<this.roomList.size();h++) {
                Room potentialRoom = this.roomList.get(h);
                int xc1 = 0;
                int yc1 = 0;
                int xc2 = 0;
                int yc2 = 0;
                ArrayList<Integer> xc1List = new ArrayList<Integer>();
                ArrayList<Integer> xc2List = new ArrayList<Integer>();
                ArrayList<Integer> yc1List = new ArrayList<Integer>();
                ArrayList<Integer> yc2List = new ArrayList<Integer>();
                Random rand = new Random();
                int r = 0;
                
                if (!currentRoom.getccl().contains(potentialRoom)) {
                    //right wall
                    if (potentialRoom.getxFirst() - currentRoom.getxSecond() > potentialRoom.getyFirst() - currentRoom.getySecond()){
                        if (potentialRoom.getxFirst() - currentRoom.getxSecond() > currentRoom.getyFirst() - potentialRoom.getySecond()) {
                            if (potentialRoom.getxFirst() - currentRoom.getxSecond() > currentRoom.getxFirst() - potentialRoom.getxSecond()) {
                                for (int i=currentRoom.getyFirst();i<currentRoom.getySecond();i+=25) {
                                    for (int j=potentialRoom.getyFirst();j<potentialRoom.getySecond();j+=25) {
                                        if (i == j || currentRoom.getxSecond() == potentialRoom.getxFirst()) {
                                            xc1List.add(currentRoom.getxSecond());
                                            yc1List.add(i);
                                            xc2List.add(potentialRoom.getxFirst());
                                            yc2List.add(j);
                                        }
                                    }
                                }
                                if (xc1List.size() != 0) {
                                    do {
                                        r = rand.nextInt(xc1List.size());
                                        xc1 = xc1List.get(r);
                                        xc2 = xc2List.get(r);
                                        yc1 = yc1List.get(r);
                                        yc2 = yc2List.get(r);
                                        
                                    } while(xc1 == 0);
                                    if (!doesIntersect(xc1,yc1+12.5,xc2,yc2+12.5)) {
                                        potentialRoom.cclAdd(currentRoom);
                                        Corridor corridor = new Corridor(xc1+12.5,yc1+12.5,xc2+12.5,yc2+12.5);
                                        corridorList.add(corridor);
                                    }
                                    xc1List.clear();
                                    xc2List.clear();
                                    yc1List.clear();
                                    yc2List.clear();
                                }
                            }
                        }
                    }
                    //left wall
                    if (currentRoom.getxFirst() - potentialRoom.getxSecond() > potentialRoom.getyFirst() - currentRoom.getySecond()){
                        if (currentRoom.getxFirst() - potentialRoom.getxSecond() > currentRoom.getyFirst() - potentialRoom.getySecond()) {
                            if (potentialRoom.getxFirst() - currentRoom.getxSecond() < currentRoom.getxFirst() - potentialRoom.getxSecond()) {
                                for (int i=currentRoom.getyFirst();i<currentRoom.getySecond();i+=25) {
                                    for (int j=potentialRoom.getyFirst();j<potentialRoom.getySecond();j+=25) {
                                        if (potentialRoom.getxFirst() == currentRoom.getxSecond() || j == i) {
                                            xc1List.add(potentialRoom.getxSecond());
                                            yc1List.add(j);
                                            xc2List.add(currentRoom.getxFirst());
                                            yc2List.add(i);
                                        }
                                    }
                                }
                                if (xc1List.size() != 0) {
                                    do {
                                        r = rand.nextInt(xc1List.size());
                                        xc1 = xc1List.get(r);
                                        xc2 = xc2List.get(r);
                                        yc1 = yc1List.get(r);
                                        yc2 = yc2List.get(r);
                                        
                                    } while(xc1 == 0);
                                    if (!doesIntersect(xc1,yc1+12.5,xc2,yc2+12.5)) {
                                        potentialRoom.cclAdd(currentRoom);
                                        Corridor corridor = new Corridor(xc1+12.5,yc1+12.5,xc2+12.5,yc2+12.5);
                                        corridorList.add(corridor);
                                    }
                                    xc1List.clear();
                                    xc2List.clear();
                                    yc1List.clear();
                                    yc2List.clear();
                                }       
                            }
                        }
                    }
                    //bottom wall
                    if (currentRoom.getyFirst() - potentialRoom.getySecond() > potentialRoom.getxFirst() - currentRoom.getxSecond()){
                        if (currentRoom.getxFirst() - potentialRoom.getySecond() > currentRoom.getxFirst() - potentialRoom.getxSecond()) {
                            if (currentRoom.getyFirst() - potentialRoom.getySecond() > potentialRoom.getyFirst() - currentRoom.getySecond()) {
                                for (int i=currentRoom.getxFirst();i<currentRoom.getxSecond();i+=25) {
                                    for (int j=potentialRoom.getxFirst();j<potentialRoom.getxSecond();j+=25) {
                                        if (j == i || potentialRoom.getySecond() == currentRoom.getyFirst()) {
                                            
                                            xc1List.add(j);
                                            yc1List.add(potentialRoom.getySecond());
                                            xc2List.add(i);
                                            yc2List.add(currentRoom.getyFirst());
                                        }
                                    }
                                }
                                if (xc1List.size() != 0) {
                                    do {
                                        r = rand.nextInt(xc1List.size());
                                        xc1 = xc1List.get(r);
                                        xc2 = xc2List.get(r);
                                        yc1 = yc1List.get(r);
                                        yc2 = yc2List.get(r);
                                        
                                    } while(xc1 == 0);
                                    if (!doesIntersect(xc1+12.5,yc1,xc2+12.5,yc2)) {
                                        potentialRoom.cclAdd(currentRoom);
                                        Corridor corridor = new Corridor(xc1+12.5,yc1+12.5,xc2+12.5,yc2+12.5);
                                        corridorList.add(corridor);
                                    }
                                    xc1List.clear();
                                    xc2List.clear();
                                    yc1List.clear();
                                    yc2List.clear();
                                }
                            }
                        }
                    }
                    //top wall
                    if (potentialRoom.getyFirst() - currentRoom.getySecond() > potentialRoom.getxFirst() - currentRoom.getxSecond()){
                        if (potentialRoom.getyFirst() - currentRoom.getySecond() > currentRoom.getxFirst() - potentialRoom.getxSecond()) {
                            if (currentRoom.getyFirst() - potentialRoom.getySecond() < potentialRoom.getyFirst() - currentRoom.getySecond()) {
                                for (int i=currentRoom.getxFirst();i<currentRoom.getxSecond();i+=25) {
                                    for (int j=potentialRoom.getxFirst();j<potentialRoom.getxSecond();j+=25) {
                                        if (i == j || currentRoom.getySecond() == potentialRoom.getyFirst()) {
                                            xc1List.add(i);
                                            yc1List.add(currentRoom.getySecond());
                                            xc2List.add(j);
                                            yc2List.add(potentialRoom.getyFirst());
                                        }
                                    }
                                }
                                if (xc1List.size() != 0) {
                                    do {
                                        r = rand.nextInt(xc1List.size());
                                        xc1 = xc1List.get(r);
                                        xc2 = xc2List.get(r);
                                        yc1 = yc1List.get(r);
                                        yc2 = yc2List.get(r);
                                        
                                    } while(xc1 == 0);
                                    if (!doesIntersect(xc1+12.5,yc1,xc2+12.5,yc2)) {
                                        potentialRoom.cclAdd(currentRoom);
                                        Corridor corridor = new Corridor(xc1+12.5,yc1+12.5,xc2+12.5,yc2+12.5);
                                        corridorList.add(corridor);
                                    }
                                    xc1List.clear();
                                    xc2List.clear();
                                    yc1List.clear();
                                    yc2List.clear();
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
        return corridorList;
    }
    
    public boolean doesIntersect(double xc1, double yc1, double xc2, double yc2) {          
        Room currentRoom;
        
        if (yc2 == yc1) {
            for (double i=xc1;i<xc2;i++) {
                for (int j=0;j<this.roomList.size();j++) {
                    currentRoom = this.roomList.get(j);
                    if (i > currentRoom.getxFirst() && i < currentRoom.getxSecond() && (yc1+12.5 >= currentRoom.getyFirst() || yc1-12.5 >= currentRoom.getyFirst()) && (yc1+12.5 <= currentRoom.getySecond() || yc1-12.5 <= currentRoom.getySecond())) {
                        return true;
                    }
                }
            }
        }
        else if (xc1 == xc2) {
            for (double i=yc1;i<yc2;i++) {
                for (int j=0;j<this.roomList.size();j++) {
                    currentRoom = this.roomList.get(j);
                    if (i > currentRoom.getyFirst() && i < currentRoom.getySecond() && (xc1+12.5 >= currentRoom.getxFirst() || xc1-12.5 >= currentRoom.getxFirst()) && (xc1+12.5 <= currentRoom.getxSecond() || xc1-12.5 <= currentRoom.getxSecond())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void drawCorridorLines(Corridor corridor) {
        double xc1 = corridor.getxc1();
        double xc2 = corridor.getxc2();
        double yc1 = corridor.getyc1();
        double yc2 = corridor.getyc2();
        StdDraw.setPenColor(StdDraw.GRAY);
        //to-do: change corridor rect width to match pen size
        if (xc1 == xc2) {
            StdDraw.line(xc1+12.5,yc1-12.5,xc2+12.5,yc2-12.5);
            StdDraw.line(xc1-12.5,yc1-12.5,xc2-12.5,yc2-12.5);
        }
        else if (yc1 == yc2) {
            StdDraw.line(xc1-12.5,yc1+12.5,xc2-12.5,yc2+12.5);
            StdDraw.line(xc1-12.5,yc1-12.5,xc2-12.5,yc2-12.5);
        }
    }
    
    public void drawCorridorRects(Corridor corridor) {
        double xc1 = corridor.getxc1();
        double xc2 = corridor.getxc2();
        double yc1 = corridor.getyc1();
        double yc2 = corridor.getyc2();
        StdDraw.setPenColor(StdDraw.WHITE);
        //to-do: change corridor rect width to match pen size
        if (xc1 == xc2) {
            StdDraw.filledRectangle(xc1,yc1+(yc2-yc1)/2-12.5,10.7,(yc2-yc1)/2+5);
        }
        else if (yc1 == yc2) {
            StdDraw.filledRectangle(xc1+(xc2-xc1)/2-12.5,yc1,(xc2-xc1)/2+5,10.7);
        }
    }
}






