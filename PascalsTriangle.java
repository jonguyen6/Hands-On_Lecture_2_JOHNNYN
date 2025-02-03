import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number from 1 to 30 for Pascal's Triangle: ");
        int numRows = scanner.nextInt();
        List<List<Integer>> rows = new ArrayList<>();

        // while-loop to make sure user inputs a valid number
        while (numRows < 1 || numRows > 30) {
            System.out.println("Invalid number, please enter a number within the given range: ");
            numRows = scanner.nextInt();
        }

        // can use nested arrays, with the original "rows" being the one that is outputted
        // we will need a loop to make the sub-arrays based on the number of rows inputted/asked for
            for (int i = 0; i < numRows; i++) {             // first loop keeps track of what row we are on
                List<Integer> tempRow = new ArrayList<>();  // create tempRow to house current row
                for (int j = 0; j <= i; j++) {              // second loop for adding to current row
                    if (j==0 || j==i) {                     // if we are on the first or last index of the row...
                        tempRow.add(1);                     // add 1 to form the ends of the row
                    }
                    else {                                  // otherwise, add the number before and after from the previous row
                        tempRow.add(rows.get(i-1).get(j-1) + rows.get(i-1).get(j));
                    }
                }
                rows.add(tempRow);                          // add the completed row to the list of rows
            }
        System.out.println("Input: " + numRows);
        System.out.println("Output: " + rows);
    }
}