package Lab3;
import java.util.Locale;
public class FloatArithmeticMean {

	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Brak argumentów programu.");
			return;
		}
		float sum=0;
		for (String element : args) {
			float element_f;
			element_f=Float.valueOf(element);
			sum+=element_f;
			System.out.printf(Locale.US, "%10.3f%n", element_f);
		}
		
		System.out.println("----------");
		System.out.printf(Locale.US, "%10.3f%n",sum);
		
		System.out.println("");
		float average = sum/(args.length);
		System.out.printf(Locale.US, "Średnia arytmetyczna: %.4f", average);
	}
}
