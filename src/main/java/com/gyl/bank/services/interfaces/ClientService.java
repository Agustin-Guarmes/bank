package com.gyl.bank.services.interfaces;

import com.gyl.bank.dto.request.ClientRequestDTO;
import com.gyl.bank.dto.response.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    ClientResponseDTO createClient(ClientRequestDTO requestDTO);
    ClientResponseDTO getClientById(String id);
    List<ClientResponseDTO> getAllClients();
    ClientResponseDTO updateClient(String id, ClientRequestDTO requestDTO);
    void deleteClient(String id);
}
