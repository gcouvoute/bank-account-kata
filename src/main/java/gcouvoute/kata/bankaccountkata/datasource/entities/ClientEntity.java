package gcouvoute.kata.bankaccountkata.datasource.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "CLIENT")
public class ClientEntity {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private Status status;

    @Column(name = "BALANCE", nullable = false)
    private int balance;

    @Column(name = "CREATIONDATE", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "MODIFICATIONDATE")
    private LocalDateTime modificationDate;

    @Column(name = "DELETIONDATE")
    private LocalDateTime deletionDate;

    @OneToMany(mappedBy = "client")
    private List<OperationEntity> operations;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
