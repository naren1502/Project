package genericUtility;

public class FileUtility {

	public String readDataFromPropertyfile(String key) throws IOException {
		File file=new File("");
		FileInputStream fis=new FileInputStream(file);
		Properties property=new Properties();
		property.load(fis);
		return property.getProperty(key);			
	}
}
