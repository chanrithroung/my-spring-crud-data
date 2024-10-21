package com.example.crud;

import com.example.crud.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@GetMapping
	public List<Student> hello() {
		return List.of(
				new Student(
						"Raksmey Smos",
						"Raksmey@gmail.com",
						LocalDate.of(2004, Month.FEBRUARY, 24),
						20
				),
				new Student(
						"PinPin",
						"PinPin@gmail.com",
						LocalDate.of(2004, Month.FEBRUARY, 24),
						19
				)
		);
	}
}
