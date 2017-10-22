package com.shatskiy.vel.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shatskiy.vel.dao.TenderDAO;
import com.shatskiy.vel.domain.Tender;
import com.shatskiy.vel.service.MicroService;
import com.shatskiy.vel.service.parser.MicroParser;

@Service
public class MicroServiceImpl implements MicroService{
	
	@Autowired
	@Qualifier("csvTenderDAO")
	private TenderDAO csvTenderDAO;
	
	@Autowired
	@Qualifier("sqlTenderDAO")
	private TenderDAO sqlTenderDAO;
	
	private static final Logger log = Logger.getLogger(MicroServiceImpl.class);
	
	private static final String HARD_CODE_ADDRESS = "http://www.icetrade.by/tenders/all/view/";

	@Override
	public void addInfo(int id) {
		
		String fullAddres = HARD_CODE_ADDRESS + id;
		Document doc = null;
		
		Tender tender = new Tender();
		String finish = null;
		String[] email = null;
		String[] phone = null;
		
		try {
			doc = Jsoup.connect(fullAddres).get();
		} catch (IOException e) {	
			log.error("fail...", e);
		}
		
		StringBuffer textEmailPhone = new StringBuffer();
		
		Elements emailPhoneToParseDataHtml = doc.select(".af-customer_data >.afv");
		Elements emailPhoneToParseContactsHtml = doc.select(".af-customer_contacts >.afv");
		Elements finishTenderHtml = doc.select(".af-request_end >.afv");
		
		for(Element x : emailPhoneToParseDataHtml){
			textEmailPhone.append(x.text());
		}
		
		for(Element x : emailPhoneToParseContactsHtml){
			textEmailPhone.append(x.text());
		}
		
		for(Element x : finishTenderHtml){
			finish = x.text();
		}
		
		email = MicroParser.findEmail(textEmailPhone.toString());
		phone = MicroParser.findPhone(textEmailPhone.toString());
		
		tender.setId(id);
		tender.setEmail(email);
		tender.setPhone(phone);
		tender.setFinish(finish);
		
		csvTenderDAO.addTender(tender);
		sqlTenderDAO.addTender(tender);	
	}
}
