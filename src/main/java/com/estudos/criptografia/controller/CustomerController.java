package com.estudos.criptografia.controller;

import com.estudos.criptografia.domain.CustomerDomain;
import com.estudos.criptografia.repository.CustomerRepository;
import com.estudos.criptografia.textencyptor.CriptoTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    @Autowired(required = false)
    CriptoTextEncryptor encryptor;

    public CustomerController(CustomerRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    //Salva criptografando com Bcrypt
    @PostMapping("/salvar")
    public ResponseEntity<CustomerDomain> salvarNovoCustomer(@RequestBody CustomerDomain customer){
        CustomerDomain customerDomain = new CustomerDomain();
        customerDomain.setId(customer.getId());
        customerDomain.setDocument(encoder.encode(customer.getDocument()));
        customerDomain.setNome(encoder.encode(customer.getNome()));
        return ResponseEntity.ok(repository.save(customerDomain));
    }

    //Salva criptografando com TextEncryptor
    @PostMapping("/save")
    public ResponseEntity<CustomerDomain> saveNovoCustomer(@RequestBody CustomerDomain customer){
        CustomerDomain customerDomain = new CustomerDomain();
        customerDomain.setId(customer.getId());
        customerDomain.setDocument(encryptor.encrypt(customer.getDocument()));
        customerDomain.setNome(encryptor.encrypt(customer.getNome()));
        return ResponseEntity.ok(repository.save(customerDomain));
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<CustomerDomain>> listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/consultarTodosPorDocument/{document}")
    public ResponseEntity<List<CustomerDomain>> consultaTodosPorDocument(@PathVariable("document") String document){
        return ResponseEntity.ok(repository.findAllByDocumentCustomer(document));
    }

    @GetMapping("/consultarPorDocument/{document}")
    public ResponseEntity consultaPorDocument(@PathVariable("document") String document){

        Optional<CustomerDomain> customer = repository.findByDocumentCustomer(document);
        if (!customer.isEmpty()){
            encryptor.decrypt(customer.get().getDocument());
            encryptor.decrypt(customer.get().getNome());
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/consultarPorId/{id}")
    public ResponseEntity consultaPorId(@PathVariable("id") Integer id){

        Optional<CustomerDomain> customer = repository.findByIdCustomer(id);
        if (!customer.isEmpty()){
            encryptor.decrypt(customer.get().getDocument());
            encryptor.decrypt(customer.get().getNome());
        }
        return ResponseEntity.ok(customer);
    }

}
