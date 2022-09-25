package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s:show队列");
            System.out.println("e:exit");
            System.out.println("a:add");
            System.out.println("d:delete");
            System.out.println("h:head");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    try {
                        System.out.println("输入一个数");
                        int value = scanner.nextInt();
                        arrayQueue.addQueue(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'd':
                    try {
                        int delete = arrayQueue.delete();
                        System.out.println(delete);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.showHead();
                        System.out.println(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

        }


    }
}
// 使用数组模拟队列
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue() {
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    public boolean isEmpty(){
        return (rear + maxSize - front) % maxSize == 0;
    }
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    public void addQueue(int x){
        if(isFull()){
            System.out.println("队列满不能加入数据");
        }else
        {
            arr[rear] = x;
            rear = (rear + 1) % maxSize;
        }
    }
    public int delete(){
        if (isEmpty()) throw new RuntimeException("队列空，不能取数据");
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }
    public void showQueue(){
        if(isEmpty()) throw new RuntimeException("队列为空");
        for (int i =front; i < front + (rear + maxSize - front) % maxSize; i++) {
            int val = arr[i % maxSize];
            System.out.print("\t"+ i % maxSize + " "+val);
        }
    }


    public int showHead(){
        if(isEmpty()) throw new RuntimeException("队列为空");
        return arr[front + 1];
    }
}