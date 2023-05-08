import java.util.Scanner;

public class MiniMazeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze(10, 10);
        Player player = new Player(maze.getStartRow(), maze.getStartColumn());
        maze.print(player.getRow(), player.getColumn());

        while (!maze.isComplete(player.getRow(), player.getColumn())) {
            System.out.print("Enter a direction (up, down, left, right): ");
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    if (player.getRow() > 0 && maze.isPath(player.getRow() - 1, player.getColumn())) {
                        player.moveUp();
                    } else {
                        System.out.println("Invalid move");
                    }
                    break;
                case "down":
                    if (player.getRow() < 9 && maze.isPath(player.getRow() + 1, player.getColumn())) {
                        player.moveDown();
                    } else {
                        System.out.println("Invalid move");
                    }
                    break;
                case "left":
                    if (player.getColumn() > 0 && maze.isPath(player.getRow(), player.getColumn() - 1)) {
                        player.moveLeft();
                    } else {
                        System.out.println("Invalid move");
                    }
                    break;
                case "right":
                    if (player.getColumn() < 9 && maze.isPath(player.getRow(), player.getColumn() + 1)) {
                        player.moveRight();
                    } else {
                        System.out.println("Invalid move");
                    }
                    break;
                default:
                    System.out.println("Invalid direction");
            }

            maze.print(player.getRow(), player.getColumn());
        }

        System.out.println("Congratulations, you completed the maze in " + player.getMoves() + " moves!");
    }
}