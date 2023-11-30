package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validates that the inventory of a Part is within the allowed maximum.
 */
public class PartInventoryValidator implements ConstraintValidator<ValidPartInventory, Part> {

    @Override
    public void initialize(ValidPartInventory constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        // Validate the inventory
        return part.getInv() <= part.getMaximum();
    }
}
