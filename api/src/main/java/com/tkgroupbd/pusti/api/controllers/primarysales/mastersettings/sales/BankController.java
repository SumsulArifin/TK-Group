package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Bank;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.BankRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.BankServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Tag(name = "Bank")
@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankServiceImpl bankService;

    @GetMapping("/getAllBanks")
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }

    @PostMapping("/addBank")
    public ResponseEntity<MessageResponse> addBank(@RequestBody BankRequest bankRequest) {
        MessageResponse newBank = bankService.addBank(bankRequest);
        return new ResponseEntity<>(newBank, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBank/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable("id") Integer id) {
        bankService.deleteBank(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getBankById/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable("id") Integer id) {
        Bank bank = bankService.getBankById(id);
        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    @PutMapping("/updateBank/{id}")
    public ResponseEntity<Optional<Bank>> updateBank(@PathVariable Integer id,
            @RequestBody BankRequest bankRequest) {
        Optional<Bank> updateBank = bankService.updateBank(id, bankRequest);
        return new ResponseEntity<Optional<Bank>>(updateBank, HttpStatus.OK);
    }

    @GetMapping("/bankSortedFor/{field}")
    private ApiResponse<List<Bank>> getBankSortedFor(@PathVariable String field) {
        List<Bank> bankList = bankService.findSortedBanksByKey(field);
        return new ApiResponse(bankList.size(), bankList);
    }

    @GetMapping("/getPaginatedBank/{offset}/{pageSize}")
    private ApiResponse<Page<Bank>> getPaginatedBanks(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Bank> paginatedBanks = bankService.findBankByPagination(offset, pageSize);
        return new ApiResponse(paginatedBanks.getSize(), paginatedBanks);
    }

    @GetMapping("/getPaginatedBankAndSort/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<Bank>> getPaginatedBankAndSort(@PathVariable int offset,
            @PathVariable int pageSize, @PathVariable String field) {
        Page<Bank> paginatedSortedBanks = bankService.findSortedBankByPagination(offset, pageSize, field);
        return new ApiResponse(paginatedSortedBanks.getSize(), paginatedSortedBanks);
    }

    @GetMapping("/search/bank/by/name/{name}")
    private List<Bank> findBankByName(@PathVariable String name) {
        List<Bank> allBanks = bankService.findBankByBankName(name);
        return allBanks;
    }

}