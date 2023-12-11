import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static List<Pair>list;
    static boolean[][] isEnd;
    static int[] select;
    static char[][] arr;
    static int answer;
    static void combi(int idx,int depth){
        if(depth==7){
            bfs(select);
            return;
        }
        for(int i=idx;i<25;i++){
            select[depth]=i;
            combi(i+1,depth+1);
        }
    }
    static void bfs(int[] select){
        Queue<Integer>q = new ArrayDeque<>();
        boolean[] visited = new boolean[7];

        visited[0] = true;
        q.offer(select[0]);
        int cnt = 1;
        int yCnt=0;
        while(!q.isEmpty()){
            int num = q.poll();
            int x = num/5;
            int y = num%5;
            if(arr[x][y]=='Y') yCnt++;
            for(int i=0;i<4;i++){
                for(int j=0;j<7;j++){
                    if(visited[j])continue;
                    if(x+dr[i]==select[j]/5&&y+dc[i]==select[j]%5){
                        visited[j]=true;
                        q.offer(select[j]);
                        cnt++;
                    }
                }

            }
        }
        if(yCnt<4&&cnt==7) answer++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];
        select = new int[7];
        isEnd = new boolean[5][5];
        list = new ArrayList<>();
        for(int i=0;i<5;i++){
            String s = bf.readLine();
            for(int j=0;j<5;j++){
                if(s.charAt(j)=='S'){
                    list.add(new Pair(i,j));
                }
                arr[i][j]=s.charAt(j);
            }
        }
        combi(0,0);
        System.out.println(answer);
    }
}
