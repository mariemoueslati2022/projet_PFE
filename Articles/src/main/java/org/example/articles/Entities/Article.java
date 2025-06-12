package org.example.articles.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private String designation;
    private int quantiteStockEntree;
    private int quantiteStockSortie;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
