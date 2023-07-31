package com.gyl.bank.dto.request;

import javax.validation.constraints.Size;

public class EmployeeRequestDTO {
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    private String firstName;
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres.")
    private String lastName;
    @Size(min = 4, max = 50, message = "El cargo debe tener entre 4 y 50 caracteres.")
    private String position;
    @Size(min = 4, max = 50, message = "La contraseña debe tener entre 4 y 50 caracteres.")
    private String password;

    public EmployeeRequestDTO() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
