package com.test.selenium;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.github.sd4324530.fastexcel.FastExcel;
import com.test.selenium.model.MyTest;

public class TestReaderExcel {
	
	@Test
	public void list() throws InvalidFormatException, IOException{
//		Logger LOG = Logger.getLogger(Test.class.getClass());
		String file = this.getClass().getResource("/excel/data.xlsx").getFile();
		FastExcel fastExcel = new FastExcel(file);
        fastExcel.setSheetName("活动信息数据");
        List<MyTest> tests = fastExcel.parse(MyTest.class);
        if(null != tests && !tests.isEmpty()) {
            for(MyTest myTest : tests) {
//                LOG.debug(myTest.toString());
            }
        } else {
//            LOG.debug("没有结果");
        }
	}
}
