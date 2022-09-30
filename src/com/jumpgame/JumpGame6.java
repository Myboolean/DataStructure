package com.jumpgame;

import java.awt.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/27
 * Time: 17:23
 */
public class JumpGame6 {
    class Point implements Comparable{
        int x;
        int y;
        public Point(int x, int y){
            this.x =x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point o1 = (Point) o;
            return this.x - o1.x;
        }
    }
    int [] f = new int [100010];
    // 单调队列优化
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Point> deque = new LinkedList<>();
        int ans = nums[0];
        deque.offer(new Point(nums[0], 0));
        for (int i = 1; i < n; i++) {

            while(i - deque.peekFirst().y > k) deque.pollFirst();
            ans  = deque.peekFirst().x + nums[i];

            while(!deque.isEmpty() && ans >= deque.peekLast().x) deque.pollLast();
            deque.offer(new Point(ans, i));

        }
        return  ans;
    }
    public int priorityQueueMaxResult(int [] nums, int k){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(nums[0], 0));
        int n = nums.length;
        int ans = nums[0];
        for(int i = 1; i < n ; i++){
            while(i  - pq.peek().y > k) pq.poll();
            ans = pq.peek().x + nums[i];
            pq.offer(new Point(ans, i));
        }
        return ans;
    }

    public int chaoshi(int [] nums, int k){
        int n = nums.length;
        for(int i = 0 ; i < n;i++) f[i] = Integer.MIN_VALUE;
        f[0] = nums[0];
        for(int i = 1 ; i < n;i++){

            for(int j = Math.max(0, i - k); j < i;j++){
                f[i] = Math.max(f[i], f[j] + nums[i]);
            }
        }
        return f[n - 1];
    }
    public static void main(String[] args) {

    }
}
