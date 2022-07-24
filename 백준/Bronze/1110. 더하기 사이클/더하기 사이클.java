import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = n;
        int cnt = 0;
        do {
            if(tmp<10)
                tmp=tmp*10+tmp;
            else
                tmp=(tmp%10)*10+(tmp/10+tmp%10)%10;
            cnt++;
        }while(tmp!=n);
        System.out.println(cnt);

    }
}
