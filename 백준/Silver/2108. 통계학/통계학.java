import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] arr2 = new int[8001];
        int sum=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<N;i++){
            arr[i]=sc.nextInt();
            arr2[arr[i]+4000]++;
            sum+=arr[i];
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        Arrays.sort(arr);
        int max2=Integer.MIN_VALUE;
        int maxidx=0;
        int maxmiidx=0;
        for(int i=8000; i>=0;i--){
            max2=Math.max(arr2[i],max2);
            if(max2==arr2[i]){
                maxmiidx=maxidx;
                maxidx=i;
            }
        }
        if(sum<0)
            System.out.println(-Math.round((double)-sum/N));
        else
            System.out.println(Math.round((double)sum/N));
        System.out.println(arr[N/2]);
        if(arr2[maxidx]==arr2[maxmiidx])
            System.out.println(maxmiidx-4000);
        else
            System.out.println(maxidx-4000);
        System.out.println(max-min);
    }
}
