import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long cnt =0;
        if(2*w<=s){
            System.out.println((long)w*(x+y));
        }else{
            while(x!=0&&y!=0){
                --x;
                --y;
                cnt+=s;
            }
            long max = Math.max(x,y);
            if(max==1){
                System.out.println(cnt+w);
            }else{
                if(w<=s){
                    cnt+=max*w;
                }else{
                    long a = max/2;
                    long b= max%2;
                    if(b==0){
                        cnt+=2*a*s;
                    }else{
                        cnt+=2*a*s+w;
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}