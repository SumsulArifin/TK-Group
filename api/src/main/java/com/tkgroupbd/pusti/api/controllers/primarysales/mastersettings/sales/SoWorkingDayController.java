package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SoWorkingDay;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.SoWorkingDayRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.SoWorkingDayServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Working Day")
@RestController
@RequestMapping("/")
public class SoWorkingDayController {

    @Autowired
    SoWorkingDayServiceImpl service;

    @PostMapping("/addSoWorkingDay")
    public ResponseEntity<MessageResponse> addSoWorkingDay(@RequestBody SoWorkingDayRequest soWorkingDayRequest) {
        MessageResponse newSoWorkingDay = service.createSoWorkingDay(soWorkingDayRequest);
        return new ResponseEntity<>(newSoWorkingDay, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSoWorkingDay/{id}")
    public ResponseEntity<?> deleteSoWorkingDay(@PathVariable("id") Integer id) {
        service.deleteSoWorkingDay(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateSoWorkingDay/{id}")
    public ResponseEntity<Optional<SoWorkingDay>> updateSoWorkingDay(@PathVariable Integer id,
            @RequestBody SoWorkingDayRequest soWorkingDayRequest) {
        Optional<SoWorkingDay> soWorkingDay = service.updateSoWorkingDay(id, soWorkingDayRequest);
        return new ResponseEntity<Optional<SoWorkingDay>>(soWorkingDay, HttpStatus.OK);
    }

}
