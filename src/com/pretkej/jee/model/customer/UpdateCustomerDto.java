package com.pretkej.jee.model.customer;

public class UpdateCustomerDto {
    private String name;
    private String surname;
    private int birthYear;

    public UpdateCustomerDto(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "CreateCustomerDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
