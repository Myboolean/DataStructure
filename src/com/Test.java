package com;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/6/28
 * Time: 17:08
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        swap(a, b);
        System.out.println(a + "   " + b);
    }
    public static void swap(int a,int b){
        int temp  = a;
        a = b;
        b = temp;
    }
}
