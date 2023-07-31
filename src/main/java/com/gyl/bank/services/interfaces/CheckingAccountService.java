package com.gyl.bank.services.interfaces;

import com.gyl.bank.dto.request.CheckingAccountRequestDTO;
import com.gyl.bank.dto.response.CheckingAccountResponseDTO;

import java.util.List;

public interface CheckingAccountService {
    CheckingAccountResponseDTO createCheckingAccount(CheckingAccountRequestDTO requestDTO);
    CheckingAccountResponseDTO getCheckingAccountById(String id);
    List<CheckingAccountResponseDTO> getAllCheckingAccounts();
    CheckingAccountResponseDTO updateCheckingAccount(String id, CheckingAccountRequestDTO requestDTO);
    void deleteCheckingAccount(String id);
}
