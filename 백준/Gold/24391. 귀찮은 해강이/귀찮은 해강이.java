import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    static int find(int x){
        if(parent[x]<0){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    static void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x==y) return;

        if(parent[x]<parent[y]){
            parent[x]+=parent[y];
            parent[y]=x;
        }else{
            parent[y]+=parent[x];
            parent[x]=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        Arrays.fill(parent,-1);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int[] arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int cnt =0;
        for(int i=0;i<n-1;i++){
            if(find(arr[i])!=find(arr[i+1])){
                ++cnt;
            }
        }
        System.out.println(cnt);
    }
}