package com.wk.exception;

public class FailedStudentException extends Exception {
	
	
	/**
	 * �����ѧ����Ϣ�쳣
	 */
	
	private static final long serialVersionUID = 5353598088562228977L;

	public FailedStudentException(){
		super();
	}
	
	public FailedStudentException(String msg){
		super(msg);
	}

}
