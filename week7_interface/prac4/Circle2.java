public class Circle2 implements MyComparable, AreaComputable {
    private int x, y ;
    private int radius ;
    public Circle2(int x, int y, int radius) {
        this.x = x ; this.y = y ; this.radius = radius ;
    }
    public float getArea() { return (float) Math.PI * radius * radius ; }
    public int compareTo(Object other) {
        if(!(other instanceof Circle2)) return -2;
        Circle2 otherCircle = (Circle2) other;
        int returnValue = 0;
        if(radius < otherCircle.radius) returnValue = -1;
        if(radius == otherCircle.radius) returnValue = 0;
        if(radius > otherCircle.radius) returnValue = 1;
        return returnValue;
    }
    public boolean equal(Object other) {
        if(!(other instanceof Circle2)) return false;
        Circle2 otherCircle = (Circle2) other;
        return x == otherCircle.x && y == otherCircle.y && radius == otherCircle.radius;
    }
    public String toString() {
        return "";
    }
}
