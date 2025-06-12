package org.example.paiements.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;
    private String mode;
    private int nombreEcheances;

    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
