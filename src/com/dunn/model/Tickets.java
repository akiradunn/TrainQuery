package com.dunn.model;
public class Tickets {//存储价格余票参数对象，可用于OOP
    private String station_train_code = "";
   	private String start_station_name = "";
    private String end_station_name = "";
    private String start_time = "";
    private String arrive_time = "";
    private String lishi = "";
    private String yw_num = "";
    private String yz_num = "";
    private String wz_num = "";
    public String getStation_train_code() {
		return station_train_code;
	}
	public void setStation_train_code(String station_train_code) {
		this.station_train_code = station_train_code;
	}
	public String getStart_station_name() {
		return start_station_name;
	}
	public void setStart_station_name(String start_station_name) {
		this.start_station_name = start_station_name;
	}
	public String getEnd_station_name() {
		return end_station_name;
	}
	public void setEnd_station_name(String end_station_name) {
		this.end_station_name = end_station_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getArrive_time() {
		return arrive_time;
	}
	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}
	public String getLishi() {
		return lishi;
	}
	public void setLishi(String lishi) {
		this.lishi = lishi;
	}
	public String getYw_num() {
		return yw_num;
	}
	public void setYw_num(String yw_num) {
		this.yw_num = yw_num;
	}
	public String getYz_num() {
		return yz_num;
	}
	public void setYz_num(String yz_num) {
		this.yz_num = yz_num;
	}
	public String getWz_num() {
		return wz_num;
	}
	public void setWz_num(String wz_num) {
		this.wz_num = wz_num;
	}
}
