package com.study.top100liked;

import java.math.BigInteger;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = concatList(l1).add(concatList(l2));
        char[] sumAry = sum.toString(10).toCharArray();

        ListNode node = null;
        for (char val : sumAry) {
            node = new ListNode(Character.getNumericValue(val), node);
        }

        return node;
    }

    private BigInteger concatList(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(node.val);
        } while ((node = node.next) != null);

        return new BigInteger(stringBuilder.reverse().toString());
    }
}
