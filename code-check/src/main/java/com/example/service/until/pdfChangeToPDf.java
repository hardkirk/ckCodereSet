package com.example.service.until;

import com.itextpdf.text.PageSize;
import lombok.extern.slf4j.Slf4j;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author chuke
 * @create 2020/8/19 20:07
 */
@Slf4j
public class pdfChangeToPDf {
        public static void convert(String source, String target) {
            Document document = new Document(PageSize.A4, 10, 10, 50, 50);
            //设置文档页边距
            document.setMargins(0,0,0,0);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(target);
                PdfWriter.getInstance(document, fos);
                //打开文档
                document.open();
                //获取图片的宽高
                Image image = Image.getInstance(source);
                float imageHeight=image.getScaledHeight();
                float imageWidth=image.getScaledWidth();
                //设置页面宽高与图片一致
                Rectangle rectangle = new Rectangle(imageWidth, imageHeight);
                document.setPageSize(rectangle);
                //图片居中
                image.setAlignment(Image.ALIGN_CENTER);
                //新建一页添加图片
                document.newPage();
                document.add(image);
            } catch (Exception ioe) {
                System.out.println(ioe.getMessage());
            } finally {
                //关闭文档
                document.close();
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        public static void main(String[] args) throws IOException {
            PDDocument document = new PDDocument();
            File file = new File("D:/uploadfile/sss");
            if (!file.exists())
                file.mkdir();
            document.addPage(new PDPage());
            document.save("D:/uploadfile/sss/333.pdf");
            document.close();/*
            String source = "D:/uploadfile/null/777.jpg";
            String target = "D:/uploadfile/null/777.PDF";
            convert(source, target);*/
        }

}
