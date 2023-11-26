package lab4;
import javax.swing.JOptionPane;
public class LineCounterPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] file_name = new String[1];
		file_name[0]= JOptionPane.showInputDialog("Podaj nazwe pliku");
	
		LineCounter.main(file_name);

	}

}