/* ************************************
 *         S2I CO., Ltd.
 * ************************************
 */
package com.fujitsu.mode;

import java.util.Date;

/**
 * 登録者、更新者などの情報は登録できる <br>
 * <br>
 * <b>改定履歴</b>
 * <ul>
 * <li>
 * [新規] 2014年2月19日 tanglin</li>
 * </ul>
 *
 * @author tanglin [Create 2014年2月19日]
 * @version v1.00
 */
public interface ModifyMetaDataAware {

    public abstract Date getCreateTime();

    public abstract void setCreateTime(Date createTime);

    public abstract String getCreateUser();

    public abstract void setCreateUser(String createUser);

    public abstract Date getUpdateTime();

    public abstract void setUpdateTime(Date updateTime);

    public abstract String getUpdateUser();

    public abstract void setUpdateUser(String updateUser);

}
