
package com.wk.zipFile;

import java.io.File;

public class ZIPFiles{
	

	public static void main(String[] args) throws Exception {
		//创建ZipUtils - E:/1.zip为压缩后的路径
		ZipUtils zip = new ZipUtils("F:/qingniao.zip");
		//设置压缩文件
		zip.setRead(new File("F:/青鸟java课程"));
		//开始压缩
		zip.zipFile();
	}
}