package com.filwsx.rest.controller;

import com.filwsx.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author filwsx
 * @create 2022-05-17 13:25
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

}
