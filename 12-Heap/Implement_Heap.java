import java.util.ArrayList;

/*-------- MinHeap - smaller the value higher the priority --------*/
class MinHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    /*---- calling function ----*/
    public void add(int data) {
        insert(data);
    }

    public void remove() {
        System.out.println("remove >> " + removeFromHeap());
    }

    public void peek() {
        System.out.println("Peek >> " + peekInto());
    }

    public void show() {
        System.out.println("MinHeap >> " + arr);
    }
        /*---- ----*/

    /*------ Working function ------*/

    /*---- Insert a value ----*/
    private void insert(int data) { // TC -> O(log(n)) || SC -> O(1)
        // step1 -> insert the value at the end of array list
        arr.add(data);

        // step2 -> fix the heap
        int childIdx = arr.size() - 1;
        int parentIdx = (childIdx - 1) / 2;

        while (arr.get(childIdx) < arr.get(parentIdx)) {
            // swapping
            int swapVar = arr.get(childIdx);
            arr.set(childIdx, arr.get(parentIdx));
            arr.set(parentIdx, swapVar);

            // change index values
            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }
            /*---- ----*/
    /*---- Remove a val from heap ----*/
    private int removeFromHeap() {
        int removeVal = arr.get(0);

        // Step1 -> swap first & last
        int swapVar = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, swapVar);

        // step2 -> remove value
        arr.remove(arr.size() - 1);

        // step3 -> fix the heap
        heapify(0);

        return removeVal;
    }

    private void heapify(int i) {
        int minIdx = i;
        int left = 2 * i + 1; // current root's left child
        int right = 2 * i + 2; // current root's right child

        // search for minimum value to swap with current root
        if (left < arr.size() && arr.get(minIdx) > arr.get(left))
            minIdx = left;
        if (right < arr.size() && arr.get(minIdx) > arr.get(right))
            minIdx = right;

        // fix the heap
        if (minIdx != i) {
            // swap
            int swapVar = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, swapVar);

            heapify(minIdx);
        }
    }
            /*---- ----*/
    /*--- Peek on Heap- ----*/
    private int peekInto() { // TC -> O(1) || SC -> O(1)
        return arr.get(0);
    }
        /*---- ----*/

        /*------ ------*/

}
                    /*-------- --------*/

/*-------- MaxHeap - greater the value higher the priority --------*/
class MaxHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    /*---- calling function ----*/
    public void add(int data) {
        insert(data);
    }

    public void remove() {
        System.out.println("remove >> " + removeFromHeap());
    }

    public void peek() {
        System.out.println("Peek >> " + peekInto());
    }

    public void show() {
        System.out.println("MaxHeap >> " + arr);
    }
        /*---- ----*/

    /*------ Working function ------*/

    /*---- Insert a value ----*/
    private void insert(int data) { // TC -> O(log(n)) || SC -> O(1)
        // step1 -> insert the value at the end of array list
        arr.add(data);

        // step2 -> fix the heap
        int childIdx = arr.size() - 1;
        int parentIdx = (childIdx - 1) / 2;

        while (arr.get(childIdx) > arr.get(parentIdx)) {
            // swapping
            int swapVar = arr.get(childIdx);
            arr.set(childIdx, arr.get(parentIdx));
            arr.set(parentIdx, swapVar);

            // change index values
            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }
        /*---- ----*/
    /*---- Remove a val from heap ----*/
    private int removeFromHeap() {
        int removeVal = arr.get(0);

        // Step1 -> swap first & last
        int swapVar = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, swapVar);

        // step2 -> remove value
        arr.remove(arr.size() - 1);

        // step3 -> fix the heap
        heapify(0);

        return removeVal;
    }

    private void heapify(int i) {
        int maxIdx = i;
        int left = 2 * i + 1; // current root's left child
        int right = 2 * i + 2; // current root's right child

        // search for maximum value to swap with current root
        if (left < arr.size() && arr.get(maxIdx) < arr.get(left))
            maxIdx = left;
        if (right < arr.size() && arr.get(maxIdx) < arr.get(right))
            maxIdx = right;

        // fix the heap
        if (maxIdx != i) {
            // swap
            int swapVar = arr.get(i);
            arr.set(i, arr.get(maxIdx));
            arr.set(maxIdx, swapVar);

            heapify(maxIdx);
        }
    }
        /*---- ----*/
    /*--- Peek on Heap- ----*/
    private int peekInto() { // TC -> O(1) || SC -> O(1)
        return arr.get(0);
    }
        /*---- ----*/

        /*------ ------*/

}
                    /*-------- --------*/

public class Implement_Heap {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.add(5);
        mh.add(6);
        mh.add(7);
        mh.add(8);
        mh.add(1);

        mh.show();
        /*  1
           / \
          5   7
         / \
        8   6
                */

        mh.peek();
        mh.remove();
        // mh.remove();
        mh.show();

        // --------------------------------------------
        System.out.println("---------- ---------");
        // --------------------------------------------

        MaxHeap maxH = new MaxHeap();
        maxH.add(5);
        maxH.add(6);
        maxH.add(7);
        maxH.add(8);
        maxH.add(1);

        maxH.show();
        /*  8
           / \
          7   6
         / \
        5   1
                */
        maxH.peek();

        maxH.remove();
        // maxH.remove();
        maxH.show();

    }
}
