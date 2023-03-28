package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class Num2178 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row, column;
		int x = 0;
		int y = 0;
		int counter = 1;
		Stack<Coordinate> pathFinder = new Stack<>();
		pathFinder.add(new Coordinate(x, y, counter));

		String[] mazeSize = scan.nextLine().split(" ");

		row = Integer.parseInt(mazeSize[0]);
		column = Integer.parseInt(mazeSize[1]);

		int[][] maze = new int[row][column];
		boolean[][] visited = new boolean[row][column];
		visited[0][0] = true;

		for (int i = 0; i < row; i++) {
			String rowNumbers = scan.nextLine();
			for (int k = 0; k < column; k++) {
				maze[i][k] = Character.getNumericValue(rowNumbers.charAt(k));
			}
		}

		scan.close();

		while (!pathFinder.isEmpty()) {
			Coordinate coordinate = pathFinder.pop();
			x = coordinate.x;
			y = coordinate.y;
			counter = coordinate.counter;
			System.out.println("x:" + x + " y:" + y + " counter:" + counter + "\n");
			if (x == row - 1 && y == column - 1)
				break;
			if (x + 1 < row && maze[x + 1][y] == 1 && !visited[x + 1][y]) {
				pathFinder.add(new Coordinate(x + 1, y, counter + 1));
			}
			if (y + 1 < column && maze[x][y + 1] == 1 && !visited[x][y + 1]) {
				pathFinder.add(new Coordinate(x, y + 1, counter + 1));
			}
			if (x - 1 > -1 && maze[x - 1][y] == 1 && !visited[x - 1][y]) {
				pathFinder.add(new Coordinate(x - 1, y, counter + 1));
			}
			if (y - 1 > -1 && maze[x][y - 1] == 1 && !visited[x][y - 1]) {
				pathFinder.add(new Coordinate(x, y - 1, counter + 1));
			}
			visited[x][y] = true;
		}
		System.out.println(counter);
	}

	static class Coordinate {
		int x = 0;
		int y = 0;
		int counter = 1;

		Coordinate(int x, int y, int counter) {
			this.x = x;
			this.y = y;
			this.counter = counter;
		}
	}

}
