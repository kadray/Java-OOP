package lab2;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Weekend2 {
	public static void main(String[] args) {
		String tab[]={"poniedzialek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela"};
		LocalDate data= LocalDate.now();
		DayOfWeek day=data.getDayOfWeek();
		int day_n=day.getValue();
		if (day_n<=5) {
			System.out.println("Dzisiaj jest " +tab[day_n-1]);
			if(day_n!=4) {
				System.out.println("Do weekendu zostało "+(5-day_n)+ " dni");
			}else {
				System.out.println("Do weekendu został "+(5-day_n)+ " dzień");
			}
		}else {
			System.out.println("Mamy Weekend!");
		}
	}
}
