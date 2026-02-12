package com.example.be_study_2026.week6;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Menu> findByName(String name);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select m from Menu m where m.id = :id")
    Optional<Menu> findByIdWithLock(@Param("id") Long id);
}
