import java.util.*;

public class MountainSort {

    public static void main(String[] args) {
        int[][] Tests = {
                {},
                {5},
                {5, 23, 32, 2, 1},
                {6, 2, 8, 5, 7, 5, 0, 2},
                {2,2,2,2,2,2,2,2},
                {4, -7, 2, 1, 0, 2, 4, 2, -3, 3, -3, 7, -2, 7, 7},
                {-2, -2, -4, -9, -1, -6, -1, -14, -3, -15, -12, -12, -2, -8, -9},
        };
        for (int[] A: Tests) {
            try {
                System.out.println("Given array: " + Arrays.toString(A));
                A = MountainSort(A); //change the name of function if necessary
                System.out.println("Array sorted: " + Arrays.toString(A));
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error for array: "+ Arrays.toString(A));
                System.out.println(e);
            }
        }
    }

    public static int[] MountainSort(int[] A) {
        if (A.length <= 0) {
            return A;
        }

        int lowest = A[0], highest = A[0];
        for (int j : A) {
            if (j < lowest) {
                lowest = j;
            }

            if (j > highest) {
                highest = j;
            }
        }

        int[] indexCounter = new int[highest - lowest + 1];
        for (int j : A) {
            indexCounter[j - lowest] += 1;
        }

        int index = 0;
        int value = lowest;
        for (int i : indexCounter) {
            for (int n = i; n > 0; n--) {
                A[index] = value;
                index++;
            }
            value++;
        }

        int temp;
        int reverseIndex = A.length/2;
        for (int k = A.length-1; k >= A.length/2; k--) {
            temp = A[reverseIndex];
            A[reverseIndex++] = A[k];
            A[k] = temp;

            if ((int) Math.ceil(A.length/4.0) == A.length - k) {
                break;
            }
        }

        return A;
    }

}
