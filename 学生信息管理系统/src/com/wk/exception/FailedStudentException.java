package com.wk.exception;

public class FailedStudentException extends Exception {
	
	
	/**
	 * 错误的学生信息异常
	 */
	
	private static final long serialVersionUID = 5353598088562228977L;

	public FailedStudentException(){
		super();
	}
	
	public FailedStudentException(String msg){
		super(msg);
	}

}
