package cn.lys.motherland.mapper;

import cn.lys.motherland.pojo.Comment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

    List<Comment> findAllComment();
}
