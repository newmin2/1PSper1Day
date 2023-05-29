import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            BigInteger n = BigInteger.valueOf(Long.parseLong(bf.readLine()));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long s = Long.parseLong(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            //입력끝
            BigInteger time = BigInteger.ZERO;
            while (!n.equals(BigInteger.ONE)) {
                if (n.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
                    time = time.add(n.divide(BigInteger.TWO).multiply(BigInteger.valueOf(s)).min(BigInteger.valueOf(t)));
                    n = n.divide(BigInteger.TWO);
                } else {
                    time = time.add(BigInteger.valueOf(s));
                    n = n.subtract(BigInteger.valueOf(1));
                }
//            System.out.println("time: "+time);
//            System.out.println("n :"+n);
            }
            time = time.add(BigInteger.valueOf(s));
            System.out.println(time);
//            System.out.println(n);
//            System.out.println(s);
//            System.out.println(t);
        }
    }
}