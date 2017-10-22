package com.shatskiy.vel.service.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shatskiy.vel.domain.Email;
import com.shatskiy.vel.domain.Phone;

public final class MicroParser {
	
	private MicroParser() {
		super();
	}

	public static Set<Email> findEmail(String emailPhone) {

		Set<Email> set = new HashSet<>();

		Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(emailPhone);
		
		while (m.find()) {
			Email email = new Email();
			email.setValue(m.group());
			set.add(email);
		}
		return set;
	}

	public static Set<Phone> findPhone(String emailPhone) {

		Set<Phone> set = new HashSet<>();

		Matcher mobile = Pattern.compile("^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$").matcher(emailPhone);
		while (mobile.find()) {
			Phone phone = new Phone();
			phone.setValue(mobile.group());
			set.add(phone);
		}
		Matcher noMobile = Pattern.compile("(8 0(25|29|33|34) ([0-9]{3}( [0-9]{2}){2}))").matcher(emailPhone);
		while (noMobile.find()) {
			Phone phone = new Phone();
			phone.setValue(noMobile.group());
			set.add(phone);
		}
		
		Matcher freeStyle = Pattern.compile("\\d{3}\\s\\d{2}\\s\\d{2}|\\d{3}-\\d{2}-\\d{2}").matcher(emailPhone);
		while (freeStyle.find()) {
			Phone phone = new Phone();
			phone.setValue(freeStyle.group());
			set.add(phone);
		}
		return set;
	}
}
