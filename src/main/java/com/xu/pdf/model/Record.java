package com.xu.pdf.model;

/**
 * 人行报告记录实体类
 * 
 * @author tanchao 2017/9/14
 *
 */
public class Record {
	private String creditRecord;// 信贷记录
	private String publicRecords;// 公共记录
	private String queryLog; // 查询记录
	private String organizationQueryDetail;// 机构查询记录明细
	private String selfQueryDetail;// 个人查询记录明细

	public String getCreditRecord() {
		return creditRecord;
	}

	public void setCreditRecord(String creditRecord) {
		this.creditRecord = creditRecord;
	}

	public String getPublicRecords() {
		return publicRecords;
	}

	public void setPublicRecords(String publicRecords) {
		this.publicRecords = publicRecords;
	}

	public String getQueryLog() {
		return queryLog;
	}

	public void setQueryLog(String queryLog) {
		this.queryLog = queryLog;
	}

	public String getOrganizationQueryDetail() {
		return organizationQueryDetail;
	}

	public void setOrganizationQueryDetail(String organizationQueryDetail) {
		this.organizationQueryDetail = organizationQueryDetail;
	}

	public String getSelfQueryDetail() {
		return selfQueryDetail;
	}

	public void setSelfQueryDetail(String selfQueryDetail) {
		this.selfQueryDetail = selfQueryDetail;
	}

	@Override
	public String toString() {
		return "Record [creditRecord=" + creditRecord + ", publicRecords=" + publicRecords + ", queryLog=" + queryLog
				+ ", organizationQueryDetail=" + organizationQueryDetail + ", selfQueryDetail=" + selfQueryDetail + "]";
	}

}