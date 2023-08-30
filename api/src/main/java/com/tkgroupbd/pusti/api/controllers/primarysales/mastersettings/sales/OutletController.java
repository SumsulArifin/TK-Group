package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Outlet;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.OutletRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.OutletServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Outlet")
@RestController
@RequestMapping("/outlet")
public class OutletController {

    @Autowired
    OutletServiceImpl outletService;

    // All outlets will show
    @GetMapping("/getAllOutlets")
    public ResponseEntity<List<Outlet>> getOutlets() {
        List<Outlet> outlet = outletService.getAllOutlet();
        return new ResponseEntity<>(outlet, HttpStatus.OK);
    }

    // all outlet will show which zone id is same
    @GetMapping("/getAllOutletByZoneId/{id}")
    public ResponseEntity<List<Outlet>> getAllOutletByZoneId(@PathVariable("id") Integer id) {
        List<Outlet> outlet = outletService.findOutletByZoneId(id);
        return new ResponseEntity<>(outlet, HttpStatus.OK);
    }

    // one outlet will add
    @PostMapping("/addOutlet")
    public ResponseEntity<MessageResponse> addOutlet(@RequestBody OutletRequest outletRequest) {
        MessageResponse newOutlets = outletService.createOutlet(outletRequest);
        return new ResponseEntity<>(newOutlets, HttpStatus.CREATED);
    }

    // delete one outlet
    @DeleteMapping("/deleteOutlet/{id}")
    public ResponseEntity<?> deleteOutlet(@PathVariable("id") Integer id) {
        outletService.deleteOutlet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // one outlet will return which id will give
    @GetMapping("/getOutletById/{id}")
    public ResponseEntity<Outlet> getOutletById(@PathVariable("id") Integer id) {
        Outlet outlet = outletService.getOutletById(id);
        return new ResponseEntity<>(outlet, HttpStatus.OK);
    }

    // update outlet for this
    @PutMapping("/updateOutlet/{id}")
    public ResponseEntity<Optional<Outlet>> updateZone(@PathVariable Integer id,
            @RequestBody OutletRequest outletRequest) {
        Optional<Outlet> outlet = outletService.updateOutlet(id, outletRequest);
        return new ResponseEntity<Optional<Outlet>>(outlet, HttpStatus.OK);
    }

    // outlet status will change for this
    @PutMapping("/updateOutletStatus/{id}")
    public ResponseEntity<Optional<Outlet>> updateZoneStatus(@PathVariable Integer id,
            @RequestBody OutletRequest outletRequest) {
        Optional<Outlet> updateZone = outletService.outletStatusChange(id, outletRequest);
        return new ResponseEntity<Optional<Outlet>>(updateZone, HttpStatus.OK);
    }

    // search by name with like operator
    @GetMapping("/search/outlet/by/name/{name}")
    private List<Outlet> findZoneByNameByKey(@PathVariable String name) {
        List<Outlet> allOultlets = outletService.findByOutletName(name);
        return allOultlets;
    }
}
