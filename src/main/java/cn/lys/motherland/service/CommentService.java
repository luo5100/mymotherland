package cn.lys.motherland.service;


import cn.lys.motherland.mapper.CommentMapper;
import cn.lys.motherland.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> findAllComment(){
        return this.commentMapper.findAllComment();
    }

    public int addComment(Comment comment){
        return this.commentMapper.insert(comment);
    }

}
