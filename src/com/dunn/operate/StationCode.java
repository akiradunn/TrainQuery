package com.dunn.operate;
import java.io.BufferedReader;
import java.io.FileReader;
public class StationCode {//�����װ�˻�ȡ��վ���ŵķ���
      public static String getCode(String stationname)throws Exception{
   		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\file\\stationCode.txt"));
   		StringBuffer buf = new StringBuffer();
   		String str = "";
   		while(null!=(str=reader.readLine())){
   					buf.append(new String(str.getBytes(),"UTF-8"));
   		   }
   		str = "|"+stationname+"|";
   		//System.out.println(buf.toString());
   		int i = buf.toString().indexOf(str)+str.length();
   		int j = buf.toString().indexOf('|', i);
   		reader.close();
        return buf.toString().subSequence(i, j).toString();
       }
}
