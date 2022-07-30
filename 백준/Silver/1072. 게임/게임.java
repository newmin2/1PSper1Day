import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        long x= Long.parseLong(st.nextToken());
        long y =Long.parseLong(st.nextToken());

        if(100*y/x>=99) {
            System.out.println(-1);
            return;
        }
        if(x<10) {
            System.out.println(1);
            return;
        }
        long first= 0;
        long end = 1000000000;
        long mid = (first+end)/2;

        while(first<=end) {
            long a= (y+mid)*100/(x+mid);
            long b= (y*100/x);
            if(a>b){
                end = mid-1;
            }else
                first = mid+1;
            mid = (first+end)/2;
        }
        System.out.println(end+1);
    }
}
