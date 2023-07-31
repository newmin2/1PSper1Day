import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] info;
        while(true){
            info = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted().toArray();
            if(info[0]+info[1]+info[2]==0)break;
            if(Math.pow(info[0],2)+Math.pow(info[1],2)==Math.pow(info[2],2)) sb.append("right");
            else sb.append("wrong");
            sb.append('\n');
        }
        System.out.println(sb);
    }
}