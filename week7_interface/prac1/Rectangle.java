public class Rectangle implements MyComparable{
    private int width, height;

    public Rectangle(int width, int height){
        this.width = width; this.height = height;
    }

    @Override
    public int compareTo(Object other) {
        if(!(other instanceof Rectangle))   return -2;
        Rectangle r = (Rectangle) other;
        if(width*height < r.width*r.height) return -1;
        if(width*height == r.width*r.height) return 0;
        if(width*height > r.width*r.height) return 1;
        return 0;
    }

    @Override
    public boolean equal(Object other) {
        if(!(other instanceof Rectangle))   return false;
        Rectangle r = (Rectangle) other;
        return width == r.width && height == r.height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle{area=%d}", width*height);
    }
}