public class maxHeap<T extends Comparable<? super T>>{
    private int size;
    public T[] array;
    private int endIndex;
    private T[] sortedArray;
    public maxHeap(){
        this(50);
    }
    @SuppressWarnings("unchecked")
    public maxHeap(int size){
        array = (T[]) new Comparable[size];
        endIndex = 0;
    }
    public T getMax(){
        if (endIndex < 1){
            throw new IllegalAccessError();
        }
        return array[1];
    }
    public T remove(){ // FIX THIS ITS SPAGETTI CODEEEEE
        if (endIndex < 1){
            throw new IllegalAccessError();
        }
        if (endIndex == 1){
            T last = array[1];
            array[1] = null;
            endIndex--;
            return last;
        }
        else{
            int traversingIndex = 1;
            T last = array[endIndex]; // this is the last value of the heap
            T largest = array[1];
            array[traversingIndex] = last;
            array[endIndex] = null;
            endIndex--;
            while (traversingIndex * 2 + 1 <= endIndex){
                traversingIndex *= 2;
                if ((array[traversingIndex].compareTo(array[traversingIndex + 1]) > 0) && (array[traversingIndex].compareTo(last) > 0)){ // if the left side is larger than the right
                    int parent = traversingIndex / 2;
                    array[parent] = array[traversingIndex];
                }
                else if ((array[traversingIndex + 1].compareTo(array[traversingIndex]) > 0) && (array[traversingIndex + 1].compareTo(last) > 0)){
                    int parent = traversingIndex / 2;
                    array[parent] = array[traversingIndex + 1];
                    traversingIndex++;
                }
                else{
                    // array[traversingIndex] = last;
                    // break;
                }
            }
            array[traversingIndex] = last;
            return largest;
        }
    }
    public void add(T value){
        if (endIndex < 1){ // if the heap was already empty
            endIndex = 1;
            array[endIndex] = value;
        }
        else{   // if the heap already has elements
            endIndex++;
            array[endIndex] = value;
            int traversingIndex = endIndex;
            while (traversingIndex / 2 != 0){
                if ((array[traversingIndex]).compareTo(array[traversingIndex / 2]) > 0){
                    array[traversingIndex] = array[traversingIndex / 2];
                    traversingIndex = traversingIndex / 2;
                    array[traversingIndex] = value;
                }
                else{
                    array[traversingIndex] = value;
                    break;
                }
            }
        }
    }
    public T[] sort(){ // I am actually removing them from the other array and sorting them but this code is messed up
        sortedArray = (T[]) new Comparable[endIndex + 1];
        for (int i = 0; i <= endIndex + 5; i++){
            sortedArray[i] = remove();
        }
        return sortedArray;
    }
}
