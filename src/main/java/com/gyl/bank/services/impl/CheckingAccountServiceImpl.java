package com.gyl.bank.services.impl;

import com.gyl.bank.dto.request.CheckingAccountRequestDTO;
import com.gyl.bank.dto.response.CheckingAccountResponseDTO;
import com.gyl.bank.entities.CheckingAccount;
import com.gyl.bank.repositories.CheckingAccountRepository;
import com.gyl.bank.services.interfaces.CheckingAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckingAccountServiceImpl implements CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;
    private final ModelMapper modelMapper;

    public CheckingAccountServiceImpl(CheckingAccountRepository checkingAccountRepository, ModelMapper modelMapper) {
        this.checkingAccountRepository = checkingAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CheckingAccountResponseDTO createCheckingAccount(CheckingAccountRequestDTO requestDTO) {
        CheckingAccount checkingAccount = modelMapper.map(requestDTO, CheckingAccount.class);

        checkingAccountRepository.save(checkingAccount);
        return modelMapper.map(checkingAccount, CheckingAccountResponseDTO.class);
    }

    @Override
    public CheckingAccountResponseDTO getCheckingAccountById(String id) {
        CheckingAccount checkingAccount = checkingAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta corriente no encontrada con el ID: " + id));
        return modelMapper.map(checkingAccount, CheckingAccountResponseDTO.class);
    }

    @Override
    public List<CheckingAccountResponseDTO> getAllCheckingAccounts() {
        List<CheckingAccount> checkingAccounts = checkingAccountRepository.findAll();
        return checkingAccounts.stream()
                .map(checkingAccount -> modelMapper.map(checkingAccount, CheckingAccountResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CheckingAccountResponseDTO updateCheckingAccount(String id, CheckingAccountRequestDTO requestDTO) {
        CheckingAccount checkingAccount = checkingAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta corriente no encontrada con el ID: " + id));

        modelMapper.map(requestDTO, checkingAccount);

        checkingAccountRepository.save(checkingAccount);

        return modelMapper.map(checkingAccount, CheckingAccountResponseDTO.class);
    }

    @Override
    public void deleteCheckingAccount(String id) {
        CheckingAccount checkingAccount = checkingAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta corriente no encontrada con el ID: " + id));
        checkingAccountRepository.delete(checkingAccount);
    }
}
