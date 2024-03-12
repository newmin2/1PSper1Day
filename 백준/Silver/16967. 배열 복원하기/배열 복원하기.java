import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] a = new int[input[0]][input[1]];
        int[][] b = new int[input[0]+input[2]][input[1]+input[3]];

        for(int i=0;i<b.length;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<b[0].length;j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<input[0];i++){
            for(int j=0;j<input[1];j++){
                if(i-input[2]<0||j-input[3]<0){
                    a[i][j]=b[i][j];
                }else{
                    a[i][j]=b[i][j]-a[i-input[2]][j-input[3]];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int[] x : a){
            for(int y : x){
                sb.append(y).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}