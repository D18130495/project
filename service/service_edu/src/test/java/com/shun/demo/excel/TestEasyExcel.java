package com.shun.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    public static void main(String[] args) {
//        String fileName = "E:\\write.xlsx";
//        EasyExcel.write(fileName, DemoDate.class).sheet("学生列表").doWrite(getList());

        String fileName = "E:\\write.xlsx";
        EasyExcel.read(fileName, DemoDate.class, new ExcelListener()).sheet().doRead();
    }

    private static List<DemoDate> getList() {
        List<DemoDate> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            DemoDate date = new DemoDate(i, "lucy" + i);
            list.add(date);
        }

        return list;
    }
}
