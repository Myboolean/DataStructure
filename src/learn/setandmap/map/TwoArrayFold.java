package learn.setandmap.map;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/22
 * Time: 11:31
 */
public class TwoArrayFold {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums1){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num , 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) map.remove(num);
            }
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        int [] res = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            res[i] = integers[i];
        }
        return  res;
    }
}
