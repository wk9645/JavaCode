package com.wk.download;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadText {
	
	URL url;
	HttpURLConnection connection;
	public static void main(String[] args) {
		DownloadText text = new DownloadText();
		text.download();
	}
	
	public void download(){
	        try {
	            url = new URL("http://www.baidu.com");
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setConnectTimeout(5000);
	            connection.setReadTimeout(400);
	            InputStream is = connection.getInputStream();
	            write(is);
	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            if(connection!=null)
	                connection.disconnect();
	        }
		}
	
	
	public void write(InputStream is) throws FileNotFoundException, UnsupportedEncodingException{
        BufferedReader br=null;
        BufferedWriter bw=null;;
        File file = new File("F:\\wk.baidu.txt");
		br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        String line=null;
        try {
            while((line=br.readLine())!=null){
            	bw.write(line);
            	bw.newLine();
            	bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
    	if(br!=null)
			try {
				br.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	if(bw!=null)
			try {
				bw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
	}
		
}
