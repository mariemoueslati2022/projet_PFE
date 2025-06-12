package org.example.articles.Controller;

import org.example.articles.Service.ArticleService;
import org.example.articles.Entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAll() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @PostMapping
    public Article save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
