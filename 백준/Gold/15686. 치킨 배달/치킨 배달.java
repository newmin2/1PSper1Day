import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M,answer;
    static int[][] arr;
    static List<Pair>house, chicken;
    static boolean[] visited;
    static void calcMinLength(int depth, Pair[] alive, int next){
        if(depth==M){
            int length=0;
            for(int i=0;i<house.size();i++){
                int min = Integer.MAX_VALUE;
                for(int j=0;j<M;j++){
                    min = Math.min(min,Math.abs(alive[j].x-house.get(i).x)+Math.abs(alive[j].y-house.get(i).y));
                }
                length+=min;
                if(length>=answer)
                    return;
            }
            answer= Math.min(length,answer);
            return;
        }
        for(int i=next+1;i<chicken.size();i++){
            if(visited[i])continue;
            visited[i]=true;
            alive[depth]=chicken.get(i);
            calcMinLength(depth+1,alive,i);
            visited[i]=false;
        }
    }
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    house.add(new Pair(i,j));
                }
                if(arr[i][j]==2){
                    chicken.add(new Pair(i,j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        //입력 끝
        answer = Integer.MAX_VALUE;
        calcMinLength(0,new Pair[M],-1);
        System.out.println(answer);
    }
}