# VITTAS: Plataforma Integrada de Acesso e Transparência na Rede Pública de Saúde

Projeto desenvolvido para a Atividade de Estudo Programada (AEP) do 4º Semestre dos cursos de Engenharia de Software e Análise e Desenvolvimento de Sistemas.

## Integrantes
* Lucas Henrique Fernandes - RA: 25293549-2
* Mateus Bergamin Sobral - RA: 25363433-2
* Samuel Yuiti Endo Silva - RA: 25363377-2

## Alinhamento ODS
O projeto está alinhado ao ODS 3 - Saúde e Bem-Estar, pois utiliza a tecnologia para ampliar o acesso a informações e serviços de saúde, melhorar a previsibilidade do atendimento e tornar a jornada do cidadão mais organizada.

## Tecnologias Utilizadas
* Linguagem: Java 17+
* Framework Backend: Spring Boot 3.3.x
* Banco de Dados: PostgreSQL
* Controle de Versão: Git e GitHub

## Lista de Requisitos Funcionais
* RF01: O sistema deve consumir e disponibilizar APIs para permitir a integração progressiva com os sistemas utilizados pelas unidades e pela gestão pública.
* RF02: O sistema deve permitir a consulta de UBSs e UPAs, apresentando localização, horário de funcionamento, serviços disponíveis e demais informações fornecidas pela rede integrada.
* RF03: O sistema deve permitir a consulta de profissionais, especialidades e horários disponíveis nas unidades, conforme os dados recebidos dos sistemas integrados.
* RF04: O sistema deve permitir a consulta da disponibilidade de medicamentos nas UBSs, apresentando também a data e o horário da última atualização das informações de estoque.
* RF05: O sistema deve apresentar informações sobre demanda ou ocupação das UPAs e, quando houver dados suficientes, estimativas de tempo de espera.
* RF06: O sistema deve permitir que o cidadão preencha uma pré-avaliação orientativa antes do atendimento de pronto atendimento, encaminhando as informações à equipe responsável pelo acolhimento e triagem.
* RF07: O sistema deve permitir o agendamento de serviços de acesso direto quando houver disponibilidade e quando a funcionalidade estiver habilitada pela gestão da unidade.
* RF08: O sistema deve apresentar alternativas de unidades compatíveis quando houver diferenças relevantes de demanda, disponibilidade ou tempo estimado de atendimento.
* RF09: O sistema deve enviar notificações relacionadas a agendamentos, alterações e movimentações relevantes dos atendimentos ou solicitações do cidadão.
* RF10: O sistema deve disponibilizar um painel de gestão com informações e indicadores relacionados ao atendimento, demanda e funcionamento das unidades.
* RF11: O sistema deve possuir mecanismos de identificação, autenticação e autorização adequados aos diferentes perfis de usuário.
* RF12: O sistema deve respeitar as regras de proteção de dados e controle de acesso, garantindo que dados pessoais e informações de saúde sejam acessados apenas por usuários autorizados.



## Como Executar o Projeto

### 1. Pré-requisitos
* Java JDK 17 ou superior instalado.
* PostgreSQL instalado e rodando.
* Uma IDE de sua preferência (recomendamos IntelliJ IDEA ou VS Code).

### 2. Configuração do Banco de Dados
1. Abra o pgAdmin (ou terminal do PostgreSQL) e crie um banco de dados chamado `vittas`.
2. Abra o arquivo `database/schema.sql` presente neste repositório e execute-o no banco `vittas` para criar as tabelas necessárias.

### 3. Configuração da Aplicação
1. Abra o arquivo `src/main/resources/application.properties`.
2. Altere a propriedade `spring.datasource.password` para a senha do seu usuário do PostgreSQL (geralmente o usuário é `postgres`).

### 4. Executando
1. Abra o projeto na sua IDE e aguarde o download das dependências do Maven.
2. Execute a classe principal `VittasApplication.java`.
3. A API estará disponível no endereço: `http://localhost:8080/api/pacientes`

