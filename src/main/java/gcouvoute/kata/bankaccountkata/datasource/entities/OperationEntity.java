package gcouvoute.kata.bankaccountkata.datasource.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "OPERATION")
public class OperationEntity {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Column(name = "ID", unique = true, nullable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION", nullable = false)
    private Operation operation;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "BALANCE", nullable = false)
    private int balance;

    @ManyToOne
    @JoinColumn(name = "CLIENTID", nullable = false)
    private ClientEntity client;

    public enum Operation {
        DEPOSIT, WITHDRAWAL
    }
}
