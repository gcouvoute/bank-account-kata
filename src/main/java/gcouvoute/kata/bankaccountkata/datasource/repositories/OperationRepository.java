package gcouvoute.kata.bankaccountkata.datasource.repositories;

import gcouvoute.kata.bankaccountkata.datasource.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, String> {
}
