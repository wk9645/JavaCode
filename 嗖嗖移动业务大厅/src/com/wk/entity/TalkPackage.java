package com.wk.entity;

import com.wk.service.ICallService;
import com.wk.service.ISendService;

	
	/**
	 * �����ײ�
	 */


public class TalkPackage extends ServicePackage implements ICallService,ISendService{

	
	private int talkTime = 500;
	private int smsCount = 30;
	
	
	@Override
	public void showInfo() {
		
//		System.out.println("�����ײͣ�ͨ��ʱ��Ϊ500����/�£���������Ϊ30��/��" );
		System.out.println("ͨ��ʱ����" + talkTime + "����");
		System.out.println("����������" + smsCount + "��");
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
