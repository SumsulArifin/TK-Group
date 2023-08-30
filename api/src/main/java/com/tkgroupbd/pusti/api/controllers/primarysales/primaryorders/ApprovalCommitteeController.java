package com.tkgroupbd.pusti.api.controllers.primarysales.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommittee;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommitteeMember;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovalCommitteeRequest;

import com.tkgroupbd.pusti.api.services.primaryorders.ApprovalCommitteeServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/approvalCommittee")
@Tag(name = "Approval Committee")
public class ApprovalCommitteeController {
    @Autowired
    private ApprovalCommitteeServiceImpl approvalCommitteeService;

    @PostMapping("/save-with-member")
    public ApprovalCommittee saveApprovalCommitteeWithMember(
            @RequestBody ApprovalCommitteeRequest approvalCommitteeRequest) {
        return approvalCommitteeService.saveApprovalCommitteeWithApprovalCommitteeMember(approvalCommitteeRequest);
    }

    @PutMapping("/update/{committeeId}")
    public ResponseEntity<Optional<ApprovalCommittee>> updateApprovalCommittee(@PathVariable Integer committeeId,
            @RequestBody ApprovalCommitteeRequest request) {
        Optional<ApprovalCommittee> approvalCommittee = approvalCommitteeService.updateApprovalCommittee(committeeId,
                request);
        return new ResponseEntity<Optional<ApprovalCommittee>>(approvalCommittee, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<ApprovalCommittee>> getAllApprovalCommittee() {
        List<ApprovalCommittee> approvalCommittees = approvalCommitteeService.getAllApprovalCommittee();
        return new ResponseEntity<>(approvalCommittees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{committeeId}")
    public ResponseEntity<?> deleteApprovalCommitteeTypeById(@PathVariable("committeeId") Integer committeeId) {
        approvalCommitteeService.deleteApprovalCommitteeById(committeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getBy/{committeeId}")
    public ApprovalCommitteeMember getApprovalCommitteeMemberById(@PathVariable int committeeId) {
        return approvalCommitteeService.getApprovalCommitteeDetailById(committeeId);
    }
}
