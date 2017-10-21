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
			for (int i = 0; i < tender.getEmail().size(); i++) {
				builder.append(tender.getEmail().get(i));
				if (i < tender.getEmail().size() - 1) {
					builder.append("||");
				}
			}
		}
		builder.append(",");
		
		if (tender.getPhone() != null) {
			for (int i = 0; i < tender.getPhone().size(); i++) {
				builder.append(tender.getPhone().get(i));
				if (i < tender.getPhone().size() - 1) {
					builder.append("||");
				}
			}
		}
		builder.append(",");
		
		if (tender.getFinishTender() != null) {
			builder.append(tender.getFinishTender());
		}
		builder.append("\n");
		
		return builder.toString();
	}
}
