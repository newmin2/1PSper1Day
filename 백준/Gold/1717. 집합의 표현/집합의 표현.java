import java.io.*;
import java.util.*;

public class Main{
    static int[] arr,rank;
    static void union(int x, int y){
        x= find(x);
        y =find(y);
        if(x==y)return;

        if(rank[x]>rank[y]){
            int tmp =x;
            x = y;
            y= tmp;
        }
        arr[x]=y;
        if(rank[x]==rank[y]) rank[y]++;
    }
    static int find(int x){
        if(arr[x]==x){
            return x;
        }
        return arr[x]=find(arr[x]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<m;i++){
            st= new StringTokenizer(bf.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(calc==0){
                union(a,b);
            }else{
                if(find(a)==find(b)) sb.append("yes").append('\n');
                else sb.append("no").append('\n');
            }
        }
        System.out.println(sb);
    }
}