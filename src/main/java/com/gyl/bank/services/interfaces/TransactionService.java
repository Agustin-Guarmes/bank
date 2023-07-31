package com.gyl.bank.services.interfaces;

import com.gyl.bank.dto.request.TransactionRequestDTO;
import com.gyl.bank.dto.response.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {
    TransactionResponseDTO createTransaction(TransactionRequestDTO requestDTO);
    TransactionResponseDTO getTransactionById(Long id);
    List<TransactionResponseDTO> getAllTransactions();
    // No se incluye el método para actualizar transacciones, ya que no se deberían modificar
    // Se podría tener un método para revertir una transacción si es necesario
    void deleteTransaction(Long id);
}
