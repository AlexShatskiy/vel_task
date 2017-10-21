package com.shatskiy.vel.service.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MicroParser {
	
	private MicroParser() {
		super();
	}

	public static List<String> findEmail(String emailPhone) {

		List<String> list = new ArrayList<String>();

		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(emailPhone);
		
		while (m.find()) {
			list.add(m.group());
		}
		return list;
	}

	public static List<String> findPhone(String emailPhone) {

		List<String> list = new ArrayList<String>();

		Matcher mobile = Pattern.compile("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$").matcher(emailPhone);
		while (mobile.find()) {
			list.add(mobile.group());
		}
		Matcher noMobile = Pattern.compile("(8 0(25|29|33|34) ([0-9]{3}( [0-9]{2}){2}))").matcher(emailPhone);
		while (noMobile.find()) {
			list.add(noMobile.group());
		}
		
		Matcher freeStyle = Pattern.compile("\\d{3}\\s\\d{2}\\s\\d{2}|\\d{3}-\\d{2}-\\d{2}").matcher(emailPhone);
		while (freeStyle.find()) {
			list.add(freeStyle.group());
		}
		return list;
	}
}
