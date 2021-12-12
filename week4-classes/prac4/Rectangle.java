public class Rectangle{
    private Point p1;
    private Point p2;

    public Rectangle(Point p1, Point p2){
        this.p1 = p1; this.p2 = p2;
    }

    public Rectangle(Rectangle rectangle){
        this.p1 = new Point(rectangle.p1.getX(), rectangle.p1.getY());
        this.p2 = new Point(rectangle.p2.getX(), rectangle.p2.getY());
    }

    public void moveBy(int x, int y){
        p1.setX(p1.getX()+x);
        p2.setX(p2.getX()+x);
        p1.setY(p1.getY()+y);
        p2.setY(p2.getY()+y);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[(%d,%d),(%d,%d)]", p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}