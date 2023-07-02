package com.demo.pocketpal.services;

import com.demo.pocketpal.entitiy.Person;
import com.demo.pocketpal.repo.*;
import com.demo.pocketpal.services.base.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends ServiceManager<Person, Long> {
    private final IPersonRepository iPersonRepository;
    private final IrregularExpenseRepository irregularExpenseRepository;
    private final RegularExpenseRepository regularExpenseRepository;
    private final RegularIncomeRepository regularIncomeRepository;
    private final IrregularIncomeRepository irregularIncomeRepository;

    public PersonService(IPersonRepository iPersonRepository, IrregularExpenseRepository irregularExpenseRepository,
                         RegularExpenseRepository regularExpenseRepository, RegularIncomeRepository regularIncomeRepository,
                         IrregularIncomeRepository irregularIncomeRepository) {
        super(iPersonRepository);
        this.iPersonRepository = iPersonRepository;
        this.irregularExpenseRepository = irregularExpenseRepository;
        this.regularExpenseRepository = regularExpenseRepository;
        this.regularIncomeRepository = regularIncomeRepository;
        this.irregularIncomeRepository = irregularIncomeRepository;
    }


}
