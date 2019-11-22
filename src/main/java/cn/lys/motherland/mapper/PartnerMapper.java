package cn.lys.motherland.mapper;

import cn.lys.motherland.pojo.Partner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface PartnerMapper extends Mapper<Partner> {

    @Select("select * from partner where username=#{username} and password=#{password}")
    public Partner queryPartner(@Param("username") String username ,@Param("password") String password);

}
