package com.java_backend.Finance_Tracker_Java_Springboot.Repository;

import com.java_backend.Finance_Tracker_Java_Springboot.entity.Entry;
import com.java_backend.Finance_Tracker_Java_Springboot.entity.EntryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {

    @Query("SELECT e FROM Entry e " +
            "WHERE (:category IS NULL OR e.category = :category) " +
            "AND (:type IS NULL OR e.type = :type) " +
            "AND (:startDate IS NULL OR e.date >= :startDate) " +
            "AND (:endDate IS NULL OR e.date <= :endDate)")
    List<Entry> findByFilters(@Param("category") String category,
                              @Param("type") EntryType type,
                              @Param("startDate") LocalDate startDate,
                              @Param("endDate") LocalDate endDate);
}

