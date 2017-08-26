package chapter;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		File file=null;
		boolean isRead=false;
		while(file==null){
		System.out.print("请输入数据文件位置: ");
		String path=null;
		try{
			path=input.nextLine();
		}catch(Throwable e){
			System.out.println("发生了未知的错误，退出");
			e.printStackTrace(System.out);
			System.exit(1);
		}
		
		file=new File(path);
		isRead=file.exists();
		if(!DataManager.checkFile(file)){
			System.out.println("文件无效，请重新指定");
			file=null;
		}
		}
		
		DataManager db=null;
		if(isRead){
			boolean success=false;
			try {
				db=new DataManager(file);
			} catch (Exception e) {
				System.out.println("打开失败，发生了未知的数据错误");
				e.printStackTrace();
				System.exit(1);
			}
			for(byte i=0;i<3;i++){
				System.out.print("请输入密码: ");
				if(db.password.equals(input.nextLine())){
					success=true;
					break;
				}else{
					System.out.println("密码错误");
				}
			}
			if(!success){
			System.out.println("密码错误太多，退出 ");
			System.exit(0);
			}
		}else{
		System.out.print("请输入新密码: ");
		try {
			db=new DataManager(file,input.nextLine());
		} catch (IOException e) {
			System.out.println("发生了未知错误，退出");
			e.printStackTrace();
			System.exit(1);
		}
		
		}
		System.out.println("=====================================");
		System.out.println("提示:用户名是数据文件");
		System.out.println("注意:数据文件必须有写入权限，班级学生数量不得超过"+0x7fff+"人，学生年龄不得超过"+0x7f+"岁，否则会发生一个未知的错误");
		System.out.println("=====================================");
		while(true){
			System.out.print("> ");
			String[] param=input.nextLine().split(" ");
			if(param.length<1){
				continue;
			}
			switch(param[0]){
			case "q":
			case "exit":
			case "退出":
				System.out.println("=====================================");
				try {
					db.save();
				} catch (Exception e) {
					System.out.println("数据保存失败");
					e.printStackTrace();
					System.exit(1);
				}
				input.close();
				System.out.println("谢谢使用");
				System.exit(0);
			break;
			case "1":
				if(param.length<2){
					System.out.println("请输入学号");
					break;
				}
				int ii;
				try{
				ii=Integer.parseInt(param[1]);
				}catch(Throwable e){
					System.out.println("请输入有效的学号");
					break;
				}
				ii&=0x7fff;
			Account stu1=db.list[ii];
			if(stu1==null){
				System.out.println("查无此人 ");
			}else{
				System.out.println(stu1.toString());
			}
				break;
			case "2":
				int[] sxx=new int[0x80];
				for(Account stu2:db.list){
					if(stu2!=null){
					sxx[stu2.getAge()]++;
					}
				}
				
				for(byte i=0;i>=0;i++){
					if(sxx[i]>0){
						System.out.println("年龄: "+i+",人数: "+sxx[i]);
					}
				}
			break;
			case "3":
				boolean success=false;
				for(byte i=0;i<3;i++){
					
					System.out.print("请输入姓名: ");
					String n=input.nextLine();
					for(Account stu:db.list){
						if(stu!=null&&stu.getName().equals(n)){
							db.list[stu.getId()]=null;
							success=true;
						}
					}
					if(success){
						break;
					}
				}
				if(!success){
					System.out.println("错误3次，退出");
					System.exit(0);
				}
			break;
			case "4":
				for(Account stu:db.list){
					if(stu!=null&&stu.getSex()==Sex.X){
						byte age=stu.getAge();
						if(age<18){
							age++;
								age&=0x7f;
							stu.setAge(age);
						}
					}
				}	
			break;
			case "5":
			case "add":
			case "添加":
			short id=db.findEmptyId();
			if(id==-1){
				System.out.println("错误，学生太多");
				break;
			}
			
			String n=null;
			byte age=-1;
			Sex sex=null;
			try{
			n=param[1];
			age=Byte.parseByte(param[2]);
			sex=Sex.parseSex(param[3]);
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("参数不全，请查看帮助");
				break;
			}catch(NumberFormatException e){
				System.out.println("参数有误，请查看帮助");
				break;
			}
			if(n==null||sex==null||age<0){
				System.out.println("参数异常，请查看帮助");
				break;
			}
			Account stu=new Account(id,n,sex,age);
			db.list[id]=stu;
			System.out.println("已添加到编号: "+id);
			break;
			case "ls":
				for(Account stu6:db.list){
					if(stu6!=null){
						System.out.println(stu6.toString());
					}
				}
			break;
			case "gc":
			System.gc();
			break;
			case "h":
			case "help":
			case "帮助":
				default:
				System.out.println("使用说明，可用命令列表");
				System.out.println("退出");
				System.out.println("1 <int:学号> #输出指定学号的学生信息");
				System.out.println("2 #输出所有学生的信息");
				System.out.println("3 #删除指定名称的学生");
				System.out.println("4 #把女生没满18的年龄+1");
				System.out.println("5 <string:姓名> <int:年龄> <enum(男,女):性别> #添加学生");
			break;
			}
		}

	}

}