package com.xu.pdf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.pdf.model.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


/**
 * @author xuhongda
 */
public class PdfTextStripperTest {


    /**
     *
     * @param document
     * @param writer
     * @throws IOException
     */
    public void getTextStripper(PDDocument document, Writer writer)
            throws IOException {
        PDFTextStripper textStripper = new PDFTextStripper();
        textStripper.writeText(document, writer);
    }

    /**
     * 提取文本内容
     *
     * @param fileName 加载文档的路径
     * @return String
     * @throws IOException
     */
    public String getText(File fileName) throws IOException {
        String textString;
        SavePdfDocument pdfDocument = new SavePdfDocument();
        PDDocument document = pdfDocument.getPdDocument(fileName);
        //将提取出来的字节流转换为字符流进行显示  
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out);
        getTextStripper(document, writer);
        document.close();
        out.close();
        writer.close();
        byte[] con = out.toByteArray();
        textString = new String(con);
        return textString;
    }

    public static String rex(String str) {
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("@");
    }

    public static void main(String[] args) {
        PedestrianReport pedestrianReport = new PedestrianReport();
        IndividualCreditReport individualCreditReport = new IndividualCreditReport();
        try {
            String filePath = "C:\\Users\\Administrator\\Desktop\\xhm.pdf";
            PdfTextStripperTest textStripperTest = new PdfTextStripperTest();
            File file = new File(filePath);
            String pdf = textStripperTest.getText(file);
            String[] strings = pdf.split("报告编号: ");
            String[] split = strings[1].split("查询时间: ");
            String reportNum = split[0];
            individualCreditReport.setReportNum(reportNum);
            String[] split1 = split[1].split("报告时间:");
            String queryTime = split1[0];
            individualCreditReport.setQueryTime(queryTime);
            String reportTime = split1[1].split("\n")[0];
            individualCreditReport.setReportTime(reportTime);
            String[] split2 = split1[1].split("\n");
            String[] split3 = split2[1].split("%姓名：(\\S+)\\s%");
            String[] split4 = split3[0].split("姓名: ");
            String[] split5 = split4[1].split("证件类型: ");
            String name = split5[0];
            individualCreditReport.setName(name);
            String idType = split5[1].split("证件号码: ")[0];
            String[] split6 = split5[1].split("证件号码: ");
            String idNO = split6[1].split("\\s")[0];
            individualCreditReport.setIdNO(idNO);
            String maritalStatus = split6[1].split("\\s")[1];
            individualCreditReport.setMaritalStatus(maritalStatus);
            String[] creditRecords = pdf.split("信贷记录");
            Record record = new Record();
            String creditRecord = creditRecords[1] + "信贷记录" + creditRecords[2].split("信息概要")[0];
            record.setCreditRecord(creditRecord);
            String publicRecords = pdf.split("公共记录")[1].split("查询记录")[0];
            record.setPublicRecords(publicRecords);
            String queryLog = pdf.split("查询记录")[1].split("机构查询记录明细")[0];
            record.setQueryLog(queryLog);
            String organizationQueryDetail = "机构查询记录明细";
            record.setOrganizationQueryDetail(organizationQueryDetail);
            String selfQueryDetail = "个人查询记录明细";
            record.setSelfQueryDetail(selfQueryDetail);
            String creditCardAccount = pdf.split("账户数")[1].split("房（包括商住两用）贷款和个人住房公积")[0];
            creditCardAccount = PdfTextStripperTest.rex(creditCardAccount);
            String[] split7 = creditCardAccount.split("@");
            String housingMortgageAccount = "";
            String otherCreditAccount = "";
            //int i = 1;
            for (int i = 0; i < split7.length; i++) {
                if (i == 1) {
                    creditCardAccount = split7[i];
                } else if (i == 2) {
                    housingMortgageAccount = split7[i];

                } else if (i == 3) {
                    otherCreditAccount = split7[i];
                }
            }
            String s = pdf.split("未结清/未销户账户数")[1].split("金贷款。")[0];
            String rex = PdfTextStripperTest.rex(s);
            String[] split8 = rex.split("@");
            String creditCardUnclearedAccount = "";
            String housingMortgageUnclearedAccount = "";
            String otherCreditUnclearedAccount = "";
            for (int i = 0; i < split8.length; i++) {
                if (i == 1) {
                    creditCardUnclearedAccount = split8[i];
                } else if (i == 2) {
                    housingMortgageUnclearedAccount = split8[i];

                } else if (i == 3) {
                    otherCreditUnclearedAccount = split8[i];
                }
            }
            String s1 = pdf.split("发生过逾期的账户数")[1].split("发生过逾期的信用卡账户，")[0];
            String rex1 = PdfTextStripperTest.rex(s1);
            String[] split9 = rex1.split("@");
            String creditCardOverdueAccount = "";
            String housingMortgageOverdueAccount = "";
            String otherCreditOverdueAccount = "";
            for (int i = 0; i < split9.length; i++) {
                if (i == 1) {
                    creditCardOverdueAccount = split9[i];
                } else if (i == 2) {
                    housingMortgageOverdueAccount = split9[i];

                } else if (i == 3) {
                    otherCreditOverdueAccount = split9[i];
                }
            }
            String s2 = pdf.split("发生过90天以上逾期的账户数")[1].split("时还最低还款额")[0];
            String rex2 = PdfTextStripperTest.rex(s2);
            String[] split10 = rex2.split("@");
            String creditCardOverdueNinetyAccount = "";
            String housingMortgageOverdueNinetyAccount = "";
            String otherCreditOverdueNinetyAccount = "";
            for (int i = 0; i < split10.length; i++) {
                if (i == 1) {
                    creditCardOverdueNinetyAccount = split10[i];
                } else if (i == 2) {
                    housingMortgageOverdueNinetyAccount = split10[i];
                } else if (i == 3) {
                    otherCreditOverdueNinetyAccount = split10[i];
                }
            }
            String s3 = pdf.split("为他人担保笔数")[1].split("支超过60天”的准贷记卡账户")[0];
            String rex3 = PdfTextStripperTest.rex(s3);
            String[] split11 = rex3.split("@");
            // 信用卡为他人担保笔数
            String creditCardGuaranteeAccount = null;
            // 购房贷款为他人担保笔数
            String housingMortgageGuaranteeAccount = null;
            // 其它贷款为他人担保笔数
            String otherCreditGuaranteeAccount = null;
            for (int i = 0; i < split11.length; i++) {
                if (i == 1) {
                    creditCardGuaranteeAccount = split11[i];
                } else if (i == 2) {
                    housingMortgageGuaranteeAccount = split11[i];

                } else if (i == 3) {
                    otherCreditGuaranteeAccount = split11[i];
                }
            }
            InformationSummary informationSummary = new InformationSummary();
            // 信用卡账户数();
            informationSummary.setCreditCardAccount(creditCardAccount);
            // 购房贷款账户数();
            informationSummary.setHousingMortgageAccount(housingMortgageAccount);
            // 其它贷款账户数();
            informationSummary.setOtherCreditAccount(otherCreditAccount);
            // 信用卡未结();
            informationSummary.setCreditCardUnclearedAccount(creditCardUnclearedAccount);
            // ();
            informationSummary.setHousingMortgageUnclearedAccount(housingMortgageUnclearedAccount);
            // 其它贷款();
            informationSummary.setOtherCreditUnclearedAccount(otherCreditUnclearedAccount);
            // 信用卡发生过逾();
            informationSummary.setCreditCardOverdueAccount(creditCardOverdueAccount);
            // 购房();
            informationSummary.setHousingMortgageOverdueAccount(housingMortgageOverdueAccount);
            // 其它贷款发生();
            informationSummary.setOtherCreditOverdueAccount(otherCreditOverdueAccount);
            // 信();
            informationSummary.setCreditCardOverdueNinetyAccount(creditCardOverdueNinetyAccount);
            informationSummary.setHousingMortgageOverdueNinetyAccount(housingMortgageOverdueNinetyAccount);
            // ();
            informationSummary.setOtherCreditOverdueNinetyAccount(otherCreditOverdueNinetyAccount);
            //
            informationSummary.setCreditCardGuaranteeAccount(creditCardGuaranteeAccount);
            informationSummary.setHousingMortgageGuaranteeAccount(housingMortgageGuaranteeAccount);
            informationSummary.setOtherCreditGuaranteeAccount(otherCreditGuaranteeAccount);
            //
            String[] split12 = pdf.split("信用卡")[1].split("其他贷款")[0].split("\r\n");
            String s4 = split12[1].split(":")[0];
            String s5 = pdf.split("信用卡")[1].split("其他贷款")[0];
            String s6 = s5.replaceAll("。截至", "@");
            String s7 = s6.split("明细如下：")[1];
            String regEx = "[。？！?.!]";
            Pattern p = Pattern.compile(regEx);
            //按照句子结束符分割句子
            String[] substrs = p.split(s7);
            //查询
            String s8 = pdf.split("说(\\s+)明")[1].split("（www.pbccrc.org.cn）查询。")[0];
            String s11 = pdf.split("机构查询记录明细")[1].split("本人查询记录明细")[0];
            String[] split13 = s11.split("\\n");
            List<Map<Integer, String>> list1 = new ArrayList();
            List<Map<Integer, String>> list2 = new ArrayList();
            List<String> list3 = new ArrayList<>();
            for (int i = 0; i < split13.length; i++) {
                String trim = split13[i].substring(0, 1).trim();
                try {
                    Integer.parseInt(trim);
                    Map<Integer, String> map1 = new HashMap(30);
                    map1.put(i, split13[i]);
                    list1.add(map1);
                    list3.add(split13[i]);
                } catch (Exception e) {
                    Map<Integer, String> map2 = new HashMap(16);
                    String s12 = split13[i];
                    map2.put(i, s12);
                    list2.add(map2);
                }
            }
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> list = new ArrayList<>();
            for (Map map : list1) {
                Set set = map.entrySet();
                for (Object o : set) {
                    Map.Entry entry = (Map.Entry) o;
                    String value = (String) entry.getValue();
                    list.add(value);
                }
            }
            List<QueryDetails> queryDetailss = new ArrayList<>(130);
            QueryDetails queryDetails;
            for (String str : list3) {
                if (str.length() > 10) {
                    queryDetails = new QueryDetails();
                    String[] split14 = str.split("\\s+");
                    for (int i = 0; i < split14.length; i++) {
                        String s15 = split14[i];
                        if (i == 0) {
                            queryDetails.setNumber(s15);
                        } else if (i == 1) {
                            queryDetails.setQueryDate(s15);
                        } else if (i == 2) {
                            queryDetails.setQueryOperator(s15);
                        } else if (i == 3) {
                            queryDetails.setQueryReason(s15);
                        }
                    }
                    queryDetailss.add(queryDetails);
                    String s16 = objectMapper.writeValueAsString(queryDetails);
                }
            }
            String s15 = pdf.split("本人查询记录明细")[1];
            String[] split14 = s15.split("\\n");
            for (int i = 0; i < split14.length; i++) {
                String trim = split14[i].substring(0, 1).trim();
                try {
                    Integer.parseInt(trim);
                    queryDetails = new QueryDetails();
                    if (split14[i].length() > 10) {
                        //空格分割
                        String[] split15 = split14[i].split("\\s+");
                        for (int i2 = 0; i2 < split15.length; i2++) {
                            String s16 = split15[i2];
                            if (i2 == 0) {
                                queryDetails.setNumber(s16);
                            } else if (i2 == 1) {
                                queryDetails.setQueryDate(s16);
                            } else if (i2 == 2) {
                                queryDetails.setQueryOperator(s16);
                            } else if (i2 == 3) {
                                queryDetails.setQueryReason(s16);
                            }
                        }
                        queryDetailss.add(queryDetails);
                    }
                } catch (Exception e) {

                }
            }
            String[] split15 = pdf.split("个人信用报告( \\s+)");
            String s17 = split15[0].split("公共记录(\\s+)")[0];
            //
            String s18 = s17.split("报告编号:")[0];
            String s19 = s17.split("支超过60天”的准贷记卡账户")[1];
            String s20 = s18 + s19;
            List<CreditCardDetails> creditCardDetailsList = new ArrayList<>();
            int i = s20.indexOf("个人信用报告");
            int i1 = s20.indexOf("为他人担保信息");
            String substring = null;
            if (i1>0){
                 substring = s20.substring(i, i1);
            }else {
                substring = s20.substring(i);
            }

            String[] split16 = substring.split("\\n");
            List<String> list4 = new ArrayList<>();
            Map<Integer, String> map1 = new HashMap<>(16);
            Map<Integer, String> map2 = new HashMap<>(16);
            Map<Integer, String> map3 = new HashMap<>(16);
            for (int j = 0; j < split16.length; j++) {
                if (j > 0) {
                    if (split16[j].length() > 4) {
                        String s21 = split16[j];
                        String substring1 = s21.substring(0, 2);
                        if ("20".equals(substring1)&&s21.length()>20) {
                            //记录
                            map1.put(j, s21.trim());
                        } else {
                            //others
                            if (s21.contains("。") || s21.contains("页")) {

                            } if (s21.contains("。")){
                                map3.put(j,s21.trim());
                            }else {
                                map2.put(j, s21.trim());
                            }
                        }
                        list4.add(s21);
                    }
                }
            }
            Set<Integer> set1 = map3.keySet();
            Iterator<Integer> iterator3 = set1.iterator();
            while (iterator3.hasNext()){
                Set<Integer> set = map1.keySet();
                Iterator<Integer> iterator = set.iterator();
                Integer next = iterator3.next();
                while (iterator.hasNext()){
                    Integer next1 = iterator.next();
                    if (next1+1 == next){
                        String str = map1.get(next1)+map3.get(next);
                        map1.put(next1,str);
                    }
                }
            }

            /*System.out.println(objectMapper.writeValueAsString(map1));
            System.out.println(objectMapper.writeValueAsString(map2));
            System.out.println(objectMapper.writeValueAsString(map3));*/
            //遍历map1
            Set<Integer> set = map1.keySet();
            Iterator<Integer> iterator1 = set.iterator();
            Integer max = 0;
            while (iterator1.hasNext()) {
                max = iterator1.next();
            }
            //遍历map2
            Set<Integer> integers = map2.keySet();
            Iterator<Integer> iterator = integers.iterator();
            //biaoji
            Integer xinyongka = 0;
            Integer fangdai = 0;
            Integer qita = 0;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                String map2Value = map2.get(next);
                if ("信用卡".equals(map2Value)) {
                    xinyongka = next;
                } else if ("购房贷款".equals(map2Value)) {
                    fangdai = next;
                } else if ("其他贷款".equals(map2Value)) {
                    qita = next;
                }
            }
            if (i1 != -1) {
                CreditCardDetails creditCardDetails = new CreditCardDetails();
                creditCardDetails.setLoanType("为他人担保信息");
                String substring1 = s20.split("为他人担保信息")[1];
                String[] split17 = substring1.split("\\n");
                List<String> details = new ArrayList<>();
                for (int j = 0; j < split17.length-1; j++) {
                    if (j%2!=0&&j!=0){
                        String s16 = split17[j] + split17[j + 1];
                        details.add(s16);
                    }
                }
                creditCardDetails.setDetail(details);
                creditCardDetailsList.add(creditCardDetails);
            }
            if (xinyongka == 0 && fangdai == 0 && qita == 0) {
                //都没有
                creditCardDetailsList.add(null);
            } else if (xinyongka != 0 && fangdai == 0 && qita == 0) {
                //只有信用卡
                CreditCardDetails creditCardDetails = new CreditCardDetails();
                creditCardDetails.setLoanType(map1.get(xinyongka));
                creditCardDetails.setHeading(map1.get(xinyongka + 1));
                List<String> details = new ArrayList<>(20);
                //遍历map1
                for (int i4 = xinyongka + 2; i4 <= max; i4++) {
                    if (map1.get(i4) != null) {
                        details.add(map1.get(i4));
                    }
                }
                creditCardDetailsList.add(creditCardDetails);
            } else if (xinyongka == 0 && fangdai != 0 && qita == 0) {
                //只有房贷
                CreditCardDetails creditCardDetails001 = null;
                CreditCardDetails creditCardDetails002 = null;
                //
                Set<Integer> integers2 = map2.keySet();
                Iterator<Integer> iterator2 = integers2.iterator();
                Integer x1 = 0;
                Integer x2 = 0;
                while (iterator.hasNext()) {
                    Integer next = iterator2.next();
                    String x = map2.get(next);
                    if (x.length() > 0) {
                        if ("发生过逾期的账户明细如下".equals(x)) {
                            x1 = next;
                            creditCardDetails001 = new CreditCardDetails();
                        } else if ("从未逾期过的账户明细如下".equals(x)) {
                            x2 = next;
                            creditCardDetails002 = new CreditCardDetails();
                        }
                    }

                }
                if (x1 != 0 && x2 == 0) {
                    creditCardDetails001.setLoanType("购房贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 == 0 && x2 != 0) {
                    creditCardDetails002.setLoanType("购房贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 != 0 && x2 != 0) {
                    creditCardDetails001.setLoanType("购房贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    creditCardDetails002.setLoanType("购房贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    List<String> list6 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 < x2; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list6.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list6);
                    creditCardDetailsList.add(creditCardDetails001);
                    creditCardDetailsList.add(creditCardDetails002);
                }
            } else if (xinyongka == 0 && fangdai == 0 && qita != 0) {
                //其他贷款
                CreditCardDetails creditCardDetails001 = null;
                CreditCardDetails creditCardDetails002 = null;
                //
                Set<Integer> integers2 = map2.keySet();
                Iterator<Integer> iterator2 = integers2.iterator();
                Integer x1 = 0;
                Integer x2 = 0;
                while (iterator.hasNext()) {
                    Integer next = iterator2.next();
                    String x = map2.get(next);
                    if (x.length() > 12) {
                        if ("发生过逾期的账户明细如下".equals(x)) {
                            x1 = next;
                            creditCardDetails001 = new CreditCardDetails();
                        } else if ("从未逾期过的账户明细如下".equals(x)) {
                            x2 = next;
                            creditCardDetails002 = new CreditCardDetails();
                        }
                    }
                }
                if (x1 != 0 && x2 == 0) {
                    creditCardDetails001.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 == 0 && x2 != 0) {
                    creditCardDetails002.setLoanType("其他贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 != 0 && x2 != 0) {
                    creditCardDetails001.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    creditCardDetails002.setLoanType("其他贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    List<String> list6 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 < x2; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list6.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list6);
                    creditCardDetailsList.add(creditCardDetails001);
                    creditCardDetailsList.add(creditCardDetails002);
                }
            } else if (xinyongka != 0 && fangdai != 0 && qita == 0) {
                //信用卡
                CreditCardDetails creditCardDetails = new CreditCardDetails();
                creditCardDetails.setLoanType(map1.get(xinyongka));
                creditCardDetails.setHeading(map1.get(xinyongka + 1));
                List<String> details = new ArrayList<>(20);
                //遍历map1
                for (int i4 = xinyongka + 2; i4 < fangdai; i4++) {
                    if (map1.get(i4) != null) {
                        details.add(map1.get(i4));
                    }
                }
                creditCardDetailsList.add(creditCardDetails);

                //其他贷款
                CreditCardDetails creditCardDetails001 = null;
                CreditCardDetails creditCardDetails002 = null;
                //
                Set<Integer> integers2 = map2.keySet();
                Iterator<Integer> iterator2 = integers2.iterator();
                Integer next = iterator2.next();
                Integer x1 = 0;
                Integer x2 = 0;
                while (iterator.hasNext()) {
                    String x = map2.get(next);
                    if (x.length() > 12) {
                        if ("发生过逾期的账户明细如下".equals(x.substring(0, 12))) {
                            x1 = next;
                            creditCardDetails001 = new CreditCardDetails();
                        } else if ("从未逾期过的账户明细如下".equals(x.substring(0, 12))) {
                            x2 = next;
                            creditCardDetails002 = new CreditCardDetails();
                        }
                    }

                }
                if (x1 != 0 && x2 == 0) {
                    creditCardDetails001.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 == 0 && x2 != 0) {
                    creditCardDetails002.setLoanType("其他贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 != 0 && x2 != 0) {
                    creditCardDetails001.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    creditCardDetails002.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    List<String> list6 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 < x2; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list6.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list6);
                    creditCardDetailsList.add(creditCardDetails001);
                    creditCardDetailsList.add(creditCardDetails002);
                }

            } else if (xinyongka != 0 && fangdai == 0 && qita != 0) {
                //信用卡
                CreditCardDetails creditCardDetails = new CreditCardDetails();
                creditCardDetails.setLoanType(map2.get(xinyongka));
                creditCardDetails.setHeading(map2.get(xinyongka + 1));
                List<String> details = new ArrayList<>(20);
                for (int i4 = xinyongka + 2; i4 < qita; i4++) {
                    if (map1.get(i4) != null) {
                        details.add(map1.get(i4));
                    }
                }
                creditCardDetails.setDetail(details);
                creditCardDetailsList.add(creditCardDetails);
                //其他贷款
                CreditCardDetails creditCardDetails001 = null;
                CreditCardDetails creditCardDetails002 = null;
                //两小项标记
                Integer x1 = 0;
                Integer x2 = 0;
                Set<Integer> integers2 = map2.keySet();
                Iterator<Integer> iterator2 = integers2.iterator();
                //获取两小项index
                while (iterator2.hasNext()) {
                    Integer next = iterator2.next();
                    String x = map2.get(next);
                    System.out.println(x);
                    if (x.length() > 12) {
                        System.out.println(x.substring(0, 12));
                        if ("发生过逾期的账户明细如下".equals(x.substring(0, 12))) {
                            x1 = next;
                            creditCardDetails001 = new CreditCardDetails();
                        } else if ("从未逾期过的账户明细如下".equals(x.substring(0, 12))) {
                            x2 = next;
                            creditCardDetails002 = new CreditCardDetails();
                        }
                    }
                }
                //条件判断
                if (x1 != 0 && x2 == 0) {
                    creditCardDetails001.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 == 0 && x2 != 0) {
                    creditCardDetails002.setLoanType("其他贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails002);
                } else if (x1 != 0 && x2 != 0) {
                    creditCardDetails001.setLoanType("其他贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    creditCardDetails002.setLoanType("其他贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    List<String> list6 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 < x2; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    for (int i4 = x2 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list6.add(map1.get(i4));
                        }
                    }
                    creditCardDetails002.setDetail(list6);
                    creditCardDetailsList.add(creditCardDetails001);
                    creditCardDetailsList.add(creditCardDetails002);
                }
            } else if (xinyongka == 0 && fangdai != 0 && qita != 0) {
                //只有房贷
                CreditCardDetails creditCardDetails001 = null;
                CreditCardDetails creditCardDetails002 = null;
                //
                Integer x1 = 0;
                Integer x2 = 0;
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    String x = map2.get(next);
                    if (next<qita){
                        if (x.length() > 12) {
                            if ("发生过逾期的账户明细如下".equals(x.substring(0, 12))) {
                                x1 = next;
                                creditCardDetails001 = new CreditCardDetails();
                            } else if ("从未逾期过的账户明细如下".equals(x.substring(0, 12))) {
                                x2 = next;
                                creditCardDetails002 = new CreditCardDetails();
                            }
                        }
                    }
                }
                if (x1 != 0 && x2 == 0) {
                    creditCardDetails001.setLoanType("购房贷款");
                    creditCardDetails001.setHeading("发生过逾期的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x1 + 1; i4 < qita; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails001.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails001);
                } else if (x1 == 0 && x2 != 0) {
                    creditCardDetails002.setLoanType("购房贷款");
                    creditCardDetails002.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    for (int i4 = x2 + 1; i4 < qita; i4++) {
                        if (map1.get(i4) != null) {
                            if (map1.get(i4) != null) {
                                list5.add(map1.get(i4));
                            }
                        }
                    }
                    creditCardDetails002.setDetail(list5);
                    creditCardDetailsList.add(creditCardDetails002);
                    //其他贷款
                    CreditCardDetails creditCardDetails003 = null;
                    CreditCardDetails creditCardDetails004 = null;
                    //
                    Integer x3 = 0;
                    Integer x4 = 0;
                    while (iterator.hasNext()) {
                        Integer next = iterator.next();
                        String x = map2.get(next);
                        if (next>qita){
                            if (x.length() > 12) {
                                if ("发生过逾期的账户明细如下".equals(x.substring(0, 12))) {
                                    x3 = next;
                                    creditCardDetails003 = new CreditCardDetails();
                                } else if ("从未逾期过的账户明细如下".equals(x.substring(0, 12))) {
                                    x4 = next;
                                    creditCardDetails004 = new CreditCardDetails();
                                }
                            }
                        }
                    }
                    if (x3 != 0 && x4 == 0) {
                        creditCardDetails003.setLoanType("其他贷款");
                        creditCardDetails003.setHeading("发生过逾期的账户明细如下:");
                        List<String> list6 = new ArrayList<>();
                        for (int i4 = x3 + 1; i4 <= max; i4++) {
                            if (map1.get(i4) != null){
                                list6.add(map1.get(i4));
                            }
                        }
                        creditCardDetails003.setDetail(list6);
                        creditCardDetailsList.add(creditCardDetails003);
                    } else if (x3 == 0 && x4 != 0) {
                        creditCardDetails004.setLoanType("其他贷款");
                        creditCardDetails004.setHeading("从未逾期过的账户明细如下:");
                        List<String> list6 = new ArrayList<>();
                        for (int i4 = x4 + 3; i4 <= max; i4++) {
                            if (map1.get(i4) != null) {
                                list6.add(map1.get(i4));
                            }
                        }
                        creditCardDetails004.setDetail(list6);
                        creditCardDetailsList.add(creditCardDetails003);
                    } else if (x3 != 0 && x4 != 0) {
                        creditCardDetails003.setLoanType("其他贷款");
                        creditCardDetails003.setHeading("发生过逾期的账户明细如下:");
                        creditCardDetails004.setLoanType("其他贷款");
                        creditCardDetails004.setHeading("从未逾期过的账户明细如下:");
                        List<String> list6 = new ArrayList<>();
                        for (int i4 = x3 + 1; i4 < x4; i4++) {
                            if (map1.get(i4) != null) {
                                list6.add(map1.get(i4));
                            }
                        }
                        for (int i4 = x4 + 1; i4 <= max; i4++) {
                            if (map1.get(i4) != null) {
                                list6.add(map1.get(i4));
                            }
                        }
                        creditCardDetailsList.add(creditCardDetails003);
                        creditCardDetailsList.add(creditCardDetails004);
                    }
                }
            } else if (xinyongka != 0 && fangdai != 0 && qita != 0) {
                //信用卡
                CreditCardDetails creditCardDetails = new CreditCardDetails();
                creditCardDetails.setLoanType(map2.get(xinyongka));
                creditCardDetails.setHeading(map2.get(xinyongka + 1));
                List<String> details = new ArrayList<>(20);
                //遍历map1
                for (int i4 = xinyongka + 2; i4 < fangdai; i4++) {
                    if (map1.get(i4) != null) {
                        details.add(map1.get(i4));
                    }
                }
                creditCardDetails.setDetail(details);
                creditCardDetailsList.add(creditCardDetails);
                /**/
                //房贷
                CreditCardDetails creditCardDetails006 = null;
                CreditCardDetails creditCardDetails007 = null;
                //
                Set<Integer> integers2 = map2.keySet();
                Iterator<Integer> iterator2 = integers2.iterator();
                Integer x6 = 0;
                Integer x7 = 0;
                //
                int ii = 0;
                int iii = 0;
                while (iterator2.hasNext()) {
                    Integer next = iterator2.next();
                    String x = map2.get(next);
                    if (x.length() > 12) {
                        if ("发生过逾期的账户明细如下".equals(x.substring(0, 12))){
                            ii++;
                            if (ii==1){
                                x6 = next;
                                creditCardDetails006 = new CreditCardDetails();
                            }
                        } else if ("从未逾期过的账户明细如下".equals(x.substring(0, 12))) {
                            iii++;
                            if (iii == 1){
                                x7 = next;
                                creditCardDetails007 = new CreditCardDetails();
                            }
                        }
                    }
                }
                if (x6 != 0 && x7 == 0) {
                    creditCardDetails006.setLoanType("购房贷款");
                    creditCardDetails006.setHeading("发生过逾期的账户明细如下:");
                    List<String> list6 = new ArrayList<>();
                    for (int i4 = x6 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list6.add(map1.get(i4));
                        }
                    }
                    creditCardDetails006.setDetail(list6);
                    creditCardDetailsList.add(creditCardDetails006);
                } else if (x6 == 0 && x7 != 0) {
                    creditCardDetails007.setLoanType("购房贷款");
                    creditCardDetails007.setHeading("从未逾期过的账户明细如下:");
                    List<String> list7 = new ArrayList<>();
                    for (int i4 = x7 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list7.add(map1.get(i4));
                        }
                    }
                    creditCardDetails007.setDetail(list7);
                    creditCardDetailsList.add(creditCardDetails007);
                } else if (x6 != 0 && x7 != 0) {
                    creditCardDetails006.setLoanType("购房贷款");
                    creditCardDetails006.setHeading("发生过逾期的账户明细如下:");
                    creditCardDetails007.setLoanType("购房贷款");
                    creditCardDetails007.setHeading("从未逾期过的账户明细如下:");
                    List<String> list5 = new ArrayList<>();
                    List<String> list6 = new ArrayList<>();
                    for (int i4 = x6 + 1; i4 < x7; i4++) {
                        if (map1.get(i4) != null) {
                            list5.add(map1.get(i4));
                        }
                    }
                    creditCardDetails006.setDetail(list5);
                    for (int i4 = x7 + 1; i4 <= qita; i4++) {
                        if (map1.get(i4) != null) {
                            list6.add(map1.get(i4));
                        }
                    }
                    creditCardDetails007.setDetail(list6);
                    creditCardDetailsList.add(creditCardDetails006);
                    creditCardDetailsList.add(creditCardDetails007);
                }
                //其他贷款
                CreditCardDetails creditCardDetails008 = null;
                CreditCardDetails creditCardDetails009 = null;
                //
                Set<Integer> integers3 = map2.keySet();
                Iterator<Integer> iterator4 = integers3.iterator();
                Integer x8 = 0;
                Integer x9 = 0;
                while (iterator4.hasNext()) {
                    Integer next = iterator4.next();
                    String x = map2.get(next);
                    if (next>qita){
                        if (x.length() > 12) {
                            if ("发生过逾期的账户明细如下".equals(x.substring(0, 12))) {
                                x8 = next;
                                creditCardDetails008 = new CreditCardDetails();
                            } else if ("从未逾期过的账户明细如下".equals(x.substring(0, 12))) {
                                x9 = next;
                                creditCardDetails009 = new CreditCardDetails();
                            }
                        }
                    }
                }
                if (x8 != 0 && x9 == 0) {
                    creditCardDetails008.setLoanType("其他贷款");
                    creditCardDetails008.setHeading("发生过逾期的账户明细如下:");
                    List<String> list7 = new ArrayList<>();
                    for (int i4 = x8 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list7.add(map1.get(i4));
                        }
                    }
                    creditCardDetails008.setDetail(list7);
                    creditCardDetailsList.add(creditCardDetails008);
                } else if (x8 == 0 && x9 != 0) {
                    creditCardDetails009.setLoanType("其他贷款");
                    creditCardDetails009.setHeading("从未逾期过的账户明细如下:");
                    List<String> list7 = new ArrayList<>();
                    for (int i4 = x9 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list7.add(map1.get(i4));
                        }
                    }
                    creditCardDetails009.setDetail(list7);
                    creditCardDetailsList.add(creditCardDetails009);
                } else if (x8 != 0 && x9 != 0) {
                    creditCardDetails008.setLoanType("其他贷款");
                    creditCardDetails008.setHeading("发生过逾期的账户明细如下:");
                    creditCardDetails009.setLoanType("其他贷款");
                    creditCardDetails009.setHeading("从未逾期过的账户明细如下:");
                    List<String> list7 = new ArrayList<>();
                    List<String> list8 = new ArrayList<>();
                    for (int i4 = x8 + 1; i4 < x9; i4++) {
                        if (map1.get(i4) != null) {
                            list7.add(map1.get(i4));
                        }
                    }
                    creditCardDetails008.setDetail(list7);
                    for (int i4 = x9 + 1; i4 <= max; i4++) {
                        if (map1.get(i4) != null) {
                            list8.add(map1.get(i4));
                        }
                    }
                    creditCardDetails009.setDetail(list8);
                    creditCardDetailsList.add(creditCardDetails008);
                    creditCardDetailsList.add(creditCardDetails009);
                }
            }
            pedestrianReport.setRecord(record);
            pedestrianReport.setIndividualCreditReport(individualCreditReport);
            pedestrianReport.setInformationSummary(informationSummary);
            pedestrianReport.setQueryDetailsList(queryDetailss);
            pedestrianReport.setCreditCardDetailsList(creditCardDetailsList);
            String s16 = objectMapper.writeValueAsString(pedestrianReport);
            System.out.println(s16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}