package pe.com.sedapal.scr.core.beans;

import java.util.List;

public class Result {
	
	private Long records;
	@SuppressWarnings("rawtypes")
	private List data;
	
	public Long getRecords() {
		return records;
	}
	public void setRecords(Long records) {
		this.records = records;
	}
	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}
	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "Result [records=" + records + ", data=" + data + "]";
	}	

}
