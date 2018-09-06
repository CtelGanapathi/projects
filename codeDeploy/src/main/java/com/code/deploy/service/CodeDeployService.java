package com.code.deploy.service;

import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.deploy.dao.CodeDeployDAO;
import com.code.deploy.entity.CodeDeploy;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
@Service("CodeDeployService")
@Transactional
public class CodeDeployService {
	
	@Autowired
	CodeDeployDAO codeDeployDAO;
	
	List<CodeDeploy> instance;
	
	
	int threadCount=0;
	int i;
    boolean s=true; 
    String command="(cd /var/www/html/demo; mkdir Ganapathifolder)";
    JSONObject   finalResult=new  JSONObject();

	ChannelSftp.LsEntry lsEntry = null;
    static SftpATTRS attrs = null;
	static String[] hostname = {"10.10.10.27","10.10.10.24","10.10.12.216"};
	static String[] username ={ "hiranya","qcuser","ctel"};
	static String[] password = {"ctel@123","cteladmin","cteladmin"};
	static String[]  copyTo={"/var/www/html/demo","/var/www/html/demo","/var/www/html/demo"};
	
	
	//static String[]  files={"C:\\Users\\Ganapathi-PC\\Desktop\\distillery-prodv14.0.tar.gz"};
	String result;
	
	public String getCodeDeployStatus(String data) throws InterruptedException{
		
		System.out.println(data);
		instance=codeDeployDAO.findByLocationId(data);
		
		for(CodeDeploy code:instance){
			System.out.println(code.getQA_IP_ADDRESS()+"   *********************");
			System.out.println(code.getQA_ROOT_USERNAME()+"   *********************");
			System.out.println(code.getQA_ROOT_PASSWORD()+"   *********************");
		}
		
		
		
		
		
		
		
		
		
		
		/*String[]  files={data};
		Thread[] threads = new Thread[hostname.length];
		 for ( i = 0; i < threads.length; i++) {
			final int  count=i;
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      	    System.out.println(timestamp+">>>>>>>>>>>>>>>>");
		     threads[i] = new Thread(new Runnable() {
		         public void run() {
		        	 Timestamp timestamp123 = new Timestamp(System.currentTimeMillis());
	 				 System.out.println(timestamp123+"start");
		 				JSch jsch = new JSch();
		 				com.jcraft.jsch.Session session = null;
		 				System.out.println("Trying to connect.....");
		 				try {
		 					session = jsch.getSession(username[count], hostname[count], 22);
		 					session.setConfig("StrictHostKeyChecking", "no");
		 					session.setPassword(password[count]);
		 					session.connect(); 
		 					System.out.println("Connected "+i+"!!"+new Date());
		 					com.jcraft.jsch.Channel channel = session.openChannel("sftp");
		 					channel.connect();
		 					ChannelSftp sftpChannel = (ChannelSftp) channel; 
		 					for(int t=0;t<files.length;t++){
			        		String copyFrom = files[t];
		 					sftpChannel.put(copyFrom, copyTo[count]);
		 					
		 					
		 					try {
		 						channel = session.openChannel("exec");
		 						((ChannelExec) channel).setCommand(command);
		 						channel.setInputStream(null);
		 						((ChannelExec) channel).setErrStream(System.err);
		 						InputStream in = channel.getInputStream();
		 						channel.connect();
		 						int d;
		 						while ((d = in.read()) != -1) {
		 						}
		 					} catch (Exception e) {

		 					}
		 					
		 					
		 					
		 					attrs = sftpChannel.lstat("/var/www/html/demo/distillery-prodv14.0.tar.gz");
		 					long size2 = attrs.getSize();
		 					
		 					System.out.println(size2+"::::::::::::::::::::");
		 		           
		 					File f=new File(data);
		 					System.out.println(f.length()+":::::::::::::::::::::");
		 					
		 					
		 					if(size2==f.length()){
		 						finalResult.put(hostname[count]+"File Size", "Matched" );
		 						
		 						
		 					}
		 					else{
		 						sftpChannel.rm("/var/www/html/demo/distillery-prodv14.0.tar.gz");
		 					}
		 					
		 					}
		 					finalResult.put(hostname[count]+" File Result", "Sucessfully Copied" );
		 					sftpChannel.exit();
		 					session.disconnect();
		 				} catch (JSchException e) {
		 					finalResult.put(hostname[count]+"File Result ", "JSchException" );
		 					System.out.println(count+"-------------------thread");
		 					System.out.println(e);
		 				} catch (SftpException e) {
		 					finalResult.put(hostname[count]+"File Result ", "SftpException" );
		 					System.out.println(count+"-------------------thread2");
		 					System.out.println(e);
		 				}
		 				catch (Exception e) {
		 					finalResult.put(hostname[count]+"File Result ", e.getClass() );
		 					System.out.println(count+"-------------------thread3");
		 					System.out.println(e);
		 				}
		 				 Timestamp timestamp12 = new Timestamp(System.currentTimeMillis());
		 				 System.out.println(timestamp12+"end");
		 			   
                          threadCount=threadCount+1;
                          
                          System.out.println(threadCount+"::::::::::::::::::::::::::::::::::::::::::::::::");
                          System.out.println(hostname.length+"::::::::::::::::::::::::::::::::::::::::::::::::");
                          
		 				//latch.countDown();
		 			    result=hostname[count]+" Sucessfully File Copied";
		        	 }
		         }
		     );
		     threads[i].start();
		 }
		 while(s){
			 System.out.println("******* Running1****************"+threadCount);
			 System.out.println("******* Running2****************"+hostname.length);
		 if(hostname.length==threadCount){
		             break;
		 }
		 
		 }
			return finalResult.toJSONString(); 
*/
		
		return instance.toString();
	}

}
