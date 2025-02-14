package com.workintech.s18d1.controller;


import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger addBurger(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger) {
            burgerDao.update(burger);
            return burger;
    }

    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable Long id) {
        Burger burger = burgerDao.findById(id);
        if (burger != null) {
            burgerDao.remove(id);
        }
    }

    @GetMapping("/price/{price}")
    public List<Burger> getBurgersByPrice(@PathVariable("price") Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> getBurgersByBreadType(@PathVariable("breadType") String breadType) {
        return burgerDao.findByBreadType(BreadType.valueOf(breadType));
    }


    @GetMapping("/content/{content}")
    public List<Burger> getBurgersByContent(@PathVariable("content") String content) {
        return burgerDao.findByContent(content);
    }
}
