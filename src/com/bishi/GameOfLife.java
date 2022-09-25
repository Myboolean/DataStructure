package com.bishi;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;


public class GameOfLife extends Thread{
    private final int [][] arr;
    private final ReentrantLock lock = new ReentrantLock(); //读写冲突加锁
    public GameOfLife(int[][] arr) {
        this.arr = arr;
    }


    private void updateNextState(int[][] arr){
        int M = arr.length;
        int N = arr[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                try {
                    Thread.sleep(100);
                    lock.lock();
                    try {
                        arr[i][j] = getNextVal(arr, i ,j);
                        printMatrix(arr);
                    }finally {
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println();
        }
    }
    private int countLivingNeighbors(int [][] a, int i, int j){
        int count = 0;
        int n = a.length;
        int m = a[0].length;
        int []dx = new int[]{0, 1, 0, -1, -1, -1 ,1, 1};
        int []dy = new int[]{-1, 0, 1, 0, 1, -1, -1, 1};
        for (int k = 0; k < 8; k++) {
            int c = i + dx[k] , d = j + dy[k];
            if(c >= 0 && c < n && d >=0 && d < m && a[c][d] == 1){
                count++;
            }
        }
        return count;
    }


    private int getNextVal(int [][]a, int i, int j){
        int nextVal = 0;
        int count = countLivingNeighbors(a, i, j);
        if(a[i][j] == 0){
            if(count == 3) nextVal = 1;
        }else {
            if(count == 2|| count == 3) nextVal = 1;
        }

        return nextVal;
    }

    @Override
    public String toString() {
        return "GameOfLife{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
    private void printMatrix(int [][] arr){


        int N = arr[0].length;
        for (int[] ints : arr) {
            for (int j = 0; j < N; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

    }
    @Override
    public void run() {

            updateNextState(this.arr);


    }

    public static void main(String[] args) {
        int [][] a = new int [][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        GameOfLife gameOfLife = new GameOfLife(a);

        gameOfLife.start();


        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
