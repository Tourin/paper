/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tojsq.view.master;

import com.tojsq.mode.Vpn;
import com.tojsq.service.VpnService;
import com.tojsq.view.AbstractViewBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author tanglin
 */
@Named
@ViewScoped
public class VpnViewBean extends AbstractViewBean<Vpn> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private VpnService vpnService;

    private String qq;

    private String result;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public VpnViewBean() {

    }

    @PostConstruct
    protected void doPostConstruct() {
    }

    public void search() {
        final List<Vpn> vpnList = vpnService.selectByQQ(this.getQq());
        if (vpnList.size() > 0) {
            final Vpn vpn = vpnList.get(0);
            int days = Days.daysBetween(LocalDate.now(), LocalDate.fromDateFields(vpn.getEndDate())).getDays();
            if (days < 0) {
                this.setResult(String.format("帐号已经到期，需要继续使用请续费，到期日期:%s", LocalDate.fromDateFields(vpn.getEndDate()).toString("yyyy-MM-dd")));
            } else {
                this.setResult(String.format("到期日期:%s,还剩余%d天。", LocalDate.fromDateFields(vpn.getEndDate()).toString("yyyy-MM-dd"), days));
            }
        } else {
            this.setResult("查询结果不存在！换成旺旺号或者QQ号再试一次吧~");
        }

    }

}
