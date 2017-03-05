package com.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class FileTools2 {

		public   String createChecksum(File file) {
			
					// 文件的输入流
					InputStream fis = null;
					MessageDigest complete = null;
					try {
							fis = new FileInputStream(file);
							byte[] buffer = new byte[1024];
							complete = MessageDigest.getInstance("MD5");
							int numRead = -1;
							
							while ((numRead = fis.read(buffer)) != -1) {
									complete.update(buffer, 0, numRead);
							}
					} catch (FileNotFoundException e) {
							e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
							e.printStackTrace();
							
					} catch (IOException e) {
							e.printStackTrace();
					} finally {
							try {
									if (null != fis) {
											fis.close();
									}
							} catch (IOException e) {
									
							}
					}
					byte[] b = complete.digest();
					if (null == b) {
							
							return null;
					}
					StringBuilder result = new StringBuilder();
					
					for (int i = 0; i < b.length; i++) {
							result.append(Integer.toString((b[i] & 0xff) + 0x100, 16)
							        .substring(1));
					}
					return result.toString();		
			}
}
