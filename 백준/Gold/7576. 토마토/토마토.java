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
        Tomato(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    //상,하,좌,우,위,아래
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int m,n,cnt,day,empty;
    static ArrayList<Tomato>list = new ArrayList<>();
    static int[][] arr;
    static Queue<Tomato> q = new LinkedList<>();
    static boolean bfs(){
        for(int i=0; i<list.size();i++) {
            q.offer(list.get(i));
        }
            while(!q.isEmpty()) {
                int qsize = q.size();
                for (int k = 0; k < qsize; k++) {
                    Tomato tomato = q.poll();
                    for (int j = 0; j < 4; j++) {
                        if (tomato.x + dr[j] < n && tomato.x + dr[j] >= 0 && tomato.y + dc[j] < m && tomato.y + dc[j] >= 0
                                && arr[tomato.x + dr[j]][tomato.y + dc[j]] != -1 && arr[tomato.x + dr[j]][tomato.y + dc[j]] != 1) {
                            arr[tomato.x + dr[j]][tomato.y + dc[j]]= 1;
                            q.offer(new Tomato(tomato.x + dr[j], tomato.y + dc[j]));
                            cnt++;
                        }
                    }
                }
                day++;
            }
        if(m*n-empty-list.size()-cnt==0) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
            for(int j=0;j<n;j++){
                st = new StringTokenizer(bf.readLine());
                for(int k=0; k<m; k++){
                    arr[j][k]=Integer.parseInt(st.nextToken());
                    if(arr[j][k]==1)
                        list.add(new Tomato(j,k));
                    else if(arr[j][k]==-1)
                        empty++;
                }
            }
        if(empty+ list.size()==m*n)
            System.out.println(0);
        else{
            if(bfs())
                System.out.println(day-1);
            else
                System.out.println(-1);
        }
    }
}
