import com.dunn.model.*;
import com.dunn.query.*;
import com.dunn.operate.*;
public class Main {
	public static void main(String[] args){//ָ����ѯ���������վ��Ŀ�ĵأ��˳����ڣ����κſ��Բ�ѯ��Ʊ���
		String start_station_name = "����";
		String end_station_name = "����";
		String date = "2017-01-21";
		try {
			//��ѯ��Ʊ
			Query.query(start_station_name, end_station_name, date);
			//��ѯ��Ʊ�е�ָ�����εļ�Ǯ,���κ�ͨ����Ʊ���ָ��
			String station_train_code = "T9";
			Query.query(start_station_name, end_station_name, date, station_train_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
