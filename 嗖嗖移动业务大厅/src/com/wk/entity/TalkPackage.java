package com.wk.entity;

import com.wk.service.ICallService;
import com.wk.service.ISendService;

	
	/**
	 * 话唠套餐
	 */


public class TalkPackage extends ServicePackage implements ICallService,ISendService{

	
	private int talkTime = 500;
	private int smsCount = 30;
	
	
	@Override
	public void showInfo() {
		
//		System.out.println("话唠套餐：通话时长为500分钟/月，短信条数为30条/月" );
		System.out.println("通话时长：" + talkTime + "分钟");
		System.out.println("短信条数：" + smsCount + "条");
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
	public double send(MobileCard card) {
		
		int realSMSCount = card.getRealSMSCount();
		if(realSMSCount >= smsCount){
			price+= 0.1 * (realSMSCount - smsCount);
			smsCount = 0;
		}else {
			smsCount = smsCount - realSMSCount;
		}
		return price;
	}

}
