package com.windshadow.Service.XGS.Film;

import com.windshadow.Pojo.Film;
import com.windshadow.Pojo.Sort;
import com.windshadow.Pojo.User;

import java.util.List;

public interface FilmService {

    //电影新增方法
    public void InseFilm(Film fil);

    //新增电影与类型关系表
    public void InseFilmSort(int id,List<Integer> list);


    //查询电影
    public List<Film> SeleFilm();

    //按照id查询电影
    public Film SeleFilmId(int id);

    //按照Id查询电影相关联的电影类型
    public List<Sort> SeleSortId(int id);

    //修改电影表
    public int UpdaFilm(Film film);

    //删除电影和电影类型关系表
    public int DelFilmSort(int fid);

    //删除电影表
    public int DeleFilm(int id);

    //根据条件状态进行数据查询
    public List<Film> SeleFilmStatus(String status);






    //前端功能
    //注册账号
    public int InseUser(User user);

    //查询用户
    //按条件查询用户
    public List<User> SeleAndUser(User user);

    //查询热映电影并且按时间排序
    List<Film> DomeSelFilm(String status);

    //查询经典电影
    public List<Film> DomeSelFilmJD();
}
