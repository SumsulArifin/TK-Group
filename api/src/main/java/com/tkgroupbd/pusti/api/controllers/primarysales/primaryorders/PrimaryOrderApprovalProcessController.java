package com.tkgroupbd.pusti.api.controllers.primarysales.primaryorders;

import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.PrimaryOrderApprovalProcessRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Primary Order Approval")
@RequestMapping("/primaryOrderApproval")
public class PrimaryOrderApprovalProcessController {

    @Autowired
    com.tkgroupbd.pusti.api.services.primaryorders.PrimaryOrderApprovalProcessService primaryOrderApprovalService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> savePrimaryOrderApproval(
            @RequestBody PrimaryOrderApprovalProcessRequest primaryOrderApprovalRequest) {
        MessageResponse primaryOrder = primaryOrderApprovalService
                .createPrimaryOrderApproval(primaryOrderApprovalRequest);
        return new ResponseEntity<>(primaryOrder, HttpStatus.CREATED);
    }

}
