/*
Problem Description
Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
Input Format. The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack.
The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 and 𝑤𝑖—the
value and the weight of 𝑖-th item, respectively.
Constraints. 1 ≤ 𝑛 ≤ 10^3, 0 ≤ 𝑊 ≤ 2 · 10^6; 0 ≤ 𝑣𝑖 ≤ 2 · 10^6, 0 < 𝑤𝑖 ≤ 2 · 10^6 for all 1 ≤ 𝑖 ≤ 𝑛. All the
numbers are integers.
Output Format. Output the maximal value of fractions of items that fit into the knapsack. The absolute
value of the difference between the answer of your program and the optimal value should be at most
10^−3. To ensure this, output your answer with at least four digits after the decimal point (otherwise
your answer, while being computed correctly, can turn out to be wrong because of rounding issues).
*/

import java.util.Scanner;



public class FractionalKnapsack {
    

	private static double getOptimalValue(int capacity, int[] values, int[] weights, int size) {
   
		//int size = values.length;     
		double value = 0;
        
		double totalValue = 0;
		int totalWeight = 0;
		//write your code here

    
    			
		// get the unit values
		double[] units = new double[size];
		for( int i = 0; i < size; i++ ) {
			units[i] = (double)(values[i]) / weights[i];
		}
		
		

		// sort:
		for ( int i = 0; i < size; i++ ) {

			totalValue = totalValue + values[i];
			totalWeight = totalWeight + weights[i];

			for ( int j = i+1; j < size; j++ ) {
				if ( units[i] < units[j] ) {
					int temp1 = values[i];
					int temp2 = weights[i];
					double temp3 = units[i];
					values[i] = values[j];
					weights[i] = weights[j];
					units[i] = units[j];
					values[j] = temp1;
					weights[j] = temp2;
					units[j] = temp3;
				}
			}
		}

		//for the case that all the items weigh the same or less than the capacity
		if( totalWeight <= capacity ) {
			return totalValue;
		} else {
			// calculate the value;
			int weight = 0;
			int index = 0;
			while ( capacity != 0 && index < size ) {
				if( ( capacity - weights[index] ) >= 0 ) {
					value = value + ( units[index] * weights[index] );
					capacity = capacity - weights[index];
				} else {
					int k = weights[index] - ( (-1)*( capacity - weights[index] ) );
					value = value + ( units[index] * k );
					capacity = capacity - k;
					
				}
				index++;
			}
		}
		
		return value;
    
	}

    

	public static void main(String args[]) {
        
		Scanner scanner = new Scanner(System.in);
        
		int n = scanner.nextInt();
        
		int capacity = scanner.nextInt();
        
		int[] values = new int[n];
        
		int[] weights = new int[n];
        

		for (int i = 0; i < n; i++) {
            
			values[i] = scanner.nextInt();
            
			weights[i] = scanner.nextInt();
        
		}
        

		//System.out.println(getOptimalValue(capacity, values, weights));
   
		System.out.printf("%.3f", getOptimalValue(capacity, values, weights, n));
   
	}

} 
