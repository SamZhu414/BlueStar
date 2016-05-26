/**
 * 
 */
package com.ibm.digital.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Sam
 *
 */
public class UploadUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
	public static String replaceFileName(String webPath, String html,List<String> oldFileNameList,List<String> newFileNameList){
		
		for(int i = 0; i < oldFileNameList.size();i ++){
			String oldFileName = oldFileNameList.get(i);
			String newFileName = newFileNameList.get(i);
			html = html.replace(oldFileName, newFileName);
		}
		return html;
	}
	
  public static String createhtml(String html, String path, String uuid){
	  String fileName = uuid +".html";
	  File file = new File(path  + "\\" + fileName);
	  FileWriter fw;
	  	try {
	  		fw = new FileWriter(file);
			fw.write(html);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
    }
  
  	public static String getUUID(){
  		return java.util.UUID.randomUUID().toString();
  	}
  	
  	public static boolean createDir(String destDirName) {  
        File dir = new File(destDirName);  
        if (dir.exists()) {  
            System.out.println("create folder" + destDirName + "faild, the target folder is exits");  
            return false;  
        }  
        
        if (!destDirName.endsWith(File.separator)) {  
            destDirName = destDirName + File.separator;  
        }  
        
        if (dir.mkdirs()) {  
            System.out.println("create folder" + destDirName + " is successfully");  
            return true;  
        } else {  
            System.out.println("create folder" + destDirName + " is fiailer");  
            return false;  
        }  
    }  
     
}
