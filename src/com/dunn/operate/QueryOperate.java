package com.dunn.operate;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dunn.model.Json;
public class QueryOperate {
	private static JSONObject o = null;
	public static void analyseLeftTickets(JSONObject o)throws Exception{
		//FileOutputStream writer = new FileOutputStream(System.getProperty("user.dir")+"\\result\\lefttickets.txt");
		FileOutputStream writer = new FileOutputStream("D:\\lefttickets.txt");
		JSONArray array = o.getJSONArray("data");	
		for(int i=0 ; i<array.length() ; i++){
			JSONObject v = array.getJSONObject(i);
			try {
				writer.write(("车次:"+v.getJSONObject("queryLeftNewDTO").getString("station_train_code")+" ").getBytes());
				writer.write(("出发站:"+v.getJSONObject("queryLeftNewDTO").getString("start_station_name")+" ").getBytes());
				writer.write(("终点站:"+v.getJSONObject("queryLeftNewDTO").getString("end_station_name")+" ").getBytes());
				writer.write(("出发时间:"+v.getJSONObject("queryLeftNewDTO").getString("start_time")+" ").getBytes());
				writer.write(("到达时间:"+v.getJSONObject("queryLeftNewDTO").getString("arrive_time")+" ").getBytes());
				writer.write(("历时:"+v.getJSONObject("queryLeftNewDTO").getString("lishi")+" ").getBytes());
				writer.write(("硬卧票:"+v.getJSONObject("queryLeftNewDTO").getString("yw_num")+" ").getBytes());
				writer.write(("硬座票:"+v.getJSONObject("queryLeftNewDTO").getString("yz_num")+" ").getBytes());
				writer.write(("无座票:"+v.getJSONObject("queryLeftNewDTO").getString("wz_num")).getBytes());
				writer.write("\n".getBytes());
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void analyseTicketPrice(JSONObject o){
		JSONObject v = o.getJSONObject("data");
		try {
			//FileOutputStream writer = new FileOutputStream(System.getProperty("user.dir")+"\\result\\price.txt");
			FileOutputStream writer = new FileOutputStream("D:\\price.txt");
			writer.write(("硬卧价:"+v.getString("A3")+" ").getBytes());
			writer.write(("硬座价:"+v.getString("A1")+" ").getBytes());
			writer.write(("无座价:"+v.getString("WZ")).getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//查询剩余余票情况
	public static void queryTickets(String start_station_name , String end_station_name , String date)throws Exception{
		String a = StationCode.getCode(start_station_name);
	    //System.out.println(a);
		String b = StationCode.getCode(end_station_name);
	   // System.out.println(b);
		String queryurl = "https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date="+date+"&leftTicketDTO.from_station="+a+"&leftTicketDTO.to_station="+b+"&purpose_codes=ADULT";
	    o = Json.getJsonResponse(queryurl);
		QueryOperate.analyseLeftTickets(o);
		System.out.println("success query! go to your project result dictory to see lefttickets.txt");
	}
	public static JSONObject getTicketsObject(String start_station_name , String end_station_name , String date)throws Exception{
		start_station_name = StationCode.getCode(start_station_name);
		end_station_name = StationCode.getCode(end_station_name);
		String queryurl = "https://kyfw.12306.cn/otn/leftTicket/queryTicketPrice?leftTicketDTO.train_date="+date+"&leftTicketDTO.from_station="+start_station_name+"&leftTicketDTO.to_station="+end_station_name+"&purpose_codes=ADULT";
	    o = Json.getJsonResponse(queryurl);
		return o;
	}
	public static void queryPrice(String date , String station_train_code , JSONObject ticketsJson)throws Exception{
		PriceCode p = new PriceCode(ticketsJson , station_train_code);
		String train_no = p.getTrain_no();
		String from_station_no = p.getFrom_station_no();
		String to_station_no = p.getTo_station_no();
		String seat_types = p.getSeat_types();
		String queryUrl = "https://kyfw.12306.cn/otn/leftTicket/queryTicketPrice?train_no="+train_no+"&from_station_no="+from_station_no+"&to_station_no="+to_station_no+"&seat_types="+seat_types+"&train_date="+date;
		//System.out.println(queryUrl);
		QueryOperate.analyseTicketPrice(Json.getJsonResponse(queryUrl));
		System.out.println("success query! go to your project result dictory to see price.txt");
	}
}
