import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        int[][] dpMax = new int[2][3];
        int[][] dpMin = new int[2][3];
        StringTokenizer st =new StringTokenizer(bf.readLine());
        dpMin[0][0]=dpMax[0][0]=Integer.parseInt(st.nextToken());
        dpMin[0][1]=dpMax[0][1]=Integer.parseInt(st.nextToken());
        dpMin[0][2]=dpMax[0][2]=Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());
            dpMin[1][0]=Math.min(dpMin[0][1],dpMin[0][0])+a;
            dpMin[1][1]=Math.min(dpMin[0][1],Math.min(dpMin[0][0],dpMin[0][2]))+b;
            dpMin[1][2]=Math.min(dpMin[0][1],dpMin[0][2])+c;
            dpMax[1][0]=Math.max(dpMax[0][1],dpMax[0][0])+a;
            dpMax[1][1]=Math.max(dpMax[0][1],Math.max(dpMax[0][0],dpMax[0][2]))+b;
            dpMax[1][2]=Math.max(dpMax[0][1],dpMax[0][2])+c;
            dpMin[0][0]=dpMin[1][0];
            dpMin[0][1]=dpMin[1][1];
            dpMin[0][2]=dpMin[1][2];
            dpMax[0][0]=dpMax[1][0];
            dpMax[0][1]=dpMax[1][1];
            dpMax[0][2]=dpMax[1][2];
        }
        System.out.println(Math.max(dpMax[0][2],Math.max(dpMax[0][0],dpMax[0][1]))+" "+Math.min(dpMin[0][2],Math.min(dpMin[0][0],dpMin[0][1])));
    }
}
