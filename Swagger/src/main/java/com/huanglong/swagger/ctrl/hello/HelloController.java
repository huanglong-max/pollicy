package com.huanglong.swagger.ctrl.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  @author: huanglong
 *  @Date: 2020/7/10 14:05
 *  @Description: Swagger的入门案例展示
 */
@Api(tags = "入门案例展示")
@RestController
    public class HelloController {


    /**
    * @Description
    * @Author  huanglong
    * @Date   2020/7/10 14:12
    * @Param  
    * @Return      
    * @Exception   
    * 
    */
    @ApiOperation(value = "helloword案例",notes="只限测试使用" )
    @RequestMapping(value = "/hello" )
    public String hello(HttpServletRequest request){
        return  "hello";
    }

}
