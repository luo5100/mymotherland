package cn.lys.motherland.controller;

import cn.lys.motherland.pojo.Partner;
import cn.lys.motherland.service.PartnerService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//@RestController
@Controller
@CrossOrigin
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/login")
    @ResponseBody
    public String queryPartner(@RequestBody Partner partner, HttpSession session, HttpServletResponse response){
        JSONObject data = new JSONObject();
        logger.info(JSONObject.toJSONString(partner));
        Partner partner1 = partnerService.queryPartner(partner.getUsername(), partner.getPassword());
        if (partner1 != null){
            session.setAttribute("user",partner1);
            logger.info(JSONObject.toJSONString(session.getAttribute("user")));
            logger.info(JSONObject.toJSONString(session.getId()));
            response.addCookie(new Cookie("JSSESIONID",session.getId()));

            if (partner.getUsername().equals("admin")){
                data.put("result","successAdmin");
            }
            data.put("result","success");

        }else{
            data.put("result","false");
        }
        return data.toJSONString();
    }

    @PostMapping("/addUser")
    @ResponseBody
    public int addUser(@RequestBody Partner partner){
        if (partner.getUsername() == null||partner.getUsername().equals("")||
        partner.getPassword()==null||partner.getPassword().equals("")){
            return 0;
        }else {
            return this.partnerService.addUser(partner);
        }
    }

    @GetMapping("/getUser")
    @ResponseBody
    public Partner getPartner(HttpSession session){
        logger.info(JSONObject.toJSONString(session.getAttribute("user")));
        return (Partner) session.getAttribute("user");
    }

    @GetMapping("/outLogin")
    public String outLogin(HttpSession session){
        logger.info(JSONObject.toJSONString(session.getAttribute("user")));
        session.invalidate();
        return "login";
    }

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/growingup")
    public String growingup(){
        return "growingup";
    }

    @GetMapping("/recommend")
    public String recommend(){
        return "recommend";
    }

    @GetMapping("/life")
    public String life(){
        return "life";
    }




}
