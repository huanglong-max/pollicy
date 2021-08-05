package com.huanglong.swagger.pojo;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.omg.CORBA.PRIVATE_MEMBER;
import java.io.Serializable;


@ApiModel(value="用户实体",description = "用于描述用户的实体")
public class User implements Serializable {
    /**
     *   @ApiModelProperty
     *       . value : 字段说明
     *       . name : 重写一下属性的名字
     *       . dataType : 属性类型
     *       . required : 是否必须
     *       . example : 举例说明
     *       . hidden : 隐藏
     */
    @ApiModelProperty(value="用户id",example = "1")
    private Integer id;
    @ApiModelProperty(value="用户名")
    private String username;
    @ApiModelProperty(value="用户密码")
    private String password;


    public User() {
    }


    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
