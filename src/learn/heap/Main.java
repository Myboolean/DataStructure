package learn.heap;

import javax.management.relation.RelationNotFoundException;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 16:04
 */
public class Main {
    public static double testHeap(Integer [] arr, boolean heapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if(heapify) maxHeap = new MaxHeap<>(arr);
        else {
            maxHeap = new MaxHeap<>();
            for(int num : arr) maxHeap.add(num);
        }
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = maxHeap.extractMax();
        }
        for (int i = 1 ; i < arr.length; i++) {
            if(arr1[i-1] < arr1[i]) throw new RuntimeException("not maxheap");
        }

        long endTime = System.nanoTime();


        return (startTime - endTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        Integer [] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 =testHeap(arr, false);
        double time2 = testHeap(arr, true);


        System.out.println("without heapify" + time1);

        System.out.println("with heapify" + time2);

    }
}
