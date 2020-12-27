package Backend;

public enum Direction{
UP(0,1),
DOWN(0,-1),
LEFT(-1,0),
RIGHT(1,0),
UP_RIGHT(1,1),
UP_LEFT(-1,1),
DOWN_RIGHT(1,-1),
DOWN_LEFT(-1,-1);

private final int delta_x, delta_y;
Direction(int delta_x, int delta_y){
    this.delta_x = delta_x;
    this.delta_y = delta_y;
}

Point getDelta(){
    return new Point(delta_x, delta_y);
}
}