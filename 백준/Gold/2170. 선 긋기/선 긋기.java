import java.util.*;
import java.io.*;


public class Main {
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Pair>pq = new PriorityQueue<>((o1,o2)->o1.x==o2.x?o1.y-o2.y:o1.x-o2.x);
        String[] info;
        for(int i=0;i<N;i++){
            info = bf.readLine().split(" ");
            pq.offer(new Pair(Integer.parseInt(info[0]),Integer.parseInt(info[1])));
        }
        Pair start = pq.poll();
        int min = start.x;
        int max = start.y;
        int ans = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(pair.x>=min&&pair.y<=max) continue;
            if(pair.x>max){
                ans+=max-min;
                min = pair.x;
            }
            max = pair.y;
        }
        System.out.println(ans+max-min);
    }
}