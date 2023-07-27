import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Building{
        int x,y;
        Building(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        PriorityQueue<Building>pq = new PriorityQueue<>(Comparator.comparingInt(o->o.x));
        pq.offer(new Building(0,0));
        pq.offer(new Building(10000001,0));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pq.offer(new Building(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Stack<Integer>stack = new Stack<>();
        int sum=0;
        Building b = pq.poll();
        stack.push(b.y);
        while(!pq.isEmpty()){
            b = pq.poll();
            if(stack.peek()>b.y){
                while(!stack.isEmpty()&&stack.peek()>b.y){
                    stack.pop();
                    sum++;
                }
                if(stack.isEmpty()||stack.peek()!=b.y) {
                    stack.push(b.y);
                }
            }else if(stack.peek()<b.y){
                stack.push(b.y);
            }
        }
        System.out.println(sum);
    }
}