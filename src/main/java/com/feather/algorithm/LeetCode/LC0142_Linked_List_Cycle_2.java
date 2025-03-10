package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author Milo
 * @date 2025/3/10 18:01
 */
public class LC0142_Linked_List_Cycle_2 {
    Tag[] tags = {Tag.LinkList, Tag.TWO_POINTERS};

    /**
     * 1. 找到两指针的相遇点 A
     * 2. 起点到 A 的距离  ==  相遇点到 A 的距离
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }

        }
        return null;
    }
}
