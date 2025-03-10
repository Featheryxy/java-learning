package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Milo
 * @date 2025/3/10 18:01
 */
public class LC0141_Linked_List_Cycle {
    Tag[] tags = {Tag.LinkList, Tag.TWO_POINTERS};

    /**
     * 快慢指针，慢指针移动一步，快指针移动两步。
     * 当两指针相遇时，表明链表有环。快指针移动为null 无环
     * ps：同时判断快指针是否为null， 以及其下一个节点是否为null
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode loop = head;
        while (loop != null) {
            if (set.contains(loop)) {
                return true;
            }

            set.add(loop);

            loop = loop.next;
        }
        return false;
    }
}
