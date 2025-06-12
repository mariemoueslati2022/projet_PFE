package org.example.articles.Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.example.articles.Entities.Article;
import org.example.articles.Repository.ArticleRepository;


@Service
public class ArticleService {
    @Autowired
    private ArticleRepository ArticleRepository;

    public List<Article> getAll() {
        return ArticleRepository.findAll();
    }

    public Article getById(Long id) {
        return ArticleRepository.findById(id).orElse(null);
    }

    public Article save(Article article) {
        return ArticleRepository.save(article);
    }

    public void delete(Long id) {
        ArticleRepository.deleteById(id);
    }
}
