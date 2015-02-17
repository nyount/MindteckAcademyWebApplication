package com.mindteck.businesslayer;

public class InputValidationService {
	
	private static final String HAS_DIGIT = "(.*\\d.*)";
	private static final String ONLY_DIGITS = "^\\d+$";
	
	public static boolean validateName(String name) {
		if (!name.matches(HAS_DIGIT) && name.length() > 1) {
			return true;
		}
		return false;
	}
	
	public static boolean validateDate(String date) {
		if (date.length() == 10) {
			if (date.charAt(4) == '-' && date.charAt(7) == '-') {
				if (date.substring(0, 4).matches(ONLY_DIGITS)) {
					String monthString = date.substring(5, 7);
					int monthInt = Integer.parseInt(monthString);
					if (monthString.matches(ONLY_DIGITS) && monthInt > 0 && monthInt < 13) {
						String dayString = date.substring(8, 10);
						if (dayString.matches(ONLY_DIGITS)) {
							int dayInt = Integer.parseInt(dayString);
							// February
							if (monthInt == 2 && dayInt > 0 && dayInt < 30) {
								return true;
							}
							// January, March, May, July, August, October, December
							else if (monthInt != 2 && ((monthInt%2 != 0 && monthInt < 8) || (monthInt%2 == 0 && monthInt > 7))) {
								if (dayInt > 0 && dayInt < 32) {
									return true;
								}
							}
							// April, June, September, November
							else if (monthInt != 2 && ((monthInt%2 == 0 && monthInt < 7) || (monthInt%2 != 0 && monthInt > 8))) {
								if (dayInt > 0 && dayInt < 31) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean validateDateDifference(String startDate, String endDate) {
		int startYear = Integer.parseInt(startDate.substring(0, 4));
		int endYear = Integer.parseInt(endDate.substring(0, 4));
		
		if (endYear >= startYear) {
			int startMonth = Integer.parseInt(startDate.substring(5, 7));
			int endMonth = Integer.parseInt(endDate.substring(5, 7));
			if (endMonth >= startMonth) {
				int startDay = Integer.parseInt(startDate.substring(8, 10));
				int endDay = Integer.parseInt(endDate.substring(8, 10));
				if (endDay > startDay) {
					return true;
				}
			}
		}
		
		return false;
	}

}
