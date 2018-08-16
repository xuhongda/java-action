package com.xu.pdf.model;

import java.util.List;

/**
 * 人行报告实体根类
 *
 * @author tanchao 2017/9/14
 */
public class PedestrianReport {
    private IndividualCreditReport individualCreditReport;//个人信用报告首页实体类对象
    private Record record;//人行报告记录实体类对象
    private InformationSummary informationSummary;//信息概要实体类对象
    private List<CreditCardDetails> creditCardDetailsList;//贷款类型及其明细实体类对象集合
    private List<QueryDetails> queryDetailsList;//查询明细实体类对象集合


    public IndividualCreditReport getIndividualCreditReport() {
        return individualCreditReport;
    }

    public void setIndividualCreditReport(IndividualCreditReport individualCreditReport) {
        this.individualCreditReport = individualCreditReport;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public InformationSummary getInformationSummary() {
        return informationSummary;
    }

    public void setInformationSummary(InformationSummary informationSummary) {
        this.informationSummary = informationSummary;
    }

    public List<CreditCardDetails> getCreditCardDetailsList() {
        return creditCardDetailsList;
    }

    public void setCreditCardDetailsList(List<CreditCardDetails> creditCardDetailsList) {
        this.creditCardDetailsList = creditCardDetailsList;
    }

    public List<QueryDetails> getQueryDetailsList() {
        return queryDetailsList;
    }

    public void setQueryDetailsList(List<QueryDetails> queryDetailsList) {
        this.queryDetailsList = queryDetailsList;
    }

    @Override
    public String toString() {
        return "PedestrianReport [individualCreditReport=" + individualCreditReport + ", record=" + record
                + ", informationSummary=" + informationSummary + ", creditCardDetailsList=" + creditCardDetailsList
                + ", queryDetailsList=" + queryDetailsList + "]";
    }
}