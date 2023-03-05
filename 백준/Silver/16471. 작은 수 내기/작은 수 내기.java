import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] me = new int[n];
        int[] master = new int[n];
        for(int i=0;i<n;i++){
            me[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            master[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(me);
        Arrays.sort(master);
        int cnt=0;
        for(int i=0;i<(n+1)/2;i++){
            if(me[i]<master[n-(n+1)/2+i])
                cnt++;
        }
        if(cnt>=(n+1)/2)
            System.out.println("YES");
        else{
            System.out.println("NO");
        }
    }
}