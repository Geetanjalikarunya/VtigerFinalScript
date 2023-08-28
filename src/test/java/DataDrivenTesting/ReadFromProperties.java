package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args) throws IOException {
		//step1:convert physical file into java readable object

		FileInputStream fis=new FileInputStream("./src/test/resources/data.propertites");
		
		//step2:create instance for properties class
		Properties property=new Properties();
		
		//step3:load all key-value pairs to add object from fis
		property.load(fis);
		
		//step4:fetch data from properties using key
		System.out.println(property.getProperty("url"));
		System.out.println(property.getProperty("browser"));
		System.out.println(property.getProperty("time"));

	}

}
