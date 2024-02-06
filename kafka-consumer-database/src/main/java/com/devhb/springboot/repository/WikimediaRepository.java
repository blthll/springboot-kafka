package com.devhb.springboot.repository;

import com.devhb.springboot.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {
}
