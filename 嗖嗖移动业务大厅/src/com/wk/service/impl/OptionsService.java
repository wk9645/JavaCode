package com.wk.service.impl;

import com.wk.entity.ConsumeInfo;
import com.wk.entity.MobileCard;
import com.wk.entity.NetPackage;
import com.wk.entity.ServicePackage;
import com.wk.entity.SuperPackage;
import com.wk.entity.TalkPackage;
import com.wk.service.IOptionsService;
import com.wk.utils.CardUtil;


/*
 * 功能实现类
 */

public class OptionsService implements IOptionsService{
	
	
	private CardUtil cardUtil = new CardUtil();
	
	@Override
	public boolean register(MobileCard mCard) {
		
		cardUtil.addCard(mCard);
		return true;
	}

	@Override
	public MobileCard login(MobileCard mCard) {
		
		return cardUtil.readCard(mCard);
		
	}

	@Override
	public double consumeQueryCurrMon(MobileCard mCard) {
		
		double totalMoney = 0;
		ServicePackage serPackage = mCard.getSerPackage();
		
		if(serPackage instanceof TalkPackage){
			TalkPackage talkPackage = (TalkPackage)serPackage;
			double callMoney = talkPackage.call(mCard);
			double sendMoney = talkPackage.send(mCard);
			totalMoney = callMoney + sendMoney;
			
		}else if(serPackage instanceof NetPackage){
			NetPackage netPackage = (NetPackage) serPackage;
			totalMoney = netPackage.netPlay(mCard);
			
		}else if(serPackage instanceof SuperPackage){
			SuperPackage superPackage = (SuperPackage) serPackage;
			
			double callMoney = superPackage.call(mCard);
			double sendMoney = superPackage.send(mCard);
			
			totalMoney = callMoney + sendMoney + superPackage.netPlay(mCard);
			
		}
		return totalMoney;
	}

	@Override
	public void remainingPackage(MobileCard mCard) {
		
		ServicePackage serPackage = mCard.getSerPackage();
		if(serPackage instanceof TalkPackage){
			TalkPackage talkPackage = (TalkPackage)serPackage;
			talkPackage.showInfo();
		}else if(serPackage instanceof NetPackage){
			NetPackage netPackage = (NetPackage) serPackage;
			netPackage.showInfo();
		}else if(serPackage instanceof SuperPackage){
			SuperPackage superPackage = (SuperPackage) serPackage;
			superPackage.showInfo();
		}
	}

	@Override
	public void addConsumeInfo(MobileCard card, ConsumeInfo info) {
		
		String number = card.getCardNumber();
		
		cardUtil.addConsumeInfo(number, info);
		
		
	}
	
	@Override
	public void printConsumeInfo(MobileCard mCard) {
		
		String number = mCard.getCardNumber();
		cardUtil.printConsumeInfo(number);
	}

	
	@Override
	public boolean logout(MobileCard mCard) {
		
		String number = mCard.getCardNumber();
		boolean delCard = cardUtil.delCard(number);
		if(delCard)
			return true;
		return false;
	}
	
}
