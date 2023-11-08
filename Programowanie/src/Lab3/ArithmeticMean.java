package Lab3;
import java.util.Arrays;
public class ArithmeticMean {

	public static void main(String[] args) {
		if (args.length<=1) {
			String result;
			result = args.length == 0 ? "Brak argumetów programu" : 
					 "Przekazano tylko jedną wartość: "+args[0];
			System.out.println(result);
			return;
		}
		int sum=0;
		for(int i=0; i<args.length; i++) {
			Integer num = Integer.valueOf(args[i]);
			sum+=num;
		}
		int result;
		int remainder = Integer.remainderUnsigned(sum, args.length);
		
		int mean = sum/args.length;
		String args_string = Arrays.toString(args);
		args_string = args_string.substring(1, args_string.length()-1);
		String results;
		results = remainder !=0 ? 
		"Średnia arytmetyczna liczb "+ args_string + " wynosi " +mean + ", reszta: " + remainder:
		"Średnia arytmetyczna liczb "+ args_string + " wynosi " +mean;
		System.out.println(results);	
	}
}
