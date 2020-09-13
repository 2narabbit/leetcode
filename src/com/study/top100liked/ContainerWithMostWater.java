package com.study.top100liked;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                int width = j - i;

                int water = Math.min(right, left) * width;
                if (water > maxWater) {
                    maxWater = water;
                }
            }
        }

        return maxWater;
    }
}
