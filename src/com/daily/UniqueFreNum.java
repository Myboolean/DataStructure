package com.daily;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/26
 * Time: 11:08
 */
public class UniqueFreNum {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {

            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);

        }

        Set<Integer> s = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry: m.entrySet()){
            s.add(entry.getValue());
        }

        return m.size() == s.size();

    }
    public static void main(String[] args) {

    }

}
