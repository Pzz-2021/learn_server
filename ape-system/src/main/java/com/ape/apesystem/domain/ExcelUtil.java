package com.ape.apesystem.domain;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel相关处理
 * @author pw
 */
public class ExcelUtil {
    /**
     *  单个sheet页导出
     */
    public static void writeExcel(HttpServletResponse response, List<?> data, String fileName, String sheetName, Class<?> clazz) throws Exception {
        EasyExcel.write(getOutputStream(fileName, response), clazz)
                .excelType(ExcelTypeEnum.XLSX).sheet(sheetName)
                .registerWriteHandler(getCellStyle()).doWrite(data);
    }

    /**
     * 设置请求
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition",  "attachment;filename*=utf-8'zh_cn'"+fileName+ "."+ ExcelTypeEnum.XLSX);
        return response.getOutputStream();
    }
    /**
     * 设置样式
     */
    private static HorizontalCellStyleStrategy getCellStyle(){
        //表头样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        return new HorizontalCellStyleStrategy(headWriteCellStyle,contentWriteCellStyle);
    }
}