import java.io.*;
import java.util.*;

public class Main{
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[] alphabet;
    static char[][] arr;
    static int r,c;
    static int max = Integer.MIN_VALUE;
    static void dfs(int x, int y, int cnt){
        if(alphabet[arr[x][y]-'A']) {
            max = Math.max(cnt,max);
            return;
        }
        alphabet[arr[x][y]-'A']=true;
        for(int i=0;i<4;i++){
            int nr = dr[i]+x;
            int nc = dc[i]+y;
            if(nr<0||nc<0||nr>=r||nc>=c)continue;
            dfs(nr,nc,cnt+1);
        }
        alphabet[arr[x][y]-'A']=false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for(int i=0;i<r;i++) {
            String s = bf.readLine();
            arr[i] = s.toCharArray();
        }
        alphabet = new boolean[26];
        dfs(0,0,0);
        System.out.println(max);
    }
}