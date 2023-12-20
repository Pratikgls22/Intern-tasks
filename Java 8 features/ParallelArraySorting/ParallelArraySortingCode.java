package ParallelArraySorting;

import java.util.Arrays;

public class ParallelArraySortingCode {
    public static void main(String[] args) {

        int[] arr = {1,5,6,9,2,3};

        for(int i:arr){
            System.out.print(i+" ");
        }
        Arrays.parallelSort(arr);
        System.out.println("\n Array element after sorting");

        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
