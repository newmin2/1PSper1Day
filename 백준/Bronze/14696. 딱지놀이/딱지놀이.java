import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[] a;
        int[] b;
        loop:
        for(int i=0;i<T;i++){
            a= new int[4];
            b= new int[4];
            st= new StringTokenizer(bf.readLine());
            int range =Integer.parseInt(st.nextToken());
            for(int j=0; j<range; j++){
                a[Integer.parseInt(st.nextToken())-1]++;
            }
            st= new StringTokenizer(bf.readLine());
            range =Integer.parseInt(st.nextToken());
            for(int j=0; j<range; j++){
                b[Integer.parseInt(st.nextToken())-1]++;
            }
            int idx=3;
            while(true){
                if(a[idx]>b[idx]) {
                    System.out.println("A");
                    continue loop;
                }
                else if(a[idx]<b[idx]){
                    System.out.println("B");
                    continue loop;
                }
                else {
                    if(idx==0) {
                        System.out.println("D");
                        continue loop;
                    }
                    idx--;
                }
            }
        }
    }
}
