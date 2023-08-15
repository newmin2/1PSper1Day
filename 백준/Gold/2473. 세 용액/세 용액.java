import java.util.*;
import java.io.*;

public class Main {
    static void findMin(long tmp,int i,int j,int value){
        if (Math.abs(min) >Math.abs(tmp)) {
            min=tmp;
            minArr[0] = arr[i];
            minArr[1] = arr[j];
            minArr[2] = arr[value];
        }
    }
    static int[] minArr = new int[3];
    static int[] arr;
    static long min= Long.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        //입력 끝
        int start, end, sum,mid;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                sum = arr[i] + arr[j];
                start = j + 1;
                end = n - 1;
                while (start <= end) {
                    mid = (start + end) >> 1;
                    if ((long)sum + arr[mid] < 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                if(start<n){
                    findMin((long)sum+arr[start],i,j,start);
                }
                if(end>=j+1){
                    findMin((long)sum+arr[end],i,j,end);
                }
            }
        }
        for (int i : minArr) {
            System.out.print(i + " ");
        }
    }
}