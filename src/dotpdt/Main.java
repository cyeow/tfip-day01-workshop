package dotpdt;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        Console cons = System.console();
        int rows = Integer.parseInt(cons.readLine("How many equations (rows): "));
        int cols = Integer.parseInt(cons.readLine("How many terms (cols): "));
        
        double[][] eqn = new double[rows][cols];

        System.out.println("Please enter the equation:");

        for(int i = 1; i <= rows; i++) {
            //read line 
            String input = cons.readLine("%d) ", i);
            String[] split = input.split(" ");
            //loop and fill row 
            // check if num of numbers entered is the same as the number of cols

            if(split.length != cols) {
                System.out.println("Invalid input");
                i--;
            } else {
                for(int j = 0; j < cols; j++) {
                    eqn[i-1][j] = Double.parseDouble(split[j]);
                }   
            }
        }

        double[] weights = getWeights(cols);

        double[] result = dotProduct(eqn, weights);
        
        System.out.printf("The resulting dot product is: [");
        for(int i = 0; i < rows; i++) {
            System.out.printf("%f", result[i]);
            if(i < rows -1) {
                System.out.printf(", ");
            }
        }
        System.out.printf("].");

    }

    private static double[] dotProduct(double[][] eqn, double[] weights) {
        
        double[] result = new double[eqn.length];

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

        do {
            if(split != null && split.length != rows) {
                System.out.printf("Invalid input. A valid weight requires %d rows. ", rows);
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
