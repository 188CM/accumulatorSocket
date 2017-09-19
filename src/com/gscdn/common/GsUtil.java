package com.gscdn.common;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import javax.activation.MimetypesFileTypeMap;


public class GsUtil {
	public static byte[] getResOKHader() throws UnsupportedEncodingException {
		StringBuilder r = new StringBuilder();
		r.append("HTTP/1.1 200 OK\r\n");
		r.append("Content-Type: text/html\r\n\r\n");
		return r.toString().getBytes("UTF-8");
	}

	public static byte[] getResErrHader() throws UnsupportedEncodingException {
		StringBuilder r = new StringBuilder();
		r.append("HTTP/1.0 400 Bad Request Message \\r\\n");
		r.append("Connection: close\\r\\n");
		r.append("\r\n");
		return r.toString().getBytes("UTF-8");
	}

	public static String getMineType(File file) {
		return new MimetypesFileTypeMap().getContentType(file);
	}

	public static String getReqFileName(String requestMessageLine) throws IOException {
		String fileName = null;
		StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

		if (tokenizedLine.nextToken().equals("GET")) {
			fileName = tokenizedLine.nextToken();

			if (fileName.startsWith("/") == true) {
				if (fileName.length() > 1) {
					fileName = fileName.substring(1);
				}
				// ���ϸ��� ���� �Է����� �ʾ��� ��� �⺻ ������ ����Ѵ�.
				else {
					fileName = "index.html";
				}
			}
		}
		return fileName;
	}
	
	public static void close(Closeable closeable) {
        if(closeable != null) try {
            closeable.close();
        } catch (IOException e) {
        } finally { /* we tried! */ }
    }
	
	
}
