import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int stu = Integer.parseInt(bf.readLine());
        for (int i = 0; i < stu; i++) {
            st = new StringTokenizer(bf.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int givnum = Integer.parseInt(st.nextToken());
            if (sex == 1) {
                for (int j = 0; j < n; j++) {
                    if ((j + 1) % givnum == 0)
                        arr[j] ^= 1;
                }
            } else {
                int j = 1;
                while (givnum - 1 >= j&&givnum-1+j<n && arr[givnum - 1 - j] == arr[givnum - 1 + j]) {
                    arr[givnum - 1 - j] ^= 1;
                    arr[givnum - 1 + j] ^= 1;
                    j++;
                }
                arr[givnum - 1]^= 1;
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
            cnt++;
            if(cnt==20){
                System.out.println();
            cnt=0;}
        }

    }
}

