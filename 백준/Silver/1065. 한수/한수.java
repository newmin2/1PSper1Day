import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt=0;
        if(n<100)
            System.out.println(n);
        else{
        for(int i=100; i<=n; i++){
            if(i/100+ i%10 == 2*(i%100/10))
                cnt++;
        }
        System.out.println(99+cnt);

        }

    }
}
