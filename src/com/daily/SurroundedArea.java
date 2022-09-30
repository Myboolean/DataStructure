package com.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/9/25
 * Time: 20:33
 */
public class SurroundedArea {
    static int n;
    static int m;
    public static void dfs(char [][] g, int r, int c){
        if(r < 0 || r >= n || c < 0 || c >= m  || g[r][c] != 'O') return;
        g[r][c] = 'A';
        if(r - 1 >= 0 && g[r - 1][c] == 'O') dfs(g, r - 1, c);
        if(c - 1 >= 0 && g[r][c - 1] == 'O') dfs(g, r, c - 1);
        if(c + 1 < n && g[r][c + 1] == 'O') dfs(g, r, c + 1);
        if(r + 1 < m && g[r + 1][c] == 'O') dfs(g, r + 1, c);
    }
    public static void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i ,0);
            dfs(board, i , m - 1);
        }
        for(int i = 1 ; i < m - 1; i++){
            dfs(board, 0 ,i);
            dfs(board, n - 1 , i);
        }
        for(int i = 0 ; i < n;i++)
            for(int j = 0 ; j < m;j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O') board[i][j] = 'X';
            }

    }
}
