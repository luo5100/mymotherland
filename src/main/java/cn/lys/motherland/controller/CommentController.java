package cn.lys.motherland.controller;


import cn.lys.motherland.pojo.Comment;
import cn.lys.motherland.pojo.Partner;
import cn.lys.motherland.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//@RestController
@Controller
//@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    @ResponseBody
    public int addComment(@RequestBody Comment comment, HttpSession session){

        Partner sessionPartner = (Partner)session.getAttribute("user");
        if (comment.getComment().equals("")||comment.getComment() == null){
            return 0;
        }
        comment.setPartnerid(sessionPartner.getId());
        return this.commentService.addComment(comment);
    }

    @GetMapping("/findAllComment")
    @ResponseBody
    public List<Comment> findAllComment(){
        return this.commentService.findAllComment();
    }

    @GetMapping("/findAllComments")
    public String findAllComments(Model model){
        List<Comment> allComment = commentService.findAllComment();
        model.addAttribute("allComment",allComment);
        return "growingup";
    }


}
