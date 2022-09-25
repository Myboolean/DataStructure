package com.linkedlist;

import java.util.Scanner;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key  = ' ';
        String s1= "";
        String s2= "";
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        int value;
        boolean loop = true;
        while(loop){
            key = scanner.next().charAt(0);
            switch (key){
                case 'e':
                    loop = false;
                    break;
                case 'l':

                    singleLinkedList.list();
                    break;
                case 'a':
                    System.out.println("请输入英雄的id：");
                    value = scanner.nextInt();
                    System.out.println("请输入英雄的姓名：");
                    s1 = scanner.next();
                    System.out.println("请输入英雄的昵称：");
                    s2 = scanner.next();
                    HeroNode p = new HeroNode(value,s1,s2);
                    singleLinkedList.addNode(p);
                    break;
            }

        }

    }
}
class SingleLinkedList{
    private HeroNode head = new HeroNode(0," "," ");
    public void addNode(HeroNode p){
        p.next = head.next;
        head.next = p;
    }
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
       while(head.next!=null){
           System.out.println(head);
           head = head.next;
       }

    }
}
class HeroNode implements Comparable{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ",next="+next+
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) throw new RuntimeException("输入为空，出现数据错误");
        HeroNode o1 = (HeroNode) o;
        return this.no - o1.no;
    }
}
