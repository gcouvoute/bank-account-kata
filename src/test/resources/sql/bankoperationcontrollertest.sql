DELETE FROM operation;
DELETE FROM client;

INSERT INTO
    client(id, name, status, balance, creationdate)
VALUES
    ('f274eed8-61eb-46f2-b32f-649758a18de2', 'NegativeValue', 'ACTIVE', '100', '2021-12-30T17:56:56.616'),
    ('94b1690f-aafa-4693-8c2e-919a978bdf04', 'MakeDeposit', 'ACTIVE', '0', '2021-12-30T17:56:56.616'),
    ('4c89cbc5-d9c7-4b49-ba80-423f66abae6e', 'NotEnoughBalance', 'ACTIVE', '50', '2021-12-30T17:56:56.616'),
    ('c9cb1dbe-cd1b-48d2-8c8a-5d4b343d9fa8', 'MakeWithdrawal', 'ACTIVE', '100', '2021-12-30T17:56:56.616'),
    ('90aa0584-f635-470d-a5fd-6e0fdae771a1', 'GetOperations', 'ACTIVE', '0', '2021-12-30T17:56:56.616');

INSERT INTO
    operation(id, operation, date, amount, balance, clientid)
VALUES
    ('c2c8da1d-22d2-4745-b4fa-727cf7f7c016', 'DEPOSIT', '2021-12-30T18:15:56.000', '100', '100', '90aa0584-f635-470d-a5fd-6e0fdae771a1'),
    ('783710a9-f017-40b7-a054-fa11d36b1989', 'WITHDRAWAL', '2021-12-30T18:25:56.000', '100', '0', '90aa0584-f635-470d-a5fd-6e0fdae771a1');