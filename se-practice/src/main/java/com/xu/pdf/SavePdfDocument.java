package com.xu.pdf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

/** 
 * SavePdfDocument类用于产生pdf文档 
 * @author Administrator 
 * http://www.xlgps.com/article/408957.html
 * @date 2014-8-31 
 * @version 1.0.0 
 */  
public class SavePdfDocument {  
  
    /** 
     * 日志常量 
     */  
    public static final Log logger=LogFactory.getLog(SavePdfDocument.class);
      
      
    /** 
     * 测试产生pdf文档 
     * @param sayWhat 要写入到pdf文档中的内容 
     * @param filePath 保存pdf的路径 
     * @throws IOException  
     * @throws
     *  
     */  
    public  boolean helloPdf(String sayWhat,String filePath) throws IOException{
        boolean f=false;  
        PDDocument document=getPdDocument();
        PDPage page=getPdPage();
        document.addPage(page);  
          
        PDFont font=getFont();
          
        PDPageContentStream contentStream=getPdPageContentStream(document, page);
          
        contentStream.beginText();  
          contentStream.setFont(font, 20);  
          contentStream.moveTextPositionByAmount(200, 300);  
          /* COSString cosString=new COSString(new String(sayWhat.getBytes(), "UTF-16BE")); 
         contentStream.drawString("hello world"+"\t");*/  
          //contentStream.drawString("hello world"+cosString.getString());  
          contentStream.drawString(sayWhat);  
          contentStream.endText();  
        //关闭页面内容流  
        contentStream.close();  
          
        document.save(filePath);  
        document.close();  
          
        logger.info("成功创建pdf");  
        f=true;  
        return f;  
    }  
      
      
  
      
      
      
      
    /** 
     * 获取空的pdf文档对象 
     * @return PDDocument 
     */  
    public PDDocument getPdDocument(){
        PDDocument document=new PDDocument();
        return document;  
    }  
      
    /** 
     * 通过文件名加载文档 
     * @param fileName 
     * @return PDDocument 
     * @throws IOException 
     */  
    public PDDocument getPdDocument(File fileName) throws IOException{
        PDDocument document=PDDocument.load(fileName);
        return document;  
    }  
      
    /** 
     * 获取空的pdf页面对象 
     * @return PDPage 
     */  
    public PDPage getPdPage(){
        PDPage page =new PDPage();
        return page;  
    }  
  
    /** 
     * 获取海维提卡体 
     * @return PDFont 
     */  
    public PDFont getFont(){
        PDFont font=PDType1Font.HELVETICA_BOLD;
        return font;  
    }  
      
    /** 
     * 获取页面内容流 向页面添加内容 
     * @param document PDDocument 
     * @param page PDPage 
     * @return PDPageContentStream 
     * @throws IOException 
     */  
    public PDPageContentStream getPdPageContentStream(PDDocument document, PDPage page) throws IOException{
        PDPageContentStream contentStream=new PDPageContentStream(document, page);  
        return contentStream;  
    }  
      
}  