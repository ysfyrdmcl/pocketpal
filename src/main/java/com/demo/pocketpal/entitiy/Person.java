package com.demo.pocketpal.entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<RegularIncome> regularIncomes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<RegularExpense> regularExpenses;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<IrregularIncome> irregularIncomes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<IrregularExpense> irregularExpenses;
}
