package com.myjobhunting;

public class EASY_021_Merg2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        else
        {
            if (l1.val < l2.val)
            {
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }
            else
            {
                l2.next = mergeTwoLists(l1,l2.next);
                return l2;
            }
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        return l1;
    }

}
