package com.safira.service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;




import org.json.JSONException;
import org.json.JSONObject;

@Path("/currencycalservice")
public class CurrencyCalenderService {


	public CurrencyCalenderService() {
		
	}

	/*
	 * it should implement the CRUD of CurrencyCalender todo: to be completed:
	 */
	@Path("/get")
	@GET
	@Produces("application/json")
	public List<CurrencyCalendarDTO> getAll() throws JSONException {
		
		List<CurrencyCalendarDTO> l = new ArrayList<CurrencyCalendarDTO>();
		CurrencyCalendarDTO c1 = new CurrencyCalendarDTO();
		c1.setId(1);c1.setName("name1");
		CurrencyCalendarDTO c2 = new CurrencyCalendarDTO();
		c2.setId(2);c2.setName("name2");
		CurrencyCalendarDTO c3 = new CurrencyCalendarDTO();
		c3.setId(3);c3.setName("name3");
		l.add(c1);l.add(c2);l.add(c3);
		System.out.println(l.size());
		return l;
	}
}
