package com.yobetit.test.controller;

import com.yobetit.test.dtos.LeaveHistory;
import com.yobetit.test.entities.LeaveHistoryEntity;
import com.yobetit.test.service.LeaveHistoryService;
import com.yobetit.test.ui.LeaveOverdue;
import com.yobetit.test.ui.LeaveResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by Christian Magro on 15/07/2015.
 */

@RestController
@RequestMapping(value = "v1/leave")
public class LeaveHistoryController {

    public static final Logger log = Logger.getLogger(LeaveHistoryController.class);

    @Autowired
    public LeaveHistoryService leaveHistoryService;



    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<LeaveHistory> getLeave() {

        log.info("Requesting list of all employees ");

        return leaveHistoryService.getLeave();

    }

    @RequestMapping(value = "/getAllByManager", method = RequestMethod.GET)
    public List<LeaveHistory> getLeaveByManager(Principal principal) {

        log.info("Requesting list of all employees ");

        return leaveHistoryService.getLeaveByManager(principal.getName());

    }


    @RequestMapping(value = "/getPassedLeaveByEmployee", method = RequestMethod.GET)
        public List<LeaveHistory> getPassedLeaveByEmployee(Principal principal) {

        log.info("Requesting list of all leave for employee ");

        return leaveHistoryService.getPassedLeaveByEmployee(principal.getName());

    }


    @RequestMapping(value = "/getFutureLeaveByEmployee", method = RequestMethod.GET)
    public List<LeaveHistory> getFutureLeaveByEmployee(Principal principal) {

        log.info("Requesting list of all leave for employee ");

        return leaveHistoryService.getFutureLeaveByEmployee(principal.getName());

    }


    @RequestMapping(value = "/getCancelledLeaveByEmployee", method = RequestMethod.GET)
    public List<LeaveHistory> getCancelledLeaveByEmployee(Principal principal) {

        log.info("Requesting list of all leave for employee ");

        return leaveHistoryService.getCancelledLeaveByEmployee(principal.getName());

    }

    @RequestMapping(value = "/getOverdueLeaveByEmployee", method = RequestMethod.GET)
    public List<LeaveOverdue> getOverdueLeaveByEmployee(Principal principal) {

        log.info("Requesting list of all leave for employee ");

       return leaveHistoryService.getOverdueLeaveByEmployee(principal.getName());

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json"})
    public LeaveResponse addLeave(@RequestBody LeaveHistoryEntity leaveHistoryEntity, Principal principal) {

        log.info("Request received to add new leave request");

        return leaveHistoryService.addLeave(leaveHistoryEntity, principal.getName());

    }

    @RequestMapping(value = "/getCurrentMonthLeave", method = RequestMethod.GET)
    public List<LeaveHistoryEntity> getCurrentMonthLeave() {

        log.info("Requesting list of all leave for employee ");

        return leaveHistoryService.getCurrentMonthLeave();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public LeaveResponse addLeave(@PathVariable("id") int leaveId, Principal principal) {

        log.info("Request received to delete leave request");

        return leaveHistoryService.cancelLeave(leaveId, principal.getName());

    }
}
