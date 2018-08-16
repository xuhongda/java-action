package com.xu.pdf.model;

/**
 * 信息概要实体类
 * 
 * @author tanchao 2017/9/14
 *
 */
public class InformationSummary {
	private String creditCardAccount;// 信用卡账户数
	private String housingMortgageAccount;// 购房贷款账户数
	private String otherCreditAccount;// 其它贷款账户数
	private String creditCardUnclearedAccount;// 信用卡未结清账户数
	private String housingMortgageUnclearedAccount;// 购房贷款未结清账户数
	private String otherCreditUnclearedAccount;// 其它贷款未结清账户数
	private String creditCardOverdueAccount;// 信用卡发生过逾期的账户数
	private String housingMortgageOverdueAccount;// 购房贷款发生过逾期的账户数
	private String otherCreditOverdueAccount;// 其它贷款发生过逾期的账户数
	private String creditCardOverdueNinetyAccount;// 信用卡发生过逾期90天以上的账户数
	private String housingMortgageOverdueNinetyAccount;// 购房贷款发生过逾期90天以上的账户数
	private String otherCreditOverdueNinetyAccount;// 其它贷款发生过逾期90天以上的账户数
	private String creditCardGuaranteeAccount;// 信用卡为他人担保笔数
	private String housingMortgageGuaranteeAccount;// 购房贷款为他人担保笔数
	private String otherCreditGuaranteeAccount;// 其它贷款为他人担保笔数

	public String getCreditCardAccount() {
		return creditCardAccount;
	}

	public void setCreditCardAccount(String creditCardAccount) {
		this.creditCardAccount = creditCardAccount;
	}

	public String getHousingMortgageAccount() {
		return housingMortgageAccount;
	}

	public void setHousingMortgageAccount(String housingMortgageAccount) {
		this.housingMortgageAccount = housingMortgageAccount;
	}

	public String getOtherCreditAccount() {
		return otherCreditAccount;
	}

	public void setOtherCreditAccount(String otherCreditAccount) {
		this.otherCreditAccount = otherCreditAccount;
	}

	public String getCreditCardUnclearedAccount() {
		return creditCardUnclearedAccount;
	}

	public void setCreditCardUnclearedAccount(String creditCardUnclearedAccount) {
		this.creditCardUnclearedAccount = creditCardUnclearedAccount;
	}

	public String getHousingMortgageUnclearedAccount() {
		return housingMortgageUnclearedAccount;
	}

	public void setHousingMortgageUnclearedAccount(String housingMortgageUnclearedAccount) {
		this.housingMortgageUnclearedAccount = housingMortgageUnclearedAccount;
	}

	public String getOtherCreditUnclearedAccount() {
		return otherCreditUnclearedAccount;
	}

	public void setOtherCreditUnclearedAccount(String otherCreditUnclearedAccount) {
		this.otherCreditUnclearedAccount = otherCreditUnclearedAccount;
	}

	public String getCreditCardOverdueAccount() {
		return creditCardOverdueAccount;
	}

	public void setCreditCardOverdueAccount(String creditCardOverdueAccount) {
		this.creditCardOverdueAccount = creditCardOverdueAccount;
	}

	public String getHousingMortgageOverdueAccount() {
		return housingMortgageOverdueAccount;
	}

	public void setHousingMortgageOverdueAccount(String housingMortgageOverdueAccount) {
		this.housingMortgageOverdueAccount = housingMortgageOverdueAccount;
	}

	public String getOtherCreditOverdueAccount() {
		return otherCreditOverdueAccount;
	}

	public void setOtherCreditOverdueAccount(String otherCreditOverdueAccount) {
		this.otherCreditOverdueAccount = otherCreditOverdueAccount;
	}

	public String getCreditCardOverdueNinetyAccount() {
		return creditCardOverdueNinetyAccount;
	}

	public void setCreditCardOverdueNinetyAccount(String creditCardOverdueNinetyAccount) {
		this.creditCardOverdueNinetyAccount = creditCardOverdueNinetyAccount;
	}

	public String getHousingMortgageOverdueNinetyAccount() {
		return housingMortgageOverdueNinetyAccount;
	}

	public void setHousingMortgageOverdueNinetyAccount(String housingMortgageOverdueNinetyAccount) {
		this.housingMortgageOverdueNinetyAccount = housingMortgageOverdueNinetyAccount;
	}

	public String getOtherCreditOverdueNinetyAccount() {
		return otherCreditOverdueNinetyAccount;
	}

	public void setOtherCreditOverdueNinetyAccount(String otherCreditOverdueNinetyAccount) {
		this.otherCreditOverdueNinetyAccount = otherCreditOverdueNinetyAccount;
	}

	public String getCreditCardGuaranteeAccount() {
		return creditCardGuaranteeAccount;
	}

	public void setCreditCardGuaranteeAccount(String creditCardGuaranteeAccount) {
		this.creditCardGuaranteeAccount = creditCardGuaranteeAccount;
	}

	public String getHousingMortgageGuaranteeAccount() {
		return housingMortgageGuaranteeAccount;
	}

	public void setHousingMortgageGuaranteeAccount(String housingMortgageGuaranteeAccount) {
		this.housingMortgageGuaranteeAccount = housingMortgageGuaranteeAccount;
	}

	public String getOtherCreditGuaranteeAccount() {
		return otherCreditGuaranteeAccount;
	}

	public void setOtherCreditGuaranteeAccount(String otherCreditGuaranteeAccount) {
		this.otherCreditGuaranteeAccount = otherCreditGuaranteeAccount;
	}

	@Override
	public String toString() {
		return "InformationSummary [creditCardAccount=" + creditCardAccount + ", housingMortgageAccount="
				+ housingMortgageAccount + ", otherCreditAccount=" + otherCreditAccount
				+ ", creditCardUnclearedAccount=" + creditCardUnclearedAccount + ", housingMortgageUnclearedAccount="
				+ housingMortgageUnclearedAccount + ", otherCreditUnclearedAccount=" + otherCreditUnclearedAccount
				+ ", creditCardOverdueAccount=" + creditCardOverdueAccount + ", housingMortgageOverdueAccount="
				+ housingMortgageOverdueAccount + ", otherCreditOverdueAccount=" + otherCreditOverdueAccount
				+ ", creditCardOverdueNinetyAccount=" + creditCardOverdueNinetyAccount
				+ ", housingMortgageOverdueNinetyAccount=" + housingMortgageOverdueNinetyAccount
				+ ", otherCreditOverdueNinetyAccount=" + otherCreditOverdueNinetyAccount
				+ ", creditCardGuaranteeAccount=" + creditCardGuaranteeAccount + ", housingMortgageGuaranteeAccount="
				+ housingMortgageGuaranteeAccount + ", otherCreditGuaranteeAccount=" + otherCreditGuaranteeAccount
				+ "]";
	}

}