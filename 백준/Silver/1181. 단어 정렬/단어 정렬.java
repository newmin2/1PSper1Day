import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        Arrays.sort(arr, Comparator.comparing(String::length));

        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}