package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	   private Properties property;
		/**
		 * this method is used to read the data from properties
		 * @param key
		 * @return
		 */
		public String readFromProperties(String key)
		{
			
			return property.getProperty(key);
		}
		
		/**
		 * this method is used to initialize properties file
		 * @param filepath
		 */
		public void propertiesinitialization(String filepath)
		{
			FileInputStream fis=null;
			try {
				 fis=new FileInputStream(filepath);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			property=new Properties();
			try {
				property.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

