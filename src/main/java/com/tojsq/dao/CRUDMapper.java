/* ************************************
 *         S2I CO., Ltd.
 * ************************************
 */
package com.tojsq.dao;

/**
 * TODO コメント <br>
 * <br>
 * <b>改定履歴</b>
 * <ul>
 * <li>
 * [新規] 2014年2月24日 yaochunlin</li>
 * </ul>
 * 
 * @author yaochunlin [Create 2014年2月24日]
 * @version v1.00
 */
public interface CRUDMapper<T, K> {
	/**
	 * 追加
	 * 
	 * @param assy
	 * @return
	 */
	int insert(T assy);

	/**
	 * 削除
	 * 
	 * @param assy
	 * @return
	 */
	int delete(K assy);

	/**
	 * 変更
	 * 
	 * @param assy
	 * @return
	 */
	int update(T assy);

	/**
	 * 主キーより検索
	 * 
	 * @param key
	 * @return
	 */
	T getInfoByKey(K key);
}
