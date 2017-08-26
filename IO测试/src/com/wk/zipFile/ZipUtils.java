package com.wk.zipFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * 压缩文件类
 */
public class ZipUtils {
	private File root;// 输出根目录
	private File read;// 读取目录
	private OutputStream os;// 声明输出流
	private ZipOutputStream zos; // 声明压缩输出流
    /**
     * 设置压缩后的路径
     * @param rootPath
     */
	public ZipUtils(String rootPath) {
		try {
			if (rootPath != null && "".equals(rootPath.trim())) {
				throw new Exception("文件路径不能为空");
			}
			root = new File(rootPath);
			os = new FileOutputStream(root);
			zos = new ZipOutputStream(os);
		} catch (FileNotFoundException e) {
			System.err.println("创建ZipUtils实例出错!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param filePath
	 *            压缩路径
	 * @throws Exception
	 */
	public void zipFile(String filePath) throws Exception {
		if (filePath != null) {
			File file = new File(filePath);
			zipFile(file);// 调用压缩file
		}
	}

	/**
	 * @param file
	 *            压缩后的文件
	 * @throws Exception
	 */
	public void zipFile(File file) throws Exception {
		// 需要压缩的file不能为null 并且必须存在
		if (file != null && file.exists()) {
			// 为单个文件则直接压缩
			if (file.isFile()) {
				// 获取文件的增强输入流
				BufferedInputStream bis = getInputStream(file);
				// 设置输出的条目信息
				zos.putNextEntry(new ZipEntry(file.getName()));
				/**
				 * 开始读写操作
				 */
				io(bis);
				// 关闭资源
				close(bis, true);
			} else {
				// 如果为文件夹则需要进行先遍历在压缩
				zipDir(file);
				// 关闭资源
				close(null, true);
			}
		}
	}
    /**
     * 开始压缩
     * @throws Exception
     */
	public void zipFile() throws Exception {
		zipFile(read);
	}

	/**
	 * 读写操作
	 * 
	 * @param is
	 *            输入流
	 * @throws IOException
	 */
	private void io(InputStream is) throws IOException {
		byte[] data = new byte[1024];
		while (is.read(data) != -1) {
			zos.write(data);
		}
	}

	/**
	 * 关闭资源
	 */
	private void close(InputStream is, boolean flag) {
		try {
			if (is != null)
				is.close();
			if (zos != null && flag)
				zos.close();
		} catch (IOException e) {
			System.out.println("关闭失败");
			e.printStackTrace();
		}
	}

	/**
	 * 写入文件夹 是文件夹先压缩文件夹,在压缩子文件.
	 * 
	 * @throws Exception
	 */
	private void zipDir(File file) throws Exception {
		if (file.isDirectory()) {
			// 获取子文件
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2 != null) {
					zipDir(file2);
				}
			}
		} else {
			// 获取文件的增强输入流
			BufferedInputStream bis = getInputStream(file);
			String dirAbsPath = file.getAbsolutePath();
			String entryPath = dirAbsPath.replace(read.getAbsolutePath(),"");
			//取出第一个\
			if(entryPath.charAt(0)=='\\'){
				entryPath = entryPath.substring(1,entryPath.length());
			}
			
			// 设置输出的条目信息
			zos.putNextEntry(new ZipEntry(entryPath));
			/**
			 * 开始读写操作
			 */
			io(bis);
			close(bis, false);
		}
	}

	// 根据File获取字节增强流
	private BufferedInputStream getInputStream(File file) throws Exception {
		InputStream is = new FileInputStream(file);
		return new BufferedInputStream(is);
	}

	public File getRoot() {
		return root;
	}

	public void setRoot(File root) {
		this.root = root;
	}
	/**
	 * 设置需要压缩的文件
	 * @param read
	 */
	public void setRead(File read) {
		this.read = read;
	}
}

