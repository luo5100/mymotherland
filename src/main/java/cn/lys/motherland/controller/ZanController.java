package cn.lys.motherland.controller;

import cn.lys.motherland.pojo.Partner;
import cn.lys.motherland.pojo.Zan;
import cn.lys.motherland.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/zan")
public class ZanController {

    @Autowired
    private ZanService zanService;

    @GetMapping("/findPartner")
    public String findPartner(HttpSession session){
        Partner partner = (Partner) session.getAttribute("user");
        if(zanService.findPartner(partner.getUsername())){
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/addPartner")
    public int addPartner(HttpSession session){
        Partner partner = (Partner) session.getAttribute("user");
        Zan zan = new Zan();
        zan.setUsername(partner.getUsername());
        return zanService.addPartner(zan);
    }

    @GetMapping("/deletePartner")
    public int deletePartner(HttpSession session){
        Partner partner = (Partner) session.getAttribute("user");
        return zanService.deletePartner(partner.getUsername());
    }

    @GetMapping("/getCount")
    public int getCount(Zan zan){
        return zanService.getCount(zan);
    }

}
