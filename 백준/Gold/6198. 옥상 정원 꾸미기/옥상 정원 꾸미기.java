import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Building {
        int height, cnt;

        Building(int height) {
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Stack<Building> stack = new Stack<>();
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            Building b = new Building(arr[i]);
            while (!stack.isEmpty() && stack.peek().height < arr[i]) {
                b.cnt+=stack.pop().cnt+1;
            }
            ans+=b.cnt;
            stack.push(b);
        }
        System.out.println(ans);
    }
}
