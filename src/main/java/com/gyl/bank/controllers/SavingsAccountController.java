package com.gyl.bank.controllers;

import com.gyl.bank.dto.request.SavingsAccountRequestDTO;
import com.gyl.bank.dto.response.SavingsAccountResponseDTO;
import com.gyl.bank.services.interfaces.SavingsAccountService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings-accounts")
public class SavingsAccountController {
    private final SavingsAccountService savingsAccountService;
    private final ModelMapper modelMapper;

    public SavingsAccountController(SavingsAccountService savingsAccountService, ModelMapper modelMapper) {
        this.savingsAccountService = savingsAccountService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<SavingsAccountResponseDTO> createSavingsAccount(@Valid @RequestBody SavingsAccountRequestDTO requestDTO) {
        SavingsAccountResponseDTO responseDTO = savingsAccountService.createSavingsAccount(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsAccountResponseDTO> getSavingsAccountById(@PathVariable String id) {
        SavingsAccountResponseDTO responseDTO = savingsAccountService.getSavingsAccountById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SavingsAccountResponseDTO>> getAllSavingsAccounts() {
        List<SavingsAccountResponseDTO> responseDTOList = savingsAccountService.getAllSavingsAccounts();
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsAccountResponseDTO> updateSavingsAccount(@PathVariable String id, @Valid @RequestBody SavingsAccountRequestDTO requestDTO) {
        SavingsAccountResponseDTO responseDTO = savingsAccountService.updateSavingsAccount(id, requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsAccount(@PathVariable String id) {
        savingsAccountService.deleteSavingsAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
