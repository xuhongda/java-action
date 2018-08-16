package com.xu.pdf.model;

/**
 * 查询明细实体类
 * 
 * @author tanchao 2017/9/14
 *
 */
public class QueryDetails {
	private String number;// 编号
	private String queryDate;// 查询日期
	private String queryOperator;// 查询操作员
	private String queryReason;// 查询原因

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getQueryOperator() {
		return queryOperator;
	}

	public void setQueryOperator(String queryOperator) {
		this.queryOperator = queryOperator;
	}

	public String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}

	@Override
	public String toString() {
		return "QueryDetails [number=" + number + ", queryDate=" + queryDate + ", queryOperator=" + queryOperator
				+ ", queryReason=" + queryReason + "]";
	}

}
