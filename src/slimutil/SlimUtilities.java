package slimutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SlimUtilities {

	private String defaultDateFormat = "MM/dd/yy";
	private String defaultDelimiter = ",";
	
	public void setDefaultDateFormat(String format) {
		defaultDateFormat = format;
	}
	
	public void setDefaultDelimiter(String delimiter) {
		defaultDelimiter = delimiter;
	}
	
	public String getToday(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
	}
	
	public String getToday() {
		return getToday(defaultDateFormat);
	}
	
	public int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	public String getFutureDate(int yearsToAdd, int monthsToAdd, int daysToAdd) {
		return getFutureDate(yearsToAdd, monthsToAdd, daysToAdd, defaultDateFormat);
	}
	
	public String getFutureDate(int yearsToAdd, int monthsToAdd, int daysToAdd, String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, yearsToAdd);
		calendar.add(Calendar.MONTH, monthsToAdd);
		calendar.add(Calendar.DATE, daysToAdd);
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(calendar.getTime());
	}
	
	public String formatDate(String date, String inputFormat, String outputFormat) {
		DateFormat format1 = new SimpleDateFormat(inputFormat);
		Date dateToFormat = new Date();
		try {
			dateToFormat = format1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat format2 = new SimpleDateFormat(outputFormat);
		return format2.format(dateToFormat);
	}
	
	public String formatDate(String date, String outputFormat) {
		return formatDate(date, defaultDateFormat, outputFormat);
	}
	
	public String chooseRandomItem(String items) {
		return chooseRandomItem(items, defaultDelimiter);
	}
	
	public String chooseRandomItem(String items, String delimiter) {
		String[] itemsArray = items.split(delimiter);
		Random generator = new Random();
		int random = generator.nextInt(itemsArray.length);
		return itemsArray[random].trim();
	}
	
	public Integer getRandomInteger(int lowerBound, int upperBound) {
		Random generator = new Random();
		int random = generator.nextInt(upperBound + 1);
		while (random < lowerBound) {
			random = generator.nextInt(upperBound + 1);
		}
		return random;
	}
	
	public String concatenate(String firstString, String secondString) {
		return firstString.concat(secondString);
	}
	
	public void storeSymbol(String symbolName, String symbolValue) {
		VariableStore.storeSymbol(symbolName, symbolValue);
	}
	
	public Object getSymbolValue(String symbolName) {
		return VariableStore.getSymbol(symbolName);
	}
}