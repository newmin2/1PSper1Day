import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s ="666";
        int num=0;
        int cnt=0;
        while(cnt!=n){
            if(Integer.toString(num).contains(s))
                cnt++;
            num++;
        }

        System.out.println(num-1);
    }
}
