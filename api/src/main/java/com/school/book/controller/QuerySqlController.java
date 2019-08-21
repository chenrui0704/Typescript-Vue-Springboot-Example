package com.school.book.controller;

import com.school.book.util.querySql.util.ServiceExecute;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/querySql")
public class QuerySqlController {

    @RequestMapping(value = "/{serviceName}", method = RequestMethod.POST)
    public Object baseRun(@PathVariable String serviceName, @RequestBody Map<String,String> parameterMap) {
        return ServiceExecute.execute(serviceName, parameterMap);
    }

}
