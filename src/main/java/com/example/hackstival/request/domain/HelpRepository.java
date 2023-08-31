package com.example.hackstival.request.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HelpRepository extends JpaRepository<Help,Long> {
    @Override
    Optional<Help> findById(Long aLong);
}