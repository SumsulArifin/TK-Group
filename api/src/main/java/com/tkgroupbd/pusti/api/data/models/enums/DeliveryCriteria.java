package com.tkgroupbd.pusti.api.data.models.enums;

public enum DeliveryCriteria {
    Piece(1),
    Package(2),
    Cartoon(3),
    Bags(4);
    private int code;

    private DeliveryCriteria (int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
}
