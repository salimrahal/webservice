package service;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "CurrencyCalendar")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyCalendarDTO {
	// this id is just for view, the plugin use DT_RowId
	int id;
	String name;
	String DT_RowId;
	Date dateCC;

	public Date getDateCC() {
		return dateCC;
	}
	
	public String getDT_RowId() {
		return DT_RowId;
	}



	public void setDT_RowId(String dT_RowId) {
		DT_RowId = dT_RowId;
	}

	// Technically a DOM id cannot start with an integer, so we prefix
	// a string. This can also be useful if you have multiple tables
	// to ensure that the id is unique with a different prefix
	public static String formatter(Integer id) {
		String rowId = "row_" + id;
		return rowId;
	}



	public void setDateCC(Date dateCC) {
		this.dateCC = dateCC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CurrencyCalendarDTO [id=" + id + ", name=" + name + ", dateCC="
				+ dateCC + "]";
	}
}