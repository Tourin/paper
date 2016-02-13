/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tojsq.service;

import com.tojsq.dao.CRUDMapper;
import com.tojsq.mode.Vpn;
import org.mybatis.cdi.Mapper;
import com.tojsq.dao.VpnMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author admin
 */
@Stateless
public class VpnService extends AbstractCRUDService<Vpn, Long> {

    @Inject
    @Mapper
    private VpnMapper vpnMapper;

    @Override
    protected CRUDMapper<Vpn, Long> getMapper() {
        return vpnMapper;
    }

    @Override
    public boolean isExist(Vpn entity) {
        return isKeyExist(entity.getId());
    }

    public List<Vpn> selectByQQ(String qq) {
        return vpnMapper.selectByQq(qq);
    }

}
