package com.example.demo.leetcode;

import com.alibaba.fastjson.JSON;
import java.math.BigInteger;
import java.util.Optional;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Solution {

  public static void main(String[] args) {
    log.warn(
        addTwoNumbers1(
        new ListNode(2, new ListNode(4, new ListNode(3))),
        new ListNode(5, new ListNode(6, new ListNode(4))))
    );
    log.warn(
        addTwoNumbers2(
            new ListNode(1, new ListNode(8)),
            new ListNode(0))
    );
  }

  @Getter
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
        return JSON.toJSONString(this);
      }
    }

  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int add) {
    l1 = Optional.ofNullable(l1).orElse(new ListNode(0));
    l2 = Optional.ofNullable(l2).orElse(new ListNode(0));
    int sum = l1.val + l2.val + add;
    if (sum > 9) {
      sum -= 10;
      add = 1;
    } else {
      add = 0;
    }

    if ((add == 1) || (null != l1.next && null != l2.next)) {
      return new ListNode(sum, addTwoNumbers(l1.next, l2.next, add));
    } else if (null != l1.next) {
      return new ListNode(sum, l1.next);
    } else if (null != l2.next) {
      return new ListNode(sum, l2.next);
    }

    return new ListNode(sum, null);
  }

  public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
//    int sum = l1.val + l2.val;
//    int add = 0;
//    if (sum > 9) {
//      sum -= 10;
//    }
    String s = String.valueOf(parseNumber("", l1).add(parseNumber("", l2)));
    log.error(s);
    ListNode listNode = null;
    for (String s1 : s.split("")) {
      listNode = new ListNode(Integer.parseInt(s1), listNode);
    }
    return listNode;
  }
  public static BigInteger parseNumber(String s, ListNode listNode) {
    if (listNode != null) {
      s = listNode.val + s;
      return parseNumber(s, listNode.next);
    } else {
      return new BigInteger(s);
    }
  }

}
