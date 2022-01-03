package gcouvoute.kata.bankaccountkata.datasource.repositories;

import gcouvoute.kata.bankaccountkata.datasource.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, String> {

    List<OperationEntity> findAllByClientId(String clientId);
}
