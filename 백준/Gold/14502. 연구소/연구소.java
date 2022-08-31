import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr,arr2;
    static int[] dr={-1,1,0,0};//상하좌우
    static int[] dc={0,0,-1,1};
    static int n,m,safe,max;
    static ArrayList<Pair>list = new ArrayList<>();
    static Queue<Pair>q = new LinkedList<>();
    static class Pair {
        int x;
        int y;
    }
    static void installWall(int depth){
        if(depth==3){
            for(int i=0;i<arr.length;i++){
                System.arraycopy(arr[i],0,arr2[i],0,arr[0].length);
            }
            max=Math.max(bfs(),max);
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                    installWall(depth+1);
                    arr[i][j]=0;
                }
            }
        }
    }
    static int bfs(){
        int cnt=0;
        for (Pair value : list) {
            q.offer(value);
            while (!q.isEmpty()) {
                Pair pair = q.poll();
                for (int b = 0; b < 4; b++) {
                    if (pair.x + dr[b] >= 0 && pair.x + dr[b] < n && pair.y + dc[b] >= 0 && pair.y + dc[b] < m
                            && arr2[pair.x + dr[b]][pair.y + dc[b]] == 0) {
                        Pair pair1 = new Pair();
                        pair1.x = pair.x + dr[b];
                        pair1.y = pair.y + dc[b];
                        arr2[pair1.x][pair1.y] = 2;
                        q.offer(pair1);
                        cnt++;
                    }
                }
            }
        }
        return safe-cnt-3;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int[n][m];
        arr2= new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    Pair pair = new Pair();
                    pair.x=i; pair.y=j;
                    list.add(pair);
                }
                else if(arr[i][j]==0){
                    safe++;
                }
            }
        }
        installWall(0);
        System.out.println(max);
    }
}
