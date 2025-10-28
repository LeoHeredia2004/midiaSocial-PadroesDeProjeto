# Sistema de Integração de Mídias Sociais

Este projeto é um exercício prático da disciplina de Padrões de Projetos, focado na implementação de um sistema unificado para gerenciamento de redes sociais.

## Objetivo

O objetivo principal é demonstrar o uso de padrões de projeto (como **Adapter**, **Factory Method** e **Strategy**) para integrar APIs heterogêneas (Twitter, Instagram) sob uma interface unificada, criando uma arquitetura flexível, robusta e desacoplada.

## Padrões de Projeto Utilizados

Esta é a parte mais importante do seu README, Leo! Aqui você explica *por que* usou cada padrão.

* ### 1. Padrão Adapter
    * **Por quê?** As APIs simuladas (`ApiTwitter`, `ApiInstagram`) são "sistemas legados" com interfaces totalmente incompatíveis (nomes de métodos, modelos de dados e tipos de retorno diferentes).
    * **Como?** Foram criadas as classes `TwitterAdapter` e `InstagramAdapter`. Cada uma delas **implementa** a nossa interface unificada `InterfaceMdidiaSocial` (o "Alvo") e, ao mesmo tempo, **"embrulha"** (usa) a API legada (o "Adaptee"). Elas atuam como "tradutores" em tempo real.

* ### 2. Padrão Factory Method (e Strategy)
    * **Por quê?** Para **desacoplar** o nosso "cliente" (`MainApp`) da criação dos adaptadores concretos. O `MainApp` não deve saber *como* construir um `TwitterAdapter` (que precisa de uma `TwitterAPI`, que precisa de autenticação...).
    * **Como?** A `SocialMediaFactory` foi criada com um método estático `criarPlataforma(String tipo)`. Ela centraliza toda a lógica de "montagem" (dar `new` na API, dar `new` no Adapter).
    * **Strategy:** A Factory atua como a criadora das "Estratégias" (`InterfaceMidiaSocial`). O cliente (`MainApp`) apenas solicita uma estratégia (ex: "twitter") e a utiliza através da interface comum, sem conhecer a implementação específica.

* ### 3. Sistema de Resposta Unificado (Design Robusto)
    * **Por quê?** Para evitar que o sistema "quebre" com exceções não tratadas (ex: postar no Instagram sem imagem, API offline) e para padronizar as respostas.
    * **Como?** Foi criada a classe genérica `RespostaAPI<T>`, que "embrulha" todas as respostas. Ela informa se a operação teve `sucesso()` ou `falha()` e carrega os `dados()` ou a `mensagemErro()`, permitindo ao cliente tomar decisões de forma segura.
