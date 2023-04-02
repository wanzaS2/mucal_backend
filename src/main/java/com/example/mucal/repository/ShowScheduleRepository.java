package com.example.mucal.repository;

import com.example.mucal.domain.ShowSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowScheduleRepository extends JpaRepository<ShowSchedule, Long> {
}
