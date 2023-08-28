package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataTestProperties {

	public static void main(String[] args) throws IOException {
		//step1:convert physical file into java readable object
				FileInputStream fis=new FileInputStream("./src/test/resources/data.propertites");
				
				//step2:create instance for properties class
				Properties property=new Properties();
				
				//step3:load all key-value pairs to add object from fis
				property.load(fis);
				
				//step4:write data into properties
				property.put("username2", "trainee");
				property.put("password2", "trainee");
				
				//step5:save properties
				FileOutputStream fos=new FileOutputStream("./src/test/resources/data.propertites");
				property.store(fos, "Updated File Successfully");

	}

}
