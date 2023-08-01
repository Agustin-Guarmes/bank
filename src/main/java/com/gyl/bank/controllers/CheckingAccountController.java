package com.gyl.bank.controllers;

import com.gyl.bank.dto.request.CheckingAccountRequestDTO;
import com.gyl.bank.dto.response.CheckingAccountResponseDTO;
import com.gyl.bank.services.interfaces.CheckingAccountService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checking-accounts")
public class CheckingAccountController {
    private final CheckingAccountService checkingAccountService;
    private final ModelMapper modelMapper;

    public CheckingAccountController(CheckingAccountService checkingAccountService, ModelMapper modelMapper) {
        this.checkingAccountService = checkingAccountService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CheckingAccountResponseDTO> createCheckingAccount(@Valid @RequestBody CheckingAccountRequestDTO requestDTO) {
        CheckingAccountResponseDTO responseDTO = checkingAccountService.createCheckingAccount(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckingAccountResponseDTO> getCheckingAccountById(@PathVariable String id) {
        CheckingAccountResponseDTO responseDTO = checkingAccountService.getCheckingAccountById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CheckingAccountResponseDTO>> getAllCheckingAccounts() {
        List<CheckingAccountResponseDTO> responseDTOList = checkingAccountService.getAllCheckingAccounts();
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckingAccountResponseDTO> updateCheckingAccount(@PathVariable String id, @Valid @RequestBody CheckingAccountRequestDTO requestDTO) {
        CheckingAccountResponseDTO responseDTO = checkingAccountService.updateCheckingAccount(id, requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckingAccount(@PathVariable String id) {
        checkingAccountService.deleteCheckingAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
