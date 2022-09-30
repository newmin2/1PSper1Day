import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void spring() {
        int qsize = treeList.size();
        for (int i = 0; i < qsize; i++) {
            Tree tree = treeList.poll();
            if (tree.age > arr[tree.x][tree.y]) {
                q.offer(tree);
            } else {
                arr[tree.x][tree.y] -= tree.age;
                tree.age++;
                liveq.offer(tree);
            }
        }
    }

    static void summer() {
        while(!q.isEmpty()){
            Tree tree=q.poll();
            arr[tree.x][tree.y]+=tree.age/2;
        }
    }
    static void autumn() {
        int qsize = liveq.size();
        for (int i = 0; i < qsize; i++) {
            Tree tree = liveq.poll();
            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nr = tree.x + dr[j];
                    int nc = tree.y + dc[j];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    treeList.add(new Tree(nr, nc, 1));
                }
            }
            treeList.offer(tree);
        }
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] += plus[i][j];
            }
        }
    }
    static Queue<Tree>q = new ArrayDeque<>();
    static Queue<Tree>liveq = new ArrayDeque<>();

    static class Tree {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static int n, m, k;
    static PriorityQueue<Tree> treeList = new PriorityQueue<>(new Comparator<Tree>() {
        @Override
        public int compare(Tree o1, Tree o2) {
            return o1.age - o2.age;
        }
    });
    static int[][] arr, plus;
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        plus = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = 5;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            treeList.offer(new Tree(x, y, age));
        }
        while (k > 0) {
            spring();
            summer();
            autumn();
            winter();
            k--;
        }
        System.out.println(treeList.size());
    }
}
