package com.pretkej.jee.model.customer;

import com.pretkej.jee.model.customer.CreateCustomerDto;
import com.pretkej.jee.model.customer.Customer;
import com.pretkej.jee.model.customer.CustomerDto;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;
@Stateless
public class CustomerService {
    private List<Customer> customers;
    private static int customerId = 0;
    {
        addCustomer(new CreateCustomerDto("Jan", "Zbyszard", 1999));
        addCustomer(new CreateCustomerDto("Rysiek", "Zibi", 1998));
    }

    public List<CustomerDto> getAllCustomers() {
        return customers.stream()
                .map((customer -> toCustomerDTO(customer)))
                .collect(Collectors.toList());
    }

    public CustomerDto addCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = toCustomer(createCustomerDto);
        return toCustomerDTO(customer);
    }

    public void deleteCustomer(int customerId) {
        customers.removeIf((customer) -> customer.getId() == customerId);
    }

    public CustomerDto updateCustomer(int customerId, String name, String surname, int birthYear) throws Exception {
        Customer customer = customers.stream()
                .filter((custmr) -> custmr.getId() == customerId)
                .findFirst()
                .orElseThrow(() -> new Exception("Something wrong"));

            customer.setName(name);
            customer.setSurname(surname);
            customer.setBirthYear(birthYear);
            return toCustomerDTO(customer);
    }

    private CustomerDto toCustomerDTO(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getSurname(), customer.getBirthYear());
    }

    private Customer toCustomer(CreateCustomerDto createCustomerDto) {
        return new Customer(customerId++, createCustomerDto.getName(), createCustomerDto.getSurname(),
                createCustomerDto.getBirthYear());
    }
}
