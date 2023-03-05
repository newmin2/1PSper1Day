import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Problem>map = new HashMap<>();
    static PriorityQueue<Problem>list = new PriorityQueue<>(new Comparator<Problem>() {
        @Override
        public int compare(Problem p1, Problem p2) {
            if(p1.level==p2.level) return p1.num-p2.num;
            return p1.level-p2.level;
        }
    });
    static PriorityQueue<Problem>pq = new PriorityQueue<>(new Comparator<Problem>() {
        @Override
        public int compare(Problem p1, Problem p2) {
            if(p1.level==p2.level) return p2.num-p1.num;
            return p2.level-p1.level;
        }
    });
    static class Problem{

            int num;
            int level;
            boolean isDead;

            Problem(int num, int level){
            this.num=num;
            this.level=level;
        }

    }
    static Problem recommend(int x){
        if(x==1) {
            while(true) {
                if (pq.peek().isDead)
                    pq.poll();
                else break;
            }
            return pq.peek();
        }
        else {
            while(true) {
                if (list.peek().isDead)
                    list.poll();
                else break;
            }
            return list.peek();
        }
    }
    static void add(int p, int l){
        Problem pr = new Problem(p,l);
        list.offer(pr);
        pq.offer(pr);
        map.put(p,pr);
    }
    static void solved(int p){
        map.get(p).isDead=true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Problem pr = new Problem(a,b);
            list.offer(pr);
            pq.offer(pr);
            map.put(a,pr);
        }
        int m = Integer.parseInt(bf.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            if(s.equals("solved")) {
                solved(Integer.parseInt(st.nextToken()));
            }
            else if(s.equals("recommend")) {
                Problem p=recommend(Integer.parseInt(st.nextToken()));
                System.out.println(p.num);
            }
            else{
                add(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
        }

    }
}
