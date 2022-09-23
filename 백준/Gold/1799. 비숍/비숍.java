import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;
    static int max2 = 0;
    static Pair[] arr;
    static ArrayList<Pair> list = new ArrayList<>();
    static ArrayList<Pair> list2 = new ArrayList<>();

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bishop(int cnt, int idx) {
        if(idx==list.size()){
            max=Math.max(cnt,max);
            return;
        }
        Pair pair = list.get(idx);
        boolean flag = true;
        for (int i = 0; i < cnt; i++) {
            if (Math.abs(arr[i].x - pair.x) == Math.abs(arr[i].y - pair.y)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            arr[cnt]=pair;
            bishop(cnt + 1, idx + 1);
            bishop(cnt, idx + 1);
        }
        else bishop(cnt, idx + 1);
    }

    static void bishop2(int cnt, int idx) {
        if(idx==list2.size()){
            max2=Math.max(cnt,max2);
            return;
        }
        Pair pair = list2.get(idx);
        boolean flag = true;
        for (int i = 0; i <cnt; i++) {
            if (Math.abs(arr[i].x - pair.x) == Math.abs(arr[i].y - pair.y)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            arr[cnt]=pair;
            bishop2(cnt + 1, idx + 1);
            bishop2(cnt, idx + 1);
        }
        else bishop2(cnt, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if ((i + j) % 2 == 0)
                        list.add(new Pair(i, j));
                    else
                        list2.add(new Pair(i, j));
                }
            }
        }

        arr = new Pair[list.size()];
        bishop(0,0);
        arr = new Pair[list2.size()];
        bishop2(0,0);
        System.out.println(max + max2);
    }
}