package com.QQ.DbUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class QQClient {

	private Socket socket;
	private BufferedReader bufferedReader;
	private PrintWriter pWriter;
	
	/**
	 * �����ҿͻ��˵Ĺ��췽��
	 */
	
	
	public QQClient(String host,int port) throws UnknownHostException,IOException{
		socket = new Socket(host,port);
		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pWriter = new PrintWriter(socket.getOutputStream());
	}
	
	
	/**
	 * �����ҿͻ��˷�����Ϣ�ķ���
	 */
	
	
	public void sendMessage(String str) {
		pWriter.println(str);
		pWriter.flush();
		
	}
	
	
	
	/**
	 * �����ҿͻ��˻�ȡ��Ϣ�ķ���
	 */
	
	public String reciveMessage() {
		
		
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	/**
	 * �ر��׽���
	 */
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
