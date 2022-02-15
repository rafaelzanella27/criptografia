package com.estudos.criptografia.repository;

import com.estudos.criptografia.domain.CustomerDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerDomain, Integer> {

    public Optional<CustomerDomain> findById(Integer integer);
}
