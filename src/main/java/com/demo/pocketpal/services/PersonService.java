package com.demo.pocketpal.services;
import com.demo.pocketpal.dto.request.IrregularFlowRequestDto;
import com.demo.pocketpal.dto.request.RegularFlowRequestDto;
import com.demo.pocketpal.dto.response.IrregularFlowResponseDto;
import com.demo.pocketpal.dto.response.PersonInfoResponseDto;
import com.demo.pocketpal.dto.response.RegularFlowResponseDto;
import com.demo.pocketpal.entitiy.*;
import com.demo.pocketpal.repo.*;
import com.demo.pocketpal.services.base.ServiceManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("DuplicatedCode")
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

    public Boolean createRegularExpense (RegularFlowRequestDto dto){

        Long currentUserIdOptional = Optional.of((Long) SecurityContextHolder.getContext().getAuthentication().getCredentials()).get();
        Person currentPerson = iPersonRepository.findById(currentUserIdOptional).orElseThrow(() -> new RuntimeException("Person is not Found"));

        regularExpenseRepository.save(RegularExpense.builder()
            .name(dto.getName())
            .amount(dto.getAmount())
            .expenseDayOfEachMonth(dto.getRegularFlowDayOfEachMonth())
                .person(currentPerson)
            .build());
    return true;
    }
    public Boolean deleteRegularExpense (Long id){
        regularExpenseRepository.deleteById(id);
        return true;
    }
    public RegularFlowResponseDto updateRegularExpense(Long id,RegularFlowRequestDto dto) {
        RegularExpense regularExpense = regularExpenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Regular Expense is not Found"));
        regularExpense.setName(dto.getName());
        regularExpense.setAmount(dto.getAmount());
        regularExpense.setExpenseDayOfEachMonth(dto.getRegularFlowDayOfEachMonth());
        regularExpenseRepository.save(regularExpense);
        return new RegularFlowResponseDto(regularExpense.getId(), regularExpense.getName(), regularExpense.getAmount(), regularExpense.getExpenseDayOfEachMonth());
    }
    public Boolean createRegularIncome (RegularFlowRequestDto dto){

        Long currentUserIdOptional = Optional.of((Long) SecurityContextHolder.getContext().getAuthentication().getCredentials()).get();
        Person currentPerson = iPersonRepository.findById(currentUserIdOptional).orElseThrow(() -> new RuntimeException("Person is not Found"));

        regularIncomeRepository.save(RegularIncome.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .incomeDayOfEachMonth(dto.getRegularFlowDayOfEachMonth())
                .person(currentPerson)
                .build());
        return true;
    }
    public Boolean deleteRegularIncome (Long id){
        regularIncomeRepository.deleteById(id);
        return true;
    }
    public RegularFlowResponseDto updateRegularIncome(Long id,RegularFlowRequestDto dto) {
        RegularIncome regularIncome = regularIncomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Regular Income is not Found"));
        regularIncome.setName(dto.getName());
        regularIncome.setAmount(dto.getAmount());
        regularIncome.setIncomeDayOfEachMonth(dto.getRegularFlowDayOfEachMonth());
        regularIncomeRepository.save(regularIncome);
        return new RegularFlowResponseDto(regularIncome.getId(), regularIncome.getName(), regularIncome.getAmount(), regularIncome.getIncomeDayOfEachMonth());
    }

    public Boolean createIrregularExpense(IrregularFlowRequestDto dto){
        Long currentUserIdOptional = Optional.of((Long) SecurityContextHolder.getContext().getAuthentication().getCredentials()).get();
        Person currentPerson = iPersonRepository.findById(currentUserIdOptional).orElseThrow(() -> new RuntimeException("Person is not Found"));

        irregularExpenseRepository.save(IrregularExpense.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .person(currentPerson)
                .build());
        return true;
    }
    public Boolean deleteIrregularExpense (Long id){
        irregularExpenseRepository.deleteById(id);
        return true;
    }
    public IrregularFlowResponseDto updateIrregularExpense(Long id,IrregularFlowRequestDto dto) {
        IrregularExpense irregularExpense = irregularExpenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Irregular Expense is not Found"));
        irregularExpense.setName(dto.getName());
        irregularExpense.setAmount(dto.getAmount());
        irregularExpense.setDate(dto.getDate());
        irregularExpenseRepository.save(irregularExpense);
        return new IrregularFlowResponseDto(irregularExpense.getId(), irregularExpense.getName(), irregularExpense.getAmount(), irregularExpense.getDate());
    }

    public Boolean createIrregularIncome(IrregularFlowRequestDto dto){
        Long currentUserIdOptional = Optional.of((Long) SecurityContextHolder.getContext().getAuthentication().getCredentials()).get();
        Person currentPerson = iPersonRepository.findById(currentUserIdOptional).orElseThrow(() -> new RuntimeException("Person is not Found"));

        irregularIncomeRepository.save(IrregularIncome.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .person(currentPerson)
                .build());
        return true;
    }
    public Boolean deleteIrregularIncome (Long id){
        irregularIncomeRepository.deleteById(id);
        return true;
    }
    public IrregularFlowResponseDto updateIrregularIncome(Long id,IrregularFlowRequestDto dto) {
        IrregularIncome irregularIncome = irregularIncomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Irregular Income is not Found"));
        irregularIncome.setName(dto.getName());
        irregularIncome.setAmount(dto.getAmount());
        irregularIncome.setDate(dto.getDate());
        irregularIncomeRepository.save(irregularIncome);
        return new IrregularFlowResponseDto(irregularIncome.getId(), irregularIncome.getName(), irregularIncome.getAmount(), irregularIncome.getDate());
    }

    public Boolean deletePerson(Long id){
        iPersonRepository.deleteById(id);
        return true;
    }
    public PersonInfoResponseDto getPersonInfoWithEmail(String email){
       Person person= iPersonRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Person is not Found"));

        return PersonInfoResponseDto.builder()
                .id(person.getId())
                .password(person.getPassword())
                .name(person.getName())
                .email(person.getEmail())
                .roles(person.getRoles())
                .regularIncomes(person.getRegularIncomes().stream().map(income -> new RegularFlowResponseDto(income.getId(), income.getName(), income.getAmount(), income.getIncomeDayOfEachMonth())).collect(Collectors.toList()))
                .regularExpenses(person.getRegularExpenses().stream().map(expense -> new RegularFlowResponseDto(expense.getId(), expense.getName(), expense.getAmount(), expense.getExpenseDayOfEachMonth())).collect(Collectors.toList()))
                .irregularExpenses(person.getIrregularExpenses().stream().map(expense -> new IrregularFlowResponseDto(expense.getId(), expense.getName(), expense.getAmount(), expense.getDate())).collect(Collectors.toList()))
                .irregularIncomes(person.getIrregularIncomes().stream().map(income -> new IrregularFlowResponseDto(income.getId(), income.getName(), income.getAmount(), income.getDate())).collect(Collectors.toList()))
                .build();
    }

}
