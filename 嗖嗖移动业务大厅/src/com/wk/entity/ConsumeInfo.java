package com.wk.entity;

import com.wk.enums.TypeEnum;

/**
 * ������Ϣ
 * @author wk
 *
 */
public class ConsumeInfo {

//	private String cardNumber;	//���ѿ���
	private TypeEnum type;		//��������
	private int consumeData;	//��������
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
