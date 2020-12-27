package Backend;

import java.util.ArrayList;
import java.util.List;

import Backend.*;

public class Board{
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
    private final List<GameListener> listeners = new ArrayList<>();
    private Cell[][] grid = new Cell[WIDTH][HEIGHT];

    public void initialize(){
        fillGrid();
    }

    private void fillGrid(){
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                Cell cell = new Cell(this);
                grid[x][y] = cell;
            }
        }
        //TODO: ineficient
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                Point cellPoint = new Point(x,y);
                for (Direction dir : Direction.values()) {
                    Point adjPoint = cellPoint.add(dir.getDelta());
                    Cell adjCell = (isInside(adjPoint))? grid[adjPoint.getX()][adjPoint.getY()] : new Wall(this);
                    grid[x][y].setAdjacent(adjCell, dir);
                }
            }
        }
        
    }

    private boolean isInside(Point p){
        return p.inside(new Point(0,0), new Point(WIDTH-1,HEIGHT-1));
    }

    public void addListener(GameListener listener){
        listeners.add(listener);
    }

    public void cellExploded(){
        for(GameListener l : listeners){
            l.cellExploded();
        }
    }
}