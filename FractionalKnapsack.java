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
