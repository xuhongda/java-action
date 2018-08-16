package com.xu.pdf.model;

import java.util.List;

/**
 * 贷款类型及其明细实体类
 * 
 * @author tanchao 2017/9/14
 *
 */
public class CreditCardDetails {
	private String loanType;// 贷款类型
	private String heading;//标题
	private List<String> detail;//明细
//	private String overdueDetailHeading;// 发生过逾期这个标题
//	private String overdueDetail;// 发生过逾期的明细
//	private String neverOverdueDetailHeading;// 从未逾期过的这个标题
//	private String neverOverdueDetail;// 从未逾期过的明细

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}


	public List<String> getDetail() {
		return detail;
	}

	public void setDetail(List<String> detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "CreditCardDetails [loanType=" + loanType + ", heading=" + heading + ", detail=" + detail + "]";
	}

	

	

}
