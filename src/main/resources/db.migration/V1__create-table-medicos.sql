CREATE TABLE medicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    crm VARCHAR(50) NOT NULL,
    especialidade VARCHAR(50) NOT NULL,
    logradouro VARCHAR(255),
    numero VARCHAR(20),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(20)
);