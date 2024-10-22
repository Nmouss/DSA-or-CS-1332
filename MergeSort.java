public class MergeSort{ // pretty basic sorting algorithm
  public static void main(String[] args){
    
  }
  public static Integer[] mergesort(Integer[] array){
    if (array.length <= 1){
      return array;
    }
    int mid = array.legnth / 2;
    Integer[] left = new Integer[mid];
    Integer[] right = new Integer[array.length - mid];
    for (int i = 0; i < mid; i++){ // copying arrays from the first half to left (I could have used the Arrays class but lets do everything manually)
      left[i] = array[i];
    }
    for (int i = mid; i < length; i++){ // copying right half of the array
      left[i - mid] = array[i]; // if i = 4 and mid = 3 then, left[1] = ar
    }
    Integer[] left_half = mergesort(left);
    Integer[] right_half = mergesort(right);
    return merge(left_half, right_half);
  }
  public static Integer[] merge(Integer[] left, Integer[] right){
    
  }
}
