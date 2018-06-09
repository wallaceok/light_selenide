package com.test.selenium.model;

import com.github.sd4324530.fastexcel.annotation.MapperCell;

public class MyTest {
	@MapperCell(cellName = "名称")
    private String name;

    @MapperCell(cellName = "联系电话")
    private String phone;

    @MapperCell(cellName = "地址")
    private String address;

    @MapperCell(cellName = "一级分类ID")
    private int type;

    @MapperCell(cellName = "经度")
    private double lat;
}
