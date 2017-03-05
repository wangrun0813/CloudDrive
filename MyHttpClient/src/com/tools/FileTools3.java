package com.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



public class FileTools3 {

	
	public static void download(String path,String fileid,String filename,CloseableHttpClient httpclient){
		OutputStream out = null;
		InputStream in = null;

		try {
			HttpGet httpGet = new HttpGet("http://localhost:8080/MyHttpClientweb3/user/download");
			
			httpGet.addHeader("fileid", fileid);
			
			HttpResponse httpResponse = httpclient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			in = entity.getContent();
			

			long length = entity.getContentLength();
			if (length <= 0) {
				System.out.println("下载文件不存在！");
				return;
			}
             System.out.println("tools3Path"+path);
			File file = new File(path+"\\"+filename);
			if (!file.exists()) {
				file.createNewFile();
			}

			out = new FileOutputStream(file);
			byte[] buffer = new byte[4096];
			int readLength = 0;
			while ((readLength = in.read(buffer)) > 0) {
				byte[] bytes = new byte[readLength];
				System.arraycopy(buffer, 0, bytes, 0, readLength);
				out.write(bytes);
			}

			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void cache(String filename,CloseableHttpClient httpclient){
		OutputStream out = null;
		InputStream in = null;

		try {
			HttpGet httpGet = new HttpGet("http://localhost:8080/MyHttpClientweb3/user/cache");
			
			httpGet.addHeader("filename", filename);
			
			HttpResponse httpResponse = httpclient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			in = entity.getContent();
			

			long length = entity.getContentLength();
			if (length <= 0) {
				System.out.println("下载文件不存在！");
				return;
			}
            
			File file = new File("F:\\"+filename);
			if (!file.exists()) {
				file.createNewFile();
			}

			out = new FileOutputStream(file);
			byte[] buffer = new byte[4096];
			int readLength = 0;
			while ((readLength = in.read(buffer)) > 0) {
				byte[] bytes = new byte[readLength];
				System.arraycopy(buffer, 0, bytes, 0, readLength);
				out.write(bytes);
			}

			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
