package com.shatskiy.vel.dao.format;

import com.shatskiy.vel.domain.Email;
import com.shatskiy.vel.domain.Phone;
import com.shatskiy.vel.domain.Tender;

public final class CsvFormat {

	private CsvFormat() {
		super();
	}

	public static String toCsvFormat(Tender tender) {
		StringBuilder builder = new StringBuilder();

		builder.append("id");
		builder.append(",");
		builder.append("email");
		builder.append(",");
		builder.append("phone");
		builder.append(",");
		builder.append("finishTender");
		builder.append("\n");

		if (tender.getId() != null) {
			builder.append(tender.getId());
		}
		builder.append(",");

		if (tender.getEmail() != null) {
			int i = 0;
			for (Email email : tender.getEmail()) {
				builder.append(email.getValue());
				if (i < tender.getEmail().size() - 1) {
					builder.append("||");
				}
				i++;
			}
		}
		builder.append(",");
		
		if (tender.getPhone() != null) {
			int i = 0;
			for (Phone phone : tender.getPhone()) {
				builder.append(phone.getValue());
				if (i < tender.getPhone().size() - 1) {
					builder.append("||");
				}
				i++;
			}
		}
		builder.append(",");
		
		if (tender.getFinish() != null) {
			builder.append(tender.getFinish());
		}
		builder.append("\n");
		
		return builder.toString();
	}
}
