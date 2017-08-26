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
 * ѹ���ļ���
 */
public class ZipUtils {
	private File root;// �����Ŀ¼
	private File read;// ��ȡĿ¼
	private OutputStream os;// ���������
	private ZipOutputStream zos; // ����ѹ�������
    /**
     * ����ѹ�����·��
     * @param rootPath
     */
	public ZipUtils(String rootPath) {
		try {
			if (rootPath != null && "".equals(rootPath.trim())) {
				throw new Exception("�ļ�·������Ϊ��");
			}
			root = new File(rootPath);
			os = new FileOutputStream(root);
			zos = new ZipOutputStream(os);
		} catch (FileNotFoundException e) {
			System.err.println("����ZipUtilsʵ������!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param filePath
	 *            ѹ��·��
	 * @throws Exception
	 */
	public void zipFile(String filePath) throws Exception {
		if (filePath != null) {
			File file = new File(filePath);
			zipFile(file);// ����ѹ��file
		}
	}

	/**
	 * @param file
	 *            ѹ������ļ�
	 * @throws Exception
	 */
	public void zipFile(File file) throws Exception {
		// ��Ҫѹ����file����Ϊnull ���ұ������
		if (file != null && file.exists()) {
			// Ϊ�����ļ���ֱ��ѹ��
			if (file.isFile()) {
				// ��ȡ�ļ�����ǿ������
				BufferedInputStream bis = getInputStream(file);
				// �����������Ŀ��Ϣ
				zos.putNextEntry(new ZipEntry(file.getName()));
				/**
				 * ��ʼ��д����
				 */
				io(bis);
				// �ر���Դ
				close(bis, true);
			} else {
				// ���Ϊ�ļ�������Ҫ�����ȱ�����ѹ��
				zipDir(file);
				// �ر���Դ
				close(null, true);
			}
		}
	}
    /**
     * ��ʼѹ��
     * @throws Exception
     */
	public void zipFile() throws Exception {
		zipFile(read);
	}

	/**
	 * ��д����
	 * 
	 * @param is
	 *            ������
	 * @throws IOException
	 */
	private void io(InputStream is) throws IOException {
		byte[] data = new byte[1024];
		while (is.read(data) != -1) {
			zos.write(data);
		}
	}

	/**
	 * �ر���Դ
	 */
	private void close(InputStream is, boolean flag) {
		try {
			if (is != null)
				is.close();
			if (zos != null && flag)
				zos.close();
		} catch (IOException e) {
			System.out.println("�ر�ʧ��");
			e.printStackTrace();
		}
	}

	/**
	 * д���ļ��� ���ļ�����ѹ���ļ���,��ѹ�����ļ�.
	 * 
	 * @throws Exception
	 */
	private void zipDir(File file) throws Exception {
		if (file.isDirectory()) {
			// ��ȡ���ļ�
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2 != null) {
					zipDir(file2);
				}
			}
		} else {
			// ��ȡ�ļ�����ǿ������
			BufferedInputStream bis = getInputStream(file);
			String dirAbsPath = file.getAbsolutePath();
			String entryPath = dirAbsPath.replace(read.getAbsolutePath(),"");
			//ȡ����һ��\
			if(entryPath.charAt(0)=='\\'){
				entryPath = entryPath.substring(1,entryPath.length());
			}
			
			// �����������Ŀ��Ϣ
			zos.putNextEntry(new ZipEntry(entryPath));
			/**
			 * ��ʼ��д����
			 */
			io(bis);
			close(bis, false);
		}
	}

	// ����File��ȡ�ֽ���ǿ��
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
	 * ������Ҫѹ�����ļ�
	 * @param read
	 */
	public void setRead(File read) {
		this.read = read;
	}
}

