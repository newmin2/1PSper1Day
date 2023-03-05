import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int ans=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int tmp=arr[start];
        while(start<n&&end<n){
//            System.out.println("tmp: "+tmp);
//            System.out.println("ans: "+ans);
            if(tmp>=s){
                ans=Math.min(ans,end-start+1);
                tmp-=arr[start++];
                if(start>=n)
                    break;
                if(start>end) {
                    end++;
                    tmp=arr[start];
                }
            }else{
                if(end==n-1)
                    break;
                else
                    tmp+=arr[++end];
            }
        }
        if(ans==Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}
