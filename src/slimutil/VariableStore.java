package slimutil;

import java.util.HashMap;
import java.util.Map;

public class VariableStore {
	private static Map<String, Object> variables = new HashMap<String, Object>();
	
	public static void storeSymbol(String symbolName, String symbolValue) {
		variables.put(symbolName, symbolValue);
	}
	
	public static Object getSymbol(String symbolName) {
		return variables.get(symbolName);
	}
}
