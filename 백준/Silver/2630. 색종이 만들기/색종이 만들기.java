import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int blue,white;
    static int[][] arr;

    static void papering(int x1,int y1, int x2,int y2){
        int flag = arr[x1][y1];
        boolean realFlag=false;
        loop:
        for(int i=x1;i<x2;i++){
            for(int j=y1;j<y2;j++){
                if(arr[i][j]!=flag) {
                    realFlag=true;
                    break loop;
                }
            }
        }
        if (realFlag) {
            papering(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
            papering((x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
            papering(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
            papering((x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
        }else {
            if (flag == 1)
                blue++;
            else white++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        papering(0,0,n,n);
        System.out.println(white);
        System.out.println(blue);
    }
}
