package utilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ReadConfigPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.property");
		
		Properties pr = new Properties();
		pr.load(fr);
	}

}
