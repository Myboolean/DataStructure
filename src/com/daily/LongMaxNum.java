package com.daily;

import learn.segementtree.SegementTree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/25
 * Time: 19:11
 */
public class LongMaxNum {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longLength = 1;
        for (int num: nums) {
            set.add(num);
        }
        for(int s:set){

            if(!set.contains(s - 1)){
                int curNum = s;
                int curLength = 1;
                while(set.contains(curNum + 1)){
                    curNum += 1;
                    curLength+=1;
                }
                longLength = Math.max(longLength, curLength);
            }
        }
        return longLength;


    }

    public static void main(String[] args) {
        int []nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
