/* ************************************
 *         S2I CO., Ltd.
 * ************************************
 */
package com.tojsq.service;

/**
 * データ入力削除の共通Service <br>
 * <code>T</code>は操作するレコードのタイプ <code>K</code>はTの主キー <br>
 * <b>改定履歴</b>
 * <ul>
 * <li>
 * [新規] 2014年2月19日 jihailong</li>
 * </ul>
 * 
 * @author jihailong [Create 2014年2月19日]
 * @version v1.00
 */
public interface CRUDService<T, K> {

	/**
	 * 追加
	 * 
	 * @param entity
	 * @return
	 */
	public abstract int insert(T entity);

	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
	public abstract int update(T entity);

	/**
	 * 削除
	 * 
	 * @param key
	 * @return
	 */
	public abstract int deleteByKey(K key);

	/**
	 * レコードは存在かどうか
	 * 
	 * @param entity
	 * @return
	 */
	abstract public boolean isExist(T entity);

	/**
	 * 主キーは存在かどうか
	 * 
	 * @param key
	 * @return
	 */
	abstract public boolean isKeyExist(K key);

}