package com.tkgroupbd.pusti.api.controllers.primarysales.depot;

import com.tkgroupbd.pusti.api.data.models.entity.depot.ReceivingEntry;
import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.DeliveredProduct;
import com.tkgroupbd.pusti.api.data.payloads.requests.depot.ReceivingEntryRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.secondaryorders.DeliveredProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.depot.ReceivingEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receivingEntry")
public class ReceivingEntryController {


    @Autowired
    ReceivingEntryService receivingEntryService;


    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addReceivingEntry(@RequestBody ReceivingEntryRequest request) {
        MessageResponse response = receivingEntryService.addReceivingEntry(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{receivingEntryId}")
    public ResponseEntity<Optional<ReceivingEntry>> updateReceivingEntry(@PathVariable int receivingEntryId, @RequestBody ReceivingEntryRequest request) {
        Optional<ReceivingEntry> receivingEntry = receivingEntryService.updateReceivingEntry(receivingEntryId,request);
        return new ResponseEntity<Optional<ReceivingEntry>>(receivingEntry, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReceivingEntry>> getAllReceivingEntry() {
        List<ReceivingEntry> receivingEntryList = receivingEntryService.getAllReceivingEntry();
        return new ResponseEntity<>(receivingEntryList, HttpStatus.OK);
    }

    @GetMapping("/getById/{receivingEntryId}")
    public ResponseEntity<ReceivingEntry> getReceivingEntryById(@PathVariable("receivingEntryId") Integer receivingEntryId) {
        ReceivingEntry receivingEntry = receivingEntryService.getReceivingEntryById(receivingEntryId);
        return new ResponseEntity<>(receivingEntry, HttpStatus.OK);
    }
}
