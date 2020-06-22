package com.zxw.leetcode.algorithm;

/**
 * @author zxw
 * @date 2020/6/19 15:44
 */
public class JuneDay {
    public static void main(String[] args) {
        JuneDay juneDay = new JuneDay();
        juneDay.isPalindrome("race a car");
    }

    /**
     * 125. 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(r))){
                r++;
                continue;
            }
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 面试题 16.18. 模式匹配
     * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
     *
     * 示例 1：
     *
     * 输入： pattern = "abba", value = "dogcatcatdog"
     * 输出： true
     *
     * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        return false;
    }
}
