import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[1000][1666];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1666; j++) {
                arr[i][j] = 3 * i + 5 * j;
                if (N == arr[i][j]) {
                    System.out.println(i + j);
                    return;
                }
                }
            }
        System.out.println(-1);
        }



    }
