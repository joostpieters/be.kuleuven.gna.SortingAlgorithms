package gna;

/**
 * This class provides a number of sorting algorithms.
 *
 * @author Kasper Vervaecke
 */
@SuppressWarnings("rawtypes")
public class SortingAlgorithms {

    private int merge_comparisons;
    private int quick_comparisons;

    /**
     * Sorts the given array using selection sort.
     *
     * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
     */
    public <T extends Comparable<T>> int selectionSort(T[] array) {
        int comparisons = 0;
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(array[j], array[min])) {
                    min = j;
                }
                comparisons++;
            }
            exch(array, i, min);
        }
        return comparisons;
    }

    /**
     * Sorts the given array using insertion sort.
     *
     * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
     */
    public <T extends Comparable<T>> int insertionSort(T[] array) {
        int comparisons = 0;
        int N = array.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
                comparisons++;
            }
        }
        return comparisons + N;
    }

    /**
     * Sorts the given array using (2-way) merge sort.
     * <p/>
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
        mergeSort(array, 0, array.length - 1);
        return merge_comparisons;
    }

    /**
     * Sorts the given array using quick sort. Do NOT perform a random shuffle.
     *
     * @return The number of comparisons (i.e. calls to compareTo) performed by the algorithm.
     */
    public <T extends Comparable<T>> int quickSort(T[] array) {
        quick_comparisons = 0;
        quickSort(array, 0, array.length - 1);
        return quick_comparisons;
    }

    /**
     * Sorts the given array using k-way merge sort. The implementation can assume that k is at least 2.
     * k is the number of the number of subarrays (at each level) that must be separately sorted via a recursive call and merged via a k-way merge.
     * For example, if k equals 3, then the array must be subdivided into three subarrays that are each sorted by 3-way merge sort. After the 3 sub-
     * arrays, these sub-arrays are combined via a 3-way merge.
     * <p/>
     * Note that if k is larger than the length of the array (or larger than the length of a sub-array in a recursive call),
     * then the implementation is allowed sort that sub-array using quick sort.
     *
     * @return An non-null array of length 2. The first element of this array is the number of comparisons (i.e. calls to compareTo) performed by
     *         the algorithm, while the second element is the number of data moves.
     */
    public <T extends Comparable<T>> int[] kWayMergeSort(T[] array, int k) {
        throw new RuntimeException("not implemented");
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void mergeSort(Comparable[] array, int lo, int hi) {
        merge_comparisons = 0;
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private void merge(Comparable[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        Comparable[] aux = new Comparable[array.length];
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
                merge_comparisons++;
            } else if (j > hi) {
                array[k] = aux[i++];
                merge_comparisons++;
            } else if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
                merge_comparisons++;
            } else {
                array[k] = aux[i++];
            }
        }
    }

    private void quickSort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(array, lo, hi);
        quickSort(array, lo, j - 1);
        quickSort(array, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                quick_comparisons++;
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                quick_comparisons++;
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                quick_comparisons++;
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
