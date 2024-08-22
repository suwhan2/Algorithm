import java.io.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int c= Integer.parseInt(br.readLine());
            if(c==0) sb.append(heap.poll()).append("\n");
            else heap.offer(c);
        }
        System.out.println(sb);
    }
}
class Heap{
    int[] heap;
    int size;
    Heap(int l){ //생성자
        heap = new int[l+1];
    }
    void offer(int e){
        heap[++size] = e;
        int target = size << 1;
        while((target >>= 1) > 1){
            if(!swap(target)) break;
        }
    }
    int poll(){
        if(size == 0) return 0;
        int e = heap[1];
        heap[1] = heap[size--];
        int i = 1;
        while((i<<=1)<=size){
            if(i<size && heap[i] > heap[i+1]) i++;
            if(!swap(i)) break;
        }
        return e;
    }

    boolean swap(int mother){
        int son = mother >>1;
        int sonValue = heap[son];
        int motherValue = heap[mother];
        if(sonValue < motherValue) return false;
        heap[son] = motherValue;
        heap[mother] = sonValue;
        return true;
    }
}