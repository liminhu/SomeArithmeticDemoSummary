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
1) ���� HttpClient �Լ� GetMethod / PostMethod�� HttpRequest�ȶ���;
2) �������Ӳ���;
3) ִ�� HTTP ����;
4) ������������ؽ��;
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
	            //�������󣬵õ���Ӧ
	            HttpResponse response = client.execute(request);

	            //����ɹ�
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
	        //����Ҫ���ݵĲ���
	        // List<NameValuePair> params = new ArrayList<NameValuePair>();
	        //��Ӳ���
	        //params.add(new BasicNameValuePair("parameter","��Post��ʽ��������"));

	        try {
	            //�����ַ���
	            HttpEntity entity = new UrlEncodedFormEntity(nvps,"utf-8");
	            //�������
	            request.setEntity(entity);
	            //��������
	            HttpResponse response = client.execute(request);

	            //����ɹ�
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
	                //�ر���
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