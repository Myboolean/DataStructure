package com.sparse;

import javax.print.DocFlavor;
import java.io.*;

public class ExerSparse {
    public static void main(String[] args) {
        rd();

    }
    public static void rd(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("map.txt"));
            String res;
            res = bufferedReader.readLine();
            String[] row= res.split(" ");
            int[][] reArr = new int[Integer.parseInt(row[0])][Integer.parseInt(row[1])];
            int num = Integer.parseInt(row[2]);
            while((res = bufferedReader.readLine()) != null){
                String[] rows= res.split(" ");
                int i = Integer.parseInt(rows[0]);
                int j = Integer.parseInt(rows[1]);
                int k = Integer.parseInt(rows[2]);
                reArr[i][j] = k;
            }
            for(int[] rows:reArr){
                for (int data:rows){
                    System.out.print("\t"+data);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader !=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void wr(){
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0) sum++;
            }
        }
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        int cnt = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j]!=0) {
                    sparseArr[cnt][0] = i;
                    sparseArr[cnt][1] = j;
                    sparseArr[cnt++][2] =chessArr1[i][j];
                }
            }
        }
        //创建输出流对象
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("map.txt"));
            String str;
            for (int i = 0; i < sum+1; i++) {
                str = sparseArr[i][0]+ " "+ sparseArr[i][1] + " "+ sparseArr[i][2];
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
