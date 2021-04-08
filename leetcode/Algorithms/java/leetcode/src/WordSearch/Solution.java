package WordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        //boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, words, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, char[] words, int i, int j, int k) {

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) {
            return false;
        }

        if (k == words.length - 1) {
            return true;
        }

        char tmp = board[i][j];
        board[i][j] = '*';
        boolean flag = check(board, words, i + 1, j, k + 1) ||
                check(board, words, i, j + 1, k + 1) ||
                check(board, words, i - 1, j, k + 1)
                || check(board, words, i, j - 1, k + 1);
/*        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : directions) {
            int newi = i + d[0];
            int newj = j + d[1];
            if (newi >=0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, words, newi, newj, k + 1);
                    if (flag) {
                        return true;
                    }
                }
            }
        }*/
        board[i][j] = tmp;
        return flag;
    }
}
