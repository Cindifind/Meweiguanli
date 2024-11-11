package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.model.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public List<DataEntity> findInforCData() {
        return dataRepository.findByDelAndCollege(0,"0");
    }
    public List<DataEntity> findHumanCData() {
        return dataRepository.findByDelAndCollege(0,"1");
    }
    public List<DataEntity> findGeneralCData() {
        return dataRepository.findByDelAndCollege(0,"2");
    }
    public List<DataEntity> findFACCData() {
        return dataRepository.findByDelAndCollege(0,"3");
    }
    public List<DataEntity> findConciergeData() {
        return dataRepository.findByOAAAAndDel(0,0);
    }
    public List<DataEntity> findUserData() {return dataRepository.findByGAAndOAAAAndDel(0,0,0);}
}
