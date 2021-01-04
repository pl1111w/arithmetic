package algorithm.backTracking;

/**
 * @title: pl1111w
 * @description: 回溯-矩阵中的路径
 * @author: Kris
 * @date 2021/1/4 22:35
 */
public class TraceOfMatrix {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        char[] words = {'A', 'B', 'C', 'C', 'E', 'D'};

        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = exist(board, words, visited);
        System.out.println(result);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static boolean exist(char[][] board, char[] words, boolean[][] visited) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, char[] words, boolean[][] visited, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || words[index] != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (index == words.length - 1) {
            return true;
        }
        boolean res;

        res = dfs(board, words, visited, i + 1, j, index + 1) |
                dfs(board, words, visited, i, j + 1, index + 1) |
                dfs(board, words, visited, i - 1, j, index + 1) |
                dfs(board, words, visited, i, j - 1, index + 1);
        return res;

    }
}
