package com.windshadow.Controller;

import com.windshadow.Pojo.Film;
import com.windshadow.Pojo.User;
import com.windshadow.Service.XGS.Film.FilmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/demo")
@Api(value = "前台功能")
public class demoController {

    @Autowired
    FilmService filmService;


    //进入前端首页
    @PostMapping(value = "/Index")
    public String Index_show()
    {
        return "../Demo/index";
    }

    //账号注册
    @PostMapping(value = "/UserRegistered")
    @ApiOperation(value = "注册用户api",notes = "注册用户方法")
    public String UserRegistered(@RequestBody User user)
    {
        boolean flag = false;
        if(user.getName() != null && user.getName().equals(""))
        {
            System.out.println("姓名不能为空！错误！");
        }else if(user.getPwd() != null && user.equals(""))
        {
            System.out.println("密码不能为空！错误！");
        }else if(user.getMailbox() != null && user.getMailbox().equals(""))
        {
            System.out.println("邮箱不能为空！错误！");
        }else if(user.getPhone() != null && user.getPhone().equals(""))
        {
            System.out.println("电话不能为空！错误！");
        }else
        {
            flag = true;
        }
        if(!flag)
        {
            return "数据不正确！";
        }

        if(filmService.InseUser(user) > 0) System.out.println("新增成功");

        return "";
    }

    //查询是否有重复的用户
    //查询全部用户
    @PostMapping(value = "SeleAndUser")
    @ApiOperation(value = "查询用户Api",notes = "查询用户方法，可参数值查询也可以待用户名和密码查询")
    public List<User> SeleAndUser(@RequestBody User user){
        return filmService.SeleAndUser(user);
    }

    //测试swagger方法
    @PostMapping(value = "/AA")
    @ApiOperation(value = "测试swagger方法api",notes = "测试swagger方法使用")
    public String AA(@ApiParam("必填") @RequestParam("name") String name, @RequestParam("i") int i)
    {
        System.out.println(name);
        System.out.println("+++");
        return "123";
    }


    //查询当前热映电影，并且按照时间排序
    //and查询当前预上架好评电影，并按时间排序
    @PostMapping(value = "/DomeSelFilm")
    @ApiOperation(value = "按照状态进行查询Api",notes = "按照状态进行查询出当前热映电影和预上架电影")
    public List<Film> DomeSelFilm(@ApiParam("必填") @RequestParam("status") String status)
    {
        return filmService.DomeSelFilm(status);
    }


}
