import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double[] info = Arrays.stream(bf.readLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        int ans= (int)Math.ceil(info[0]/(1+info[2]))*(int)Math.ceil(info[1]/(1+info[3]));
        System.out.println(ans);
    }
}