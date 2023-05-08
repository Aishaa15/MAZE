public class Maze {
    private int[][] mazeArray;
    private int startRow;
    private int startColumn;
    private int endRow;
    private int endColumn;

    public Maze(int width, int height) {
        this.mazeArray = new int[height][width];

        // Set the start and end positions randomly
        this.startRow = (int) (Math.random() * height);
        this.startColumn = (int) (Math.random() * width);
        this.endRow = (int) (Math.random() * height);
        this.endColumn = (int) (Math.random() * width);

        // Make sure the start and end positions are not the same
        while (startRow == endRow && startColumn == endColumn) {
            this.endRow = (int) (Math.random() * height);
            this.endColumn = (int) (Math.random() * width);
        }

        // Initialize the mazeArray with walls and paths
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (row == startRow && column == startColumn) {
                    mazeArray[row][column] = 1; // start position
                } else if (row == endRow && column == endColumn) {
                    mazeArray[row][column] = 1; // end position
                } else {
                    mazeArray[row][column] = Math.random() < 0.4 ? 0 : 1; // 40% walls, 60% paths
                }
            }
        }
    }

    public boolean isWall(int row, int column) {
        return mazeArray[row][column] == 0;
    }

    public boolean isPath(int row, int column) {
        return mazeArray[row][column] == 1;
    }

    public void setWall(int row, int column) {
        mazeArray[row][column] = 0;
    }

    public void setPath(int row, int column) {
        mazeArray[row][column] = 1;
    }

    public boolean isComplete(int playerRow, int playerColumn) {
        return playerRow == endRow && playerColumn == endColumn;
    }

    public void print(int playerRow, int playerColumn) {
            System.out.println();
            for (int row = 0; row < mazeArray.length; row++) {
                for (int column = 0; column < mazeArray[row].length; column++) {
                    if (row == playerRow && column == playerColumn) {
                        System.out.print("P ");
                    } else if (mazeArray[row][column] == 0) {
                        System.out.print("# ");
                    } else {
                        System.out.print(". ");
                    }
                }
                       System.out.print("\n");
            }
        }

        public int getStartRow() 
        {
            return startRow;
        }
    
        public int getStartColumn() 
        {
            return startColumn;
        }
    
        public int getEndRow() 
        {
            return endRow;
        }
    
        public int getEndColumn() 
        {
            return endColumn;
        }
    }