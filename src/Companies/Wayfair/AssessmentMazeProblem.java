package Companies.Wayfair;

import java.util.*;

public class AssessmentMazeProblem {

    public static int getMinimumMoves(List<List<Integer>> maze, int k) {
        int n = maze.size();
        int m = maze.get(0).size();

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // Cell (0,0) with 0 moves initially

        int[] dirX = {0, 0, 1, -1}; // Horizontal movement
        int[] dirY = {1, -1, 0, 0}; // Vertical movement

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            int moves = cell[2];

            if (x == n - 1 && y == m - 1) {
                return moves; // Reached the target cell
            }

            for (int d = 0; d < 4; d++) { // Explore all directions
                for (int jump = 1; jump <= k; jump++) { // Explore all possible jump lengths
                    int newX = x + dirX[d] * jump;
                    int newY = y + dirY[d] * jump;

                    // Check if new position is within bounds and not an obstacle
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && maze.get(newX).get(newY) == 0) {
                        if (!visited[newX][newY]) {
                            visited[newX][newY] = true;
                            queue.offer(new int[]{newX, newY, moves + 1});
                        }
                    } else {
                        // If there's an obstacle or the cell is out of bounds, stop checking further in this direction
                        break;
                    }
                }
            }
        }

        return -1; // Impossible to reach the target cell
    }

    public static void main(String[] args) {
        List<List<Integer>> maze = Arrays.asList(
                Arrays.asList(0, 0, 0),
                Arrays.asList(1, 0, 0)
        );
        int jumpParameter = 5;
        System.out.println(getMinimumMoves(maze, jumpParameter)); // Output should be the minimum number of moves
    }
}
