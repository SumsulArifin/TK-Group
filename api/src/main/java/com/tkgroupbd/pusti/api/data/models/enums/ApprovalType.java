package com.tkgroupbd.pusti.api.data.models.enums;

public enum ApprovalType {
    PrimaryOrderApproval(1),
    DOApproval(2),
    ;

    private int code;

    private ApprovalType (int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
}
