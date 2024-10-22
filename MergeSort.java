import java.util.*;
public class MergeSort{ // pretty basic sorting algorithm
  public static void main(String[] args){
    Integer[] array = {4, 3, 6, 100, 8, 9, 54, 1, 0};
    Integer[] FINAL_ARRAY = mergesort(array);
    System.out.println(Arrays.toString(FINAL_ARRAY));
  }
  
  public static Integer[] mergesort(Integer[] array){
    if (array.length <= 1){
      return array;
    }
    int mid = array.length / 2;
    Integer[] left = new Integer[mid];
    Integer[] right = new Integer[array.length - mid];
    for (int i = 0; i < mid; i++){ // copying arrays from the first half to left (I could have used the Arrays class but lets do everything manually)
      left[i] = array[i];
    }
    for (int i = mid; i < length; i++){ // copying right half of the array
      right[i - mid] = array[i]; // if i = 4 and mid = 3 then, left[1] = ar
    }
    Integer[] left_half = mergesort(left);
    Integer[] right_half = mergesort(right);
    return merge(left_half, right_half);
  }
  
  public static Integer[] merge(Integer[] left, Integer[] right){
    int i = 0;
    int j = 0;
    int index = 0;
    Integer[] temp_array = new Integer[left.length + right.length];
    while ((i < left.length) && (j < right.length)){
      if (left[i] < right[j]){
        temp_array[index] = left[i];
        index++;
        i++;
      }
      else{
        temp_array[index] = right[j];
        index++;
        j++;
      }
    }
    while (i < left.length){
      temp_array[index] = left[i];
      i++;
      index++;
    }
    while (j < right.length){
      temp_array[index] = right[j];
      j++;
      index++;
    }
    return temp_array;
  }  
}
