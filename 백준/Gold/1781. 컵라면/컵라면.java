import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<Integer,PriorityQueue<Long>>map = new HashMap<>();
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            int deadLine =Integer.parseInt(st.nextToken());
            long lamen = Long.parseLong(st.nextToken());
            if(!map.containsKey(deadLine)){
                PriorityQueue<Long>pq = new PriorityQueue<>((o1, o2) -> Math.toIntExact(o2-o1));
                pq.offer(lamen);
                map.put(deadLine,pq);
            }else{
                map.get(deadLine).offer(lamen);
            }
        }
        List<Integer>keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        PriorityQueue<Long> finalPq = new PriorityQueue<>();
        for(int key:keySet){
            PriorityQueue<Long>pq = map.get(key);
            for(int i=0;i<key;i++){
                finalPq.offer(pq.poll());
                if(pq.isEmpty())break;
            }
            while(finalPq.size()>key){
                finalPq.poll();
            }
        }
        long sum=0;
        while(!finalPq.isEmpty()){
            sum+=finalPq.poll();
        }
        System.out.println(sum);
    }
}
