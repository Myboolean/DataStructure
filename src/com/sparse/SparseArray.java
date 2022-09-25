package com.sparse;

public class SparseArray {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        for(int[] row:chessArr1){
            for (int data:row){
                System.out.print("\t"+data);
            }
            System.out.println();
        }
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
        System.out.println("--------------------------");
        for(int[] row:sparseArr){
            for (int data:row){
                System.out.print("\t"+data);
            }
            System.out.println();
        }

        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int num = sparseArr[0][2];
        System.out.println(num);
        int[][] reArr = new int[row][col];
        for (int i = 1; i <= num; i++) {
            System.out.println(sparseArr[i][0]+ " "+sparseArr[i][1]);
            reArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("-----------------------------");
        for(int[] rows:reArr){
            for (int data:rows){
                System.out.print("\t"+data);
            }
            System.out.println();
        }
    }
}
