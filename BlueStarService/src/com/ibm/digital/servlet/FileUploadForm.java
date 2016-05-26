package com.ibm.digital.servlet;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ibm.digital.util.UploadUtil;

@Path("/file")  
public class FileUploadForm {
	/**
	 * {
	"operationType":"0",
	"productName":"myproduct",
	"productTitle":"mytitle",
	"productContent":"myContent",
	"productUrl":"myUrl",
	"userId":"myid",
	"productId":"myproductId",
	"filelist":["c:\\test.jpg","c:\\test.jpg"]
}
	 * */
	  @Context  
	    HttpServletRequest request;  
	    @Context  
	    HttpServletResponse response;  
	  
	    @POST  
	    @Path("/upload")  
	    @Consumes("multipart/form-data")  
	    public Response upLoad() throws Exception {  
	    	
	    	String path = request.getContextPath(); 
		    String webPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	    	
	        String uploadFilePath = request.getSession().getServletContext().getRealPath("/")+"\\upload" ;  
	        
	        DiskFileItemFactory factory = new DiskFileItemFactory();  
	        factory.setRepository(Paths.get(uploadFilePath).toFile());  
	        factory.setSizeThreshold(1024 * 1024);  
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        upload.setHeaderEncoding("utf-8");  
	        String fileName = null;  
	        List<FileItem> list = upload.parseRequest(request);  
	        List<String> newFileNameList = new ArrayList<String>();
	        
	        // create new folder to save images.
	        String folderUUID = UploadUtil.getUUID();
            String newFolder = uploadFilePath + "\\" + folderUUID;
            System.out.println();
            UploadUtil.createDir(newFolder);
            
	        for (FileItem item : list) {  
	        	System.out.println("item:" + item);
	            if (item.isFormField()) {  
	                String name = item.getFieldName();  
	                String value = item.getString("utf-8");  
	                request.setAttribute(name, value);  
	            } else {  
	                String name = item.getFieldName();  
	                String value = item.getName();  
	                String fileNameUUID = UploadUtil.getUUID();
	                fileName = Paths.get(value).getFileName().toString(); 
	                
	                String fileExtendName = fileName.substring(fileName.length()-4,fileName.length());
	                fileName = fileNameUUID + fileExtendName;
	                
	                // add new file name to list
	                newFileNameList.add(webPath + "upload/" + folderUUID +"/"+ fileName);
	                
	                request.setAttribute(name, fileName);  
	                if(!Paths.get(uploadFilePath).toFile().exists()){  
	                    Paths.get(uploadFilePath).toFile().mkdirs();  
	                }  
	                
	                item.write(new File(newFolder +"/", fileName));  
	            }  
	        }  
	       
	        String html = "<!DOCTYPE html><html><head><title>Insert title here</title></head><body><img src='sss.jpg'><img src='bbb.jpg'><img src='ddd.jpg'></body></html>";
			List<String> oldFileNameList = new ArrayList<String>();
			oldFileNameList.add("sss.jpg");
			oldFileNameList.add("bbb.jpg");
			oldFileNameList.add("ddd.jpg");
	        String newHtml = UploadUtil.replaceFileName(webPath, html, oldFileNameList, newFileNameList);
	       
	        String filePath = UploadUtil.createhtml(newHtml, uploadFilePath, folderUUID);
	        return Response.status(200).entity("uploadFile is called, Uploaded file name : <a href='" + webPath + "upload/"+ filePath +"' target='_blank'>new html file</a> ").build();  
	    }  
}
