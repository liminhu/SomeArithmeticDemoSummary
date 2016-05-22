package com.my.test.useless;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.NameValuePair;

import sun.net.www.http.HttpClient;


/*
1) 创建 HttpClient 以及 GetMethod / PostMethod， HttpRequest等对象;
2) 设置连接参数;
3) 执行 HTTP 操作;
4) 处理服务器返回结果;
*/
/*
public class HttpUtil {
	  public static String get(String uri){
	        BufferedReader reader = null;
	        StringBuffer sb = null;
	        String result = "";
	        HttpClient client = new DefaultHttpClient();
	        HttpGet request = new HttpGet(uri);
	        try {
	            //发送请求，得到响应
	            HttpResponse response = client.execute(request);

	            //请求成功
	            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	                reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	                sb = new StringBuffer();
	                String line = "";
	                String NL = System.getProperty("line.separator");
	                while((line = reader.readLine()) != null){
	                    sb.append(line);
	                }
	            }
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally{
	            try {
	                if (null != reader){
	                    reader.close();
	                    reader = null;
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        if (null != sb){
	            result =  sb.toString();
	        }
	        return result;
	    }

	    public static String post(String uri,Map< String , String > params){
	        BufferedReader reader = null;
	        StringBuffer sb = null;
	        String result = "";
	        HttpClient client = new DefaultHttpClient();
	        HttpPost request = new HttpPost(uri);


	        List<NameValuePair> nvps = new ArrayList <NameValuePair>();

	        Set<String> keySet = params.keySet();
	        for(String key : keySet) {
	            nvps.add(new BasicNameValuePair(key, params.get(key)));
	        }
	        //保存要传递的参数
	        // List<NameValuePair> params = new ArrayList<NameValuePair>();
	        //添加参数
	        //params.add(new BasicNameValuePair("parameter","以Post方式发送请求"));

	        try {
	            //设置字符集
	            HttpEntity entity = new UrlEncodedFormEntity(nvps,"utf-8");
	            //请求对象
	            request.setEntity(entity);
	            //发送请求
	            HttpResponse response = client.execute(request);

	            //请求成功
	            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
	                System.out.println("post success");
	                reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	                sb = new StringBuffer();
	                String line = "";
	                String NL = System.getProperty("line.separator");
	                while((line = reader.readLine()) != null){
	                    sb.append(line);
	                }
	            }
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally{
	            try {
	                //关闭流
	                if (null != reader){
	                    reader.close();
	                    reader = null;
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        if (null != sb){
	            result =  sb.toString();
	        }
	        return result;
	    }

}
*/