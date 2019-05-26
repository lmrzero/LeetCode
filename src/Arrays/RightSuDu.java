package Arrays;

/**
 * created by LMR on 2019/5/20
 */
public class RightSuDu {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {

        boolean hflag[][] = new boolean[9][10];
        boolean lflag[][] = new boolean[9][10];
        boolean xg[][][] = new boolean[3][3][10];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    int value = board[i][j] - '0';
                    if (!hflag[i][value])
                        hflag[i][value] = true;
                    else
                        return false;
                    if (!lflag[j][value])
                        lflag[j][value] = true;
                    else
                        return false;
                    if (!xg[i / 3][j / 3][value])
                        xg[i / 3][j / 3][value] = true;
                    else
                        return false;
                }
            }

        return true;
    }
}
