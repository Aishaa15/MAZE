public class Player {
    private int row;
    private int column;
    private int moves;

    public Player(int row, int column) {
        this.row = row;
        this.column = column;
        this.moves = 0;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getMoves() {
        return moves;
    }

    public void moveUp() {
        row--;
        moves++;
    }

    public void moveDown() {
        row++;
        moves++;
    }

    public void moveLeft() {
        column--;
        moves++;
    }

    public void moveRight() {
        column++;
        moves++;
    }
}