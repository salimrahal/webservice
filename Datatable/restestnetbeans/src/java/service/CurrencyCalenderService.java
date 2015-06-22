package com.safira.service;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;




import org.json.JSONException;
import org.json.JSONObject;

@Path("/currencycalservice")
public class CurrencyCalenderService {

List<CurrencyCalendarDTO> l;
	public CurrencyCalenderService() {
		l = new ArrayList<CurrencyCalendarDTO>();
                CurrencyCalendarDTO c1 = new CurrencyCalendarDTO();
		c1.setId(1);c1.setName("name1");
		CurrencyCalendarDTO c2 = new CurrencyCalendarDTO();
		c2.setId(2);c2.setName("name2");
		CurrencyCalendarDTO c3 = new CurrencyCalendarDTO();
		c3.setId(3);c3.setName("name3");
		l.add(c1);l.add(c2);l.add(c3);
	}

	/*
	 * it should implement the CRUD of CurrencyCalender todo: to be completed:
	 */
	@Path("/get")
	@GET
	@Produces("application/json")
	public List<CurrencyCalendarDTO> getAll() throws JSONException {
		System.out.println(l.size());
		return l;
	}
        
        @Path("/getrequest/{param}")
	@GET
	@Produces("application/json")
	public List<CurrencyCalendarDTO> getreq(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@PathParam("param") String param) throws JSONException {
		System.out.println("getreq=param"+param+"/req param="+request.getParameter("reqparam"));
		return l;
	}
        /*
        @Path("/del/{id}")
	@GET
	@Produces("application/json")
        
	public List<CurrencyCalendarDTO> del() throws JSONException {
		System.out.println(l.size());
		return l;
	}*/
}
