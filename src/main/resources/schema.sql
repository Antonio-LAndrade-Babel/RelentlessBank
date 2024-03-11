CREATE TABLE IF NOT EXISTS client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    surname VARCHAR(50),
    last_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS bank_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    accountiban VARCHAR(34) NOT NULL,
    account_balance DECIMAL(15, 2),
    CONSTRAINT fk_bank_account_client
        FOREIGN KEY (client_id)
        REFERENCES Client(id)
);

CREATE TABLE IF NOT EXISTS operation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    destiny_account_id INT,
    operation_type VARCHAR(255),
    destinyiban VARCHAR(34) NOT NULL,
    date_time TIMESTAMP,
    operation_amount DECIMAL(15, 2),
    CONSTRAINT fk_operation_account
        FOREIGN KEY (account_id)
        REFERENCES bank_account(id),
    CONSTRAINT fk_operation_destiny_account
        FOREIGN KEY (destiny_account_id)
        REFERENCES bank_account(id)
);