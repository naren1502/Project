
package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility implements FrameworkConstants{

	public String readDataFromPropertyfile(String key) throws IOException {
		File file=new File(propertyFilePath);
		FileInputStream fis=new FileInputStream(file);
		Properties property=new Properties();
		property.load(fis);
		return property.getProperty(key);			
	}
}
