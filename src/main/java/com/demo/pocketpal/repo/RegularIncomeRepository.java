package com.demo.pocketpal.repo;

import com.demo.pocketpal.entitiy.RegularIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularIncomeRepository extends JpaRepository<RegularIncome,Long> {
}
