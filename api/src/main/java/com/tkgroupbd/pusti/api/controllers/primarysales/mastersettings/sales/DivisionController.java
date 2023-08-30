package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.DivisionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.DivisionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Division")
@RestController
@RequestMapping("/division")
public class DivisionController {
    @Autowired
    DivisionService divisionService;

    // Create a new Division

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> divisionSave(@RequestBody DivisionRequest divisionRequest) {
        MessageResponse newDivision = divisionService.saveDivision(divisionRequest);
        return new ResponseEntity<>(newDivision, HttpStatus.CREATED);
    }

    // retrieve all Division
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<Division>> getAllBrand() {
        List<Division> divisions = divisionService.getAllDivision();
        return new ResponseEntity<>(divisions, HttpStatus.OK);
    }

    // Update a Division information
    @PutMapping("/update/{division_id}")
    public ResponseEntity<Optional<Division>> updateDivision(@PathVariable Integer division_id,
            @RequestBody DivisionRequest divisionRequest) {
        Optional<Division> updateDivision = divisionService.updateDivision(division_id, divisionRequest);
        return new ResponseEntity<Optional<Division>>(updateDivision, HttpStatus.OK);
    }

    // Division Status Change API
    @PutMapping("/statusChange/{division_id}")
    public ResponseEntity<Optional<Division>> changeDivisionStatus(@PathVariable Integer division_id,
            @RequestBody DivisionRequest divisionRequest) {
        Optional<Division> updateDivision = divisionService.updateDivisionStatus(division_id, divisionRequest);
        return new ResponseEntity<Optional<Division>>(updateDivision, HttpStatus.OK);
    }

    // Delete Division by id
    @DeleteMapping("/delete/{division_id}")
    public ResponseEntity<?> deleteDivisionById(@PathVariable("division_id") Integer division_id) {
        divisionService.deleteDivisionById(division_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // API to retrieve Division by id
    @GetMapping("/getById/{division_id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable("division_id") Integer division_id) {
        Division division = divisionService.findDivisionById(division_id);
        return new ResponseEntity<>(division, HttpStatus.OK);
    }

    // API for search by keyword

    @GetMapping("/getSortedByKey/{field}")
    private ApiResponse<List<Division>> getSortedDivisionByKey(@PathVariable String field) {
        List<Division> divisionList = divisionService.findSortedDivisionByKey(field);
        return new ApiResponse(divisionList.size(), divisionList);
    }

}
