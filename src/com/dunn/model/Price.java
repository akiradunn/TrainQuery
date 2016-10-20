package com.dunn.model;
import org.json.JSONObject;
public class Price {//存储价格参数对象,可用于OOP
	private String train_no = "";
	private String from_station_no = "";
    private String to_station_no = "";
    private String seat_types = "";
    private String station_train_code = "";
	public String getTrain_no() {
		return train_no;
	}
	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}
	public String getFrom_station_no() {
		return from_station_no;
	}
	public void setFrom_station_no(String from_station_no) {
		this.from_station_no = from_station_no;
	}
	public String getTo_station_no() {
		return to_station_no;
	}
	public void setTo_station_no(String to_station_no) {
		this.to_station_no = to_station_no;
	}
	public String getSeat_types() {
		return seat_types;
	}
	public void setSeat_types(String seat_types) {
		this.seat_types = seat_types;
	}
	public String getStation_train_code() {
		return station_train_code;
	}
	public void setStation_train_code(String station_train_code) {
		this.station_train_code = station_train_code;
	}

}
