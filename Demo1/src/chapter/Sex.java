package chapter;

public enum Sex {
	Y(1,"��"),X(0,"Ů");
	private byte bin;
	private String m;
	
	Sex(int b,String m){
		this.bin=(byte)b;
		this.m=m;
	}
	
	public static Sex parseSex(String v){
		return "��".equals(v)?Sex.Y:Sex.X;
	}
	
	public static Sex parseSex(byte v){
		return v>0?Sex.Y:Sex.X;
	}
	
	public byte toByte(){
		return this.bin;
	}
	@Override
	public String toString(){
		return this.m;
	}
	
}
