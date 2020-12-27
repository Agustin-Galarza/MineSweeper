package Backend;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Point add(Point p){
        return new Point(getX() + p.getX(), getY() + p.getY());
    }

    public boolean inside(Point p1, Point p2){
        return inRangeX(p1.getX(), p2.getX()) && inRangeY(p1.getY(), p2.getY());
    }

    private boolean inRangeX(int x1, int x2){
        return x1 <= getX() && getX() <= x2;
    }

    private boolean inRangeY(int y1, int y2){
        return y1 <= getY() && getY() <= y2;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return Integer.compare(p.getX(),getX()) == 0 && Integer.compare(p.getY(),getY()) == 0;
    }
}
