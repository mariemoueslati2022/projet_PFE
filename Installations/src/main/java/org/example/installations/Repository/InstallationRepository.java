package org.example.installations.Repository;


import org.example.installations.Entities.Installation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallationRepository extends JpaRepository<Installation, Long> {
}
