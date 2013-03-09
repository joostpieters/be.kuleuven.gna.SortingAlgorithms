package gna;

/**
 * This class provides a number of sorting algorithms.
 *
 * @author Kasper Vervaecke
 */
public class SortingAlgorithms {
  /**
   * Sorts the given array using selection sort.
   * 
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int selectionSort(T[] array) {
    throw new RuntimeException("not implemented");
  }
  
  /**
   * Sorts the given array using insertion sort.
   * 
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int insertionSort(T[] array) {
    throw new RuntimeException("not implemented");
  }
  
  /**
   * Sorts the given array using (2-way) merge sort.
   *
   * HINT: Java does not supporting creating generic arrays (because the compiler uses type erasure for generic types).
   * For example, the statement "T[] aux = new T[100];" is rejected by the compiler. 
   * Use the statement "T[] aux = (T[]) new Comparable[100];" instead. 
   * Add an "@SuppressWarnings("unchecked")" annotation to prevent the compiler from reporting a warning. 
   * Consult the following url for more information on generics in Java: 
   * http://download.oracle.com/javase/tutorial/java/generics/index.html
   *
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int mergeSort(T[] array) {
    throw new RuntimeException("not implemented");
  }
  
  /**
   * Sorts the given array using quick sort. Do NOT perform a random shuffle.
   * 
   * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
   */
  public <T extends Comparable<T>> int quickSort(T[] array) {
    throw new RuntimeException("not implemented");
  }
  
  /**
   * Sorts the given array using k-way merge sort. The implementation can assume that k is at least 2. 
   * k is the number of the number of subarrays (at each level) that must be separately sorted via a recursive call and merged via a k-way merge. 
   * For example, if k equals 3, then the array must be subdivided into three subarrays that are each sorted by 3-way merge sort. After the 3 sub-
   * arrays, these sub-arrays are combined via a 3-way merge.
   *
   * Note that if k is larger than the length of the array (or larger than the length of a sub-array in a recursive call), 
   * then the implementation is allowed sort that sub-array using quick sort.
   *
   * @return An non-null array of length 2. The first element of this array is the number of comparisons (i.e. calls to compareTo) performed by
   *         the algorithm, while the second element is the number of data moves.
   */
  public <T extends Comparable<T>> int[] kWayMergeSort(T[] array, int k) {
    throw new RuntimeException("not implemented");
  }
}
