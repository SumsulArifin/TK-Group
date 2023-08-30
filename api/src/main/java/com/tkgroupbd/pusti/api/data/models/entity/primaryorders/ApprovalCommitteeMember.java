package com.tkgroupbd.pusti.api.data.models.entity.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "approvalCommitteeMember")
public class ApprovalCommitteeMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int committeeMemberId;
    private String sequenceNumber;

    @ManyToOne
    @JoinColumn(name = "committeeId")
    private ApprovalCommittee approvalCommittee;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
