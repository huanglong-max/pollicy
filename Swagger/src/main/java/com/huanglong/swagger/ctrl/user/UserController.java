package com.huanglong.swagger.ctrl.user;


import com.huanglong.swagger.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户模块的基本操作")
public class UserController {


    // 接口说明
    @ApiOperation(value = "根据Id进行查询",notes = "id要求必填，且为rest方式" )
    // 定义swagger中的请求参数
    @ApiImplicitParams({@ApiImplicitParam(name="id",value="根据用户id查询用户",paramType ="query",dataType ="Integer")})
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@RequestParam(name = "id",required = true) Integer id){
        User user = new User(1, "huaglong", "测试");
        return user ;
    }

    @ApiOperation(value="添加用户")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        if(user!=null){
            return "插入成功";
        }else {
            return "插入失败";
        }
    }

    @ApiOperation(value="修改用户")
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(User user){
        if(user!=null){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value = "id") Integer id){
        if(id!=null&&id!=0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
