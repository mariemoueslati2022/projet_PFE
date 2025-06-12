package org.example.articles.Controller;

import org.example.articles.Service.CategorieService;
import org.example.articles.Entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAll() {
        return categorieService.getAll();
    }

    @GetMapping("/{id}")
    public Categorie getById(@PathVariable Long id) {
        return categorieService.getById(id);
    }

    @PostMapping
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categorieService.delete(id);
    }
}
