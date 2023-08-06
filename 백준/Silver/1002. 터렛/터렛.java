import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static double distance(int a, int b,int c,int d){
        return Math.sqrt(Math.pow(a-b,2)+Math.pow(c-d,2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[] info;
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            info = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if(info[0]==info[3]&&info[1]==info[4]){
                if(info[2]==info[5]){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
                continue;
            }
            if(distance(info[0],info[3],info[1],info[4])==info[2]+info[5]||
                    distance(info[0],info[3],info[1],info[4])==Math.abs(info[2]-info[5])){
                sb.append(1).append('\n');
                continue;
            }
            if(distance(info[0],info[3],info[1],info[4])<info[2]+info[5]&&distance(info[0],info[3],info[1],info[4])>Math.abs(info[2]-info[5])){
                sb.append(2).append('\n');
                continue;
            }

            sb.append(0).append('\n');
        }
        System.out.println(sb);
    }
}
