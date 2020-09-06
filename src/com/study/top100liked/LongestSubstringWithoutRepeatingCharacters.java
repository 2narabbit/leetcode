package com.study.top100liked;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int startIndex = 0;
        int curIndex, dupIndex;
        for (curIndex = 0; curIndex < s.length(); curIndex++) {
            for (dupIndex = startIndex; dupIndex < curIndex; dupIndex++) {
                if (s.charAt(dupIndex) == s.charAt(curIndex)) {
                    break;
                }
            }

            if (dupIndex < curIndex) {
                int len = curIndex - startIndex;
                if (len > maxLen) {
                    maxLen = len;
                }
                startIndex = dupIndex + 1;
            }
        }

        int len = curIndex - startIndex;
        if (len > maxLen) {
            maxLen = len;
        }

        return maxLen;
    }
}
