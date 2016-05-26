package com.ibm.digital.bean;

import java.util.List;

public class FormBean {
	private String ss;
	private String operationType;
	private String productName;
	private String productTitle;
	private String productContent;
	private String productUrl;
	private String userId;
	private String productId;
	private List<String> filelist;
	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}
	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productTitle
	 */
	public String getProductTitle() {
		return productTitle;
	}
	/**
	 * @param productTitle the productTitle to set
	 */
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	/**
	 * @return the productContent
	 */
	public String getProductContent() {
		return productContent;
	}
	/**
	 * @param productContent the productContent to set
	 */
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	/**
	 * @return the productUrl
	 */
	public String getProductUrl() {
		return productUrl;
	}
	/**
	 * @param productUrl the productUrl to set
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the filelist
	 */
	public List<String> getFilelist() {
		return filelist;
	}
	/**
	 * @param filelist the filelist to set
	 */
	public void setFilelist(List<String> filelist) {
		this.filelist = filelist;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FormBean [operationType=" + operationType + ", productName="
				+ productName + ", productTitle=" + productTitle
				+ ", productContent=" + productContent + ", productUrl="
				+ productUrl + ", userId=" + userId + ", productId="
				+ productId + ", filelist=" + filelist + "]";
	}
	
}
