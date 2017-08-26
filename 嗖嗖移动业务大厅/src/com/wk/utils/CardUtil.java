package com.wk.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import com.wk.entity.ConsumeInfo;
import com.wk.entity.MobileCard;

/**
 * 
 * 手机卡工具类
 * @author wk
 *
 */

public class CardUtil {

	private DaoUtil daoUtil = new DaoUtil();
	//保存每个用户消费信息
	private static Map<String, List<ConsumeInfo>> map = new HashMap<>();
	public static Map<String, List<ConsumeInfo>> getMap() {
		return map;
	}
//	private static List<ConsumeInfo> consumeInfos = null;
	
	private List<MobileCard> list = daoUtil.readAll();
		
	

	
	
	/**
	 * 卡是否已注册过
	 * @param number	手机卡号
	 * @param passward	密码
	 * @return			true为已注册
	 */

	
	
	/**
	 * 卡是否已注册过
	 * @param number	手机卡号
	 * @return			true为已注册
	 */
	public boolean isExistCard(String number){
		
		for(MobileCard mc : list){
			
			if(number == mc.getCardNumber()){
				
				System.out.println("该卡号已存在，请重新选择！");
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 创建新卡号
	 * @return
	 */
	public static String createCard(){
		
		StringBuilder sb = new StringBuilder("139");
		Random random = new Random();
		for(int j=0; j<8; ++j){
			
			sb.append(random.nextInt(9));
		}
		
		return sb.toString();
	}

	
	/**
	 * 获取新卡号
	 * @param count	数量
	 * @return
	 */
	public static String[] getNewNumbers(int count){
		
		String[] numbers = new String[count];
		for(int i=0; i<numbers.length; ++i){
			
			numbers[i] = createCard();
		}
		
		return numbers;
		
	}
	

	/**
	 * 注册卡号
	 * @param card 手机卡
	 */
	public void addCard(MobileCard card) {

		boolean isExist = isExistCard(card.getCardNumber());
		
		if(isExist)
			throw new RuntimeException("改卡已存在");
		try {
			daoUtil.write(card);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public MobileCard readCard(MobileCard mCard){
		
		try {
			MobileCard card = daoUtil.readOne(mCard);
			if(card != null)
				return card;
			return null;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 删除卡号
	 * @param number	卡号
	 */
	public boolean delCard(String number){

		try {
			MobileCard card = new MobileCard();
			card.setCardNumber(number);
			
			boolean isExist = isExistCard(card.getCardNumber());
			
			if(isExist)
				DaoUtil.deleteOne(card);
			return false;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	
	/**
	 * 增加消费信息
	 * @param number	卡号
	 * @param info		消费信息
	 */
	public void addConsumeInfo(String number, ConsumeInfo info){
		
		boolean containsKey = map.containsKey(number);
		List<ConsumeInfo> list = null;
		if(!containsKey){
			list = new ArrayList<>();
			map.put(number, list);
		}
		map.get(number).add(info);
		
	}
	
	/*
	 * 写入文件
	 */
	public void printConsumeInfo(String number){
		
		try {
			
			Properties properties = new Properties();
			properties.load(new FileInputStream("./src/com/wk/properties/consumeInfo.properties"));
			
			StringBuilder sb = new StringBuilder();
			for(ConsumeInfo item : map.get(number)){
				sb.append(item.getType() + ":" + item.getConsumeData());
			}
			String[] values = sb.toString().split(",");  
			properties.put(number, values);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用Soso功能
	 * @param number	卡号
	 */
	public void userSoso(String number){
		
	}
	
	
	
	
}
