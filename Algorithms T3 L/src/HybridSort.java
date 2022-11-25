import java.util.*;

public class HybridSort {
    public static void main(String[] args) {
        int[][] Tests = {
                {},
                {6, 2, 8, 5, 7, 5, 0, 2},
                {2,2,2,2,2,2,2,2},
                {4, -7, 2, 1, 0, 2, 4, 2, -3, 3, -3, 7, -2, 7, 7},
                {-2, -2, -4, -9, -1, -6, -1, -14, -3, -15, -12, -12, -2, -8, -9},
        };
        for (int[] A: Tests) {
            try {
                System.out.println("Given array: " + Arrays.toString(A));
                A = hybridSort(A); //change the name of function if necessary
                System.out.println("Array sorted: " + Arrays.toString(A)+ "\n");
            }   catch (Exception e) {
                System.out.println("Error for array: " + Arrays.toString(A));
                System.out.println(e);
            }
        }

    }

    public static int[] hybridSort(int[] A) {
        int n = A.length;
        boolean change = true;
        int counter = 0;

        if(n <= 0){
            return A;
        }

        while (change) {
            change = false;
            int lowest = counter;

            for(var i = 0; i < n-1; i++){
                if(A[i+1] < A[lowest] && i > counter){
                    lowest = i;
                }

                if (A[i] > A[i+1]){
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                    change = true;
                }
            }

            // Save lowest
            int temp = A[counter];
            A[counter] = A[lowest];
            A[lowest] = temp;

            counter++;
            n--;
        }

        return A;
    }
}
