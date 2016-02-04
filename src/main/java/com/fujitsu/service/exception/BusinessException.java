/* ************************************
 *         S2I CO., Ltd.
 * ************************************
 */
package com.fujitsu.service.exception;

import javax.ejb.ApplicationException;

/**
 * TODO コメント <br>
 * <br>
 * <b>改定履歴</b>
 * <ul>
 * <li>
 * [新規] 2014年2月20日 yaochunlin</li>
 * </ul>
 * 
 * @author yaochunlin [Create 2014年2月20日]
 * @version v1.00
 */

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Object[] EMPTY_PARAM = {};
	private Object[] params = EMPTY_PARAM;

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException() {
	}

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException(String message, Throwable cause) {
		this(message, cause, EMPTY_PARAM);
	}

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException(String message, Throwable cause, Object... params) {
		super(message, cause);
		this.params = params;
	}

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException(String message) {
		this(message, EMPTY_PARAM);
	}

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException(String message, Object... params) {
		super(message);
		this.params = params;
	}

	/**
	 * デフォルトコンストラクタ。
	 */
	public BusinessException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

}
