import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] alphaArr = new int[26];
        int n = Integer.parseInt(bf.readLine());
        for(int i=0;i<n;i++){
            String s = bf.readLine();
            for(int j=0;j<s.length();j++){
                alphaArr[s.charAt(j)-'A']+=Math.pow(10,s.length()-1-j);
            }
        }
        Arrays.sort(alphaArr);
        int start =9;
        int sum=0;
        for(int i=25;i>0;i--) {
            sum+=alphaArr[i]*start--;
        }
        System.out.println(sum);
    }
}