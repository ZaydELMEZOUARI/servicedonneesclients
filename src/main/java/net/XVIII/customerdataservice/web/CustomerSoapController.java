package net.XVIII.customerdataservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.XVIII.customerdataservice.dto.CustomerRequest;
import net.XVIII.customerdataservice.entities.Customer;
import net.XVIII.customerdataservice.mappers.CustomerMapper;
import net.XVIII.customerdataservice.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@WebService(serviceName = "CustomerWS")
@Component
@AllArgsConstructor
public class CustomerSoapController {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    //Return List of customers
    @WebMethod
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    //Return one customer
    @WebMethod
    public Customer customerById(@WebParam(name="id") Long id){
        return customerRepository.findById(id).get();
    }

    public Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customerRequest){
        Customer customer = customerMapper.from(customerRequest);
        return customerRepository.save(customer);

    }

}
