package com.example.demo.leetcode;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public class SolutionTests {

  @Test
  public void contextLoads() throws Exception {
    log.error("开始游戏");
//    log.warn(
//        addTwoNumbers1(
//            new ListNode(2, new ListNode(4, new ListNode(3))),
//            new ListNode(5, new ListNode(6, new ListNode(4))))
//    );
//    log.warn(
//        addTwoNumbers2(
//            new ListNode(1, new ListNode(8)),
//            new ListNode(0))
//    );
//    log.warn(maximumDifference(new int[]{2, 5, 1, 3, 6})); // 0 3
    log.warn(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    log.warn(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    log.error("结束游戏");
  }

  /**
   * 4. 寻找两个正序数组的中位数
   * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
   * 请你找出并返回这两个正序数组的中位数。
   * 要求算法的时间复杂度为 O(log (m+n)) 。
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // nums1.addAll(nums2)并正序排序
    List<Integer> list = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
        .boxed().sorted().collect(Collectors.toList());
    int size = list.size();
    if (size % 2 == 0) {
      return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
    } else {
      return list.get(size / 2);
    }
  }

  /**
   * 2016. 增量元素之间的最大差值
   * 给你一个下标从 0 开始的整数数组 nums ，如果存在 i < j 满足 nums[i] < nums[j] ，
   * 那么 nums[j] - nums[i] 的 最大值 为此对的差值。返回 最大差值 。如果不存在这样的对，返回 -1 。
   */
  public static int maximumDifference(int[] nums) {
//    Map<String, Integer> map = new HashMap<>();
//    map.put("minIndex", 0);
//    map.put("minNum", nums[0]);
//    map.put("maxIndex", 1);
//    map.put("maxNum", nums[1]);
//    for (int i = 2; i < nums.length - 1; i++) {
//      if (nums[i] >= map.get("maxNum")) {
//        map.put("maxIndex", i);
//        map.put("maxNum", nums[i]);
//      }
//      if (i < map.get("maxIndex") && nums[i - 1] < map.get("minNum")) {
//        map.put("minIndex", i - 1);
//        map.put("minNum", nums[i - 1]);
//      }
//    }
    return -1;
  }

  @Getter
  public static class ListNode {
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
