<<<<<<< HEAD:src/main/java/genericUtility/FileUtility.java
package genericUtility;
=======
package genricUtility;
>>>>>>> 85f0ed4f6ef00a107e6b63605d43abd973908c60:src/main/java/genricUtility/FileUtility.java

public class FileUtility {

	public String readDataFromPropertyfile(String key) throws IOException {
		File file=new File("");
		FileInputStream fis=new FileInputStream(file);
		Properties property=new Properties();
		property.load(fis);
		return property.getProperty(key);			
	}
}
