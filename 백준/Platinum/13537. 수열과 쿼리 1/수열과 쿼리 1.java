import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    static class SegmentTree{
        List<Integer>[] tree;

        SegmentTree(int N, int[] arr){
            double treeHeight = Math.ceil(Math.log(N)/Math.log(2))+1;
            int nodeCnt = 1<<Math.round(treeHeight);
            tree = new ArrayList[nodeCnt];
            for(int i=1;i<nodeCnt;i++){
                tree[i]=new ArrayList<>();
            }
            init(arr,1,1,N);
            for(int i=1;i<nodeCnt;i++){
                Collections.sort(tree[i]);
            }
        }
        List<Integer> init(int[] arr, int node, int start, int end){
            if(start == end) {
                tree[node].add(arr[start]);
                return tree[node];
            }
            tree[node].addAll(init(arr,node*2 ,start,(start+end)/2));
            tree[node].addAll(init(arr,node*2+1,(start+end)/2+1,end));
            return tree[node];
//            return tree[node] = Stream.of(init(arr,node*2 ,start,(start+end)/2),init(arr,node*2+1,(start+end)/2+1,end))
//                    .flatMap(Collection::stream)
//                    .collect(Collectors.toList());
        }
        int BinarySearch(int node, int start, int end, int left, int right, int key){
            if(left>end||right<start) return 0;
            if(start>=left&&end<=right) {
                int bStart=0;
                int bEnd=tree[node].size()-1;
                int mid;
                while(bStart<=bEnd){
                    mid = (bStart+bEnd)/2;
                    if(tree[node].get(mid)<=key){
                        bStart=mid+1;
                    }else{
                        bEnd=mid-1;
                    }
                }
                return tree[node].size()-bStart;
            }
            return BinarySearch(node*2,start,(start+end)/2,left,right,key)+
                    BinarySearch(node*2+1,(start+end)/2+1,end,left,right,key);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N+1];
        String[] arrInfo = bf.readLine().split(" ");
        for(int i=1;i<=N;i++)arr[i]=Integer.parseInt(arrInfo[i-1]);

        SegmentTree st = new SegmentTree(N, arr);

        int M = Integer.parseInt(bf.readLine());
        int[] query;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            query = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sb.append(st.BinarySearch(1,1,N,query[0],query[1],query[2])).append('\n');
        }
        System.out.println(sb);
    }
}