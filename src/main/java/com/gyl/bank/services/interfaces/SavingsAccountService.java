package com.gyl.bank.services.interfaces;

import com.gyl.bank.dto.request.SavingsAccountRequestDTO;
import com.gyl.bank.dto.response.SavingsAccountResponseDTO;

import java.util.List;

public interface SavingsAccountService {
    SavingsAccountResponseDTO createSavingsAccount(SavingsAccountRequestDTO requestDTO);
    SavingsAccountResponseDTO getSavingsAccountById(String id);
    List<SavingsAccountResponseDTO> getAllSavingsAccounts();
    SavingsAccountResponseDTO updateSavingsAccount(String id, SavingsAccountRequestDTO requestDTO);
    void deleteSavingsAccount(String id);
}
