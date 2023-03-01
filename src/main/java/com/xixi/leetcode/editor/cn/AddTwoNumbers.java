package com.xixi.leetcode.editor.cn;

public class AddTwoNumbers{
    public static void main(){
        Solution solution = new AddTwoNumbers().new Solution();
    }
    

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else {
            if (l2 == null){
                return l1;
            }else {
                return sub(l1,l2);
            }
        }
    }

    public ListNode sub(ListNode l1, ListNode l2) {
        int tmp;
        ListNode res = new ListNode();
        ListNode nextNode = res;
        int next = 0;
        while (l1 != null || l2 != null || next == 1){
            if (next > 0){
                if (l1 == null){
                    if(l2 == null){
                        tmp = next;
                    }else{
                        tmp = l2.val + next;
                    }
                }else if (l2 == null){
                    if(l1 == null){
                        tmp = next;
                    }else{
                        tmp = l1.val + next;
                    }
                }else {
                    tmp = l1.val + l2.val + next;
                }
            }else {
                if (l1 == null){
                    tmp = l2.val;
                }else if (l2 == null){
                    tmp = l1.val;
                }else {
                    tmp = l1.val + l2.val;
                }
            }
            if (tmp > 9){
                nextNode.val = tmp % 10;
                next = 1;
            }else {
                nextNode.val = tmp;
                next = 0;
            }
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
            if (l1 != null || l2 != null || next == 1){
                nextNode.next = new ListNode();
                nextNode = nextNode.next;
            }
        }
        return res;
    }
}


}