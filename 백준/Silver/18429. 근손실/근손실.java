import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static void combi(int start,int depth){
        if(depth==n){
            cnt++;
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(start-k+arr[i]<500)continue;
            if(visited[i])continue;
            visited[i]=true;
            combi(start-k+arr[i],depth+1);
            visited[i]=false;
        }
    }
    static int n,k,cnt;
    static int[] arr;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        combi(500,0);
        System.out.println(cnt);
    }
}