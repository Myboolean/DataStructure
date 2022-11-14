package utils;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/11/14
 * Time: 17:56
 */
public class Merge {
    private static int [] temp ;
    public static void sort(int [] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int l, int r) {
        if(l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l , mid);
        sort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }
    private static void merge(int[] nums, int l, int mid, int r) {
        // 以便合并后的结果能够直接存入 nums
        for (int i = l; i <= r; i++) {
            temp[i] = nums[i];
        }
        int i = l ,j = mid + 1;

        for (int k = l; k <= r ; k++) {
            if(i >= mid + 1) {
                nums[k] = temp[j++];
            } else if(j > r) {
                nums[k] =temp[i++];
            } else if(temp [i] <= temp[j]) {
                nums[k] = temp[i++];
            }else {
                nums[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3213, 1, 414, 141, 141, 41, 4, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
