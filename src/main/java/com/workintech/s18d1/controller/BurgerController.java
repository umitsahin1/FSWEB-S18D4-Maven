package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

    BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl = burgerDaoImpl;
    }

    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerDaoImpl.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        return burgerDaoImpl.findById(id);
    }

    @PostMapping
    public Burger addBurger(@RequestBody Burger burger) {
        return burgerDaoImpl.save(burger);
    }

    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable Long id, @RequestBody Burger burger) {
        Burger existingBurger = burgerDaoImpl.findById(id);
        if (existingBurger != null) {
            burger.setId(id); // ID'yi koruyarak güncelleme yap
            burgerDaoImpl.update(burger);
            return burger;
        }
        return null; // Burger bulunamazsa null döner
    }

    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable Long id) {
        Burger burger = burgerDaoImpl.findById(id);
        if (burger != null) {
            burgerDaoImpl.remove(id);
        }
    }

    @GetMapping("/findByPrice")
    public List<Burger> getBurgersByPrice(@RequestParam Integer price) {
        return burgerDaoImpl.findByPrice(price);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> getBurgersByBreadType(@RequestParam String breadType) {
        return burgerDaoImpl.findByBreadType(BreadType.valueOf(breadType));
    }


    @GetMapping("/findByContent")
    public List<Burger> getBurgersByContent(@RequestParam String content) {
        return burgerDaoImpl.findByContent(content);
    }
}
