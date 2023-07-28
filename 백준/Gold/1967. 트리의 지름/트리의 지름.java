import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max=Integer.MIN_VALUE;
    static class Tree{
        int to,value;
        Tree(int to, int value){
            this.to=to;
            this.value=value;
        }
    }
    static boolean[] visited;
    static void dfs(int start, int sum){
        for(int i=0;i<list[start].size();i++){
            Tree tree = list[start].get(i);
            if(visited[tree.to])continue;
            visited[start]=true;
            dfs(tree.to, sum+tree.value);
            visited[start]=false;
        }
        max= Math.max(max,sum);
    }
    static List<Tree>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(bf.readLine());
        if(N==1){
            System.out.println(0);
            return;
        }
        int[] info;
        list = new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
        Queue<Integer>q = new ArrayDeque<>();
        for(int i=0;i<N-1;i++) {
            info = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            q.offer(info[1]);
            if(q.peek()==info[0]) q.poll();
            list[info[0]].add(new Tree(info[1],info[2]));
            list[info[1]].add(new Tree(info[0],info[2]));
        }
        while(!q.isEmpty()){
            dfs(q.poll(),0);
        }
        System.out.println(max);
    }
}