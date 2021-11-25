package com.example.demo.repository;

import com.example.demo.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Table> findById (Integer id);
}
