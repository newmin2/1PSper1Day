import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        //만약 에러가 나면 error 출력 - 배열이 비어있는데 D를 했을 경우에
        StringBuilder sb = new StringBuilder();
        loop:
        for(int t=0;t<T;t++){
            String p = bf.readLine();
            int n = Integer.parseInt(bf.readLine());
            String s = bf.readLine();
            String[] arr = s.substring(1,s.length()-1).split(",");

            int start = 0;
            int end = arr.length-1;
            int deleteCnt=0;
            int flag = 0;

            for(int i=0;i<p.length();i++) {
                if(deleteCnt>n) {
                    sb.append("error").append('\n');
                    continue loop;
                }
                if (p.charAt(i) == 'R') {
                    flag^=1;
                } else {
                    if (flag==1) {
                        end--;
                    } else {
                        start++;
                    }
                    deleteCnt++;
                }
            }
            if(deleteCnt>n) {
                sb.append("error").append('\n');
                continue;
            }
            sb.append(s.charAt(0));
            if(flag==0){
                for(int i=start; i<=end; i++){
                    sb.append(arr[i]);
                    if(i!=end) sb.append(',');
                }
            }else{
                for(int i=end; i>=start; i--){
                    sb.append(arr[i]);
                    if(i!=start) sb.append(',');
                }
            }
            sb.append(s.charAt(s.length()-1)).append('\n');
        }
        System.out.println(sb);
    }
}