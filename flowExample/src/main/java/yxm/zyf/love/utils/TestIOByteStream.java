package yxm.zyf.love.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import yxm.zyf.love.entity.UserBindInfoDO;

public class TestIOByteStream {
	
	public static void main(String[] args) throws Exception{
		//InputTest();
		//OutputTest();
	    bufferedReadLine();
		//bufferedIo2();
		//bufferedReadLine();
		//readerAndPrintWriter();
	}
	/**
	 * 原生 读文件    字节流
	 * @throws Exception
	 */
	private static void InputTest() throws Exception{
		InputStream in = new FileInputStream("E:/test.txt");
		int v = -1;
		List<Byte> list = new ArrayList<Byte>();
		while ((v = in.read()) != -1) {
			list.add((byte) v);
		}
		in.close();
		Object[] array = list.toArray();
		int len = array.length;
		byte[] by = new byte[len];
		for (int i = 0; i < len; i++) {
			by[i] = (byte) ((Number) array[i]);
		}
		//System.out.println(new String(by));
	}
	/**
	 * 原生写文件  字节流
	 * @throws Exception
	 */
	private static void OutputTest() throws Exception{
		InputStream in = new FileInputStream("E:/logs/httpClientLog.2018-04-14");
		OutputStream out = new FileOutputStream("E:/logs/haha");
		List<Byte> list = new ArrayList<Byte>();
		int v = -1;
		while ((v = in.read()) != -1) {
			list.add((byte) v);
		}
		Object[] ar = list.toArray();
		int len = ar.length;
		byte[] by = new byte[len];
		for (int i = 0; i < len; i++) {
			by[i] = (byte) ((Number) ar[i]);
		}
		System.out.println(new String(by));
		out.write(by);
		in.close();
		out.close();
	}
	/**
	 * BufferedInputStream、BufferedOutputStream（缓存字节流）使用方式和字节流差不多，但是效率更高（推荐使用）
	 * @throws IOException 
	 */
	private static void bufferedIo() throws IOException{
		//对文件
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:/logs/bufferedIOTest.txt"));
		//写文件
		BufferedOutputStream  out = new BufferedOutputStream (new FileOutputStream("E:/logs/haha"));
		List<Byte> list = new ArrayList<Byte>();
		
	/*	 //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while ((n = in.read(bytes, 0, bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"GBK");
            System.out.println(str);
            //写入相关文件
            out.write(bytes, 0, n);
        }*/
		int n = -1;
		while((n = in.read()) != -1){
			list.add((byte) n);
		}
		int size = list.size();
		byte[] by = new byte[size];
		for(int i=0;i<size;i++){
			by[i] = list.get(i);
		}
		out.write(by);
		//清除缓存
		out.flush();
		in.close();
		out.close();
		System.out.println(new String(by));
	}
	/**
	 * InputStreamReader、OutputStreamWriter（字节流，这种方式不建议使用，不能直接字节长度读写）。使用范围用做字符转换
	 *  使用int[] 可以防止中文乱码
	 * @throws IOException 
	 */
	private static void bufferedIo2() throws IOException{
		//对文件
		InputStreamReader in = new InputStreamReader(new FileInputStream("E:/logs/bufferedIOTest.txt"));
		//写文件
		OutputStreamWriter  out = new OutputStreamWriter (new FileOutputStream("E:/logs/haha"));
		List<Integer> list = new ArrayList<Integer>();
		int n = -1;
		while((n = in.read()) != -1){
			list.add(n);
		}
		int size = list.size();
		int[] t = new int[size];
		for(int i = 0;i < size ; i++){
			t[i] = list.get(i);
		}
		//out.write(by);
		//清除缓存
		out.flush();
		in.close();
		out.close();
		System.out.println(new String(t,0,size));
	}
	/**
	 * BufferedReader、BufferedWriter(缓存流，提供readLine方法读取一行文本) 
	 * 使用这种方式 可以满足properties文件的读写
	 */
	private static void bufferedReadLine() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("E:/test.txt")));
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str = in.readLine()) != null){
		    String a= str;
            a=a.split("参数=")[1].trim();
            a=a.replace("UserBindInfoDTO", "UserBindInfoDO");
            UserBindInfoDO d=stringtobean(a);
            System.out.println(d);
		}
		in.close();
		//System.out.println(sb.toString());
	}
	
	public static UserBindInfoDO stringtobean(String str) {
	    String c=str.substring(str.indexOf("["), str.lastIndexOf("]")+1);
	    c=c.replace("[", "{\"");
	    c=c.replace("]", "\"}");
	    c=c.replace("=", "\":\"");
	    c=c.replace(",", "\",\"");
	    //JSONObject jsonObject=JSON.parseObject(c);
	    System.out.println(c);
	    UserBindInfoDO strbean=JSON.parseObject(c, UserBindInfoDO.class);

	    return strbean;
	    }
	
	/**
	 * Reader、PrintWriter（PrintWriter这个很好用，在写数据的同事可以格式化）
	 * //直接输出为中文不会乱码
	 * 合成字符串输出乱码
	 */
	private static void readerAndPrintWriter() throws Exception{
		 //读取文件(字节流)
        Reader in = new InputStreamReader(new FileInputStream("E:/logs/BufferedReader.txt"));
        //写入相应的文件
        PrintWriter out = new PrintWriter(new FileWriter("E:/logs/haha"));
        //读取数据
        //循环取出数据
        byte[] bytes = new byte[1024];
        int[] t = new int[1024];
        int len = -1;
        int i = 0;
        //直接输出为中文不会乱码
        while ((len = in.read()) != -1) {
            //System.out.println(len);
            t[i] = len;
            i++;
            //写入相关文件
            out.write(len);
        }
       /* List<Byte> list = new ArrayList<Byte>();
        int n = -1;
        while((n = in.read()) != -1){
        	list.add((byte) n);
        }
        int size = list.size();
        byte[] by = new byte[size];
        for(int i=0;i<size;i++){
        	by[i] = list.get(i);
        }
        String string = new String(by);
        System.out.println(string);
        out.write(string, 0, string.length());*/
       System.out.println(new String(t, 0, t.length));
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
	}
}