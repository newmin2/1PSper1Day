import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair{
        int x,y;
        boolean visited = false;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        Queue<Pair>q;
        List<Pair>list;
        StringBuilder sb = new StringBuilder();
        loop:
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            Pair house = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            q= new ArrayDeque<>();
            list=new ArrayList<>();
            for(int i=0;i<n;i++){
                st = new StringTokenizer(bf.readLine());
                list.add(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(bf.readLine());
            Pair festival = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            q.offer(house);
            house.visited=true;
            while(!q.isEmpty()){
                Pair p = q.poll();
                if(Math.abs(festival.x-p.x)+Math.abs(festival.y-p.y)<=1000){
                    sb.append("happy").append('\n');
                    continue loop;
                }
                for(int i=0;i<list.size();i++){
                    Pair next= list.get(i);
                    if(next.visited)continue;
                    if(Math.abs(next.x-p.x)+Math.abs(next.y-p.y)>1000)continue;
                    next.visited=true;
                    q.offer(next);
                }
            }
            sb.append("sad").append('\n');
        }
        System.out.println(sb);
    }
}