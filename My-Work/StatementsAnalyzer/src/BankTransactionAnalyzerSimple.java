import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankTransactionAnalyzerSimple {
	
	private static final String RESOURCES = "C:/Users/saili/javaProject_real/Real-World-Software-Development/src/main/resources/";
	
	
	//private static final String RESOURCES = "C:\\Users\\saili\\javaProject_real\\Real-World-Software-Development\\src\\main\\resources\\";   
	//it works but '/' is preferred because java automatically change '/' to the right separator for each OS.
		
	
	
	public static void main(final String... args) throws IOException{
		
		final Path path = Paths.get(RESOURCES + args[0]);
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;
		for(final String line : lines) {
			final String[] columns = line.split(",");
			final double amount = Double.parseDouble(columns[1]);
			total += amount;
		}
		
		System.out.println("The total for all transactions is " + total);
		
		final Path path2 = Paths.get(RESOURCES + args[0]);
		final List<String> lines2 = Files.readAllLines(path2);
		double total2 = 0d;
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for(final String line : lines2) {
			final String[] columns = line.split(",");
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			if(date.getMonth() == Month.JANUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total2 += amount;
			}
		}
		
		System.out.println("The total for all transactions in January is " + total2);
	}

}
