import java.io.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HeapMin heapMin = new HeapMin(N);
        HeapMax heapMax = new HeapMax(N);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int c= Integer.parseInt(br.readLine());
            if(i==0){
                heapMin.offer(c);
                sb.append(heapMin.heap[1]).append("\n");
                continue;
            }

            if(heapMax.size==heapMin.size){
                if(c<heapMax.heap[1]){
                    heapMin.offer(heapMax.poll());
                    heapMax.offer(c);
                    sb.append(heapMin.heap[1]).append("\n");
                }
                else{
                    heapMin.offer(c);
                    sb.append(heapMin.heap[1]).append("\n");
                }
            }
            else{
                if(c<=heapMin.heap[1]){
                    heapMax.offer(c);
                    sb.append(heapMax.heap[1]).append("\n");
                }
                else{
                    heapMax.offer(heapMin.poll());
                    heapMin.offer(c);
                    sb.append(heapMax.heap[1]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
class HeapMin{
    int[] heap;
    int size;
    HeapMin(int l){ //생성자
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
class HeapMax{
    int[] heap;
    int size;
    HeapMax(int l){ //생성자
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
        int e = heap[1];
        heap[1] = heap[size--];
        int i = 1;
        while((i<<=1)<=size){
            if(i<size && heap[i] < heap[i+1]) i++;
            if(!swap(i)) break;
        }
        return e;
    }

    boolean swap(int mother){
        int son = mother >>1;
        int sonValue = heap[son];
        int motherValue = heap[mother];
        if(sonValue > motherValue) return false;
        heap[son] = motherValue;
        heap[mother] = sonValue;
        return true;
    }
}