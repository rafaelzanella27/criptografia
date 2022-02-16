package com.estudos.criptografia.repository;

import com.estudos.criptografia.domain.CustomerDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerDomain, Integer> {

    public Optional<CustomerDomain> findById(Integer integer);

    @Query("from CustomerDomain c inner join CustomerDomain cdb on c.document = c.document where cdb.document = :document")
    List<CustomerDomain> findAllByDocumentCustomer(@Param("document")String document);

    @Query("from CustomerDomain c where c.document = :document")
    Optional<CustomerDomain> findByDocumentCustomer(@Param("document")String document);

    @Query("from CustomerDomain c where c.id = :id")
    Optional<CustomerDomain> findByIdCustomer(@Param("id")Integer id);
}
