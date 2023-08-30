package com.tkgroupbd.pusti.api.exceptions;

import java.text.MessageFormat;

public class RegionAlreadyAssignedException extends RuntimeException{
    public RegionAlreadyAssignedException(final int regionId, final int divisionId){
        super(MessageFormat.format("Item: {0} is already assigned to cart: {1}", regionId, divisionId));
    }
}