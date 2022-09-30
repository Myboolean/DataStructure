package com.daily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/28
 * Time: 10:45
 * ugly number
 */
public class KthNumber {
    int [] factors = {3, 5, 7};
    public int getKthMagicNumber(int k) {
        int ans = 0;
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        seen.add(1L);
        for (int i = 0; i < k; i++) {
            long cur = heap.poll();
            ans = (int) cur;
            for(int factor: factors){
                long next = cur * factor;
                if(seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
