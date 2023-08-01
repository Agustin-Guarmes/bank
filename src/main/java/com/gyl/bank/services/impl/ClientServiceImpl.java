package com.gyl.bank.services.impl;

import com.gyl.bank.dto.request.ClientRequestDTO;
import com.gyl.bank.dto.response.ClientResponseDTO;
import com.gyl.bank.entities.Client;
import com.gyl.bank.repositories.ClientRepository;
import com.gyl.bank.services.interfaces.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO requestDTO) {
        Client client = modelMapper.map(requestDTO, Client.class);

        clientRepository.save(client);
        return modelMapper.map(client, ClientResponseDTO.class);
    }

    @Override
    public ClientResponseDTO getClientById(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
        return modelMapper.map(client, ClientResponseDTO.class);
    }

    @Override
    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO updateClient(String id, ClientRequestDTO requestDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));

        modelMapper.map(requestDTO, client);

        clientRepository.save(client);

        return modelMapper.map(client, ClientResponseDTO.class);
    }

    @Override
    public void deleteClient(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con el ID: " + id));
        clientRepository.delete(client);
    }
}
