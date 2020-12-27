package Backend;

public class Cell {
    private Cell[] adjacentCells = new Cell[Direction.values().length]; 
    private boolean hasMine;
    private boolean revealed;
    private Board board;

    public Cell(Board board){
        this.board = board;
    }

    public void setAdjacent(Cell cell, Direction dir){
        int position = dir.ordinal();
        if(adjacentCells[position] != null)
            throw new RuntimeException("Trying to override an existing adjacent Cell");
        adjacentCells[position] = cell;
    }

    public boolean isMined(){
        return hasMine;
    }

    public void reveal(){
        if(hasMine){
            board.cellExploded();
            return;
        }
        int adjMines = adjacentMines();
        
        if(adjMines == 0){
            for(Cell cell : adjacentCells)
                cell.reveal();
        }
        revealed = true;
    }

    public int adjacentMines(){
        int adjMines = 0;
        for(Cell cell : adjacentCells){
            adjMines += cell.isMined()? 1 : 0;
        }
        return adjMines;
    }

}
