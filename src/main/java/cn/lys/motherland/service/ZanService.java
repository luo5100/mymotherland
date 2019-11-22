package cn.lys.motherland.service;

import cn.lys.motherland.mapper.ZanMapper;
import cn.lys.motherland.pojo.Zan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class ZanService {

    @Autowired
    private ZanMapper zanMapper;

    public boolean findPartner(String username){
        Example example = new Example(Zan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        if (zanMapper.selectOneByExample(example) != null){
            return true;
        }
        return false;
    }

    public int addPartner(Zan zan) {
        return zanMapper.insert(zan);
    }

    public int deletePartner(String username) {
        Example example = new Example(Zan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        return zanMapper.deleteByExample(example);
    }

    public int getCount(Zan zan) {
        return zanMapper.selectCount(zan);
    }

}
