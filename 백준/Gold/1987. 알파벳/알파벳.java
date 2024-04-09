import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[] check;
    static char[][] arr;
    static int r,c,max;

    static void dfs(int x,int y, int depth){
        max = Math.max(depth,max);
        check[arr[x][y]-65]=true;
        for(int i=0;i<4;i++){
            int nr = x+dr[i];
            int nc = y+dc[i];
            if(nr<0||nc<0||nr>=r||nc>=c)continue;
            if(check[arr[nr][nc]-65])continue;
            dfs(nr,nc,depth+1);
        }
        check[arr[x][y]-65]=false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for(int i=0;i<r;i++){
            String s = bf.readLine();
            for(int j=0;j<c;j++){
                arr[i][j]=s.charAt(j);
            }
        }
        check = new boolean[26];
        dfs(0,0,1);
        System.out.println(max);
    }
}