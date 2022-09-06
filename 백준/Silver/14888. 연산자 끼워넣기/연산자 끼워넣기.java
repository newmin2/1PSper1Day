import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] arr,booho;
    static int n,sum;
    static Stack<Integer>mod=new Stack<>();
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;

    static void dfs(int level){
        if(level==n){
            min = Math.min(min, sum);
            max = Math.max(max,sum);
            return;
        }
        for(int i=0;i<4; i++){
            if(booho[i]!=0){
                booho[i]--;
                if(i==0)
                    sum+=arr[level];
                else if(i==1)
                    sum-=arr[level];
                else if(i==2)
                    sum*=arr[level];
                else {
                    mod.push(sum%arr[level]);
                    sum /= arr[level];
                }
                dfs(level+1);
                booho[i]++;
                if(i==0)
                    sum-=arr[level];
                else if(i==1)
                    sum+=arr[level];
                else if(i==2)
                    sum/=arr[level];
                else {
                    sum *= arr[level];
                    sum+=mod.pop();
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr= new int[n];
        booho = new int[4];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        sum+=arr[0];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<4;i++){
            booho[i]=Integer.parseInt(st.nextToken());
        }
        dfs(1);
        System.out.println(max);
        System.out.println(min);
    }
}
