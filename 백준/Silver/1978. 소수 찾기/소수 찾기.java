import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        for(int i =0; i<N; i++){
            int a = sc.nextInt();
            if(a==1)
                cnt++;
            int tmp = a;
            while(a>1) {
                if (tmp % a == 0 && tmp!=a) {
                    cnt++;
                    break;
                }
                a--;
            }
        }
        System.out.println(N-cnt);
    }
}