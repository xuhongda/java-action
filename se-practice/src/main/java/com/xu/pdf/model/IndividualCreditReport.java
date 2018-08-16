package com.xu.pdf.model;

/**
 * 个人信用报告首页实体类
 * 
 * @author tanchao 2017/9/14
 *
 */
public class IndividualCreditReport {
	private String reportNum;// 报告编号
	private String queryTime;// 查询时间
	private String reportTime;// 报告时间
	private String name;// 姓名
	private String idType;// 证件类型
	private String idNO;// 证件号码
	private String maritalStatus;// 婚姻状态

	public String getReportNum() {
		return reportNum;
	}

	public void setReportNum(String reportNum) {
		this.reportNum = reportNum;
	}

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNO() {
		return idNO;
	}

	public void setIdNO(String idNO) {
		this.idNO = idNO;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "IndividualCreditReport [reportNum=" + reportNum + ", queryTime=" + queryTime + ", reportTime="
				+ reportTime + ", name=" + name + ", idType=" + idType + ", idNO=" + idNO + ", maritalStatus="
				+ maritalStatus + "]";
	}

}
