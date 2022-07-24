import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c = b;
        System.out.println((c%10)*a);
        c/=10;
        System.out.println((c%10)*a);
        c/=10;
        System.out.println(c*a);
        System.out.println(a*b);
    }
}