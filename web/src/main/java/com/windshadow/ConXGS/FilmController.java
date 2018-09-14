package com.windshadow.ConXGS;

import com.windshadow.Pojo.Film;
import com.windshadow.Service.XGS.Film.FilmService;
import com.windshadow.tools.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/xgs")
public class FilmController {

    @Autowired
    FilmService filmService;


    //进入首页
    @RequestMapping(value = "/index")
    public String index()
    {
        return "../XGS/index";
    }


    //新增电影方法+新增电影与电影类型关系
    @RequestMapping(value = "/InseFilm")
    public String InseFilm(HttpServletRequest request,Film film,List<MultipartFile> fileG) throws UnsupportedEncodingException {
        String [] sin = request.getParameterValues("sid");
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<sin.length;i++)
        {
            list.add(Integer.parseInt(sin[i]));
        }

        List<String> lists = FileNameUtils.filejiexi(fileG,"Movie");
        film.setHoto(lists.get(0));

        filmService.InseFilm(film);//调用新增电影方法
        filmService.InseFilmSort(film.getId(),list);//调用新增电影与电影类型关系表
        return "../XGS/claim/claim_voucher_edit";
    }


    //查询电影
    @RequestMapping(value = "/SeleFilm")
    public String SeleFilm(HttpServletRequest request)
    {
        request.setAttribute("list",filmService.SeleFilm());
        return "../XGS/claim/claim_voucher_list";
    }

    //查询详细信息电影
    @RequestMapping(value = "/SeleFilmId")
    public String SeleFilmId(HttpServletRequest request,int id,int is)
    {
        System.out.println(id);
        System.out.println(is);
        request.setAttribute("list", filmService.SeleFilmId(id));
        request.setAttribute("sort",filmService.SeleSortId(id));
        if(is == 1){
            return "../XGS/claim/claim_voucher_update";
        }
        else
        {
            return "../XGS/claim/claim_voucher_view";
        }
    }


    //修改电影
    @RequestMapping(value = "/UpdaFilm")
    public void UpdaFilm(Film film,HttpServletRequest request) throws UnsupportedEncodingException
    {
        int result = filmService.DelFilmSort(film.getId());
        System.out.println(result);
        if(result > 0)
        {
            String [] sin = request.getParameterValues("sid");
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<sin.length;i++)
            {
                list.add(Integer.parseInt(sin[i]));
            }
            filmService.InseFilmSort(film.getId(),list);//调用新增电影与电影类型关系表
        }

        int i = filmService.UpdaFilm(film);
        System.out.println(i);

        this.SeleFilm(request);
    }


    //删除电影并且删除电影类型关系表
    @RequestMapping(value = "/DeleFilm")
    public String DeleFilm(HttpServletRequest request,int id){

        int result2 = filmService.DelFilmSort(id);
        if(result2 > 0)
        {
            System.out.println("电影类型关系删除成功");
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaas");
        int result = filmService.DeleFilm(id);
        if(result > 0)
        {
            System.out.println("电影删除成功");
        }
           return "redirect:SeleFilm";
    }


    @RequestMapping(value = "/SeleFilmStatus")
    public String SeleFilmStatus(String status,HttpServletRequest request)
    {
        if(!status.equals("全部"))
        {
            request.setAttribute("list",filmService.SeleFilmStatus(status));
        }else{
            request.setAttribute("list",filmService.SeleFilm());
        }

            return "../XGS/claim/claim_voucher_list";
    }


}
