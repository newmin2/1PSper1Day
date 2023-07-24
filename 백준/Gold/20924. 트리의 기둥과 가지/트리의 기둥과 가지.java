import java.util.*;
import java.io.*;


public class Main {
    static class Node{
        int to,length;
        Node(int to,int length){
            this.to=to;
            this.length=length;
        }
    }
    static int[] findGiga(int root, int columnLength){
        if(list[root].size()>2) return new int[]{root,columnLength};
        for(int i=0;i<list[root].size();i++){
            if(visited[list[root].get(i).to])continue;
            visited[root]=true;
            return findGiga(list[root].get(i).to,columnLength+list[root].get(i).length);
        }
        return new int[]{root,columnLength};
    }
    static int max=Integer.MIN_VALUE;
    static boolean[] visited;
    static void dfs(int giga, int sum){
        for(int i=0;i<list[giga].size();i++){
            if(visited[list[giga].get(i).to])continue;
            visited[giga]=true;
            dfs(list[giga].get(i).to,sum+list[giga].get(i).length);
            visited[giga]=false;
        }
        max=Math.max(max,sum);
    }
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int root = Integer.parseInt(info[1]);
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            list[i]= new ArrayList<>();
        }
        String[] treeInfo;
        for(int i=0;i<n-1;i++){
            treeInfo = bf.readLine().split(" ");
            int from = Integer.parseInt(treeInfo[0]);
            int to = Integer.parseInt(treeInfo[1]);
            int length = Integer.parseInt(treeInfo[2]);
            list[from].add(new Node(to,length));
            list[to].add(new Node(from,length));
        }
        int[] gigaInfo = list[root].size()>1?new int[]{root,0}:findGiga(root,0);
        dfs(gigaInfo[0],0);
        System.out.println(gigaInfo[1]+" "+max);
    }
}