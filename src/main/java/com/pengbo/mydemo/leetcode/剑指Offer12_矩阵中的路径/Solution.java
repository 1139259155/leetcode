package com.pengbo.mydemo.leetcode.剑指Offer12_矩阵中的路径;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public char[][] board;
    public byte[][] visited;
    public String word;
    public int row;
    public int column;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.row = board.length;
        this.column = board[0].length;
        this.word = word;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    this.visited = new byte[this.row][this.column];
                    if (dfs(i, j, 0) > 0)
                        return true;
                }
            }
        }
        return false;
    }

    private int dfs(int i, int j, int walk) {
        // if outOfBound or has visited or exceed word's length or wrong way
        if (i < 0 || i >= row || j < 0 || j >= column || visited[i][j] == 1 || walk >= word.length() || board[i][j] != word.charAt(walk)) {
            return 0;
        }

        visited[i][j] = 1;

        // path match word
        if (walk == word.length() - 1) {
            return 1;
        }

        if (dfs(i - 1, j, walk + 1) > 0) { // up
            return 1;
        } else if (dfs(i + 1, j, walk + 1) > 0) { // down
            return 1;
        } else if (dfs(i, j - 1, walk + 1) > 0) { // left
            return 1;
        } else if (dfs(i, j + 1, walk + 1) > 0) { // right
            return 1;
        } else {
            // 退格，消除访问记录
            visited[i][j] = 0;
            return 0;
        }
    }

    public static void main(String[] args) {

        /**
         * {{'A','B','C','E'},
         * {'S','F','E','S'},
         * {'A','D','E','E'}}
         */
        Solution solution1 = new Solution();
        System.out.println(solution1.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));

        /**
         * {'a', 'b', 'c', 'e'},
         * {'s', 'f', 'c', 's'},
         * {'a', 'd', 'e', 'e'}
         */
        Solution solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "abfb"));

        /**
         * {'A', 'B', 'C', 'E'},
         * {'S', 'F', 'C', 'S'},
         * {'A', 'D', 'E', 'E'}
         */
        solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));

        /**
         * {'a', 'b'},
         * {'c', 'd'}
         */
        solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "abcd"));

    }
}
