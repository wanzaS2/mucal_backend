package com.example.mucal.repository;

import com.example.mucal.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{
    boolean existsByTitle(String title);
    Show findByTitle(String title);
}
