package study.java.Helper;
import java.util.regex.Pattern;

public class RegexHelper {
	public static RegexHelper current = null;
	
	public static RegexHelper getInstance() {
		if (current == null) {
			current = new RegexHelper();
		}
		return current;
	}
	
	public static void freeInstance() {
		current = null;
	}
	
	private RegexHelper() {
		super();
	}
	
	public boolean isValue (String str) {
		boolean result = false;
		if (str != null) {
			result = !str.trim().equals("");
		}
		return result;
	}
	
	public boolean isJumin (String str) {
		boolean result = false;
		if (isValue(str)) {
			result = Pattern.matches("^\\d{6}[1-4]\\d{6}", str);
		}
		return result;
	}

}