package com.shun.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;

public class DemoDate {
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名", index = 1)
    private String sname;

    public DemoDate() {
    }

    public DemoDate(Integer sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "DemoDate{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                '}';
    }
}
