public class QuickSort{
  public static void main(String[] args){
    Integer[] array = {4, 3, 6, 100, 8, 9, 54, 1, 0};
    quicksort(0, array.length - 1, array);
    System.out.println(Arrays.toString(array));
  }
  public static void quicksort(int left, int right, Integer[] array){
    if (left < right){
      int mid = helper(left, right, array);
      quicksort(mid + 1, right, array);
      quicksort(left, mid - 1, array);
    }
  }
  public static int helper(int left, int right, Integer[] array){
    int l = left;
    int r = right;
    int pivot = array[right];
    while (l < r){
      while ((array[l] < array[right]) && (l < right)){
        l++;
      }
      while ((array[r] >= array[right]) && (r > left)){
        r--;
      }
      if (l < r){
        Integer swapVal = array[r];
        array[r] = array[l];
        array[l] = swapVal;
      }
    }
    if (array[l] > pivot){
      int temp = array[l]; 
      array[l] = pivot;
      array[right] = temp;
    }
    return l;
  }
}
