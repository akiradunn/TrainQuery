package com.dunn.operate;
import org.json.JSONArray;
import org.json.JSONObject;
public class PriceCode {//将查询价格请求url所需要的参数封装至一个类中
	   private String train_no;
	   private String from_station_no;
       private String to_station_no;
       private String seat_types;
       private JSONObject o;
    public PriceCode(JSONObject o , String station_train_code){
       this.o = o;
       setTrainInfo(station_train_code);
    }
	public void setTrainInfo(String station_train_code) {
		JSONArray array = o.getJSONArray("data");
		for(int i=0 ; i<array.length() ; i++){
			JSONObject v = array.getJSONObject(i);
			if(station_train_code.equals(v.getJSONObject("queryLeftNewDTO").getString("station_train_code"))){
				train_no = v.getJSONObject("queryLeftNewDTO").getString("train_no");
				from_station_no = v.getJSONObject("queryLeftNewDTO").getString("from_station_no");
				to_station_no = v.getJSONObject("queryLeftNewDTO").getString("to_station_no");
				seat_types = v.getJSONObject("queryLeftNewDTO").getString("seat_types");
			}
		}
	}
    public String getTrain_no() {
		return train_no;
	}
	public String getFrom_station_no() {
		return from_station_no;
	}
	public String getTo_station_no() {
		return to_station_no;
	}
	public String getSeat_types() {
		return seat_types;
	}
}
