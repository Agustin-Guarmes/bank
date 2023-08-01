package com.gyl.bank.dto.request;


import jakarta.validation.constraints.Size;

public class BankBranchRequestDTO {
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres.")
    private String name;

    @Size(min = 2, max = 100, message = "La ubicación debe tener entre 2 y 100 caracteres.")
    private String location;

    public BankBranchRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
