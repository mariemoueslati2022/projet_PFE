package org.example.commandes.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;
    private Double prixUnitaire;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    // Référence à l'article (supposé être dans un autre microservice)
    private Long articleId;
}