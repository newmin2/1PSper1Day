import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(x -> x <= info[1])
                .sorted().toArray();
        if (arr.length == 0) {
            System.out.println(0);
            return;
        }
        //하나로만 할 수 있는가?
        if (arr[arr.length - 1] == info[1]) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] != info[1]) {
                    int start = j + 1;
                    int end = arr.length - 1;
                    int mid;
                    while (start <= end) {
                        mid = (start + end) >> 1;
                        if (arr[mid] + arr[i] + arr[j] < info[1]) {
                            start = mid + 1;
                        } else if (arr[mid] + arr[i] + arr[j] > info[1]) {
                            end = mid - 1;
                        } else {
                            System.out.println(1);
                            return;
                        }
                    }
                } else {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}