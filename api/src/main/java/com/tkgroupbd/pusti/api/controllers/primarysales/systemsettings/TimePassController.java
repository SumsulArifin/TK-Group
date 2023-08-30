package com.tkgroupbd.pusti.api.controllers.primarysales.systemsettings;

import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.TimePass;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.TimePassRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.systemsettings.TimePassServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Time Pass")
@RestController
@RequestMapping("/")
public class TimePassController {

    @Autowired
    private TimePassServiceImpl service;

    @GetMapping("/getAllTimePass")
    public ResponseEntity<List<TimePass>> getAllTimePass() {
        List<TimePass> timePasses = service.getAllTimePass();
        return new ResponseEntity<>(timePasses, HttpStatus.OK);
    }

    @PostMapping("/addTimePass")
    public ResponseEntity<MessageResponse> createTimePass(
            @RequestBody TimePassRequest request) {
        MessageResponse newTimePass = service.createTimePass(request);
        return new ResponseEntity<>(newTimePass, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTimePass/{id}")
    public ResponseEntity<?> deleteTimePass(@PathVariable("id") Integer id) {
        service.deleteTimePass(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getTimePassById/{id}")
    public ResponseEntity<TimePass> getTimePassById(@PathVariable("id") Integer id) {
        TimePass timePass = service.getTimePassById(id);
        return new ResponseEntity<>(timePass, HttpStatus.OK);
    }

    @PutMapping("/updateTimePass/{id}")
    public ResponseEntity<Optional<TimePass>> updateTimePass(@PathVariable Integer id,
            @RequestBody TimePassRequest request) {
        Optional<TimePass> timePass = service.updateTimePass(id, request);
        return new ResponseEntity<Optional<TimePass>>(timePass, HttpStatus.OK);
    }

    @PutMapping("/timePassStatusChange/{id}")
    public ResponseEntity<Optional<TimePass>> timePassStatusChange(@PathVariable Integer id,
            @RequestBody TimePassRequest request) {
        Optional<TimePass> timePass = service.timePassStatusChange(id, request);
        return new ResponseEntity<Optional<TimePass>>(timePass, HttpStatus.OK);
    }
}
