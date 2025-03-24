package com.yezhiyuan.controller;


import com.yezhiyuan.anno.SkipCheckToken;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;

@RestController
public class TestController {

    public static ThreadLocal<String>t =new ThreadLocal<>();

    private static final String IMAGE_URL = "https://static-legacy.dingtalk.com/media/lADPDhYBVipLJZnNA7_NA78_959_959.jpg";

    @GetMapping("test")
    public ResponseEntity<byte[]> getImage() {
        RestTemplate restTemplate = new RestTemplate();
        byte[] imageBytes = restTemplate.getForObject(IMAGE_URL, byte[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "image/jpeg");
        System.out.println(imageBytes[0]);
        System.out.println(imageBytes[1]);
        System.out.println(imageBytes[2]);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }


    @PostMapping("/export/excel")
    public void exportExcel(@RequestBody HashMap map, HttpServletResponse response) throws IOException {
        String filename = "data.xlsx";

        // 创建 Excel 工作簿
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("corpId");
        header.createCell(1).setCellValue("组织名称");
        header.createCell(2).setCellValue("pc登录人数");
        header.createCell(3).setCellValue("移动端登录人数");
        header.createCell(4).setCellValue("月份");
        header.createCell(5).setCellValue("销售人员ID");
        header.createCell(6).setCellValue("销售人员名称");
        header.createCell(7).setCellValue("授权人数");
        header.createCell(8).setCellValue("版本人数上限");

        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("测试");
        row.createCell(1).setCellValue("测试");
        row.createCell(2).setCellValue("测试");
        row.createCell(3).setCellValue("测试");
        row.createCell(4).setCellValue("测试");
        row.createCell(5).setCellValue("测试");
        row.createCell(6).setCellValue("测试");
        row.createCell(7).setCellValue("测试");
        row.createCell(8).setCellValue("测试");

        // 填充数据...

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        // 写入输出流
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
        workbook.close();
    }



    @SkipCheckToken
    @RequestMapping("test")
    public String test(){
        System.out.println("test");
        System.out.println("当前线程"+Thread.currentThread().getName());
        String s = t.get();
        t.set("Thread.currentThread().getName()");
        return s;
    }

    @RequestMapping("err")
    public String err() throws Exception {
        t.set("Thread.currentThread().getName()");
        throw new Exception();
    }
}
