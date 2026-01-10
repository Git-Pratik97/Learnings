package recursion;

public class WordSearchGrid {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};

        String word = "ABCCED";
        boolean[][] visited = new boolean[board.length][board[0].length];

        boolean result = backtrack(board, word, 0, 0, 0, visited);

        System.out.println("If the word can be formed in board or nor ? " + result);
    }

    public static boolean backtrack(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        if(backtrack(board, word, index + 1, i + 1, j, visited) ||
        backtrack(board, word, index + 1, i - 1, j, visited) ||
        backtrack(board, word, index + 1, i, j + 1, visited) ||
        backtrack(board, word, index + 1, i, j - 1, visited)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
