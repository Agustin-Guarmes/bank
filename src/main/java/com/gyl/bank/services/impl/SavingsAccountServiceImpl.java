package com.gyl.bank.services.impl;

import com.gyl.bank.dto.request.SavingsAccountRequestDTO;
import com.gyl.bank.dto.response.SavingsAccountResponseDTO;
import com.gyl.bank.entities.SavingsAccount;
import com.gyl.bank.repositories.SavingsAccountRepository;
import com.gyl.bank.services.interfaces.SavingsAccountService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {
    private final SavingsAccountRepository savingsAccountRepository;
    private final ModelMapper modelMapper;

    public SavingsAccountServiceImpl(SavingsAccountRepository savingsAccountRepository, ModelMapper modelMapper) {
        this.savingsAccountRepository = savingsAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SavingsAccountResponseDTO createSavingsAccount(SavingsAccountRequestDTO requestDTO) {
        SavingsAccount savingsAccount = modelMapper.map(requestDTO, SavingsAccount.class);

        savingsAccountRepository.save(savingsAccount);
        return modelMapper.map(savingsAccount, SavingsAccountResponseDTO.class);
    }

    @Override
    public SavingsAccountResponseDTO getSavingsAccountById(String id) {
        SavingsAccount savingsAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta de ahorro no encontrada con el ID: " + id));
        return modelMapper.map(savingsAccount, SavingsAccountResponseDTO.class);
    }

    @Override
    public List<SavingsAccountResponseDTO> getAllSavingsAccounts() {
        List<SavingsAccount> savingsAccounts = savingsAccountRepository.findAll();
        return savingsAccounts.stream()
                .map(savingsAccount -> modelMapper.map(savingsAccount, SavingsAccountResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SavingsAccountResponseDTO updateSavingsAccount(String id, SavingsAccountRequestDTO requestDTO) {
        SavingsAccount savingsAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta de ahorro no encontrada con el ID: " + id));

        modelMapper.map(requestDTO, savingsAccount);

        savingsAccountRepository.save(savingsAccount);

        return modelMapper.map(savingsAccount, SavingsAccountResponseDTO.class);
    }

    @Override
    public void deleteSavingsAccount(String id) {
        SavingsAccount savingsAccount = savingsAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuenta de ahorro no encontrada con el ID: " + id));
        savingsAccountRepository.delete(savingsAccount);
    }
}
