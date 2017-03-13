1、上传完成后，要记得删除临时文件
	fileitem.delete();
	
2、限制上传文件最大值
	ServletFileUpload.setFileSizeMax(1024*1024);
	然后捕获FileUploadBase.FileSizeLimitExceededException异常，给用户友好提示

3、上传文件中文乱码
	ServletFileUpload.setHeaderEncoding("UTF-8");

4、上传数据的乱码
	FileItem.getString("UTF-8")

5、限制上传文件的类型
	
	
6、为保证服务器的安全，上传文件的保存要禁止外界直接访问到

7、为防止文件覆盖的现象，服务器要为每一个上传文件分配一个唯一的文件名（UUID）

8、上传文件要打散存储

9、可以通过解析器的监听器，监听到文件上传的进度
	upload.setProgressListener(new ProgressListener(){

				public void update(long bytesRead, long contentLength, int items) {

					System.out.println("当前文件大小是：" + contentLength + "，当前已上传：" + bytesRead);
					
				}
				
	});
	
10、



