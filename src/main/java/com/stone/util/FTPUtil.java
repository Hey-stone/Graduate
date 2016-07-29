package com.stone.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;
/**
 * 
 * @author Administrator
 */
public class FTPUtil {
	private static FTPClient ftpClient = new FTPClient();
	private static String encoding = System.getProperty("file.encoding");
	
    /**
     * Description: 向FTP服务器上传文件
     * 
     * @Version1.0
     * @param url
     *            FTP服务器hostname
     * @param port
     *            FTP服务器端口
     * @param username
     *            FTP登录账号
     * @param password
     *            FTP登录密码
     * @param remotePath
     *            FTP服务器目录，如果是根目录则为“/”， 一定要以“/”开头并且以“/”结束
     * @param fileName
     *            上传到FTP服务器上的文件名
     * @param localPath
     *            上传前从本地的路径获取
     * @return 成功返回true，否则返回false
     */
	@Deprecated
    public static boolean uploadFile(String url, int port, String username,
            String password, String remotePath, String fileName, String localPath) {
        boolean result = false;
        try {
            int reply;
//            ftpClient.setControlEncoding("ISO-8859-1");//设置与FTP服务器通讯的编码集，FTPClient默认使用UTF-8编码
            //1.连接FTP服务器
            //如果采用ftp默认端口号21，可以使用ftp.connect(url)的方式直接连接FTP服务器；否则使用ftp.connect(url, port)
            ftpClient.connect(url, port);
            //2.登录FTP服务器
            ftpClient.login(username, password);
            //3.获取FTP登录应答代码，检测是否连接成功
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.out.println("连接失败...");
                ftpClient.disconnect();//断开连接
                return result;
            }
            //4.转移到FTP服务器工作目录至指定的目录下
            if (!ftpClient.changeWorkingDirectory(new String(remotePath.getBytes("GBK"),"ISO-8859-1"))) {
            	ftpClient.makeDirectory(new String(remotePath.getBytes("GBK"),"ISO-8859-1"));//在FTP服务器（FTP服务器必须开启创建目录的权限）上创建目录
			}
            ftpClient.changeWorkingDirectory(new String(remotePath.getBytes("GBK"),"ISO-8859-1"));
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件传输类型为二进制
        	File localFile = new File(localPath + File.separator + fileName);
        	InputStream is = new FileInputStream(localFile);
        	//5.在FTP服务器保存上传文件
            result = ftpClient.storeFile(new String(fileName.getBytes("GBK"),"ISO-8859-1"), is);
            is.close();
            if (result) {
                System.out.println("上传成功!");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				//6.退出FTP服务器
				ftpClient.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                	ioe.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public static boolean uploadFile(String url, int port, String username,
            String password, String remotePath, String fileName, InputStream is) {
        boolean result = false;
        try {
            int reply;
//            ftpClient.setControlEncoding("ISO-8859-1");//设置与FTP服务器通讯的编码集，FTPClient默认使用UTF-8编码
            //1.连接FTP服务器
            //如果采用ftp默认端口号21，可以使用ftp.connect(url)的方式直接连接FTP服务器；否则使用ftp.connect(url, port)
            ftpClient.connect(url, port);
            //使用被动模式传输数据
            ftpClient.enterLocalPassiveMode();
            //2.登录FTP服务器
            ftpClient.login(username, password);
            //3.获取FTP登录应答代码，检测是否连接成功
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.out.println("连接失败...");
                ftpClient.disconnect();//断开连接
                return result;
            }
            //4.转移到FTP服务器工作目录至指定的目录下
            
            // 不要进入工作空间，直接创建稳健夹，返回false就标示稳健夹存在
            //if (!ftpClient.changeWorkingDirectory(new String(remotePath.getBytes("GBK"),"ISO-8859-1"))) 
			//}
//            ftpClient.changeWorkingDirectory(new String(remotePath.getBytes("GBK"),"ISO-8859-1"));

            ftpClient.makeDirectory(remotePath);//在FTP服务器（FTP服务器必须开启创建目录的权限）上创建目录    又冒得中文，干嘛要转码
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件传输类型为二进制
        	//5.在FTP服务器保存上传文件
            result = ftpClient.storeFile(remotePath + fileName, is);
            
            if (result) {
                System.out.println("上传成功!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
				//6.退出FTP服务器
				ftpClient.logout();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                	ioe.printStackTrace();
                }
            }
            try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return result;
    }
    
    /**
     * Description: 从FTP服务器下载文件
     * 
     * @Version1.0
     * @param url
     *            FTP服务器hostname
     * @param port
     *            FTP服务器端口
     * @param username
     *            FTP登录账号
     * @param password
     *            FTP登录密码
     * @param remotePath
     *            FTP服务器目录，如果是根目录则为“/”， 一定要以“/”开头并且以“/”结束
     * @param fileName
     *            要下载的文件名
     * @param localPath
     *            下载后保存到本地的路径
     * @return 成功返回true，否则返回false
     */
    public static boolean downloadFile(String url, int port, String username,
            String password, String remotePath, final String fileName, String localPath) {
        boolean result = false;
        try {
            int reply;
//            ftpClient.setControlEncoding("ISO-8859-1");//设置与FTP服务器通讯的编码集，FTPClient默认使用UTF-8编码
            //1.连接FTP服务器
            //如果采用ftp默认端口号21，可以使用ftp.connect(url)的方式直接连接FTP服务器；否则使用ftp.connect(url, port)
            ftpClient.connect(url, port);
            //2.登录FTP服务器
            ftpClient.login(username, password);
            //3.获取FTP登录应答代码，检测是否连接成功
            reply = ftpClient.getReplyCode();
            
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.err.println("连接失败...");
                ftpClient.disconnect();//断开连接
                return result;
            }
            ftpClient.enterLocalPassiveMode();
            //4.转移到FTP服务器工作目录至指定的目录下
            //ftpClient.changeWorkingDirectory(remotePath); 此段代码害的我们加班两天
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//设置文件传输类型为二进制
            FTPFile[] ftpFiles = ftpClient.listFiles(remotePath, new FTPFileFilter() {
				
				@Override
				public boolean accept(FTPFile file) {
					if (file.getName().contains(fileName)) {
						return true;
					}
					return false;
				}
				
			});//获取文件列表
            for (FTPFile ftpFile : ftpFiles) {
            	String remoteFileName = ftpFile.getName();
            	if (remoteFileName.equals(fileName)) {
            		File localPathFile = new File(localPath);
            		if(!localPathFile.exists()){
            			localPathFile.mkdirs();
            		}
            		File localFile = new File(localPathFile, remoteFileName);
            		OutputStream os = new FileOutputStream(localFile);
            		//5.从FTP服务器保存下载文件
            		result = ftpClient.retrieveFile(remotePath + File.separator + ftpFile.getName(), os);
            		os.close();
            		break;
            	}
            }
            if (result) {
				System.out.println("下载成功！");
			}
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				//6.退出FTP服务器
				ftpClient.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                	ioe.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public static boolean downloadFile(String url, int port, String username,
    		String password, String remotePath, final String fileName, OutputStream os) {
    	boolean result = false;
    	try {
    		int reply;
//            ftpClient.setControlEncoding("ISO-8859-1");//设置与FTP服务器通讯的编码集，FTPClient默认使用UTF-8编码
    		//1.连接FTP服务器
    		//如果采用ftp默认端口号21，可以使用ftp.connect(url)的方式直接连接FTP服务器；否则使用ftp.connect(url, port)
    		ftpClient.connect(url, port);
    		//2.登录FTP服务器
    		ftpClient.login(username, password);
    		//3.获取FTP登录应答代码，检测是否连接成功
    		reply = ftpClient.getReplyCode();
    		
    		if (!FTPReply.isPositiveCompletion(reply)) {
    			System.err.println("连接失败...");
    			ftpClient.disconnect();//断开连接
    			return result;
    		}
    		ftpClient.enterLocalPassiveMode();
    		//4.转移到FTP服务器工作目录至指定的目录下
    		//ftpClient.changeWorkingDirectory(remotePath); 此段代码害的我们加班两天
    		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//设置文件传输类型为二进制
    		FTPFile[] ftpFiles = ftpClient.listFiles(remotePath, new FTPFileFilter() {
    			
    			@Override
    			public boolean accept(FTPFile file) {
    				if (file.getName().contains(fileName)) {
    					return true;
    				}
    				return false;
    			}
    			
    		});//获取文件列表
    		for (FTPFile ftpFile : ftpFiles) {
    			String remoteFileName = ftpFile.getName();
    			if (remoteFileName.equals(fileName)) {
    				//5.从FTP服务器保存下载文件
    				result = ftpClient.retrieveFile(remotePath + File.separator + ftpFile.getName(), os);
    				os.close();
    				break;
    			}
    		}
    		if (result) {
    			System.out.println("下载成功！");
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			//6.退出FTP服务器
    			ftpClient.logout();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		if (ftpClient.isConnected()) {
    			try {
    				ftpClient.disconnect();
    			} catch (IOException ioe) {
    				ioe.printStackTrace();
    			}
    		}
    	}
    	return result;
    }
    
    /**
     * 下载某个文件夹下的所有文件，不包含子文件夹
     * @param url
     * @param port
     * @param username
     * @param password
     * @param remotePath
     * @param localPath
     * @return
     */
    public static boolean downloadDir(String url, int port, String username,
            String password, String remotePath, String localPath) {
        boolean result = false;
        try {
            int reply;
//            ftpClient.setControlEncoding("ISO-8859-1");//设置与FTP服务器通讯的编码集，FTPClient默认使用UTF-8编码
            //1.连接FTP服务器
            //如果采用ftp默认端口号21，可以使用ftp.connect(url)的方式直接连接FTP服务器；否则使用ftp.connect(url, port)
            ftpClient.connect(url, port);
            //2.登录FTP服务器
            ftpClient.login(username, password);
            //3.获取FTP登录应答代码，检测是否连接成功
            reply = ftpClient.getReplyCode();
            
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.err.println("连接失败...");
                ftpClient.disconnect();//断开连接
                return result;
            }
            ftpClient.enterLocalPassiveMode();
            //4.转移到FTP服务器工作目录至指定的目录下
            //ftpClient.changeWorkingDirectory(remotePath); 此段代码害的我们加班两天
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//设置文件传输类型为二进制
            //获取路径下所有的文件
            FTPFile[] ftpFiles = ftpClient.listFiles(remotePath);
            //获取文件列表
            for (FTPFile ftpFile : ftpFiles) {
            	//如果是文件则下载
            	if (ftpFile.isFile()) {
            		String remoteFileName = ftpFile.getName();
                	File localPathFile = new File(localPath);
                	if(!localPathFile.exists()){
                		localPathFile.mkdirs();
                	}
                	File localFile = new File(localPathFile, remoteFileName);
                	OutputStream os = new FileOutputStream(localFile);
                	//5.从FTP服务器保存下载文件
                	result = ftpClient.retrieveFile(remotePath + File.separator + ftpFile.getName(), os);
                	os.close();
                	//如果 有一个下载失败，则退出下载
                	if (!result) {
    					break;
    				}
				}
            }
            if (result) {
				System.out.println("下载成功！");
			}
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				//6.退出FTP服务器
				ftpClient.logout();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                	ioe.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public static boolean copyFile(String fileFrom, String fileTo) {  
        try {  
            FileInputStream in = new java.io.FileInputStream(fileFrom);  
            FileOutputStream out = new FileOutputStream(fileTo);  
            byte[] bt = new byte[1024];  
            int count;  
            while ((count = in.read(bt)) > 0) {  
                out.write(bt, 0, count);  
            }  
            in.close();  
            out.close();  
            return true;  
        } catch (IOException ex) {  
            return false;  
        }  
    }  
    
    
    public static void main(String[] args) {
/*        try {
            boolean flag = uploadFile("127.0.0.1", 21, "admin","admin", "/汇文件/", "临时文件.txt", "E:/");
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        try {
            //boolean flag = downloadFile("127.0.0.1", 21, "admin", "admin", "/", "临时文件.txt", "E:/源文件");
            boolean flag = downloadDir("127.0.0.1", 21, "admin", "admin", "/statisticsFiles", "G:/FTPRoot/test");
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
