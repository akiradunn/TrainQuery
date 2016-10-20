package com.dunn.query;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import com.dunn.operate.QueryOperate;
import com.dunn.operate.StationCode;
public class Query {
	//查询余票
	public static void queryLeftTickets(String start_station_name , String end_station_name , String date)throws Exception{
		QueryOperate.queryTickets(start_station_name, end_station_name, date);
	}
	//查询票价，需要在查询余票之后指定车次进行查询
	public static void queryPrice(String start_station_name , String end_station_name , String date , String station_train_code)throws Exception{
		JSONObject o = null;
		o = QueryOperate.getTicketsObject(start_station_name, end_station_name, date);
		QueryOperate.queryPrice(date, station_train_code, o);
	}
	public static void query(String start_station_name , String end_station_name , String date , String station_train_code)throws Exception{
			queryPrice(start_station_name , end_station_name , date , station_train_code);
	}
	public static void query(String start_station_name , String end_station_name , String date)throws Exception{
		queryLeftTickets(start_station_name , end_station_name , date);
}
}
