package com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.enums.EmployeeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employees")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    private String dealingAreaId;
    private String salesOrgId;
    private String mobile;
    private String depotId;
    private String backPermit;
    private String designationId;
    private String dateOfJoining;
    private String dateOfResignation;
    private String basicSalary;
    private String houseRent;
    private String medicalAllowance;
    private String internetBills;
    private String otherAllowance;
    private String sscPassingYear;
    private String highestDegreeName;
    private String dateOfBirth;
    private String bloodGroup;
    private String bankId;
    private String backAccNumber;
    private String districtId;
    private String email;
    private String nid;
    private String travellingDailyAllowance;
    private String meetingTravellingAllowance;
    private String meetingDailyAllowance;

}
