

-- Tabela base (Pessoa)
CREATE TABLE pessoa (
    id        BIGSERIAL PRIMARY KEY,
    nome      VARCHAR(150) NOT NULL,
    cpf       VARCHAR(14)  NOT NULL UNIQUE,
    email     VARCHAR(150),
    telefone  VARCHAR(20),
    tipo      VARCHAR(20)  NOT NULL
);

-- Especialização: Paciente
CREATE TABLE paciente (
    id              BIGINT PRIMARY KEY REFERENCES pessoa(id) ON DELETE CASCADE,
    cartao_sus      VARCHAR(20) UNIQUE,
    data_nascimento DATE
);

-- Unidade de Saúde (UBS / UPA)
CREATE TABLE unidade_saude (
    id                    BIGSERIAL PRIMARY KEY,
    nome                  VARCHAR(150) NOT NULL,
    tipo                  VARCHAR(10)  NOT NULL,
    endereco              VARCHAR(255),
    horario_funcionamento VARCHAR(100)
);

-- Especialização: Profissional
CREATE TABLE profissional (
    id             BIGINT PRIMARY KEY REFERENCES pessoa(id) ON DELETE CASCADE,
    crm            VARCHAR(20) UNIQUE,
    especialidade  VARCHAR(100),
    unidade_id     BIGINT REFERENCES unidade_saude(id)
);

-- Especialização: Gestor
CREATE TABLE gestor (
    id    BIGINT PRIMARY KEY REFERENCES pessoa(id) ON DELETE CASCADE,
    login VARCHAR(50)  NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Agendamento
CREATE TABLE agendamento (
    id              BIGSERIAL PRIMARY KEY,
    paciente_id     BIGINT       NOT NULL REFERENCES paciente(id),
    profissional_id BIGINT       REFERENCES profissional(id),
    unidade_id      BIGINT       NOT NULL REFERENCES unidade_saude(id),
    data_hora       TIMESTAMP    NOT NULL,
    status          VARCHAR(30)  NOT NULL
);

-- Ocorrência do Agendamento
CREATE TABLE ocorrencia_agendamento (
    id               BIGSERIAL PRIMARY KEY,
    agendamento_id   BIGINT      NOT NULL REFERENCES agendamento(id) ON DELETE CASCADE,
    tipo             VARCHAR(50) NOT NULL,
    descricao        TEXT,
    data_ocorrencia  TIMESTAMP   NOT NULL
);