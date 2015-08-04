package service;

import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/currencycalservice")
public class CurrencyCalenderService {
	List<CurrencyCalendarDTO> l;
	int rowidcounter = 1;

	public CurrencyCalenderService() {
		l = new ArrayList<CurrencyCalendarDTO>();
	}

	/*
	 * it should implement the CRUD of CurrencyCalender todo: to be completed:
	 */
	@Path("/get")
	@GET
	@Produces("application/json")
	public List<CurrencyCalendarDTO> getAll() throws JSONException {

		CurrencyCalendarDTO c1 = new CurrencyCalendarDTO();
		Integer id1 = 222, id2 = 223, id3 = 224;
		c1.setId(id1);
		c1.setName("name1");
		c1.setDT_RowId(CurrencyCalendarDTO.formatter(id1));
		CurrencyCalendarDTO c2 = new CurrencyCalendarDTO();
		c2.setId(223);
		c2.setName("name2");
		c2.setDT_RowId(CurrencyCalendarDTO.formatter(id2));
		CurrencyCalendarDTO c3 = new CurrencyCalendarDTO();
		c3.setId(224);
		c3.setName("name3");
		c3.setDT_RowId(CurrencyCalendarDTO.formatter(id3));
		l.add(c1);
		l.add(c2);
		l.add(c3);
		System.out.println("getAll:"+l.size());
		return l;
	}

	/*
	 * receive a Json object build the java (BEC) then save it
	 */
	@Path("/create")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String create(@FormParam("name") String nameparam)
			throws JSONException {
		// String nameParam = request.getParameter("name");
		CurrencyCalendarDTO c1 = new CurrencyCalendarDTO();
		System.out.println("create req param=" + nameparam);
		Integer id1 = 225;
		c1.setId(id1);
		c1.setName(nameparam);
		c1.setDT_RowId(CurrencyCalendarDTO.formatter(id1));
		l.add(c1);
		return String.valueOf(rowidcounter);
	}
/*
	 * receive a Json object build the java (BEC) then save it
	 */
	@Path("/update")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@FormParam("name") String nameparam)
			throws JSONException {
		//it should take the id(row_id) and the name
		System.out.println("update req param=" + nameparam);
		
		return String.valueOf(rowidcounter);
	}
	@Path("/del")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@Context HttpServletRequest request)
			throws JSONException {
		// it receives the row id to be deleted
		String DT_RowId = request.getParameter("id");
		System.out.println("del to be deleted DT_RowId=" + DT_RowId);
		return String.valueOf(DT_RowId);
	}

	@Path("/createsimple/{param}")
	@GET
	@Produces("application/json")
	public Integer getreq(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@PathParam("param") String param) throws JSONException {
		System.out.println("getreq=param" + param + "/req param="
				+ request.getParameter("reqparam"));
		Integer res = 1;
		return res;
	}

}
