package com.zxw.leetcode.swordoffer;

import com.zxw.common.datastruct.ListNode;
import com.zxw.common.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zxw
 * @date 2020-05-11 08:8:46
 * @Description 牛客练习
 */
public class Test {

    public static void main(String[] args) {
        int n = 39;
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(31));
        while (n != 0) {
            n = n & (n - 1);
            System.out.println(n);
        }
        Test t = new Test();
        t.movingCount(4, 6, 15);
    }

    /**
     * 面试题03. 数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 示例 1：
     * 输入：
     * new int[]{2, 3, 1, 0, 2, 5, 3}
     * 输出：2 或 3
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //开始的
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }


    /**
     * 面试题04. 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // method 1: 暴力解法
        // 执行用时 :1 ms在所有 Java 提交中击败了31.41%的用户
        // 内存消耗 :45.5 MB, 在所有 Java 提交中击败了100.00%的用户
        boolean b = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        // method 2:线性解法
        // 执行用时 :0 ms在所有 Java 提交中击败了100%的用户
        // 内存消耗 :45.2 MB, 在所有 Java 提交中击败了100.00%的用户
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target < matrix[i][j]) {
                    break;
                }
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return b;
    }

    /**
     * 面试题05. 替换空格
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%");
    }

    /**
     * 面试题06. 从尾到头打印链表
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            int val = head.val;
            stack.push(val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; !stack.empty(); i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    /**
     * 面试题07. 重建二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }

    /**
     * 面试题10- I. 斐波那契数列
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 面试题10- II. 青蛙跳台阶问题
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[1] + dp[2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 面试题11. 旋转数组的最小数字
     * 示例 1：
     * 输入：[3,4,5,1,2]
     * 输出：1
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < res) {
                res = numbers[i];
            }
        }
        return res;
    }


    /**
     * 面试题12. 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     * 提示：
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        return false;
    }


    /**
     * 面试题13. 机器人的运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * 示例 1：
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                int sum = sum(i, j);
                if (sum <= k) {
                    res = dp[i][j] + 1;
                }
            }
        }
        int mid = m > n ? m : n;
        return res + 1 > mid ? res + 1 : mid;
    }

    /**
     * 面试题15. 二进制中1的个数
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    /**
     * 面试题16. 数值的整数次方
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n % 2 == 0) {
            double t = myPow(x, n / 2);
            return t * t;
        } else {
            double t = myPow(x, n / 2);
            if (n < 0) x = (1 / x);
            return t * t * x;
        }
    }

    private int sum(int m, int n) {
        int sum = 0;
        while (m > 10) {
            sum += m % 10;
            m = m % 10;
        }
        sum += m;
        while (n > 10) {
            sum += n % 10;
            n = n % 10;
        }
        sum += n;
        return sum;
    }


}
