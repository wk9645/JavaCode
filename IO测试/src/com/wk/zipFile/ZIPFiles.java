
package com.wk.zipFile;

import java.io.File;

public class ZIPFiles{
	

	public static void main(String[] args) throws Exception {
		//����ZipUtils - E:/1.zipΪѹ�����·��
		ZipUtils zip = new ZipUtils("F:/qingniao.zip");
		//����ѹ���ļ�
		zip.setRead(new File("F:/����java�γ�"));
		//��ʼѹ��
		zip.zipFile();
	}
}