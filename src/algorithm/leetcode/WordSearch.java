package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  上午9:29 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class WordSearch {


    /**
     * 按照深度优先搜索的思想寻找
     * <p>
     * 但是会Time Limit Exceeded
     * <p>
     * todo  为什么会超时
     *
     * 更新：---
     * 加了一个!res的判断
     * 就不超时了，原因是：提前结束搜索
     *
     *
     *
     * @param board
     * @param word
     * @return
     */
    boolean res = false;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        int m = board.length;//行数
        int n = board[0].length;//列数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, word, 0, i, j);
            }
        }
        return res;
    }

    public void helper(char[][] board, String word, int index, int idx1, int idx2) {
        if (index == word.length()) {
            res = true;
        } else {
            //这里加了一个!res的判断，就可以通过了
            //也就是一旦找到符合要求的路径，就不再继续搜索
            if (!res && idx1 >= 0 && idx1 < board.length && idx2 >= 0 && idx2 < board[idx1].length) {
                char c = board[idx1][idx2];
                if ((index < word.length()) && (c == word.charAt(index))) {
                    board[idx1][idx2] = '#';
                    helper(board, word, index + 1, idx1, idx2 + 1);
                    helper(board, word, index + 1, idx1, idx2 - 1);
                    helper(board, word, index + 1, idx1 + 1, idx2);
                    helper(board, word, index + 1, idx1 - 1, idx2);
                    board[idx1][idx2] = c;
                }
            }
        }
    }


    /**
     *
     * 基于exist1的改进：
     * 同样是深度搜索优先，但是在找到一条符合要求的路径之后，就会结束整个搜索
     *
     * 而exist1则会一直进行完全的搜索，直到全部结束
     *
     * 可以通过leetcode
     *
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist2(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length;//行数
        int n = board[0].length;//列数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper2(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper2(char[][] board, String word, int index, int idx1, int idx2) {
        if (index == word.length()) {
            return true;
        }

        if (idx1 < 0 || idx1 >= board.length || idx2 < 0 || idx2 >= board[idx1].length) {
            return false;
        }

        char c = board[idx1][idx2];

        if (c != word.charAt(index)) {
            return false;
        }

        board[idx1][idx2] = '#';
        boolean exist = helper2(board, word, index + 1, idx1, idx2 + 1) ||
                helper2(board, word, index + 1, idx1, idx2 - 1) ||
                helper2(board, word, index + 1, idx1 + 1, idx2) ||
                helper2(board, word, index + 1, idx1 - 1, idx2);

        board[idx1][idx2] = c;
        return exist;
    }


    /**
     * 来自：https://leetcode.com/problems/word-search/discuss/27765
     * <p>
     * todo 跟我写的差不多，为什么就可以通过呢
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist3(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
                dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
                dfs(board, words, idx + 1, x - 1, y);
        board[x][y] ^= 256;
        return exist;
    }


    @Test
    public void test() {
        //char[][] ch = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        char[][] ch = {{'A', 'B' }};
        String word = "BA";
        System.out.println(exist(ch, word));


    }
}
