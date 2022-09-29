import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int findSet(int x){
        if(x!=p[x])
            p[x]=findSet(p[x]);
        return p[x];
    }
    static void union(int x, int y){
        p[y]=x;
    }
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] edges = new int[e][3];
        p=new int[v+1];
        for(int i=0;i<e;i++){
            st = new StringTokenizer(bf.readLine());
            edges[i][0]=Integer.parseInt(st.nextToken());
            edges[i][1]=Integer.parseInt(st.nextToken());
            edges[i][2]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=1;i<v+1;i++)
            p[i]=i;
        int ans=0;
        int pick=0;
        for(int i=0;i<e;i++){
            int px =findSet(edges[i][0]);
            int py =findSet(edges[i][1]);
            if(px!=py){
                union(px,py);
                ans+=edges[i][2];
                pick++;
            }
            if(pick==v-1)
                break;
        }
        System.out.println(ans);
    }
}
