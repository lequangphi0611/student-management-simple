package com.app.studentmanagement.util.impl;

import org.springframework.stereotype.Component;

import com.app.studentmanagement.dto.PersonDTO;
import com.app.studentmanagement.entity.Person;
import com.app.studentmanagement.util.Mapper;

@Component
public class PersonMapper implements Mapper<Person, PersonDTO> {

	@Override
	public PersonDTO parseDTO(Person entity) {
		return new PersonDTO(entity.getId(), entity.getName(), entity.isGender(), entity.getBirthday(), entity.isStatus());
	}

	@Override
	public Person parseEntity(PersonDTO dto) {
		return new Person(dto.getId(), dto.getName(), dto.isGender(), dto.getBirthday(), dto.isStatus());
	}

}
