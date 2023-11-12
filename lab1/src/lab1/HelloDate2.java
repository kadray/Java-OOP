package lab1;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
public class HelloDate2 {

	public static void main(String[] args) {
		Date data= new Date();
		
		SimpleDateFormat dataForm= new SimpleDateFormat("yyyy.mm.dd hh:mm:ss");
		String result = dataForm.format(data);
		System.out.println("Witaj, teraz jest: " + result);
	}

}
