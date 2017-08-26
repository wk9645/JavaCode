package com.wk.entity;

import javax.security.sasl.RealmCallback;

import com.wk.service.ICallService;
import com.wk.service.INetService;
import com.wk.service.ISendService;


	
	/**
	 * 超人套餐
	 */


public class SuperPackage extends ServicePackage implements ICallService,ISendService,INetService{

	
	private int talkTime = 200;
	private int smsCount = 50;
	private int flow = 1;	
	
	@Override
	public double netPlay(MobileCard mCard) {

		int realFlow = mCard.getRealFlow();
		if(realFlow >= flow){
			price+= 0.1 * (realFlow - flow * 1024);
			flow = 0;
		}else {
			flow = flow - realFlow / 1024;
		}
		return price;
	}

	@Override
	public double send(MobileCard mCard) {
		
		int realSMSCount = mCard.getRealSMSCount();
		if(realSMSCount >= smsCount){
			price+= 0.1 * (realSMSCount - smsCount);
			smsCount = 0;
		}else {
			smsCount = smsCount - realSMSCount;
		}
		return price;
	}

	@Override
	public double call(MobileCard mCard) {
		
		int realTalkTime = mCard.getRealTalkTime();
		if(realTalkTime >= talkTime){
			price+= 0.2 * (realTalkTime - talkTime);
			talkTime = 0;
		}else {
			talkTime = talkTime - realTalkTime;
		}
		return price;
	}
	@Override
	public void showInfo() {
		
//		System.out.println("超人套餐：通话时长为200分钟/月，短信条数为50条/月，上网流量为1GB/月" );
		System.out.println("通话时长：" + talkTime + "分钟");
		System.out.println("短信条数：" + smsCount + "条");
		System.out.println("上网流量：" + flow + "GB");
	}
	
}
