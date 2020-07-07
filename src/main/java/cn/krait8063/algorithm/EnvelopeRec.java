package cn.krait8063.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * created by krait8064 at 2020/07/07
 */
public class EnvelopeRec {
    //    算法：
//    假设我们知道了信封套娃顺序，那么从里向外的顺序必须是按 w 升序排序的子序列。
//
//    在对信封按 w 进行排序以后，我们可以找到 h 上最长递增子序列的长度。、
//
//    我们考虑输入 [[1，3]，[1，4]，[1，5]，[2，3]]，如果我们直接对 h 进行 LIS 算法，我们将会得到 [3，4，5]，显然这不是我们想要的答案，因为 w 相同的信封是不能够套娃的。
//
//    为了解决这个问题。我们可以按 w 进行升序排序，若 w 相同则按 h 降序排序。则上述输入排序后为 [[1，5]，[1，4]，[1，3]，[2，3]]，再对 h 进行 LIS 算法可以得到 [5]，长度为 1，是正确的答案。这个例子可能不明显。
//
//    我们将输入改为 [[1，5]，[1，4]，[1，2]，[2，3]]。则提取 h 为 [5，4，2，3]。我们对 h 进行 LIS 算法将得到 [2，3]，是正确的答案。
//
//    PythonJava
//
//
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int maxEnvelopes(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i)
            secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }

    @Test
    public void test() {
        int[][] arr = {{1, 2}, {1, 4}, {1, 5}, {2, 3}};
        maxEnvelopes(arr);
    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, start = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i])
                start = i;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public int lis(int[] arr) {
        int len = 0;
        int[] dp = new int[arr.length];
        for (int num : arr) {
            int i = Arrays.binarySearch(arr, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    //Two SUM
//    var twoSum = function(nums, target) {
//        let res = {}
//        for (let i = 0; i < nums.length; i++) { // 每个人登记自己想要配对的人，让主持人记住
//            res[target - nums[i]] = nums[i]
//        }
//        for (let j = 0; j < nums.length; j++) { // 每个人再次报数的时候，主持人看一下名单里有没有他
//            if (res[nums[j]] !== undefined) {
//                return [nums[j], res[nums[j]]]
//            }
//        }
//    j}

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode prehead = new ListNode(-1);
//
//        ListNode prev = prehead;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//
//        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
//        prev.next = l1 == null ? l2 : l1;
//
//        return prehead.next;
//    }
//

    public Node merge(Node node0, Node node1) {
        Node res = new Node();
        if (node0.lessThan(node1)) {
            res.setNext(node0);
        } else {
            res.setNext(node1);
        }
        return res;
    }
    static class Node {
        Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean lessThan(Node node) {
            return true;
        }
    }

}
