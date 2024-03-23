package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of N integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum chocolates given to the students is minimum.
Examples:

Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3
Output: Minimum Difference is 2
Explanation:
We have seven packets of chocolates and we need to pick three packets for 3 students
If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.

Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5
Output: Minimum Difference is 6
 */
public class ChocolateDistribution {

    int distributeChocolate(int[] arr, int m) {
        int result = Integer.MAX_VALUE;

        if (arr == null || arr.length == 0 || m == 0) return 0;
        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        if (arr.length - 1 < m) return -1;

        int i = 0;

        while (i + m <= arr.length) {
            int firstEle = arr[i];
            int lastEle = arr[i + m - 1];
            int cal = lastEle - firstEle;

            result = Math.min(cal, result);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        //int[] arr = {7, 3, 2, 4, 9, 12, 56};int m = 3;
        //int[] arr = {3, 4, 1, 9, 56, 7, 9, 12}; int m = 5;
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50}; int m = 7;

        System.out.println(new ChocolateDistribution().distributeChocolate(arr, m));
    }
}
