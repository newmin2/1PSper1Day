import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class SegmentTree{
        private int[] minTree;
        private int treeSize;
        SegmentTree(int n,int[] arr){
            int treeheight = (int) (Math.ceil(Math.log(n)/Math.log(2))+1);
            treeSize = 1<<treeheight;
            minTree = new int[treeSize];
            minInit(arr,1,1,arr.length-1);
        }
        int minInit(int[] arr, int node, int start, int end){
            if(start==end) return minTree[node]=arr[start];
            return minTree[node]=Math.min(minInit(arr,node*2,start,(start+end)/2),
                    minInit(arr,node*2+1,(start+end)/2+1,end));
        }
        int findMin(int node,int start,int end, int left, int right){
            if(left>end||start>right) return Integer.MAX_VALUE;
            if(left<=start&&right>=end) return minTree[node];
            return Math.min(findMin(node*2,start,(start+end)/2,left,right),findMin(node*2+1,(start+end)/2+1,end,left,right));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] info = bf.readLine().split(" ");
        int[] arr = new int[Integer.parseInt(info[0])+1];
        for(int i=1;i<=Integer.parseInt(info[0]);i++){
            arr[i]=Integer.parseInt(bf.readLine());
        }
        SegmentTree st = new SegmentTree(arr.length-1,arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Integer.parseInt(info[1]);i++){
            String[] mInfo = bf.readLine().split(" ");
            sb.append(st.findMin(1,1,arr.length-1,Integer.parseInt(mInfo[0]),Integer.parseInt(mInfo[1]))).append('\n');
        }
        System.out.println(sb);
    }
}