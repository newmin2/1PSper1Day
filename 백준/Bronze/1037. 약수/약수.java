import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int minindex=1000000;
        int maxindex=0;
        for(int i=0; i<N; i++){
            int a= sc.nextInt();
            minindex= Math.min(minindex,a);
            maxindex= Math.max(maxindex,a);
        }
        System.out.println(minindex*maxindex);

    }

}
