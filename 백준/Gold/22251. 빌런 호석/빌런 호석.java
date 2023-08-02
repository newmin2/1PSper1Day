import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        info[3]="0".repeat(info[0].length()-info[3].length())+info[3];
        String[] start =info[3].split("");
        int[][] change = {
                {0,4,3,3,4,3,2,3,1,2},
                {4,0,5,3,2,5,6,1,5,4},
                {3,5,0,2,5,4,3,4,2,3},
                {3,3,2,0,3,2,3,2,2,1},
                {4,2,5,3,0,3,4,3,3,2},
                {3,5,4,2,3,0,1,4,2,1},
                {2,6,3,3,4,1,0,5,1,2},
                {3,1,4,2,3,4,5,0,4,3},
                {1,5,2,2,3,2,1,4,0,1},
                {2,4,3,1,2,1,2,3,1,0}
        };
        int ans =0;
        for(int i=1;i<=Integer.parseInt(info[0]);i++){
            int tmp = i;
            int cnt=0;
            for(int j=0;j<start.length;j++){
                cnt+=change[Integer.parseInt(start[j])][(int)(tmp/Math.pow(10,start.length-1-j))];
                tmp%=Math.pow(10,start.length-1-j);
            }
            if(cnt<=Integer.parseInt(info[2])) ans++;
        }
        System.out.println(ans-1);
    }
}