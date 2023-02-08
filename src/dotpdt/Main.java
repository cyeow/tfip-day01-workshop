package dotpdt;

import java.io.Console;

public class Main {
    public static void main(String[] args) {

        // request input on the matrix size
        Console cons = System.console();
        int rows = Integer.parseInt(cons.readLine("How many equations (rows): "));
        int cols = Integer.parseInt(cons.readLine("How many terms (cols): "));
        
        // double[][] eqn = getEqn(rows, cols); // request input on the equation matrix 
        // double[] weights = getWeights(cols); // request input on the weights
        // double[] result = dotProduct(eqn, weights); // calculate the dot product of eqn and weight matrices

        // above 3 methods can be condensed into the following:
        double[] result = dotProduct(getEqn(rows,cols), getWeights(cols));

        // display the resultant matrix in a row
        System.out.printf("The resulting dot product is: [");
        for(int i = 0; i < rows; i++) {
            System.out.printf("%f", result[i]);
            if(i < rows -1) {
                System.out.printf(", "); // prints comma if it's not the last element
            }
        }
        System.out.printf("].");

    }

    private static double[][] getEqn(int rows, int cols) {
        Console cons = System.console();

        System.out.println("Please enter the equation:");

        double[][] eqn = new double[rows][cols];

        for(int i = 1; i <= rows; i++) {
            //read line 
            String input = cons.readLine("%d) ", i);
            String[] split = input.split(" ");
            //loop and fill row 
            // check if num of numbers entered is the same as the number of cols
            // if incorrect, request for input again.
            if(split.length != cols) {
                System.out.println("Invalid input");
                i--;
            } else {
                for(int j = 0; j < cols; j++) {
                    eqn[i-1][j] = Double.parseDouble(split[j]);
                }   
            }
        }

        return eqn;
    }

    private static double[] dotProduct(double[][] eqn, double[] weights) {
        
        double[] result = new double[eqn.length];

        // calculates the dotproduct of two matrices by doing two loops and assigning to the result array. 
        // 1) to go through each row 
        // 2) to go through each element within the row, or "column"
        for(int i = 0; i < eqn.length; i++) {
            double sum = 0;
            for(int j = 0; j < weights.length; j++) {
                sum += eqn[i][j] * weights[j];
            }
            result[i] = sum;
        }
        return result;
    }

    private static double[] getWeights(int rows) {
        Console cons = System.console();
        String[] split = null;
        double[] weight = new double[rows];

        // loop is to ensure that the program only accepts valid input. 
        // no exit otherwise. wahaha. 
        do {
            if(split != null && split.length != rows) {
                System.out.printf("Invalid input. A valid weight requires %d elements. ", rows);
            }
            split = cons.readLine("Please enter the weights:\n").split(" ");

        } while(split.length != rows);


        if(split.length == rows) {
            for(int i = 0; i < rows; i++) {
                weight[i] = Double.parseDouble(split[i]);
            }
        }

        return weight;
    }
}
