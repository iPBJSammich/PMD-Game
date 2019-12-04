public class Player {
    
    private int x, y = 0;
    private String color = "";
    
    public Player(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public int getx() {
        return x;
    }
    
    public int gety() {
        return y;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setx(int x) {
        this.x = x;
    }
    
    public void sety(int y) {
        this.y = y;
    }
    
    
    
}