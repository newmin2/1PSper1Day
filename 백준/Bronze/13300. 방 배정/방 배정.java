import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[6][2];
        int sex;
        int grade;
        int cnt=0;
        for(int i=0; i<n; i++){
            st= new StringTokenizer(bf.readLine());
            sex= Integer.parseInt(st.nextToken());
            grade = Integer.parseInt(st.nextToken());
            arr[grade-1][sex]++;
        }
        for(int i=0; i<6; i++){
            for(int j=0; j<2; j++){
                if(arr[i][j]!=0) {
                    cnt++;
                    if(arr[i][j]>k)
                        cnt += (arr[i][j]-1)/k;
                }
            }
        }
        System.out.println(cnt);
    }
}
