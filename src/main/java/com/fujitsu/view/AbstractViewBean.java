package com.fujitsu.view;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.faces.component.EditableValueHolder;
import javax.faces.event.AjaxBehaviorEvent;

public abstract class AbstractViewBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * フォームID
	 */
	private FormId formId;
	/**
	 * 編集対象
	 */
	private T target;
	/**
	 * ヘーダ表示対象
	 */
	private T previewTarget;
	/**
	 * データ一覧
	 */
	private List<T> dataList = Collections.emptyList();

	/**
	 * 　一覧データのKEY
	 * 
	 * @param record
	 * @return
	 */
	abstract public Object getRowKey(T record);

	public AbstractViewBean() {
		super();
	}

	public String getContainerClass() {
		return "";
	}

	public String close() {
		return "/index";
	}

	/**
	 * @return the formId
	 */
	public FormId getFormId() {
		return formId;
	}

	/**
	 * @param formId
	 *            the formId to set
	 */
	public void setFormId(final FormId formId) {
		this.formId = formId;
	}

	public String getTitle() {
		if (formId != null) {
			return formId.getTitle();
		} else {
			return "";
		}
	}

	public String getHeaderText() {
		if (formId != null) {
			return formId.getHeaderText();
		} else {
			return "";
		}
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
	 * @param target
	 *            the target to set
	 */
	public void setTarget(final T target) {
		this.target = target;
	}

	/**
	 * @return the previewTarget
	 */
	public T getPreviewTarget() {
		return previewTarget;
	}

	/**
	 * @param previewTarget
	 *            the previewTarget to set
	 */
	public void setPreviewTarget(final T previewTarget) {
		this.previewTarget = previewTarget;
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

	/**
	 * @param event
	 * @return
	 */
	protected String getSubmitedValue(final AjaxBehaviorEvent event) {
		final EditableValueHolder input = (EditableValueHolder) event.getSource();
		final String submittedValue = (String) input.getSubmittedValue();
		return submittedValue;
	}
}