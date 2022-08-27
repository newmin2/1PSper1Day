import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T ;i++){
            String s = bf.readLine();
            int sum=0;
            int cnt=1;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='O')
                    sum+=cnt++;
                else
                    cnt=1;
            }
            System.out.println(sum);
        }
    }
}
