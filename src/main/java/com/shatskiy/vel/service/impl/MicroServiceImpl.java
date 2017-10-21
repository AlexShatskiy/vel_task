package com.shatskiy.vel.service.impl;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.shatskiy.vel.service.MicroService;

@Service
public class MicroServiceImpl implements MicroService{
	
	private static final String HARD_CODE_ADDRESS = "http://www.icetrade.by/tenders/all/view/";

	@Override
	public void addInfo(int number) {
		
		String fullAddres = HARD_CODE_ADDRESS + number;
		
		Document doc = null;
		try {
			doc = Jsoup.connect(fullAddres).get();
			
			
		} catch (IOException e) {	
			
			
			e.printStackTrace();
		}

		Elements div = doc.select(".af-place_for_submission >.afv");

		

		for(Element x : div){
			System.out.println(x.text());
		}
		
	}
}
