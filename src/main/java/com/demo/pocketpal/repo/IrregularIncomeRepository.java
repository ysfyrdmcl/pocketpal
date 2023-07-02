package com.demo.pocketpal.repo;

import com.demo.pocketpal.entitiy.IrregularIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrregularIncomeRepository extends JpaRepository<IrregularIncome,Long> {
}
