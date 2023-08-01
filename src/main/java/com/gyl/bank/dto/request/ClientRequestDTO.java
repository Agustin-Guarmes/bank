package com.gyl.bank.dto.request;

import jakarta.validation.constraints.Size;

public class ClientRequestDTO {
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    private String firstName;
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres.")
    private String lastName;
    @Size(min = 7, max = 12, message = "El número de identificación debe tener entre 7 y 12 caracteres.")
    private String identificationNumber;
    @Size(min = 4, max = 50, message = "La contraseña debe tener entre 4 y 50 caracteres.")
    private String password;

    public ClientRequestDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
