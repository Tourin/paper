/* ************************************
 *         S2I CO., Ltd.
 * ************************************
 */
package com.tojsq.view;

/**
 * 画面のIDと名称 <br>
 * <br>
 * <b>改定履歴</b>
 * <ul>
 * <li>
 * [新規] 2014年2月17日 yaochunlin</li>
 * </ul>
 * 
 * @author yaochunlin [Create 2014年2月17日]
 * @version v1.00
 */
public enum FormId {

	ZRKM0010("ASSY原単位保守画面", "ASSY原単位　保守"), //
	;

	private FormId(final String title, final String headerText) {
		this.title = title;
		this.headerText = headerText;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the headerText
	 */
	public String getHeaderText() {
		return headerText;
	}

	private final String title;

	private final String headerText;

}
