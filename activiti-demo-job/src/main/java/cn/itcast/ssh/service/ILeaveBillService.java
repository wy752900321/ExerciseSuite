package cn.itcast.ssh.service;

import cn.itcast.ssh.domain.LeaveBill;

import java.util.List;


public interface ILeaveBillService {

    List<LeaveBill> findLeaveBillList();

    void saveLeaveBill(LeaveBill leaveBill);

    LeaveBill findLeaveBillById(Long id);

    void deleteLeaveBillById(Long id);

}
