package com.dunn.model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
public class Json {//返回访问指定url返回的json数据
	public static JSONObject getJsonResponse(String url)throws Exception{ 
    	HttpClient client = HttpClients.createDefault();
    	JSONObject o = null;
		 BufferedReader bufferedReader = null;
		 StringBuilder entityStringBuilder=new StringBuilder();  
		 HttpGet Get = new HttpGet(url);
		 HttpResponse response = client.execute(Get);
         int returnCode = response.getStatusLine().getStatusCode();
         if (returnCode == 200) {//200表示成功访问 
        	 //得到Response报文的Content部分 
             HttpEntity httpEntity=response.getEntity();  
             //System.out.println(httpEntity.toString()); 
             if (httpEntity!=null) {  
                 try {  
                     bufferedReader=new BufferedReader(new InputStreamReader(httpEntity.getContent(), "UTF-8"), 8*1024);  
                     String line=null;  
                     while ((line=bufferedReader.readLine())!=null) {  
                         entityStringBuilder.append(line);  
                     }
                     //利用从HttpEntity中得到的String生成JsonObject  
                    // System.out.println(entityStringBuilder.toString());
 	               o=new JSONObject(entityStringBuilder.toString()); 
 	               //System.out.println(o);
                 } catch (Exception e) {  
                     e.printStackTrace();  
                 }   
       } else {  
           System.out.println("error code: " + returnCode);  
               } 
         }
         return o;
}
}
