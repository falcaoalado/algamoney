CREATE TABLE pessoas (
	id			BIGINT(20)		PRIMARY KEY AUTO_INCREMENT,
	nome		VARCHAR(50)						  NOT NULL,
	ativo		TINYINT(1)						  NOT NULL,
	logradouro	VARCHAR(100)							  ,
	numero		VARCHAR(10)								  ,
	complemento VARCHAR(30)								  ,
	bairro		VARCHAR(30)								  ,
	cep			VARCHAR(8)								  ,
	cidade		VARCHAR(30)								  ,
	estado		VARCHAR(20)					
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoas 
(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES
('Roberto Carlos', true, 'Rua Pedro Antonio Pereira', '187', null, 'Moquetá', '26285291', 'Nova Iguaçu', 'RJ');

INSERT INTO pessoas 
(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES
('Maria Andrade', true, 'Rua Projetada Sete', '685', null, 'Bairro das Graças', '26113333', 'Belford Roxo', 'RJ');

INSERT INTO pessoas 
(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES
('Luciana Carolina Barbosa', false, 'Rua Onze', '937', 'apt. 1', 'Jardim Mariana', '78145817', 'Várzea Grande', 'MT');

INSERT INTO pessoas 
(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES
('Melissa Julia da Cunha', true, 'Quadra QS 3', '613', 'Conjunto 5', 'Riacho Fundo II', '71884030', 'Brasília', 'DF');

INSERT INTO pessoas 
(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado)
VALUES
('Fabiana Joana Teresinha Barros', true, 'Alameda Girassol', '538', 'SEM COMPLEMENTO', 'Setor 04', '76873537', 'Ariquemes', 'RO');