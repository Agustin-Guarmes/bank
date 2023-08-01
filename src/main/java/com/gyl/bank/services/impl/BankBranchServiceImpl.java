package com.gyl.bank.services.impl;

import com.gyl.bank.dto.request.BankBranchRequestDTO;
import com.gyl.bank.dto.response.BankBranchResponseDTO;
import com.gyl.bank.entities.BankBranch;
import com.gyl.bank.repositories.BankBranchRepository;
import com.gyl.bank.services.interfaces.BankBranchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankBranchServiceImpl implements BankBranchService {
    private final BankBranchRepository bankBranchRepository;
    private final ModelMapper modelMapper;

    public BankBranchServiceImpl(BankBranchRepository bankBranchRepository, ModelMapper modelMapper) {
        this.bankBranchRepository = bankBranchRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BankBranchResponseDTO createBankBranch(BankBranchRequestDTO requestDTO) {
        BankBranch bankBranch = modelMapper.map(requestDTO, BankBranch.class);

        bankBranchRepository.save(bankBranch);
        return modelMapper.map(bankBranch, BankBranchResponseDTO.class);
    }

    @Override
    public BankBranchResponseDTO getBankBranchById(String id) {
        BankBranch bankBranch = bankBranchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada con el ID: " + id));
        return modelMapper.map(bankBranch, BankBranchResponseDTO.class);
    }

    @Override
    public List<BankBranchResponseDTO> getAllBankBranches() {
        List<BankBranch> bankBranches = bankBranchRepository.findAll();
        return bankBranches.stream()
                .map(bankBranch -> modelMapper.map(bankBranch, BankBranchResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BankBranchResponseDTO updateBankBranch(String id, BankBranchRequestDTO requestDTO) {
        BankBranch bankBranch = bankBranchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada con el ID: " + id));

        modelMapper.map(requestDTO, bankBranch);

        bankBranchRepository.save(bankBranch);

        return modelMapper.map(bankBranch, BankBranchResponseDTO.class);
    }

    @Override
    public void deleteBankBranch(String id) {
        BankBranch bankBranch = bankBranchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada con el ID: " + id));
        bankBranchRepository.delete(bankBranch);
    }
}
