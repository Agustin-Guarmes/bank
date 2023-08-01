package com.gyl.bank.controllers;

import com.gyl.bank.dto.request.BankBranchRequestDTO;
import com.gyl.bank.dto.response.BankBranchResponseDTO;
import com.gyl.bank.services.interfaces.BankBranchService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-branches")
public class BankBranchController {
    private final BankBranchService bankBranchService;
    private final ModelMapper modelMapper;

    public BankBranchController(BankBranchService bankBranchService, ModelMapper modelMapper) {
        this.bankBranchService = bankBranchService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<BankBranchResponseDTO> createBankBranch(@Valid @RequestBody BankBranchRequestDTO requestDTO) {
        BankBranchResponseDTO responseDTO = bankBranchService.createBankBranch(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankBranchResponseDTO> getBankBranchById(@PathVariable String id) {
        BankBranchResponseDTO responseDTO = bankBranchService.getBankBranchById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BankBranchResponseDTO>> getAllBankBranches() {
        List<BankBranchResponseDTO> responseDTOList = bankBranchService.getAllBankBranches();
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankBranchResponseDTO> updateBankBranch(@PathVariable String id, @Valid @RequestBody BankBranchRequestDTO requestDTO) {
        BankBranchResponseDTO responseDTO = bankBranchService.updateBankBranch(id, requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankBranch(@PathVariable String id) {
        bankBranchService.deleteBankBranch(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
