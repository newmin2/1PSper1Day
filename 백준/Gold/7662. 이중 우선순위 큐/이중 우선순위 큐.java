import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        TreeMap<Integer,Integer> map;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(bf.readLine());
            map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                String[] arr = bf.readLine().split(" ");
                int num = Integer.parseInt(arr[1]);
                if(arr[0].equals("I")){
                    if(map.containsKey(num)){
                        map.replace(num,map.get(num)+1);
                    }else{
                        map.put(num,1);
                    }
                }else{
                    if(map.isEmpty()) continue;
                    Map.Entry<Integer,Integer> entry = num==-1?map.firstEntry():map.lastEntry();
                    if(entry.getValue()>1){
                        map.replace(entry.getKey(), entry.getValue()-1);
                    }else{
                        map.remove(entry.getKey());
                    }
                }
            }
            sb.append(map.isEmpty()?"EMPTY":map.lastKey()+" "+map.firstKey());
            sb.append('\n');
        }
        System.out.println(sb);
    }
}