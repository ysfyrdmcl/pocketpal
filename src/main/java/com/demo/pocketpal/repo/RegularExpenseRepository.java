package com.demo.pocketpal.repo;

import com.demo.pocketpal.entitiy.RegularExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegularExpenseRepository  extends JpaRepository<RegularExpense,Long> {
}
