package com.wk.entity;

import com.wk.enums.TypeEnum;

/**
 * 消费信息
 * @author wk
 *
 */
public class ConsumeInfo {

//	private String cardNumber;	//消费卡号
	private TypeEnum type;		//消费类型
	private int consumeData;	//消费数据
/*	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
*/
	
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public int getConsumeData() {
		return consumeData;
	}
	public void setConsumeData(int consumeData) {
		this.consumeData = consumeData;
	}
	
	
	
}
