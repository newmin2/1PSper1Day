import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;
    static int n;
    static void permutation(int depth){
        if(depth==n){
            for(int i:arr){
                sb.append(i+" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=n;i++){
            if(visited[i])continue;
            visited[i]=true;
            arr[depth]=i;
            permutation(depth+1);
            visited[i]=false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr= new int[n];
        visited=new boolean[n+1];
        permutation(0);
        System.out.println(sb);
    }
}