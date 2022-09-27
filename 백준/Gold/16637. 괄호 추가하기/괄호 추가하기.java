import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int max=Integer.MIN_VALUE;
    static char[] arr;
    static int gwalho(int a,char b,int c ) {
        if (b == '+')
            return a + c;
        else if (b == '*')
            return a * c;
        else return a - c;
    }
    static void maxresult(int idx,int sum){
        if(idx>=n+1) {
            max=Math.max(max,sum);
            return;
        }
        maxresult(idx+2,gwalho(sum,arr[idx-1],arr[idx]-'0'));
        if(idx>=n) {
            max=Math.max(max,gwalho(sum,arr[idx-1],arr[idx]-'0'));
            return;
        }
        maxresult(idx+4,gwalho(sum,arr[idx-1],gwalho(arr[idx]-'0',arr[idx+1],arr[idx+2]-'0')));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new char[n+2];
        arr[0]='+';
        String s = bf.readLine();
        for (int i = 1; i < n+1; i++) {
            arr[i] = s.charAt(i-1);
        }
        maxresult(1,0);
        if(n==1)
            System.out.println(arr[1]);
        else if(n==3)
            System.out.println(gwalho(arr[1]-'0',arr[2],arr[3]-'0'));
        else
            System.out.println(max);
    }
}