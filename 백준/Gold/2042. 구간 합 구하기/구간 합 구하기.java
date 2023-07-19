import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static class SegmentTree{
        private long[] tree;

        SegmentTree(int n){
            double treeHeight = Math.ceil(Math.log(n)/Math.log(2))+1;
            long treeNodeCount = Math.round(Math.pow(2,treeHeight));
            tree= new long[Math.toIntExact(treeNodeCount)];
        }

        long init(long[] arr, int node, int start, int end){
            if(start==end) return tree[node]=arr[start];
            return tree[node] = init(arr, node*2, start, (start+end)/2)
                    + init(arr,node*2+1,(start+end)/2+1,end);
        }
        long sum(int node, int start, int end, int left, int right){
            if(end<left||right<start) return 0;
            if(left <= start && end<=right) return tree[node];
            return sum(node*2,start,(start+end)/2,left,right)+
                    sum(node*2+1,(start+end)/2+1,end,left,right);
        }
        void update(int node, int start, int end, int index, long diff){
            if(index<start||end<index) return;
            tree[node] = tree[node]+diff;//변경할 값 - 기존값 = 차이값

            if(start!=end){
                update(node*2, start,(start+end)/2, index, diff);
                update(node*2+1,(start+end)/2+1, end, index, diff);
            }
        }
        long update2(int node, int start, int end, int index, long changeValue) {
            // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)가 포함되지 않을 경우
            if (index < start || end < index) {
                // 트리의 노드 값 리턴
                return tree[node];
            } else if (start == index && end == index) {
                // 노드가 가지는 값의 구간과 배열의 인덱스(값이 변경 될 인덱스)값이 같은 경우
                // 노드의 값을 변경 될 값으로 변경
                return tree[node] = changeValue;
            } else {
                // 노드가 가지는 값의 구간에 배열의 인덱스(값이 변경 될 인덱스)값이 포함되는 경우(같은 경우는 제외)
                // 자식 노드를 탐색 후 값을 더해서 리턴
                return tree[node] = update2(node * 2, start, (start + end) / 2, index, changeValue) +
                        update2(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        long[] arr= new long[Integer.parseInt(info[0])+1];
        for(int i=1;i<=Integer.parseInt(info[0]);i++){
            arr[i]=Long.parseLong(bf.readLine());
        }
        SegmentTree st = new SegmentTree(Integer.parseInt(info[0]));
        st.init(arr,1,1,Integer.parseInt(info[0]));
        StringTokenizer stz;
        for(int i=0;i<Integer.parseInt(info[1])+Integer.parseInt(info[2]);i++){
            stz = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            long c = Long.parseLong(stz.nextToken());
            if(a==1){
                long diff = c - arr[b];
                arr[b]=c;
                st.update(1,1,Integer.parseInt(info[0]),b,diff);
            }else{
                long result = st.sum(1,1,Integer.parseInt(info[0]),b,(int)c);
                System.out.println(result);
            }
        }
    }
}