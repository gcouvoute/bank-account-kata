DELETE FROM operation;
DELETE FROM client;
INSERT INTO
    client(id, name, status, balance, creationdate)
VALUES
       ('c7d9404d-eee4-405e-b7ca-425384d26cbe', 'tata', 'ACTIVE', '100', '2021-12-30T17:56:56.616'),
       ('4f7b0a38-e1bf-46c5-8292-7eec8b165611', 'titi', 'ACTIVE', '100', '2021-12-30T17:56:56.616');
