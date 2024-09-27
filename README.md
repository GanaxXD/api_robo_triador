# API de Coleta de DAdos das Automações do Toada Lab
Este projeto visa a coleta de informações analíticas produzidas pelas automações do Toada Lab.
## Release Notes:
* ***1.0.0:*** Estrutura inicial de coleta de informações do Clóvis e da Judith. Os dados coletados incluem quantidade de processos etiquetados, quantidade de processos lidos, quantidade de etiquetas inseridas, o tempo de trabalho do Clóvis ou da Judith, a data de execução e o Local Implantado onde o robô rodou.
* ***1.0.1:*** Correções na coleta de dados e nas rotas de acesso da API, permitindo requisições realizadas por todo o TJMA (inserção do Cros-Origin - CORS).
* ***2.0.0:*** Reestruturação das Entidades, Novas tabelas no banco para coleta de informações do robô Mário Lúcio; Correções nas tabelas "Robôs", "Execuções Clóvis e Judith"; Inserção da entidade "Interações Usuário" para estimar quantidade de interações que o usuário humano teria ao realizar as tarefas dos robôs (quantidade de cliques e caracteres digitados).
* ***2.1.0:*** Reestruturação das Entidades "Robôs" e "Execuções Mário Lúcio", permitindo uma coleta de dados que facilitem o tratamento dos dados no Power Bi para geração de relatórios mais intuitivos para a alta gestão do TJMA; Inserção das colunas "Quantidade de Minutas inseridas" na entidade "Execuções Clóvis e Judith". 
* ***2.2.0:*** Inserção da Entidade "Processos Remetidos" para coleta da quantidade de processos remetidos ao segundo grau pelo robô da SEJUD.  
* ***2.2.1:*** Inserção das colunas "Quantidade Palavras Lidas" e "Quantidade d eCaracteres Lidos" na tabela "Interações Usuários".
  * ***2.2.1.1:*** Correção no nome das colunas da tabela "Interações Usuários": Caracteres e Palavras digitadas para Caracteres e Palavras Lidas. Alteração feita para que as coletas de dados já realizadas reflitam a realidade. O robô não escreveu, apenas leu o processo.
* ***2.2.2:*** Inserção da coluna "ativo" e "bairro" na tabela Distritos, para que seja possível verificar a que bairro o código se refere.
---

>**Notas:**
>* O projeto está usando o *Lombok* para evitar verbosidade excessiva
>* Para instalar o *Lombok*, siga os passos abaixo:
>
> <br>
> 
>**Instalando o Lombok no Eclipse:**
>* Na pasta do eclipse .me, repositório de dependencias baixadas pelo maven, onde o lombok foi baixado (C:\Users\seu_nome_de_usuario\.m2\repository\org\projectlombok\lombok\1.18.24), abra o CMD como Administrador;
>* Digite: java -jar lombok-1.18.24.jar
>* Na tela de instalação do lombok selecione specify location vá até a pasta do eclipse e selecione eclipse.ini.
>* Na pasta do eclipse, abra o arquivo eclipse.init. No arquivo eclipse.ini digite no fim da lista -vmargs javaagent:C:\caminho-do-eclipse-na-sua-máquina\lombok.jar , salve a alteração.
>* Dê um quit na tela de instalação do lombok.  
> <br>
>  
> <br>
> Mas caso esteja trabalhando com o <i>InteliJ</i>, basta rodar o projeto para que as dependências sejam baixadas pelo <i>Maven</i>.
  
## Do Projeto
A API foi contruída com o objetivo de coletar dados de funcionamento das automações criadas pelo Toada Lab para análises estatísticas de uso das 
automações do Tribunal de Justiça do Maranhão.

## Da Necessidade
O acesso à base de dados do PJe é extremamente restrito, e, por assim ser, visando maior segurança, integridade, 
confidencialidade e disponibilidade dos dados, nós, externos à DTIC - Diretoria de Tecnologia e Informação do TJMA
não podemos acessar seus dados e produzir informações. 
No intuito de evitar a solicitação constante de relatórios para a referida diretoria, ocupando-os com uma tarefa
 muito recorrente, achamos por bem criar esta API para coletar informações simples sobre as automações, que, a depender
 do projeto, poderá coletar informações diversas, mas nada sigiloso.
 Dessa forma, conseguimos acessar informações analiticas que são importantes para o laboratórios, de forma 
"autonoma" da DTIC, evitando recorrentes chamados para os servidores do setor (com tempo já muito concorrido).

## Por que Coletamos?
Vários ações, prêmios e eventos lançados ou produzidos pelo CNJ exigem provas da utilização e resultados comprovados
 dos projetos inscritos, motivo pelo qual necessitamos constantemente de relatórios analitos dos trabalhos dos nossos projetos, 
sejam de tecnologia ou não. Além disso, somos provocados pela alta administração do TJMA, por vezes, a apresentar 
resultados dos nossos projetos. Desta forma, torna-se mais oportuno ter gerencia dessas informações 
pelo próprio Toada Lab, evitando constantes e recorrentes chamados à DTIC 
para geração de relatórios que, embora simples, demandam tempo de um setor extremamente concorrido.

## O Que Coletamos?
Depende da automação:
1. **Todas as automações (Dados analíticos):** Ações que seriam realizadas pelo usuário. Coleta:
   * Quantidade de Cliques;
   * Quantidade de Caracteres Lidos;
   * Quantidade de Caracteres Digitados;
   * Quantidade de Palavras Lidas;
   * Quantidade de Palavras Digitadas;
   * Quantidade de Palavras Digitadas;
   * Id do robô.
2. **Clóvis:** RPA de triagem de processos. Coleta:
    * Tempo Etiquetando Processos;
    * Quantidade de Processos Etiquetados;
    * Quantidade de Processos Lidos;
    * Quantidade de Etiquetas Inseridas;
    * Data da Execução;
    * Houve Erro;
    * Hora inicial de Execução das Atividades;
    * Minutas Inseridas;
    * Id do Robô.
3. **Judith:** RPA de etiquetagem de processos parados a mais de 100 dias, conforme lista de processos passados pelo usuário.
   * Mesmo do Clóvis.
4. **Mário Lúcio:**
   * Tempo Distribuindo Mandados;
   * Quantidade de Mandados Distribuidos (Enviados);
   * Quantidade de Mandados Distribuidos Para Análise Humana (Analise);
   * Data da Execução;
   * Houve Erro;
   * Hora inicial de Execução das Atividades;
   * Id do Robô.

   Quanto aos Mandados distribuídos, coletamos:
   * Número do Processo;
   * Código Contido no Mandado;
   * Id Do Documento;
   * Id do Distrito;
   * Data da Distribuição.
   
5. **Raimundo:** Automação de Inserção de minutas baseadas nas etiquetas contida sno processo. Coletamos:
   * Ainda em desenvolvimento.
6. **Dolores (Nome Provisório):** Automação de Indicação de suspeição e Impedimento na Agenda Virtual dos Desembargadores. Coletamos:
   * Ainda em desenvolvimento.
7. **Tony (Nome Provisório):** Automação para remeter processos das unidades cíveis para o segundo grau. Coletamos:
   * Ainda em desenvolvimento.
  
### Tecnologias Utilizadas
* Java 17 ou superior: a estrutura do projeto utiliza "records" para criação das DTOs, disponibilizadas no Java a partir da versão 17.
* Spring Boot (JPA, Postgres Driver)
* Database Relacional em Postgres

### Das Entidades Envolvidas
