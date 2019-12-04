import java.util.*;
import java.io.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class aaaMain {
    
    public double runGame(int repetitions) {
        
        double time = 0;
        int roomCount = 15;
        int width = 1000, height = 1000;
        StdDraw.setCanvasSize(width, height);
        
        StdDraw.setPenRadius(.01);
        
        RoomGenerator obj1 = new RoomGenerator();
        for (int i=0;i<roomCount;i++)
            obj1.createRoom();
        CorridorGenerator obj2 = new CorridorGenerator(obj1.getRoomList());
        StairsGenerator obj3 = new StairsGenerator(obj1.getRoomList());
        Stairs sta = obj3.createStairs();
        PlayerGenerator obj4 = new PlayerGenerator(obj1.getRoomList(),sta,"BLUE");
        Player player = obj4.createPlayer();
        
        ArrayList<Room> roomList = obj1.getRoomList();
        ArrayList<Corridor> corridorList = new ArrayList<Corridor>();
        corridorList = obj2.createCorridors();
        ArrayList<Coordinates> legalCoordsList = new ArrayList<Coordinates>();
        for (int i=0;i<roomList.size();i++) {
            for (int j=roomList.get(i).getxFirst();j<roomList.get(i).getxSecond();j+=25) {
                for (int k=roomList.get(i).getyFirst();k<roomList.get(i).getySecond();k+=25) {
                    Coordinates loc = new Coordinates(j,k);
                    legalCoordsList.add(loc);
                }
            }
        }
        
        for (int i=0;i<corridorList.size();i++) {
            for (int j=-25;j<=corridorList.get(i).getLength();j+=25) {
                if (corridorList.get(i).getxc1() == corridorList.get(i).getxc2()) {
                    Coordinates loc = new Coordinates((int) (corridorList.get(i).getxc1()-12.5),(int) (j+corridorList.get(i).getyc1()-12.5));
                    legalCoordsList.add(loc);
                }
                else if (corridorList.get(i).getyc1() == corridorList.get(i).getyc2()) {
                    Coordinates loc = new Coordinates((int) (j+corridorList.get(i).getxc1()-12.5),(int) (corridorList.get(i).getyc1()-12.5));
                    legalCoordsList.add(loc);
                }
            }
        }
        
        
        
        int marker = 0;
        int marker2 = 0;
        int marker3 = 0;
        boolean atStairs = false;
        StdDraw.enableDoubleBuffering();
        
        while (!atStairs) {
            
            marker2 = 0;
            
            //d
            if (StdDraw.isKeyPressed(68)&& marker3 == 0) {
                for (int i=0;i<legalCoordsList.size();i++) {
                    if (legalCoordsList.get(i).getx() == player.getx()+25 && legalCoordsList.get(i).gety() == player.gety() && marker == 0){
                        player.setx(player.getx()+25);
                        marker = 1;
                        
                    }
                    
                }
                
                marker = 0;
                marker2 = 1;
                marker3 = 1;
            }
            //a
            if (StdDraw.isKeyPressed(65) && marker3 == 0) {
                for (int i=0;i<legalCoordsList.size();i++) {
                    if (legalCoordsList.get(i).getx() == player.getx()-25 && legalCoordsList.get(i).gety() == player.gety() && marker == 0) {
                        player.setx(player.getx()-25);
                        marker = 1;
                        
                    }
                    
                }
                
                marker = 0;
                marker2 = 1;
                marker3 = 1;
            }
            //w
            if (StdDraw.isKeyPressed(87)&& marker3 == 0) {
                for (int i=0;i<legalCoordsList.size();i++) {
                    if (legalCoordsList.get(i).gety() == player.gety()+25 && legalCoordsList.get(i).getx() == player.getx() && marker == 0){
                        player.sety(player.gety()+25);
                        marker = 1;
                    }
                    
                }
                marker = 0;
                marker2 = 1;
                marker3 = 1;
            }
            //s
            if (StdDraw.isKeyPressed(83)&& marker3 == 0) {
                for (int i=0;i<legalCoordsList.size();i++) {
                    if (legalCoordsList.get(i).gety() == player.gety()-25 && legalCoordsList.get(i).getx() == player.getx() && marker == 0){
                        player.sety(player.gety()-25);
                        marker = 1;
                    }
                    
                }
                
            }
            marker = 0;
            marker2 = 1;
            marker3 = 1;
            
            
            
            
            
            marker3 = 0;
            
            StdDraw.setXscale(player.getx()-150, player.getx()+150);
            StdDraw.setYscale(player.gety()-150, player.gety()+150);
            
            StdDraw.setPenRadius(.025);
            for (int i=0;i<roomList.size();i++)
                obj1.drawRoom(roomList.get(i));
            
            for (int i=0;i<corridorList.size();i++) {
                obj2.drawCorridorLines(corridorList.get(i));
            }
            for (int i=0;i<corridorList.size();i++)
                obj2.drawCorridorRects(corridorList.get(i));
            
            StdDraw.setPenRadius(.0125);
            
            obj3.drawStairs(sta);
            
            obj4.drawPlayer(player);
            
            
            StdDraw.show();
            
            if (player.getx() == sta.getx() && player.gety() == sta.gety()) {
                atStairs = true;
                if (repetitions == 3) {
                    StdDraw.clear();
                    StdDraw.show();
                    
                }
            }
            
            if (!StdDraw.isKeyPressed(32)) {
                StdDraw.pause(100);
                time += 0.1;
            }
            
            
            
            
            if (marker2 != 0) {
                StdDraw.pause(100);
                time += 0.1;
            }
            
            
            StdDraw.clear(StdDraw.LIGHT_GRAY); 
            
            
            StdDraw.pause(33);
            time += .045;
            
            
            
            
        }
        return time;
    }
    
    public static void main(String args[]){
        double time = 0.0;
        aaaMain obj1 = new aaaMain();
        for (int i=1;i<=3;i++) {
            time += obj1.runGame(i);
        }
        System.out.printf("Congrats! Finish Time: %.3f %n", time);
        
    }
}

