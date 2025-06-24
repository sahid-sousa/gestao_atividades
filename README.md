![Java 8](https://img.shields.io/badge/Java-8-blue?logo=java&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-3.x-02303A?logo=gradle&logoColor=white)
![Grails 3](https://img.shields.io/badge/Grails-3.x-6DB33F?logo=grails&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?logo=postgresql&logoColor=white)

# Academic Document Manager
Sistema para documentação e validação de atividades complementares

**Requisitos**

- SDKMAN(Software Development Kit Manager)
- Grails 3.3.5
- Java 1.8
- PostgreSQL 9.5.14

**O Ambiente de Desenvolvimento**

Esse projeto foi totalmente desenvolvido em um ambiente de desenvolvimento configurando no sistema operacional **Linux Ubuntu MATE no release 18.04.1 LTS (Bionic Beaver)**, **Grails na versão 3.3.5**, **banco de dados PostgreSQL na versão 9.5.14** e o **Java na versão 8.0.181-zulu**.

Para automatizar a instalação do **Grails** a documentação recomenda utilizar o **SDKMAN(Software Development Kit Manager)** que é uma ferramenta para gerenciar versões paralelas de vários kits de desenvolvimento de software, simplificando e muito a instalação e o gerenciamento de várias versões do Grails, Java e outros.

**Instalando o SDKMAN**

Para instalar o **SDMAN** no **Linux** bastar abrir  um novo terminal utilizando o atalho CTRL + ALT + T e digitar ou copiar o seguinte comando e pressionar enter:

`$ curl -s "https://get.sdkman.io" | bash`

Após a execução e término do comando anterior digite:

`$ source "$HOME/.sdkman/bin/sdkman-init.sh"`

Execute o seguinte comando para garantir que a instalação foi bem sucedida:

`$ sdk version`

Se a instalação foi bem sucedida a resposta retornada após executar o comando anterior deverá ser a seguinte:

`sdkman X.X.X+XX`

**Instalando o JAVA**

Para instalar a versão do Java necessário para executar esse projeto execute o seguinte comando no terminal:

`$ sdk install java 8.0.181-zulu`

**Instalando o PostgreSQL**

Execute o comando abaixo para atualizar o gerenciandor de pacores:
`$ sudo apt-get update`

Use o comando abaixo para instalar o programa:

`$ sudo apt-get install postgresql`

Inicie o serviço

`sudo systemctl start postgresql`

Acesse o PostgreSQL

`sudo psql -U postgres`

Criando o Database do Projeto

`CREATE DATABASE gestao_atividades_development;`

**Configurando e Executando a Aplicação**

Crie as variáveis de SMTP

`
SMTP_HOST     = <HOST>
SMTP_PORT     = <PORTA
SMTP_USERNAME = <USERNAME>
SMTP_PASSWORD = <PASSOWRD>
`

Crie as variáveis do datasource

`
DATASOURCE_URL = <URL>
DATASOURCE_USERNAME = <USERNAME>
DATASOURCE_PASSWORD = <PASSWORD>
`
**Executando em Container**

Execute os comando: 

Na raiz do projeto, execute o seguinte comando:

Caso tenha mais de uma versão de sdk instalado:
`sdk u grails 3.3.5`
`sdk u java 8.0.392-zulu`

Crie o war do projeto:
`grails war`

Crie os containers:
`docker compose up --build`

Após a conclusão do processo de build, acesse a aplicação no navegador através da URL:

`http://localhost:8080/gestao/login/auth`
