import java.util.ArrayList;

public class heaptest {
    private ArrayList<Integer> heap;

    heaptest(){
        heap = new ArrayList<>();
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int leftChild(int index){
        return (2*index)+1;
    }

    private int rightChild(int index){
        return (2*index)+2;
    }

    private void insert(int key){
        heap.add(key);
        int current = heap.size()-1;
        while (current>0 && heap.get(current)<heap.get(parent(current))){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    private int takeTop(){
        int temp = heap.get(0);
        int last = heap.remove(heap.size()-1);
        if (!heap.isEmpty()){
            heap.set(0,last);
            heapify(0);
        }
        return temp;
    }

    private int deleteIndex(int key){
        for (int i = 0; i < heap.size(); i++) {
            if (key==heap.get(i)){
                swap(i,heap.size()-1);
                break;
            }
        }
        return heap.remove(heap.size()-1);
    }

    private boolean isEmpty(){
        return heap.size()==0;
    }

    private void heapify(int index){
        int smallest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        if (leftChild<heap.size()&&heap.get(smallest)>heap.get(leftChild)){
            smallest = leftChild;
        }
        if (rightChild<heap.size()&&heap.get(smallest)>heap.get(rightChild)){
            smallest = rightChild;
        }
        if (smallest!=index){
            swap(smallest,index);
            heapify(smallest);
        }
    }

    private void swap(int i,int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    public static void main(String[] args) {
        heaptest minHeap = new heaptest();
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.deleteIndex(10);

        System.out.println("Extracted elements in order:");
        System.out.println(minHeap.isEmpty());
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.takeTop() + " ");
        }
    }
}
