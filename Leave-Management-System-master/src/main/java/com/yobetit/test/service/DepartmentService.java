package com.yobetit.test.service;

import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.repositories.DepartmentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Christian Magro on 14/07/2015.
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public static final Logger log = Logger.getLogger(DepartmentService.class);

    @Transactional(readOnly = true)
    public List<DepartmentEntity> getDepartments() {

        log.info("Received request to return list of all departments");

        try {

            List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

            log.info("A total of " + departmentEntities.size() + " departments were returned ");

            return departmentEntities;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }




}
