package com.study.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        int start = 0;
        int first = nums[start];
        while (first <= 0 && start < nums.length - 2) {
            if (start == 0 || first != nums[start - 1]) {
                int end = nums.length - 1;
                int third = nums[end];
                while (third >= 0 && start < end) {
                    if (end == nums.length - 1 || third != nums[end + 1]) {
                        int sum = first + third;
                        int mid = sum >= 0 ? start + 1 : end - 1;
                        int second = nums[mid];
                        while (mid > start && mid < end && ((sum >= 0 && second <= 0) || (sum < 0 && second > 0))) {
                            if (sum + second == 0) {
                                answer.add(List.of(first, second, third));
                                break;
                            }

                            mid = sum >= 0 ? mid + 1 : mid - 1;
                            second = nums[mid];
                        }
                    }

                    third = nums[--end];
                }
            }

            first = nums[++start];
        }

        return answer;
    }
}
