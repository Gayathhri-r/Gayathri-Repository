package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
			
			Properties property;
		
	public ReadConfigFile(){  //constructor to read config file from the path
		
			File FilePath = new File("./src/test/resources/Configuration/configFile.properties");
			
			//open the file in read mode 
			FileInputStream fis;
			try {
				fis = new FileInputStream(FilePath);
				property = new Properties();
				property.load(fis);
			} catch (Exception e) {
				System.out.println("Exception is"+e.getMessage());
			}	
			
	}
	//add method to read variable and the values
	public String GetApplicationURL() {
		
			String URL=property.getProperty("url");
			return URL;
			}

	
}	

	

