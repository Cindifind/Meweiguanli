package com.example.demo.service;

import com.example.demo.dao.VisitorDAOImpl;
import com.example.demo.model.Visitor;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {
    final
    VisitorDAOImpl visitorDAO;

    public VisitorService(VisitorDAOImpl visitorDAO) {
        this.visitorDAO = visitorDAO;
    }

    public void addVisitor(Visitor visitor) {
        visitorDAO.insertVisitor(visitor);
    }

}
