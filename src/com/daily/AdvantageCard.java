package com.daily;

import learn.heap.PriorityQueue;
import learn.queue.Queue;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/10/8
 * Time: 9:57
 */

/**
 * 
 * vector<int> advantageCount(vector<int>& nums1, vector<int>& nums2) {
 *         int n = nums1.size();
 *         vector<int> res(n);
 *         sort(nums1.begin(), nums1.end());
 *         priority_queue<pair<int,int>> p;
 *         for(int i = 0 ; i <  n;i++){
 *             p.push({nums2[i], i});
 *         }
 *         int i = n - 1;
 *         int cnt = 0;
 *         while(p.size()){
 *             auto t = p.top();
 *             int v = t.first, pos = t.second;
 *             cout<< pos;
 *             p.pop();
 *             if(nums1[i] > v) res[pos] = nums1[i--];
 *             else {
 *                 res[pos] = nums1[cnt++];
 *             }
 *
 *         }
 *         return res;
 *     }
 */
public class AdvantageCard {

    static int [] advantageCount(int [] nums1, int [] nums2){
        Integer [] res = new Integer [nums1.length];

        int n = nums1.length;

        Arrays.sort(nums1);
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }
        Arrays.sort(res,  (i, j) -> nums2[i] - nums2[ j]);
        int L = 0, R = n - 1; // nums2(索引)的左右指针
        for (int i : nums1) { // 遍历nums1
            if (i > nums2[res[L]]) nums2[res[L++]] = i; // 可以满足 nums1[i] > nums2[i]
            else nums2[res[R--]] = i; //丢到数组最后
        }
        return nums2;
    }

    public static void main(String[] args) {
        int [] nums1 = {2,7,11,15};
        int [] nums2 = {1,10,4,11};

        System.out.println(Arrays.toString(Arrays.stream(advantageCount(nums1, nums2)).toArray()));
    }
}
