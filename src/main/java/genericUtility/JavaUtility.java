package genericUtility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;


public class JavaUtility {
	Random random = new Random();
	String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	/**
	 * @author Narenthiran
	 * @param range
	 * @return Returns random number with given range
	 */
	public int generateRandomNumber(int range) {
		int num = random.nextInt(range);
		return num;

	}

	/**
	 * @author Narenthiran
	 * @param startRange
	 * @param endRange
	 * @return Returns random number between the start range and end range
	 */
	public int generateRandomNumber(int startRange, int endRange) {
		int value = random.nextInt(endRange - startRange + 1) + startRange;
		return value;
	}

	/**
	 * @author Narenthiran
	 * @param length
	 * @return Returns random string data includes number within the given range
	 */
	public String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		int size = randomString.length();
		for (int i = 0; i < length; i++) {
			int randomIndex = generateRandomNumber(size);
			char c = randomString.charAt(randomIndex);
			sb.append(c);
		}
		return sb + "";
	}

	/**
	 * @author Narenthiran
	 * @param startRange
	 * @param endRange
	 * @return Returns the random string data between start range and end range
	 */
	public String generateRandomString(int startRange, int endRange) {
		StringBuilder sb = new StringBuilder();
		int size = randomString.length();
		int length = random.nextInt(endRange - startRange + 1) + startRange;
		for (int i = 0; i < length; i++) {
			int randomIndex = generateRandomNumber(size);
			char c = randomString.charAt(randomIndex);
			sb.append(c);
		}
		return sb + "";
	}

	/**
	 * @author Narenthiran
	 * @param length
	 * @return returns random string excludes special char and numbers within the
	 *         given range
	 */

	public String generateRandomAlphabets(int length) {
		StringBuilder sb = new StringBuilder();
		int size = randomString.replaceAll("[0-9]", "").length();
		for (int i = 0; i < length; i++) {
			int randomIndex = generateRandomNumber(size);
			char c = randomString.charAt(randomIndex);
			sb.append(c);
		}
		return sb + "";
	}
	/**
	 * @author Narenthiran
	 * @param map
	 * @param key
	 * @return Returns value with respect to key provided
	 */
	public Object getValueFromMap(Map map,String key) {
		return map.get(key);
	}
	/**
	 * @author Narenthiran
	 * @param format (Day -dd ,Month -MM,Year -yyyy)
	 * @return Returns local system date with give format
	 */
	public static String getLocalDate(String format) {
		LocalDate date=LocalDate.now();
		return date.format(DateTimeFormatter.ofPattern(format));
	}
	

}
