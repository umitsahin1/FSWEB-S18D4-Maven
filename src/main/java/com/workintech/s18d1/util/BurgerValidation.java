package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void validateBurger(Burger burger) {
        if (burger.getPrice() <= 0) {
            throw new BurgerException("Price must be greater than zero", HttpStatus.BAD_REQUEST);
        }

        if (burger.getName() == null || burger.getName().isEmpty()) {
            throw new BurgerException("Burger name must not be empty", HttpStatus.BAD_REQUEST);
        }

        if (burger.getContents() == null || burger.getContents().isEmpty()) {
            throw new BurgerException("Burger contents must not be empty", HttpStatus.BAD_REQUEST);
        }
        if (burger == null) {
            throw new BurgerException("Burger not found with id: " , HttpStatus.NOT_FOUND);
        }
    }
}
