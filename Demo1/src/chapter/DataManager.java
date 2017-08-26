package chapter;

import java.io.File;
import java.io.IOException;

import pocketmine.utils.BinaryStream;
import pocketmine.utils.Utils;

public final class DataManager {
	
	private File file;
	public Account[] list;
	public String password;

	DataManager(File file) throws Exception {
		if(!DataManager.checkFile(file)){
			throw new IllegalArgumentException("无效的日志文件");
		}
		this.file=file;
		
		BinaryStream data=new BinaryStream(Utils.readFile(file));
		
		short length=(short) data.getShort();
		this.list=new Account[0x8000];
		for(short i=0;i<length;i++){
			Account stu=new Account(data.getByteArray());
			this.list[stu.getId()]=stu;
		}
		this.password=data.getString();
	}
	
	DataManager(File file,String password) throws IOException{
		if(!DataManager.checkFile(file)){
			throw new IllegalArgumentException("无效的日志文件");
		}
		this.file=file;
		
		this.list=new Account[0x8000];
		this.password=password;
	}

	public void save() throws Exception{	
		BinaryStream data=new BinaryStream();
		
		short cnt=0;
		for(Account stu:this.list){
			if(stu!=null){
			cnt++;
			}
		}
		
		data.putShort(cnt);
		for(Account stu:this.list){
			if(stu!=null){
			data.putByteArray(stu.getBytes());
			}
		}
		data.putString(this.password);

		Utils.writeFile(file,data.getBuffer());
	}
	
	public short findEmptyId(){
		for(short i=0;i>=0;i++){
			if(this.list[i]==null){
				return i;
			}
		}
		return -1;
	}
	
	public static boolean checkFile(File file){
		try{
		if(file.exists()||file.createNewFile()){
		}else{
			return false;
		}
		if(file.isFile()&&file.canWrite()){
		}else{
			return false;
		}
		return true;
		}catch(Throwable e){
			return false;
		}
	}

}
