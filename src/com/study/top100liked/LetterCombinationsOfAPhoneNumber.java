package com.study.top100liked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static final String[] LETTERS = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        String[] letters = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - 48;
            letters[i] = LETTERS[c - 2];
        }

        List<String> result = new ArrayList<>();
        combination(letters, 0, "", result);

        return result;
    }

    private void combination(String[] letters, int index, String str, List<String> result) {
        String letter = letters[index];
        for (char c : letter.toCharArray()) {
            if (index == letters.length - 1) {
                result.add(str + c);
            } else {
                combination(letters, index + 1, str + c, result);
            }
        }
    }
}
