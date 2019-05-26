package Arrays;

/**
 * created by LMR on 2019/5/20
 */
public class SolveSuDu {
    public static void main(String[] args) {

    }


    public void solveSudoku(char[][] board) {

        boolean hflag[][] = new boolean[9][9];
        boolean lflag[][] = new boolean[9][9];
        boolean block[][] = new boolean[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    int value = board[i][j] - '1';
                    hflag[i][value] = true;
                    lflag[j][value] = true;
                    block[i / 3 * 3 + j / 3][value] = true;
                }
            }//存储初始状态
        dfs(board, hflag, lflag, block, 0, 0);
    }

    public boolean dfs(char[][] board, boolean[][] hflag, boolean[][] lflag, boolean[][] block, int i, int j){

        while (board[i][j] != '.')//找到空得点
        {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 1; num < 10; num++)
        {
            if (!hflag[i][num] && !lflag[j][num] && !block[i / 3 * 3 + j / 3][num])
            {
                board[i][j] = (char) ('0' + num);
                hflag[i][num] = true;
                lflag[j][num] = true;
                block[i / 3 * 3 + j / 3][num] = true;
                if (dfs(board, hflag, lflag, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    hflag[i][num] = false;
                    lflag[j][num] = false;
                    block[i / 3 * 3 + j / 3][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;

    }


}
