package com.shatskiy.vel.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.shatskiy.vel.domain.Tender;
import com.shatskiy.vel.service.MicroService;
import com.shatskiy.vel.service.parser.MicroParser;

@Service
public class MicroServiceImpl implements MicroService{
	
	private static final Logger log = Logger.getLogger(MicroServiceImpl.class);
	
	private static final String HARD_CODE_ADDRESS = "http://www.icetrade.by/tenders/all/view/";

	@Override
	public void addInfo(int number) {
		
		String fullAddres = HARD_CODE_ADDRESS + number;
		
		Tender tender = new Tender();
		Document doc = null;
		
		try {
			doc = Jsoup.connect(fullAddres).get();
		} catch (IOException e) {	
			log.error("fail...", e);
		}
		
		StringBuffer textEmailPhone = new StringBuffer();
		
		Elements emailPhoneToParseData = doc.select(".af-customer_data >.afv");
		Elements emailPhoneToParseContacts = doc.select(".af-customer_contacts >.afv");
		Elements finishTender = doc.select(".af-request_end >.afv");
		
		for(Element x : emailPhoneToParseData){
			textEmailPhone.append(x.text());
		}
		
		for(Element x : emailPhoneToParseContacts){
			textEmailPhone.append(x.text());
		}
		
		for(Element x : finishTender){
			tender.setFinishTender(x.text());
		}
		
		List<String> email = MicroParser.findEmail(textEmailPhone.toString());
		List<String> phone = MicroParser.findPhone(textEmailPhone.toString());
		
		tender.setEmail(email);
		tender.setPhone(phone);
		
		

		
		
		
		

		
	}
}
