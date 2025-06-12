package org.example.articles.Service;

import org.example.articles.Repository.CategorieRepository;
import org.example.articles.Entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository CategorieRepository;

    public List<Categorie> getAll() {
        return CategorieRepository.findAll();
    }

    public Categorie getById(Long id) {
        return CategorieRepository.findById(id).orElse(null);
    }

    public Categorie save(Categorie categorie) {
        return CategorieRepository.save(categorie);
    }

    public void delete(Long id) {
        CategorieRepository.deleteById(id);
    }
}
