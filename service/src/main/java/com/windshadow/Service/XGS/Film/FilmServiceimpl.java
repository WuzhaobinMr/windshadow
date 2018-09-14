package com.windshadow.Service.XGS.Film;

import com.windshadow.Dao.XGS.FilmDao.FilmDao;
import com.windshadow.Pojo.Film;
import com.windshadow.Pojo.Sort;
import com.windshadow.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceimpl implements FilmService {

    @Autowired
    FilmDao filmdao;

    //新增电影
    public void InseFilm(Film film) {
        try {
            filmdao.InseFilm(film);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //新增电影与电影类型
    public void InseFilmSort(int id,List<Integer> list){
        for (int i=0;i<list.size();i++)
        {
            try
            {
                filmdao.InseFilmSort(id,list.get(i));
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    //查询电影
    public List<Film> SeleFilm()
    {
        List<Film> list = new ArrayList<>();
        try
        {
            list = filmdao.SeleFilm();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }


    //查询电影按照Id查询
    public Film SeleFilmId(int id){
        Film film = new Film();
        try {
            film = filmdao.SeleFilmId(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return film;
    }


    //按照Id查询电影相关联的电影类型
    public List<Sort> SeleSortId(int id)
    {
        List<Sort> list = new ArrayList<Sort>();
        try{
            list = filmdao.SeleSortId(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    //修改电影表
    public int UpdaFilm(Film film){
        int i = 0;
        try{
           i = filmdao.UpdaFilm(film);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    //删除电影和电影类型关系表
    public int DelFilmSort(int fid){
        int i = 0;
        try{
            i =filmdao.DelFilmSort(fid);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    //删除电影表
    public int DeleFilm(int id){
        int i =0;
        try {
            i = filmdao.DeleFilm(id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    //根据条件状态进行数据查询
    public List<Film> SeleFilmStatus(String status)
    {
        return filmdao.SeleFilmStatus(status);
    }





    //前端功能
    //注册账号
    public int InseUser(User user) {
        int i = 0 ;
        try{
           i = filmdao.InseUser(user);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    //查询用户
    public List<User> SeleAndUser(User user)
    {
        List<User> list = new ArrayList<User>();
        try{
            list = filmdao.SeleAndUser(user.getName(),user.getPwd());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    //查询热映电影并且按照时间排序
    public List<Film> DomeSelFilm(String status)
    {
        List<Film> list = new ArrayList<Film>();
        try{
            list = filmdao.DomeSelFilm(status);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    //查询经典电影
    public List<Film> DomeSelFilmJD()
    {
        List<Film> list = new ArrayList<Film>();
        try{
            list = filmdao.DomeSelFilmJD();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }


}
