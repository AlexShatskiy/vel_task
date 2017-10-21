package com.shatskiy.vel.dao.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.shatskiy.vel.dao.TenderDAO;
import com.shatskiy.vel.dao.format.CsvFormat;
import com.shatskiy.vel.domain.Tender;

@Repository("csvTenderDAO")
public class CsvTenderDAO implements TenderDAO {

	private static final Logger log = Logger.getLogger(CsvTenderDAO.class);
	private static final String PASS = System.getenv("CATALINA_HOME") + "\\" + "work/tender.csv";

	@Override
	public void addTender(Tender tender) {

		try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(PASS, true))) {
			bufferWriter.write(CsvFormat.toCsvFormat(tender));
		} catch (IOException e) {
			log.error("fail...", e);
		}
	}
}
