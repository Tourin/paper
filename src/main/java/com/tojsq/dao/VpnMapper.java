package com.tojsq.dao;

import com.tojsq.mode.Vpn;
import java.util.List;

public interface VpnMapper
        extends CRUDMapper<Vpn, Long> {

    List<Vpn> selectByQq(String qq);
}
