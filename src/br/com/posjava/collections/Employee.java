package br.com.posjava.collections;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Employee(
   String name,
   LocalDate birthDate,
   BigDecimal salary,
   String department) {}
