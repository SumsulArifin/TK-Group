package com.tkgroupbd.pusti.api.controllers.notices;

import com.tkgroupbd.pusti.api.data.models.entity.notices.Notice;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.NoticesRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.notices.NoticesServices;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Notice")
@RestController
@RequestMapping("/notices")
public class NoticesController {
    @Autowired
    NoticesServices noticesServices;

    // Create a new Notices
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addNotices(@RequestBody NoticesRequest noticesRequest) {
        MessageResponse newNotices = noticesServices.addNotices(noticesRequest);
        return new ResponseEntity<>(newNotices, HttpStatus.CREATED);
    }

    // Update a Notices information
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Notice>> updateNotices(@PathVariable Integer id,
            @RequestBody NoticesRequest noticesRequest) {
        Optional<Notice> updateNotices = noticesServices.updateNotices(id, noticesRequest);
        return new ResponseEntity<Optional<Notice>>(updateNotices, HttpStatus.OK);
    }

    // Notices Status Change API
    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<Optional<Notice>> changeNoticesStatus(@PathVariable Integer id,
            @RequestBody NoticesRequest noticesRequest) {
        Optional<Notice> updateNoticesStatus = noticesServices.statusChangeAPI(id, noticesRequest);
        return new ResponseEntity<Optional<Notice>>(updateNoticesStatus, HttpStatus.OK);
    }

    // get All Notices
    @GetMapping("/getAll")
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticesServices.getAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    // Delete Notices by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotices(@PathVariable("id") Integer id) {
        noticesServices.deleteNotices(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Find by id Api
    @GetMapping("/getById/{id}")
    public ResponseEntity<Notice> getDivisionById(@PathVariable("id") Integer id) {
        Notice notices = noticesServices.getNoticesById(id);
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

}
