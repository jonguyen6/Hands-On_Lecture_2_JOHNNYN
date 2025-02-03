import java.util.Scanner;
import java.util.ArrayList;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        System.out.print("Choose two numbers from 1 to 30 for matrix dimensions (separate numbers w/ space): ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // simple while-loop to make sure user inputs are valid
        while ((m<1 || m>30) || (n<1 || n>30)) {
            System.out.print("Invalid number, please enter a number within the given range: ");
            m = scanner.nextInt();
            n = scanner.nextInt();
        }

        // defining matrix boundaries after acquiring specifications, making sure bottom and right are 1 less because arrays start indexes at 0
        int top = 0, bottom = m-1;
        int left = 0, right = n-1;

        // create matrix using the dimensions inputted
        matrix.ensureCapacity(m);                                   // set the arrayList that holds all other arrayList to size 'm'
        int count = 1;                                              // var to increment and add to matrix
        for (int i = 0; i<m; i++) {                                 // traverse the length of the matrix 'm'
            ArrayList<Integer> row = new ArrayList<Integer>(n);     // set the row length to 'n'
            for (int j = 0; j<n; j++) {                             // traverse the length of the row 'n'
                row.add(count++);                                   // add and increment count to add to row
            }
            matrix.add(row);                                        // add row to matrix
        } // matrix construction to user specifications complete

        System.out.println("Input: matrix = " + matrix);
        System.out.print("Output: ");

        // Using a while loop to simulate recursion, we can use our specified boundaries to traverse the matrix in a spiraling order
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {                       // Traverse from left to right
                System.out.print(matrix.get(top).get(i) + " ");
            }
            top++;                                                      // Move top boundary downward

            for (int i = top; i <= bottom; i++) {                       // Traverse from top to bottom
                System.out.print(matrix.get(i).get(right) + " ");
            }
            right--;                                                    // Move right boundary leftward

            if (top <= bottom) {                                        // Traverse from right to left, if still within bounds
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix.get(bottom).get(i) + " ");
                }
                bottom--;                                               // Move bottom boundary upward
            }

            if (left <= right) {                                        // Traverse from bottom to top, if still within bounds
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix.get(i).get(left) + " ");
                }
                left++;                                                 // Move left boundary rightward
            }
        }
    }
}
