# 📚 DioMe - Fundamentos de Java

<div align="center">

![Java](https://img.shields.io/badge/Java-17-blue?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.x-red?style=flat-square)
![Lombok](https://img.shields.io/badge/Lombok-1.18.30-yellow?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-green?style=flat-square)

**Formação Completa de Fundamentos de Java pela plataforma DIO (Digital Innovation One)**

[📖 Documentação Completa](#-documentações) • [🚀 Quick Start](#-quick-start) • [📦 Estrutura](#-estrutura-do-projeto) • [🎯 Navegação](#-navegação-rápida)

</div>

---

## 📋 Visão Geral

Este é um repositório educacional completo contendo toda a formação de **Fundamentos de Java**, com código fonte estruturado, exercícios práticos e documentação abrangente gerada a partir do conteúdo do curso.

### ✨ Destaques

- ✅ **2 Documentações Completas** (Fundamentos + Conceitos)
- ✅ **Guia de Navegação Rápida** com índice e referências
- ✅ **~2500 linhas** de conteúdo educacional
- ✅ **Exemplos executáveis** incluídos em cada tópico
- ✅ **14 Pacotes** com código-fonte estruturado
- ✅ **Java 17 (LTS)** com suporte Maven
- ✅ **Lombok** para redução de boilerplate

---

## 📦 Arquivos Gerados Recentemente

### 📍 Na Raiz do Repositório (15/02/2026)

```
📄 README.md                          ← Você está aqui
📄 NAVEGACAO_RAPIDA.md               ← Guia de navegação prático
```

### 📍 Em `/docs/`

```
docs/
├── 📄 README.md                     ← Índice da documentação
├── 📄 NAVEGACAO_RAPIDA.md          ← Navegação rápida (cópia em /docs)
├── Conceitos/
│   └── 📄 CONCEITOS_JAVA.md         ← 10 conceitos avançados (~900 linhas)
└── Fundamentos/
    └── 📄 FUNDAMENTOS_JAVA.md       ← 10 fundamentos básicos (~1100 linhas)
```

---

## 📖 Documentações

### 1️⃣ **FUNDAMENTOS_JAVA.md** 
📍 [`docs/Fundamentos/FUNDAMENTOS_JAVA.md`](docs/Fundamentos/FUNDAMENTOS_JAVA.md)

**Para quem está começando em Java**

| Tópico | Linhas | Status |
|--------|--------|--------|
| Introdução ao Java e Arquitetura | 50 | ✅ |
| Configuração do Ambiente | 40 | ✅ |
| Estrutura Básica de um Programa | 40 | ✅ |
| Tipos de Dados (Primitivos e Referência) | 120 | ✅ |
| Operadores (Aritméticos, Lógicos, Bitwise) | 100 | ✅ |
| Estruturas de Controle (If, Switch, Loops) | 150 | ✅ |
| Arrays e Multidimensionais | 100 | ✅ |
| Métodos e Sobrecarga | 100 | ✅ |
| Classes e Objetos | 150 | ✅ |
| Compilação e Execução | 80 | ✅ |
| **Total** | **~1100** | **✅ Concluído** |

**Inicie por aqui** → [Leia Fundamentos](docs/Fundamentos/FUNDAMENTOS_JAVA.md)

---

### 2️⃣ **CONCEITOS_JAVA.md**
📍 [`docs/Conceitos/CONCEITOS_JAVA.md`](docs/Conceitos/CONCEITOS_JAVA.md)

**Para quem domina o básico**

| Tópico | Linhas | Status |
|--------|--------|--------|
| Orientação a Objetos (OOP Completa) | 100 | ✅ |
| Herança e Polimorfismo | 100 | ✅ |
| Encapsulamento com Modificadores | 80 | ✅ |
| Interfaces e Expressões Lambda | 120 | ✅ |
| Coleções (List, Set, Map) | 130 | ✅ |
| Tratamento de Exceções | 100 | ✅ |
| Generics e Type Parameters | 90 | ✅ |
| Streams API (Intermediárias e Terminais) | 140 | ✅ |
| Enums e Optional | 100 | ✅ |
| Concorrência (Threads) | 110 | ✅ |
| **Total** | **~900** | **✅ Concluído** |

**Aprofunde aqui** → [Leia Conceitos](docs/Conceitos/CONCEITOS_JAVA.md)

---

### 3️⃣ **NAVEGACAO_RAPIDA.md**
📍 Raiz e [`docs/NAVEGACAO_RAPIDA.md`](docs/NAVEGACAO_RAPIDA.md)

**Guia prático com:**
- 🎯 Onde começar por nível
- 📖 Tabela de referência rápida (20+ tópicos)
- 🔍 Busca por tipo de problema (8 FAQs)
- 📋 Checkpoint de aprendizado (4 níveis)
- 🚀 Plano de estudo (4 semanas)
- 💻 Como executar exemplos
- ⚠️ Erros comuns

**Use para navegação** → [Navegação Rápida](NAVEGACAO_RAPIDA.md)

---

## 🚀 Quick Start

### 1. Clonar o Repositório
```bash
git clone https://github.com/gabrielsalesdavid/DioMe-Fundamentos-Java.git
cd DioMe-Fundamentos-Java
```

### 2. Compilar o Projeto
```bash
mvn clean compile
```

### 3. Executar uma Classe
```bash
# Com Maven
mvn exec:java -Dexec.mainClass="com.fundamentosdejava.Main"

# Ou diretamente com Java (após compilação)
java -cp target/classes com.fundamentosdejava.Main
```

### 4. Ler a Documentação
```bash
# Comece com os fundamentos
# Abra em seu editor: docs/Fundamentos/FUNDAMENTOS_JAVA.md

# Depois explore os conceitos avançados
# Abra em seu editor: docs/Conceitos/CONCEITOS_JAVA.md
```

---

## 📂 Estrutura do Projeto

```
DioMe-Fundamentos-Java/
├── 📄 README.md                          ← Você está aqui
├── 📄 NAVEGACAO_RAPIDA.md               ← Guia de navegação
├── 📄 pom.xml                           ← Configuração Maven
├── 📄 DioMeJavaFundamentos.iml          ← Projeto IntelliJ
│
├── 📚 docs/                             ← TODA A DOCUMENTAÇÃO
│   ├── 📄 README.md
│   ├── 📄 NAVEGACAO_RAPIDA.md
│   ├── Conceitos/
│   │   └── 📄 CONCEITOS_JAVA.md         ← Conceitos Avançados
│   └── Fundamentos/
│       └── 📄 FUNDAMENTOS_JAVA.md       ← Fundamentos Básicos
│
├── 📦 src/                              ← CÓDIGO FONTE
│   └── com/
│       ├── apistreamgenerics/
│       │   ├── Aula01.java
│       │   ├── Aula02.java
│       │   ├── Aula03.java
│       │   ├── Dao/
│       │   │   ├── GenericDAO.java
│       │   │   └── UserDAO.java
│       │   └── Domain/
│       │
│       ├── bigdecimalenumsoptinal/
│       │   ├── Aula01.java - Aula03.java
│       │   ├── OperationEnum.java
│       │   ├── StateEnum.java
│       │   ├── User.java, User02.java
│       │   └── Domain/
│       │
│       ├── classesencapsulamento/
│       │   ├── Aula01.java
│       │   ├── Person.java, Person01.java
│       │   └── TrabRecords.java
│       │
│       ├── collections/
│       │   ├── Aula01.java - Aula02.java
│       │   ├── User.java, User01.java
│       │   └── Exemplos de List, Set, Map
│       │
│       ├── collectionsutil/
│       │   ├── Aula01.java
│       │   ├── Calc.java
│       │   └── Operation.java
│       │
│       ├── datecalendar/
│       │   ├── Aula01.java
│       │   └── Aula02.java
│       │
│       ├── estruturacontrolejava/
│       │   ├── EstruturaRepeticao.java
│       │   ├── IfElseIf.java
│       │   ├── SwitchCase.java
│       │   └── WhileDoWhile.java
│       │
│       ├── exercicos/
│       │   ├── Exercicio01.java - Exercicio05.java
│       │   ├── Teste.java - Teste02.java
│       │   └── domain/
│       │
│       ├── fundamentosdejava/
│       │   ├── Main.java
│       │   ├── OperadorAritmetico.java
│       │   ├── OperadorBitwise.java
│       │   └── OperadorLogico.java
│       │
│       ├── herancapolimorfismo/
│       │   ├── Employee.java
│       │   ├── ExploHerPol.java
│       │   ├── IntroducaoHerPol.java
│       │   ├── Manager.java
│       │   └── Salesman.java
│       │
│       ├── interfacelambda/
│       │   ├── Circle.java, Rectangle.java, Square.java
│       │   ├── EntendendoKeyW.java
│       │   ├── GeometricForm.java
│       │   ├── InteFunci.java, Interf.java
│       │   ├── MusicPlayer.java, VideoPlayer.java
│       │   ├── User.java
│       │   └── keyword/
│       │
│       ├── mapwrappers/
│       │   ├── Aula01.java - Aula02.java
│       │   ├── User.java
│       │   └── Users.java
│       │
│       ├── offsetdatetimelocaldatedatetime/
│       │   └── Aula01.java
│       │
│       ├── simplificandoio/
│       │   ├── FilePersistence.java
│       │   └── IOFilePersistence.java
│       │
│       ├── simplificandonio/
│       │   ├── NIOFilePErsist.java
│       │   └── NIOFilePersistence.java
│       │
│       ├── stringbuilderbuffer/
│       │   ├── Aula01.java
│       │   └── Aula02.java
│       │
│       ├── threadinterfacerunnable/
│       │   └── Aula01.java
│       │
│       ├── tratamentoexcecoes/
│       │   ├── Main.java
│       │   ├── dao/
│       │   ├── enums/
│       │   ├── exception/
│       │   └── model/
│       │
│       └── validator/
│           └── UserValidator.java
│
├── target/                              ← Build output
└── .git/                                ← Git repository
```

---

## 🎯 Navegação Rápida

### 🟢 **Sou Iniciante em Java**

Siga este roteiro:
1. Leia [Fundamentos](docs/Fundamentos/FUNDAMENTOS_JAVA.md)
2. Estude cada tópico na sequência
3. Execute os exemplos de código
4. Revise com [Navegação Rápida](NAVEGACAO_RAPIDA.md)

### 🔵 **Já Conheço Programação**

Caminho acelerado:
1. Consulte a [Tabela de Referência](NAVEGACAO_RAPIDA.md#-tabela-de-referência-rápida)
2. Explore [Conceitos Avançados](docs/Conceitos/CONCEITOS_JAVA.md)
3. Use [FAQs](NAVEGACAO_RAPIDA.md#-busca-por-tipo-de-problema) para tópicos específicos

### 🟡 **Quero Revisar um Tópico**

Use a [Navegação Rápida](NAVEGACAO_RAPIDA.md):
- Tabela de referência com links diretos
- Busca por tipo de problema
- Mapeamento código-fonte

---

## 📊 Conteúdo Gerado - Resumo

| Item | Documento | Tamanho | Status |
|------|-----------|--------|--------|
| Conceitos Fundamentais | `CONCEITOS_JAVA.md` | ~900 linhas | ✅ |
| Fundamentos Básicos | `FUNDAMENTOS_JAVA.md` | ~1100 linhas | ✅ |
| Navegação Rápida | `NAVEGACAO_RAPIDA.md` | ~300 linhas | ✅ |
| README Principal | `README.md` (este arquivo) | ~400 linhas | ✅ |
| **Código Fonte** | 14 pacotes em `src/com/` | 60+ classes | ✅ |
| **Total de Conteúdo** | 4 documentos + código | **~2500+ linhas** | **✅ Completo** |

---

## 🔄 Status de Atualização - 15/02/2026

### ✅ Mudanças Detectadas

```diff
[+] NAVEGACAO_RAPIDA.md (novo)
[+] docs/Conceitos/CONCEITOS_JAVA.md (novo)
[+] docs/Fundamentos/FUNDAMENTOS_JAVA.md (novo)
[+] docs/README.md (novo)
[+] README.md (criado agora)
```

### 📈 Documentação

- **Tópicos Cobertos**: 20+ (10 Fundamentos + 10 Conceitos)
- **Exemplos de Código**: 100+
- **Tabelas de Referência**: 15+
- **Diagrama ASCII**: 5+
- **Links Internos**: 50+
- **FAQs**: 8+

### 🎯 Cobertura

- ✅ Tipos de dados
- ✅ Operadores (Aritméticos, Lógicos, Bitwise)
- ✅ Estruturas de controle
- ✅ Arrays
- ✅ Métodos e sobrecarga
- ✅ Classes e objetos
- ✅ Herança e Polimorfismo
- ✅ Encapsulamento
- ✅ Interfaces e Lambda
- ✅ Coleções
- ✅ Exceções
- ✅ Generics
- ✅ Streams API
- ✅ Enums e Optional
- ✅ Threads
- ✅ I/O e NIO

---

## 💻 Tecnologias

### Linguagem
- **Java 17 (LTS)** - Long Term Support
- **Sintaxe moderna** com recursos Java 8+

### Build & Dependências
- **Maven 3.x** - Gerenciamento de dependências
- **Lombbok 1.18.30** - Redução de boilerplate

### Ambiente
- **JDK 17+**
- **IDE**: IntelliJ IDEA, Eclipse, VS Code ou NetBeans

---

## 📚 Como Usar a Documentação

### Opção 1: No VS Code
```bash
# Abra a pasta do projeto
code .

# Navegue até os arquivos .md
# Docs > Conceitos > CONCEITOS_JAVA.md
# Docs > Fundamentos > FUNDAMENTOS_JAVA.md
```

### Opção 2: No GitHub
```
Visite: github.com/gabrielsalesdavid/DioMe-Fundamentos-Java
Navegue até: docs/
```

### Opção 3: Localmente
```bash
# Clone e abra com seu editor favorito
cd docs/
cat Fundamentos/FUNDAMENTOS_JAVA.md | less
```

---

## 🏆 Plano de Aprendizado Recomendado

### **Semana 1: Fundamentos** 📖
```
Dia 1-2: Tipos de Dados e Operadores
Dia 3-4: Estruturas de Controle
Dia 5: Arrays e Métodos  
Dia 6-7: Classes e Objetos
```

### **Semana 2: OOP Básica** 🏛️
```
Dia 1-2: Encapsulamento
Dia 3-4: Herança
Dia 5-6: Polimorfismo
Dia 7: Revisão e Exercícios
```

### **Semana 3: Intermediário** ⚙️
```
Dia 1-2: Interfaces
Dia 3-4: Coleções
Dia 5: Lambda
Dia 6-7: Exercícios
```

### **Semana 4: Avançado** 🚀
```
Dia 1-2: Generics
Dia 3-4: Streams
Dia 5: Exceções
Dia 6-7: Threads
```

Acompanhe seu progresso com o [Checklist de Aprendizado](NAVEGACAO_RAPIDA.md#-checklist-de-aprendizado)

---

## 🔗 Links Importantes

### 📖 Documentação
- [Fundamentos de Java](docs/Fundamentos/FUNDAMENTOS_JAVA.md)
- [Conceitos Avançados](docs/Conceitos/CONCEITOS_JAVA.md)
- [Navegação Rápida](NAVEGACAO_RAPIDA.md)
- [Índice de Docs](docs/README.md)

### 🎓 Recursos Externos
- [Oracle Java SE Documentation](https://docs.oracle.com/javase/17/docs/api/)
- [Baeldung Java Tutorials](https://www.baeldung.com/)
- [GeeksforGeeks Java](https://www.geeksforgeeks.org/java/)
- [Stack Overflow - Java](https://stackoverflow.com/questions/tagged/java)

### 📚 Plataformas
- [DIO - Digital Innovation One](https://www.dio.me/)
- [Oracle Academy](https://academy.oracle.com/)

---

## 📋 Checklist Rápido

- [ ] Li o README.md (este arquivo)
- [ ] Consultei [NAVEGACAO_RAPIDA.md](NAVEGACAO_RAPIDA.md)
- [ ] Comecei com [Fundamentos](docs/Fundamentos/FUNDAMENTOS_JAVA.md)
- [ ] Executei o projeto com Maven
- [ ] Li os primeiros 3 tópicos
- [ ] Modifiquei um exemplo de código
- [ ] Criei meu primeiro programa Java
- [ ] Explorei os 14 pacotes em `src/`

---

## ❓ Dúvidas Frequentes

**P: Por onde começo?**  
R: Se é iniciante, comece com [Fundamentos](docs/Fundamentos/FUNDAMENTOS_JAVA.md). Se já program, vá direto para [Conceitos](docs/Conceitos/CONCEITOS_JAVA.md).

**P: Como executar os exemplos?**  
R: Use Maven: `mvn exec:java -Dexec.mainClass="com.package.ClassName"`

**P: Posso usar outro IDE?**  
R: Sim! Funciona com IntelliJ, Eclipse, VS Code, NetBeans, etc.

**P: Qual é a versão de Java?**  
R: Java 17 LTS (Long Term Support)

**P: Preciso de Lombok?**  
R: Não é obrigatório, mas está configurado no pom.xml

---

## 🤝 Contribuições

Este é um repositório educacional. Sugestões de melhorias são bem-vindas!

---

## 📝 Informações do Repositório

- **Repository**: DioMe-Fundamentos-Java
- **Owner**: gabrielsalesdavid
- **Current Branch**: DioMeFundamentosJava
- **Default Branch**: DioMeFundamentosJava
- **Java Version**: 17 (LTS)
- **Build Tool**: Maven 3.x
- **Last Updated**: 15 de fevereiro de 2026

---

## 📄 Licença

Conteúdo educacional - Formação DIO (Digital Innovation One)

---

<div align="center">

### ⭐ Se este repositório ajudou você, considere dar uma estrela!

**Bom estudo! Aproveite a jornada pelo Java! 🚀**

---

*Documentação gerada em 15 de fevereiro de 2026*  
*Versão de Java: 17 LTS*  
*Status: ✅ Ativo e Completo*

</div>
