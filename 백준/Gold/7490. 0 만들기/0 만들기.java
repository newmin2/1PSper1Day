import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void makeZero(int idx){
        if(idx==n+1){
            int sum=0;
            StringBuilder sb= new StringBuilder();
            for(int i=1;i<=n;i++){
                int x =i;
                int tmp=arr[x];
                sb.append(buho[x]).append(arr[x]);
                while(x+1<=n&&buho[x+1]==' '){
                    tmp=tmp*10+arr[x+1];
                    sb.append(buho[x+1]).append(arr[x+1]);
                    x++;
                }
                if(buho[i]=='+'){
                    sum+=tmp;
                }else{
                    sum-=tmp;
                }
                i=x;
            }
            if(sum==0){
                ans.append(sb.deleteCharAt(0)).append('\n');
            }
            return;
        }
        buho[idx]=' ';
        makeZero(idx+1);
        buho[idx]='+';
        makeZero(idx+1);
        buho[idx]='-';
        makeZero(idx+1);
    }
    static int n;
    static int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
    static char[] buho = new char[10];
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(bf.readLine());
        buho[1]='+';
        for(int t=0;t<T;t++){
            n = Integer.parseInt(bf.readLine());
            makeZero(2);
            ans.append('\n');
        }
        System.out.println(ans);
        //' ', +, -
    }
}
