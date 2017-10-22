package com.shatskiy.vel.dao.format;

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
			for (int i = 0; i < tender.getEmail().length; i++) {
				builder.append(tender.getEmail()[i]);
				if (i < tender.getEmail().length - 1) {
					builder.append("||");
				}
			}
		}
		builder.append(",");
		
		if (tender.getPhone() != null) {
			for (int i = 0; i < tender.getPhone().length; i++) {
				builder.append(tender.getPhone()[i]);
				if (i < tender.getPhone().length - 1) {
					builder.append("||");
				}
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
