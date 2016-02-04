/* ************************************
 *         S2I CO., Ltd.
 * ************************************
 */
package com.fujitsu.service;

import com.fujitsu.dao.CRUDMapper;
import com.fujitsu.service.exception.BusinessException;

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
public abstract class AbstractCRUDService<T, K> implements CRUDService<T, K> {

	public AbstractCRUDService() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.co.s2_i.service.CRUDService#insert(T)
	 */
	@Override
	final public int insert(final T entity) {
		if (this.isExist(entity)) {
			throw new BusinessException("レコードは既に存在しています。");
		} else {
			generateAutoField(entity);
			return this.getMapper().insert(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.co.s2_i.service.CRUDService#update(T)
	 */
	@Override
	final public int update(final T entity) {
		final int affectedRows = this.getMapper().update(entity);
		if (affectedRows == 0) {
			throw new BusinessException("更新対象は存在しません。");
		} else {
			return affectedRows;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.co.s2_i.service.CRUDService#deleteByKey(K)
	 */
	@Override
	final public int deleteByKey(final K key) {
		final int affectedRows = this.getMapper().delete(key);
		if (affectedRows == 0) {
			throw new BusinessException("削除対象は存在しません。");
		} else {
			return affectedRows;
		}
	}

	/**
	 * かどうか存在
	 * 
	 * @return
	 */
	@Override
	final public boolean isKeyExist(final K key) {
		if (getMapper().getInfoByKey(key) == null) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jp.co.s2_i.service.CRUDService#isExist(java.lang.Object)
	 */
	@Override
	abstract public boolean isExist(T entity);

	protected void generateAutoField(final T entity) {

	}

	/**
	 * MybatisのMapperを取得する
	 * 
	 * @return
	 */
	abstract protected CRUDMapper<T, K> getMapper();

}