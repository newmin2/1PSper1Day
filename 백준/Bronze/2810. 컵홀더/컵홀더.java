import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        int cnt=-1;
        for(int i=0;i<s.length(); i++){
            if(s.startsWith("LL",i)){
                cnt++;
                i++;
            }
        }
        if(cnt!=-1)
            System.out.println(n-cnt);
         else
            System.out.println(n);
    }
}
