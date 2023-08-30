package com.tkgroupbd.pusti.api.controllers.primarysales.primaryorders;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.OrderApprovalSettings;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.OrderApprovalSettingsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.primaryorders.OrderApprovalSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orderApprovalSettings")
public class OrderApprovalSettingsController {
    @Autowired
    OrderApprovalSettingsService orderApprovalSettingsService;


    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addOrderApprovalSettings(@RequestBody OrderApprovalSettingsRequest request) {
        MessageResponse orderApprovalSettings = orderApprovalSettingsService.createOrderApprovalSettings(request);
        return new ResponseEntity<>(orderApprovalSettings, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<OrderApprovalSettings>> updateOrderApprovalSettings(@PathVariable Integer id,
                                                                               @RequestBody OrderApprovalSettingsRequest request) {
        Optional<OrderApprovalSettings> orderApprovalSettings = orderApprovalSettingsService.updateOrderApprovalSettings(id, request);
        return new ResponseEntity<Optional<OrderApprovalSettings>>(orderApprovalSettings, HttpStatus.OK);
    }
    @GetMapping("/getBy/{id}")
    public OrderApprovalSettings getOrderApprovalSettingsById(@PathVariable int id) {
        return orderApprovalSettingsService.getOrderApprovalSettingsById(id);
    }
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<OrderApprovalSettings>> getOrderApprovalSettings() {
        List<OrderApprovalSettings> orderApprovalSettings = orderApprovalSettingsService.getAllOrderApprovalSettings();
        return new ResponseEntity<>(orderApprovalSettings, HttpStatus.OK);
    }


}
