package com.demo.pocketpal.repo;

import com.demo.pocketpal.entitiy.IrregularExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrregularExpenseRepository extends JpaRepository<IrregularExpense,Long> {
}
