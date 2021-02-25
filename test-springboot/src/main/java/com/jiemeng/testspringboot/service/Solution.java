//package com.jiemeng.testspringboot.service;
//
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//@Service
//public class Solution {
//    //两数之和测试
//    public static int[] towSum(int[] nums,int target){
//        addTwoNumbers();
//
//        for (int i = 0; i <nums.length ; i++) {
//            for (int j = i+1; j <nums.length ; j++) {
//                if((nums[i]+nums[j])==target){
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[0];
//    }
//
//    public static void main(String[] args) {
//        int[] ll=new int[]{2,3,4,6};
//        int[] value=towSum(ll,9);
//        for (int i = 0; i <value.length ; i++) {
//            int l=value[i];
//            System.out.println(l);
//        }
//        System.out.println(Arrays.toString(value));
//        int a = 0;
//        for (int i = 0; i < 99; i++) {
//            System.out.println(i);
//            a ++;
//
//        }
//        System.out.println(a);
//
//        int b = 0;
//        for (int i = 0; i < 99; i++) {
//            b = ++ b;
//        }
//        System.out.println(b);
//        System.out.println("-----------------");
//        a = 2;
//        b = (3 * a++) + a;
//        System.out.println(b);
//        System.out.println("+++++++++++");
//        a = 2;
//        b = a+(3 * a+1) ;
//        System.out.println(b);
//
//
//    }
//
//
//    public static ListNode addTwoNumbers(){
//
//        int[]  ll1={2,3,4};
//        int[] ll2={5,6,4};
//        int l1=arrayToInt(ll1);
//        int l2=arrayToInt(ll2);
//        int num=l1+l2;
//
//        String str=String.valueOf(num);
//        int[] tem=new int[str.length()];
//        for (int i=0;i<str.length();i++){
//            tem[i]=Integer.parseInt(String.valueOf(str.charAt(str.length()-1-i)));
//        }
//        System.out.println(tem.toString());
//        return new ListNode();
//    }
//
//    public static int arrayToInt(int[] ll1){
//        int[] nu=new int[ll1.length];
//        for(int i=0;i<ll1.length;i++){
//            nu[i]=ll1[ll1.length-i-1];
//        }
//        String tes="";
//        for(int i=0;i<nu.length;i++){
//            tes=tes+nu[i];
//        }
//        return Integer.valueOf(tes);
//    }
//}
//class ListNode{
//    int val;
//    ListNode next;
//
//    public ListNode() {
//    }
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
