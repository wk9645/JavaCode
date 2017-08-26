package chapter;

import pocketmine.utils.BinaryStream;

public class Account {
	
	protected short id;	
	protected byte age;
	protected Sex sex;
	protected String name;
	

	Account(byte[] weak) {
		BinaryStream data=new BinaryStream();
		data.setBuffer(weak);
		this.id=(short) data.getShort();
		this.age=(byte) data.getByte();
		this.sex=Sex.parseSex((byte)data.getByte());
		this.name=data.getString();
	}

	Account(short id, String n, Sex sex, byte age) {
		this.id=id;
		this.age=age;
		this.sex=sex;
		this.name=n;
	}

	public int getId() {
		return this.id;
	}
	

	public byte[] getBytes() {
		BinaryStream data=new BinaryStream();
		data.putShort(this.id);
		data.putByte(this.age);
		data.putByte(this.sex.toByte());
		data.putString(this.name);
		return data.getBuffer();
	}

	public byte getAge() {
		return this.age;
	}
	@Override
	public String toString(){
		return this.id+"\t"+this.name+"\t"+this.sex.toString()+"\t"+this.age;
	}

	public String getName() {
		return this.name;
	}

	public Sex getSex() {
		return this.sex;
	}

	public void setAge(int i) {
		this.age=(byte) Math.abs(i);
	}

}
