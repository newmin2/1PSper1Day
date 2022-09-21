import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Tomato{
        int x;
        int y;
        int z;
        Tomato(int x, int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    //상,하,좌,우,위,아래
    static int[] dr ={-1,1,0,0,0,0};
    static int[] dc ={0,0,-1,1,0,0};
    static int[] dh ={0,0,0,0,1,-1};
    static int m,n,h,cnt,day,empty;
    static ArrayList<Tomato>list = new ArrayList<>();
    static int[][][] arr;
    static Queue<Tomato> q = new LinkedList<>();
    static boolean bfs(){
        for(int i=0; i<list.size();i++) {
            q.offer(list.get(i));
        }
            while(!q.isEmpty()) {
                int qsize = q.size();
                for (int k = 0; k < qsize; k++) {
                    Tomato tomato = q.poll();
                    for (int j = 0; j < 6; j++) {
                        if (tomato.x + dr[j] < n && tomato.x + dr[j] >= 0 && tomato.y + dc[j] < m && tomato.y + dc[j] >= 0 && tomato.z + dh[j] < h && tomato.z + dh[j] >= 0
                                && arr[tomato.x + dr[j]][tomato.y + dc[j]][tomato.z + dh[j]] != -1 && arr[tomato.x + dr[j]][tomato.y + dc[j]][tomato.z + dh[j]] != 1) {
                            arr[tomato.x + dr[j]][tomato.y + dc[j]][tomato.z + dh[j]] = 1;
                            q.offer(new Tomato(tomato.x + dr[j], tomato.y + dc[j], tomato.z + dh[j]));
                            cnt++;
                        }
                    }
                }
                day++;
            }
        if(m*n*h-empty-list.size()-cnt==0) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][m][h];
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(bf.readLine());
                for(int k=0; k<m; k++){
                    arr[j][k][i]=Integer.parseInt(st.nextToken());
                    if(arr[j][k][i]==1)
                        list.add(new Tomato(j,k,i));
                    else if(arr[j][k][i]==-1)
                        empty++;
                }
            }
        }
        if(empty+ list.size()==m*n*h)
            System.out.println(0);
        else{
            if(bfs())
                System.out.println(day-1);
            else
                System.out.println(-1);
        }
    }
}
