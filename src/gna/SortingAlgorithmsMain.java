package gna;

import java.util.ArrayList;

public class SortingAlgorithmsMain {
    public static void main(String[] args) {
        SortingAlgorithms algorithms = new SortingAlgorithms();
        //testSortingAlgorithms(algorithms);
        doublingRatioExperiment(algorithms);
    }

    private static void doublingRatioExperiment(SortingAlgorithms algorithms) {
        int i = 100;
        while (i <= 6400) {
            Integer[] array = getRandomIntegers(i);
            System.out.println("-[N = " + i + "]-");

            long start = System.currentTimeMillis();
            quickSort(algorithms, array);
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            i = i * 2;
        }
    }

    private static void testSortingAlgorithms(SortingAlgorithms algorithms) {
        for (int i = 0; i < 100; i++) {
            Integer[] array = getRandomIntegers(i);
            System.out.println("-[N = " + i + "]-");

            selectionSort(algorithms, array);
            insertionSort(algorithms, array);
            mergeSort(algorithms, array);
            quickSort(algorithms, array);
            kWayMergeSort(algorithms, array, 3);
        }
    }

    private static void kWayMergeSort(SortingAlgorithms algorithms, Integer[] array, int k) {
        int[] comparesAndMoves = algorithms.kWayMergeSort(array, k);
        System.out.println(comparesAndMoves[0] + " ; " + comparesAndMoves[1]);
    }

    private static void quickSort(SortingAlgorithms algorithms, Integer[] array) {
        System.out.println(algorithms.quickSort(array));
    }

    private static void mergeSort(SortingAlgorithms algorithms, Integer[] array) {
        System.out.println(algorithms.mergeSort(array));
    }

    private static void insertionSort(SortingAlgorithms algorithms, Integer[] array) {
        System.out.println(algorithms.insertionSort(array));
    }

    private static void selectionSort(SortingAlgorithms algorithms, Integer[] array) {
        System.out.println(algorithms.selectionSort(array));
    }

    private static Integer[] getRandomIntegers(int number) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);
        Integer[] array = new Integer[list.size()];
        array = list.toArray(array);
        return array;
    }
}

