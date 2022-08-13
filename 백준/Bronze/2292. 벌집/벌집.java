import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int i=1;
        int start=1;
        int cnt=1;
        while(n>start){
            start+=6*i++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
