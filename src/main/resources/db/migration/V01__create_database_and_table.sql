
use ubsdigital;

create table usuario (
	id int8  AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255),
    sobrenome VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(20),
    bairro VARCHAR(255),
    cartaoSus VARCHAR(255),
    senha VARCHAR(255)
);