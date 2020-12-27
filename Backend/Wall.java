package Backend;

public class Wall extends Cell {
    
    public Wall(Board board){
        super(board);
    }

    @Override
    public void reveal(){
        return;
    }

    @Override
    public boolean isMined(){
        return false;
    }
}
