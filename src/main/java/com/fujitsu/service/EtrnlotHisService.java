/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fujitsu.service;

import com.fujitsu.dao.CRUDMapper;
import com.fujitsu.dao.EtrnlotHisMapper;
import com.my.mode.mesmgr.EtrnlotHis;
import com.my.mode.mesmgr.EtrnlotHisKey;
import javax.ejb.EJB;
import javax.inject.Named;
import org.mybatis.cdi.Mapper;

/**
 *
 * @author admin
 */
public class EtrnlotHisService extends AbstractCRUDService<EtrnlotHis, EtrnlotHisKey>{
    
    @EJB
    @Mapper
    @Named("MES")
    private EtrnlotHisMapper etrnlotHisMapper;

    @Override
    public boolean isExist(EtrnlotHis entity) {
        return isKeyExist(entity);
    }

    @Override
    protected CRUDMapper<EtrnlotHis, EtrnlotHisKey> getMapper() {
        return etrnlotHisMapper;
    }
    
    
    
}
