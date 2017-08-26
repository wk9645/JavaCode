package com.wk.entity;



/**
 * 手机卡
 * @author wk
 *
 */


public class MobileCard {

	
	private String cardNumber;
	private String userName;
	private String password;
	private ServicePackage serPackage;
	private double consumeAmount;		//消费次数
	private int realTalkTime;			//真实通话时间
	private int realSMSCount;			//真实SMS次数
	private int realFlow;				//真实流量
	
	
	
	public MobileCard() {}
	
	
	
	public MobileCard(String cardNumber, String userName, String password, ServicePackage serPackage,
			double consumeAmount, int realTalkTime, int realSMSCount, int realFlow) {
		super();
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.password = password;
		this.serPackage = serPackage;
		this.consumeAmount = consumeAmount;
		this.realTalkTime = realTalkTime;
		this.realSMSCount = realSMSCount;
		this.realFlow = realFlow;
	}



	/*
	 * Getter和Setter
	 */
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ServicePackage getSerPackage() {
		return serPackage;
	}
	public void setSerPackage(ServicePackage serPackage) {
		this.serPackage = serPackage;
	}
	public double getConsumeAmount() {
		return consumeAmount;
	}
	public void setConsumeAmount(double consumeAmount) {
		this.consumeAmount = consumeAmount;
	}
	public int getRealTalkTime() {
		return realTalkTime;
	}
	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}
	public int getRealSMSCount() {
		return realSMSCount;
	}
	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}
	public int getRealFlow() {
		return realFlow;
	}
	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}
	
	
	/**
	 * 	卡号唯一
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof MobileCard))
			throw new RuntimeException("类型不匹配！");
		
		MobileCard mCard = (MobileCard)obj;
		return mCard.cardNumber.equals(this.cardNumber);
	}
	
	
	//打印信息
	public void showMsg(){
		
		System.out.println("卡信息如下：");
		System.out.println("卡号：" + cardNumber);
		System.out.println("用户名：" + userName);
		System.out.println("密码：" + password);
		System.out.println("套餐：");
		serPackage.showInfo();
		System.out.println("消费次数：" + consumeAmount + "次");
		System.out.println("真实通话：" + realTalkTime + "min");
		System.out.println("SMS：" + realSMSCount + "min");
		System.out.println("流量：" + realFlow + "kb");
	
		
	}
	
}
