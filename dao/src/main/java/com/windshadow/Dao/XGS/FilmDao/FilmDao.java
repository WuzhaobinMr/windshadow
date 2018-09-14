package com.windshadow.Dao.XGS.FilmDao;

import com.windshadow.Pojo.Film;
import com.windshadow.Pojo.Sort;
import com.windshadow.Pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

@Mapper
public interface FilmDao {

    //新增电影方法
    @Insert("insert into film(name,intro,language,min,date,monye,hoto,status,aid,office,grade) value(#{film.name},#{film.intro},#{film.language},#{film.min},#{film.date},#{film.monye},#{film.hoto},#{film.status},#{film.aid},#{film.office},#{film.grade})")
    @Options(useGeneratedKeys = true, keyProperty = "film.id", keyColumn = "id")
    public void InseFilm(@Param("film") Film film);


    //新增电影与电影类型关系表
    @Insert("insert into sort_film(fid,sid) value(#{fid},#{sid})")
    public void InseFilmSort(@Param("fid") int fid, @Param("sid") int sid);


    //查询电影信息
    @Select("select * from film")
    public List<Film> SeleFilm();

    //按照Id查询电影
    @Select("SELECT *,(SELECT NAME FROM `area` a WHERE a.`id` = m.`Aid` ) AS AREA,(SELECT id FROM `area` a WHERE a.`id` = m.`Aid` ) AS ad FROM film m WHERE id = #{id}")
    public Film SeleFilmId(@Param("id") int id);

    //按照电影Id查询相关联的电影类型
    @Select("SELECT s.`Id`,s.`Name` FROM film m,sort s,sort_film sf WHERE m.`id` = sf.`fid` AND s.`Id` = sf.`sid` AND m.`id` = 1")
    public List<Sort> SeleSortId(@Param("id") int id);

    //修改电影表
    @Update("UPDATE film SET NAME = #{film.name},LANGUAGE = #{film.language},`min` = #{film.min},monye = #{film.monye},STATUS = #{film.status},aid = #{film.aid},office = #{film.office},grade = #{film.grade},intro = #{film.intro} WHERE id = #{film.id}")
    public int UpdaFilm(@Param("film") Film film);

    //删除电影和电影类型表
    @Delete("DELETE FROM sort_film WHERE fid = #{fid}")
    public int DelFilmSort(@Param("fid") int fid);

    //删除电影表
    @Delete("delete from film where id = #{id}")
    public int DeleFilm(@Param("id") int id);

    //根据条件状态进行数据查询
    @Select("SELECT * FROM film WHERE STATUS = #{status}")
    public List<Film> SeleFilmStatus(@Param("status") String status);


    //前端功能
    //注册功能
    @Insert("INSERT INTO USER(NAME,pwd,mailbox,phone,TYPE) VALUE(#{user.name},#{user.pwd},#{user.mailbox},#{user.phone},#{user.type})")
    public int InseUser(@Param("user") User user);


    //查询是否有重复的用户
    //查询全部用户
    @Select("<script>SELECT * FROM USER WHERE 1=1 <if test='name != null and pwd != null'>AND `name` = #{name} AND pwd = #{pwd}</if></script>")
    public List<User> SeleAndUser(@Param("name") String name,@Param("pwd") String pwd);


    //查询热映电影，并且按时间排序
    @Select(value = "SELECT * FROM film WHERE STATUS = #{status} ORDER BY DATE")
    public List<Film> DomeSelFilm(@Param("status") String status);

    //查询经典电影
    @Select(value = "SELECT * FROM film WHERE STATUS = \"已上架\" AND office > 3 ORDER BY DATE LIMIT 0,5")
    public List<Film> DomeSelFilmJD();



}
