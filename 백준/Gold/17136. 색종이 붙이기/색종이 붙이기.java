import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[10][10];
    static int[] papercnt = new int[5];
    static int min;

    static class Pair {
        int x, y, max;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y + " " + max;
        }
    }

    static int getSize(Pair pair, int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (pair.x + size > 9 || pair.y + size > 9 || arr[pair.x + i][pair.y + j] != 1)
                    return getSize(pair, --size);
            }
        }
        return size;
    }

    static boolean isPossi(Pair pair, int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (pair.x + size > 9 || pair.y + size > 9 || arr[pair.x + i][pair.y + j] != 1)
                    return false;
            }
        }
        return true;
    }

    static int boochigi(Pair pair, int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                arr[pair.x + i][pair.y + j] ^= 1;
            }
        }
        return (size + 1) * (size + 1);
    }

    static void paperplay(int cnt, int onecnt, int idx) {
        if (cnt >= min)
            return;
        if (onecnt == list.size()) {
            min = Math.min(min, cnt);
            return;
        }

        Pair p = list.get(idx);
        if (arr[p.x][p.y] == 1) {
            for (int j = p.max; j >= 0; j--) {
                if (papercnt[j] < 5 && isPossi(p, j)) {
                    int test = boochigi(p, j);
                    papercnt[j]++;
                    paperplay(cnt + 1, onecnt + test, idx + 1);
                    boochigi(p, j);
                    papercnt[j]--;
                }
            }
        } else {
            paperplay(cnt, onecnt, idx + 1);
        }
    }


    static ArrayList<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    list.add(new Pair(i, j));
            }
        }
        for (Pair p : list) {
            p.max = getSize(p, 4);
        }
        min = Integer.MAX_VALUE;

        paperplay(0, 0,0);
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}