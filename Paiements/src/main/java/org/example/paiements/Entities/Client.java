package org.example.paiements.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String telephone;
    private String adresse;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Paiement> paiements;
}
