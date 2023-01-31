package com.huawei.managersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @className: TableController
 * @author: Jaara
 * @date: 2023/1/30
 * description：
 **/
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }
}
