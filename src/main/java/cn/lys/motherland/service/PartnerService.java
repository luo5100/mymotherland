package cn.lys.motherland.service;

import cn.lys.motherland.mapper.PartnerMapper;
import cn.lys.motherland.pojo.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PartnerService {

    @Autowired
    private PartnerMapper partnerMapper;

    public Partner queryPartner(String username,String password){
        return this.partnerMapper.queryPartner(username,password);
    }


    public int addUser(Partner partner) {
        return this.partnerMapper.insert(partner);
    }

}
