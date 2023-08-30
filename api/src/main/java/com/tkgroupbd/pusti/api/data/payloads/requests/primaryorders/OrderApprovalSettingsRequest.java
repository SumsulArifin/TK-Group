package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.enums.OrderType;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;


@Data
public class OrderApprovalSettingsRequest {
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private boolean isApprovalRequired;
    private String  upDatedBy;
    private Date updatedAt;
}
