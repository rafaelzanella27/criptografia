package com.estudos.criptografia.controller;

import com.estudos.criptografia.domain.CustomerDomain;
import com.estudos.criptografia.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {


    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/salvar")
    public ResponseEntity<CustomerDomain> salvarNovoCustomer(@RequestBody CustomerDomain customer){
        //usuario.setPassword(encoder.encode(usuario.getPassword()));
        CustomerDomain customerDomain = new CustomerDomain();
        customerDomain.setId(customer.getId());
        customerDomain.setDocument(customer.getDocument());
        return ResponseEntity.ok(repository.save(customerDomain));
    }
}
