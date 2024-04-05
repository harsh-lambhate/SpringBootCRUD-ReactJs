package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Coder;

@Repository
public interface CoderRepository extends JpaRepository<Coder, String> {
    // all crud database methods
}
