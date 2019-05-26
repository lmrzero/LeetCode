package Arrays;

/**
 * created by LMR on 2019/5/21
 */
public class NQueen2_y {

    public int totalNQueens(int n) {
        return solveNQueens(new int[n], n, 0);
    }

    public int solveNQueens(int[] position, int n, int index) {
        if (index == n) {
            return 1;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            position[index] = i;//当前行的数
            boolean conflict = false;
            for (int j = 0; j < index; j++) {
                if (position[j] == position[index] || Math.abs(index - j) == Math.abs(position[j] - position[index])) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict) {//当前行填入i满足前面的行则往下遍历
                num += solveNQueens(position, n, index + 1);
            }
        }
        return num;
    }
}
