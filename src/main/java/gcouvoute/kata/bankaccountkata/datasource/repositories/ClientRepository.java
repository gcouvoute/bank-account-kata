package gcouvoute.kata.bankaccountkata.datasource.repositories;

import gcouvoute.kata.bankaccountkata.datasource.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {

    boolean existsByIdAndStatus(String id, ClientEntity.Status status);
}
