package lab2;
import java.util.Date;
public class Weekend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date data= new Date();
		int result= 5 - data.getDay();
		if (result >=0) {
			System.out.println("Dni do weekendu: " + result);
		}else {
			System.out.println("Jest weekend!");

		}
		
	}
}