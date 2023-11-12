package lab2;
import java.util.Date;
public class Weekend1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date data = new Date();
		int day = data.getDay();
		switch(day) {
		case 1:
			System.out.println("Dziś jest poniedziałek");
		break;
		case 2:
			System.out.println("Dziś jest wtorek");
		break;
		case 3:
			System.out.println("Dziś jest środa");
		break;
		case 4:
			System.out.println("Dziś jest czwartek");
		break;
		case 5:
			System.out.println("Dziś jest piątek");
		break;
		case 6, 7:
			System.out.println("Jest weekend");
		break;
		}
	}
}
