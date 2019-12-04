public class Corridor {
    
    private double xc1;
    private double yc1;
    private double xc2;
    private double yc2;
    
    public Corridor(double xc1,double yc1,double xc2,double yc2) {
        this.xc1 = xc1;
        this.xc2 = xc2;
        this.yc1 = yc1;
        this.yc2 = yc2;
    }
    
    public double getxc1() {
        return this.xc1;
    }
    
    public double getxc2() {
        return this.xc2;
    }
    
    public double getyc1() {
        return this.yc1;
    }
    
    public double getyc2() {
        return this.yc2;
    }
    
    public double getLength() {
        if (this.xc1 == this.xc2)
            return Math.abs(this.yc2-this.yc1);
        else if (this.yc1 == this.yc2)
            return Math.abs(this.xc2-this.xc1);
        return 0.0;
    }
    
}
    
    