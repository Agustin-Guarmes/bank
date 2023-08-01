package com.gyl.bank.services.impl;

import com.gyl.bank.dto.request.TransactionRequestDTO;
import com.gyl.bank.dto.response.TransactionResponseDTO;
import com.gyl.bank.entities.Transaction;
import com.gyl.bank.repositories.TransactionRepository;
import com.gyl.bank.services.interfaces.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO requestDTO) {
        Transaction transaction = modelMapper.map(requestDTO, Transaction.class);

        transactionRepository.save(transaction);
        return modelMapper.map(transaction, TransactionResponseDTO.class);
    }

    @Override
    public TransactionResponseDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transacción no encontrada con el ID: " + id));
        return modelMapper.map(transaction, TransactionResponseDTO.class);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transacción no encontrada con el ID: " + id));
        transactionRepository.delete(transaction);
    }
}
