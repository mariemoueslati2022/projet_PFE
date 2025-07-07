package org.example.commandes.Entities;
import org.example.commandes.Entities.Commande;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity

@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;

    private String statut;
    public Long getId() {
        return id;
    }


    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommande> lignesCommande;


}
