import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] cnt = new int[1000001];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(st.nextToken());
            cnt[a]++;
            arr[i]=a;
        }
        Stack<Integer>stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&cnt[arr[i]]>cnt[arr[stack.peek()]]){
                ans[stack.pop()]=arr[i];
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i:ans){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }
}