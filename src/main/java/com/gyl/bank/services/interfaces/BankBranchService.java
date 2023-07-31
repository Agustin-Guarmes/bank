package com.gyl.bank.services.interfaces;

import com.gyl.bank.dto.request.BankBranchRequestDTO;
import com.gyl.bank.dto.response.BankBranchResponseDTO;

import java.util.List;

public interface BankBranchService {
    BankBranchResponseDTO createBankBranch(BankBranchRequestDTO requestDTO);
    BankBranchResponseDTO getBankBranchById(String id);
    List<BankBranchResponseDTO> getAllBankBranches();
    BankBranchResponseDTO updateBankBranch(String id, BankBranchRequestDTO requestDTO);
    void deleteBankBranch(String id);
}
