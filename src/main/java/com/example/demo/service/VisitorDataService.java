package com.example.demo.service;

import com.example.demo.model.DataEntity;
import com.example.demo.repository.VisitorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitorDataService {
    @Autowired
    private VisitorDataRepository visitorDataRepository;
    @Transactional(readOnly = true)
    public List<DataEntity> findVisitorData(String departmentName, int level) {
        if(level==1){
            return visitorDataRepository.findByDepartmentNameAndDel(departmentName,"0");
        }else if(level==2){
            List<DataEntity> list = visitorDataRepository.findByApproveAndDel(1,"0");
            list.addAll(visitorDataRepository.findByApproveAndDel(3,"0"));
            return list;
        }else {
            return visitorDataRepository.findByApproveAndDel(3,"0");
        }
    }
    public void updateApproveValueTById(Integer id, Integer value) {
        visitorDataRepository.updateApproveValueById(id, value);
    }
    public void updateDelValueTById(Integer id) {
        visitorDataRepository.updateDelValueById(id, "1");
    }
    public List<DataEntity> findByOpenidAndDel(String openid) {
        return visitorDataRepository.findByOpenidAndDel(openid,"0");
    }
}
