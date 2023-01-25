package com.devsuperior.bds03.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.devsuperior.bds03.controllers.exceptions.FieldMessage;
import com.devsuperior.bds03.dto.EmployeeDTO;

public class EmployeeInsertValidator implements ConstraintValidator<EmployeeInsertValid, EmployeeDTO> {
	
	
	@Override
	public void initialize(EmployeeInsertValid ann) {
	}

	@Override
	public boolean isValid(EmployeeDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
