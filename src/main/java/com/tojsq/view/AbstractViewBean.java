package com.tojsq.view;

import com.tojsq.intercepter.Action;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Action
public abstract class AbstractViewBean<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 編集対象
     */
    private T target;
    /**
     * データ一覧
     */
    private List<T> dataList = Collections.emptyList();

    public AbstractViewBean() {
        super();
    }

    /**
     * 編集対象
     *
     * @return the target
     */
    public T getTarget() {
        return target;
    }

    /**
     * 編集対象
     *
     * @param target the target to set
     */
    public void setTarget(final T target) {
        this.target = target;
    }

    /**
     * @return
     */
    public List<T> getDataList() {
        return dataList;
    }

    /**
     * @param dataList
     */
    public void setDataList(final List<T> dataList) {
        this.dataList = dataList;
    }

}
