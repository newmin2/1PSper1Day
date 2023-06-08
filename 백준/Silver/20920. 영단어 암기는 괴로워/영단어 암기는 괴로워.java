import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, int[]> dict = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            String word = bf.readLine();
            if(word.length()<M) continue;
            if(dict.containsKey(word)){
                dict.get(word)[0]++;
            }else {
                int[] arr = new int[2];
                arr[1] = word.length();
                dict.put(word, arr);
                list.add(word);
            }
        }
        list.sort((o1, o2) -> {
            int[] arr1 = dict.get(o1);
            int[] arr2 = dict.get(o2);
            if (arr1[0] == arr2[0]) {
                if (arr1[1] == arr2[1]) {
                    for(int i=0;i<arr1[1];i++){
                        if(o1.charAt(i)==o2.charAt(i)) continue;
                        return o1.charAt(i)-o2.charAt(i);
                    }
                }
                return arr2[1] - arr1[1];
            }
            return arr2[0] - arr1[0];
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}