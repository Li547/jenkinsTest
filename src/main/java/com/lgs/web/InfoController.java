package com.lgs.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgs.entity.Info;
import com.lgs.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.transform.Source;


@Controller
public class InfoController {
    @Autowired
    private InfoService infoService;
    /*用于html页面的跳转*/
    @GetMapping("/forward/{target}")
    public String forward(@PathVariable("target") String target){

        return "/"+target;
    }

    @GetMapping({"/init","/init/{page}"})
    public String init(Model model, @PathVariable(name = "page",required = false) Integer page){
        if(page==null){
            page=1;
        }
        PageHelper.startPage(page,5);
        PageInfo<Info> info = new PageInfo<>(infoService.getAll());
      /*  List<Info> all = infoService.getAll();*/
       /* System.out.println(info);*/
        model.addAttribute("all",info);
        return "/init";
    }
    @PostMapping("/save")
    public String save(Info info){
        //判断，是新增 ，还是修改
        if(info.getId()==null || info.getId().equals("")){
            //新增
            infoService.add(info);
        }else{
            //修改
            infoService.update(info);
        }
        return "redirect:/init";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model){

        Info f = infoService.findByid(id);
        model.addAttribute("f",f);
        return "/add";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id,Model model){

       infoService.delete(id);
        return "redirect:/init";
    }

}
