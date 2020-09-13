package com.study.top100liked;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int preAns = 0;
        int postAns = 0;

        for (int i = 0; i < s.length(); i++) {
            int pre = i - 1;
            int post = i + 1;
            while (post < s.length() && s.charAt(i) == s.charAt(post)) {
                post++;
            }

            while (pre >= 0 && post < s.length() && s.charAt(pre) == s.charAt(post)) {
                pre--;
                post++;
            }

            pre++;
            if (post - pre > postAns - preAns) {
                preAns = pre;
                postAns = post;
            }
        }

        return s.substring(preAns, postAns);
    }
}
