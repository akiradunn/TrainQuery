import com.dunn.model.*;
import com.dunn.query.*;
import com.dunn.operate.*;
public class Main {
	public static void main(String[] args){//指定查询，输入出发站，目的地，乘车日期，车次号可以查询余票情况
		String start_station_name = "北京";
		String end_station_name = "重庆";
		String date = "2016-10-21";
		try {
			//查询余票
			Query.query(start_station_name, end_station_name, date);
			//查询余票中的指定车次的价钱,车次号通过余票结果指定
			String station_train_code = "T9";
			Query.query(start_station_name, end_station_name, date, station_train_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
