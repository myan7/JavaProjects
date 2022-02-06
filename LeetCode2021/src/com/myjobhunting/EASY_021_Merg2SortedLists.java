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


    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else
            {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;
        else if(list2 != null )
            curr.next = list2;

        return sentinel.next;
    }

}
