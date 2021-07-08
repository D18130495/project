package com.shun.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<DemoDate> {
    //line by line
    public void invoke(DemoDate demoDate, AnalysisContext analysisContext) {
        System.out.println("****" + demoDate);
    }

    //read head
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头" + headMap);
    }

    //after read
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
