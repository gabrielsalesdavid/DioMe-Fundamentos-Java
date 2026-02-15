# Fundamentos de Java

## 📚 Índice
1. [Introdução ao Java](#introdução-ao-java)
2. [Configuração do Ambiente](#configuração-do-ambiente)
3. [Estrutura Básica de um Programa Java](#estrutura-básica-de-um-programa-java)
4. [Tipos de Dados](#tipos-de-dados)
5. [Operadores](#operadores)
6. [Estruturas de Controle](#estruturas-de-controle)
7. [Arrays](#arrays)
8. [Métodos](#métodos)
9. [Classes e Objetos](#classes-e-objetos)
10. [Compilação e Execução](#compilação-e-execução)

---

## Introdução ao Java

### O que é Java?
Java é uma linguagem de programação **orientada a objetos**, **compilada** e **interpretada**, criada em 1995 pela Sun Microsystems (agora Oracle).

### Características Principais
- **Multiplataforma**: "Write Once, Run Anywhere" (WORA)
- **Orientada a Objetos**: Tudo é um objeto
- **Robusta**: Gerenciamento automático de memória (Garbage Collector)
- **Segura**: Verificação de tipo em tempo de compilação
- **Simples**: Sintaxe similar a C++, mas mais limpa
- **Compilada e Interpretada**: Compilada para bytecode (.class), interpretada pela JVM

### Arquitetura Java

```
Código Java (.java)
        │
        ▼
   Compilador (javac)
        │
        ▼
   Bytecode (.class)
        │
        ▼
   Java Virtual Machine (JVM)
        │
        ▼
   Plataforma (Windows/Linux/Mac)
```

---

## Configuração do Ambiente

### Instalação da JDK (Java Development Kit)

1. **Download**: Visite [Oracle Java SE Downloads](https://www.oracle.com/java/technologies/downloads/)
2. **Instalação**: Execute o instalador apropriado para seu SO
3. **Verificação**:
   ```bash
   java -version
   javac -version
   ```

### Variáveis de Ambiente
Configure JAVA_HOME e adicione bin ao PATH do sistema.

### IDEs Recomendadas
- **IntelliJ IDEA** (completa, paga mas com versão grátis)
- **Eclipse** (gratuita, open-source)
- **Visual Studio Code** (leve, com extensões)
- **NetBeans** (gratuita, open-source)

### Build Tools
- **Maven**: Gerenciamento de dependências e build
- **Gradle**: Alternativa mais moderna ao Maven
- **Ant**: Ferramenta antiga, ainda usada em legados

---

## Estrutura Básica de um Programa Java

### Exemplo Simples

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, Mundo!");
    }
}
```

### Componentes

| Componente | Descrição |
|-----------|-----------|
| `public` | Modificador de acesso (acessível de qualquer lugar) |
| `class` | Palavra-chave para declarar uma classe |
| `Main` | Nome da classe (deve coincidir com nome do arquivo) |
| `static` | Método pertence à classe, não a instâncias |
| `void` | Tipo de retorno (nenhum) |
| `main()` | Método de entrada do programa |
| `String[] args` | Argumentos de linha de comando |
| `System.out.println()` | Imprime no console com quebra de linha |

### Convenções de Nomenclatura

```java
// Classes: PascalCase
public class MyClass {
}

// Métodos e variáveis: camelCase
public void myMethod() {
    int myVariable = 10;
}

// Constantes: UPPER_SNAKE_CASE
public static final int MAX_USERS = 100;

// Pacotes: lowercase
package com.example.myapp;
```

---

## Tipos de Dados

### Tipos Primitivos

#### Numéricos Inteiros

| Tipo | Tamanho | Intervalo | Exemplo |
|------|--------|-----------|---------|
| `byte` | 8 bits | -128 a 127 | `byte b = 10;` |
| `short` | 16 bits | -32,768 a 32,767 | `short s = 1000;` |
| `int` | 32 bits | -2,147,483,648 a 2,147,483,647 | `int i = 100000;` |
| `long` | 64 bits | ±9,223,372,036,854,775,807 | `long l = 123456789L;` |

#### Numéricos Decimais

| Tipo | Tamanho | Precisão | Exemplo |
|------|--------|----------|---------|
| `float` | 32 bits | ~7 dígitos | `float f = 3.14f;` |
| `double` | 64 bits | ~15 dígitos | `double d = 3.14159;` |

#### Booleano e Caractere

| Tipo | Tamanho | Valores | Exemplo |
|------|--------|--------|---------|
| `boolean` | 1 bit | `true` ou `false` | `boolean isValid = true;` |
| `char` | 16 bits | 0 a 65,535 (Unicode) | `char c = 'A';` |

### Exemplo Prático

```java
public class DadosPrimitivos {
    public static void main(String[] args) {
        // Inteiros
        byte idade = 25;
        short ano = 2024;
        int populacao = 8000000;
        long distancia = 150000000000L;
        
        // Decimais
        float temperatura = 36.5f;
        double pi = 3.14159265359;
        
        // Booleano
        boolean isActive = true;
        
        // Caractere
        char grade = 'A';
        
        System.out.println("Idade: " + idade);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Ativo: " + isActive);
    }
}
```

### Tipos de Referência

- **Classes**: `String`, `Person`, `Employee`
- **Interfaces**: `List`, `Set`, `Map`
- **Arrays**: `int[]`, `String[]`, `Object[]`

```java
// Null é valor padrão para tipos de referência
String name = null;
int[] numbers = null;

// Inicialização
String message = "Olá";
int[] values = {1, 2, 3, 4, 5};
```

### Autoboxing e Unboxing

```java
// Autoboxing: primitivo → objeto
Integer num = 10;  // int 10 → Integer wrapper

// Unboxing: objeto → primitivo
int value = num;   // Integer → int 10
```

---

## Operadores

### Operadores Aritméticos

```java
int a = 10, b = 3;

int soma = a + b;        // 13
int subtracao = a - b;   // 7
int multiplicacao = a * b; // 30
int divisao = a / b;     // 3
int resto = a % b;       // 1

// Incremento/Decremento
a++;         // a = 11
b--;         // b = 2
int c = ++a; // c = 12, a = 12 (pré-incremento)
int d = a++; // d = 12, a = 13 (pós-incremento)
```

### Operadores de Comparação

```java
int x = 10, y = 20;

boolean igual = (x == y);      // false
boolean diferente = (x != y);  // true
boolean maior = (x > y);       // false
boolean menorOuIgual = (x <= y); // true
```

### Operadores Lógicos

```java
boolean condicao1 = true;
boolean condicao2 = false;

// AND (&&) - ambos precisam ser true
boolean resultado1 = condicao1 && condicao2;  // false

// OR (||) - pelo menos um precisa ser true
boolean resultado2 = condicao1 || condicao2;  // true

// NOT (!) - inverte valor
boolean resultado3 = !condicao1;              // false
```

### Operadores Bitwise

```java
int a = 5;    // 0101
int b = 3;    // 0011

int and = a & b;      // 0001 = 1 (AND)
int or = a | b;       // 0111 = 7 (OR)
int xor = a ^ b;      // 0110 = 6 (XOR)
int complement = ~a;  // 1010 (NOT)
int leftShift = a << 1;  // 1010 = 10 (deslocamento esquerda)
int rightShift = a >> 1; // 0010 = 2 (deslocamento direita)
```

### Operador Ternário

```java
int idade = 25;
String status = (idade >= 18) ? "Maior de idade" : "Menor de idade";
System.out.println(status);  // "Maior de idade"

// Aninhado
String categoria = (idade < 13) ? "Criança" 
                  : (idade < 18) ? "Adolescente" 
                  : "Adulto";
```

### Precedência de Operadores

```
1. () [] .
2. ! ~ ++ -- +expr -expr (unários)
3. * / %
4. + -
5. << >> >>>
6. < > <= >= instanceof
7. == !=
8. &
9. ^
10. |
11. &&
12. ||
13. ? :
14. = += -= *= /= %=
```

---

## Estruturas de Controle

### If-Else-If

```java
int nota = 75;

if (nota >= 90) {
    System.out.println("Excelente");
} else if (nota >= 80) {
    System.out.println("Bom");
} else if (nota >= 70) {
    System.out.println("Satisfatório");
} else {
    System.out.println("Insuficiente");
}
```

### Switch-Case

```java
int dia = 3;
String nomeDia;

switch (dia) {
    case 1:
        nomeDia = "Segunda";
        break;
    case 2:
        nomeDia = "Terça";
        break;
    case 3:
        nomeDia = "Quarta";
        break;
    case 4:
        nomeDia = "Quinta";
        break;
    case 5:
        nomeDia = "Sexta";
        break;
    default:
        nomeDia = "Fim de semana";
}

System.out.println(nomeDia);  // "Quarta"
```

**Switch Expression (Java 14+)**
```java
String nomeDia = switch (dia) {
    case 1 -> "Segunda";
    case 2 -> "Terça";
    case 3, 4, 5 -> "Dias úteis";
    default -> "Fim de semana";
};
```

### While

```java
int i = 0;

while (i < 5) {
    System.out.println("Iteração " + i);
    i++;
}

// Do-While (executa pelo menos uma vez)
do {
    System.out.println("Executado");
    i++;
} while (i < 5);
```

### For

```java
// For tradicional
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}

// For-each (enhanced for)
int[] valores = {10, 20, 30, 40, 50};
for (int valor : valores) {
    System.out.println("Valor: " + valor);
}

// For com String
String[] nomes = {"João", "Maria", "Pedro"};
for (String nome : nomes) {
    System.out.println("Nome: " + nome);
}
```

### Break e Continue

```java
// Break - sai do loop
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;  // Sai quando i = 5
    }
    System.out.println(i);  // 0, 1, 2, 3, 4
}

// Continue - pula iteração
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;  // Pula valores pares
    }
    System.out.println(i);  // 1, 3, 5, 7, 9
}
```

---

## Arrays

### Declaração e Inicialização

```java
// Declaração com tamanho
int[] numeros = new int[5];

// Declaração com valores
int[] valores = {1, 2, 3, 4, 5};

// Declaração alternativa
int numeros2[] = new int[5];

// String
String[] nomes = {"João", "Maria", "Pedro"};

// Multidimensional
int[][] matriz = new int[3][3];
int[][] matriz2 = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Acesso e Modificação

```java
int[] numeros = {10, 20, 30, 40, 50};

// Acesso (0-indexed)
System.out.println(numeros[0]);  // 10
System.out.println(numeros[4]);  // 50

// Modificação
numeros[2] = 35;

// Comprimento
System.out.println(numeros.length);  // 5

// Iteração
for (int num : numeros) {
    System.out.println(num);
}
```

### Arrays Multidimensionais

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Acesso
System.out.println(matriz[0][0]);  // 1
System.out.println(matriz[1][2]);  // 6

// Iteração
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

### Array vs ArrayList

```java
// Array (tamanho fixo)
int[] arrayFixo = new int[5];
arrayFixo[0] = 10;
System.out.println(arrayFixo.length);  // 5

// ArrayList (tamanho dinâmico)
ArrayList<Integer> lista = new ArrayList<>();
lista.add(10);
lista.add(20);
lista.add(30);
System.out.println(lista.size());  // 3

// Conversão
List<Integer> listFromArray = Arrays.asList(1, 2, 3);
Integer[] arrayFromList = listFromArray.toArray(new Integer[0]);
```

---

## Métodos

### Estrutura

```java
public static void main(String[] args) {
    System.out.println("Void - sem retorno");
}

public static int somar(int a, int b) {
    return a + b;
}

public static String greet(String name) {
    return "Olá, " + name;
}
```

### Componentes

```java
[modificador] [tipo_retorno] [nome_metodo](parâmetros) [exceção] {
    // corpo
}

// Exemplo completo
public static void exibirMensagem(String mensagem) {
    System.out.println(mensagem);
}

public static int calcularIdade(int anoNascimento) throws Exception {
    return 2024 - anoNascimento;
}
```

### Passagem de Parâmetros

```java
// Primitivos - passa valor (cópia)
public static void modificarInteiro(int valor) {
    valor = 100;
}

int x = 10;
modificarInteiro(x);
System.out.println(x);  // 10 (não foi alterado)

// Objetos - passa referência
public static void modificarPessoa(Person pessoa) {
    pessoa.setName("Novo Nome");
}

Person p = new Person("João");
modificarPessoa(p);
System.out.println(p.getName());  // "Novo Nome" (foi alterado)
```

### Varargs (Número Variável de Argumentos)

```java
public static int somar(int... numeros) {
    int soma = 0;
    for (int num : numeros) {
        soma += num;
    }
    return soma;
}

System.out.println(somar(1, 2, 3));           // 6
System.out.println(somar(1, 2, 3, 4, 5));    // 15
System.out.println(somar());                 // 0
```

### Sobrecarga de Métodos

```java
public class Calculadora {
    // Mesmo nome, parâmetros diferentes
    
    public static int somar(int a, int b) {
        return a + b;
    }
    
    public static double somar(double a, double b) {
        return a + b;
    }
    
    public static int somar(int a, int b, int c) {
        return a + b + c;
    }
}

// Chamadas
Calculadora.somar(5, 3);           // 8 (int)
Calculadora.somar(5.5, 3.2);       // 8.7 (double)
Calculadora.somar(5, 3, 2);        // 10 (3 int)
```

---

## Classes e Objetos

### Definindo uma Classe

```java
public class Person {
    // Atributos (propriedades)
    private String name;
    private int age;
    private String email;
    
    // Construtor padrão
    public Person() {
        this.name = "Desconhecido";
        this.age = 0;
    }
    
    // Construtor com parâmetros
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setters
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }
    
    // Métodos
    public void displayInfo() {
        System.out.println("Nome: " + name + ", Idade: " + age);
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

### Criando Objetos

```java
// Instanciação
Person pessoa1 = new Person();
Person pessoa2 = new Person("João", 30);

// Acessando atributos e métodos
pessoa1.setName("Maria");
pessoa1.setAge(25);
pessoa1.displayInfo();  // Nome: Maria, Idade: 25

System.out.println(pessoa2);  // Person{name='João', age=30}

// Referências
Person pessoa3 = pessoa1;  // Referencia o mesmo objeto
pessoa3.setName("Pedro");
System.out.println(pessoa1.getName());  // "Pedro"
```

### This e Super

```java
public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;  // 'this' refere-se ao objeto atual
    }
    
    public void display() {
        System.out.println("Nome: " + this.name);
    }
}

public class Employee extends Person {
    private double salary;
    
    public Employee(String name, double salary) {
        super(name);  // Chama construtor da classe pai
        this.salary = salary;
    }
}
```

### Modificador Static

```java
public class Counter {
    private static int count = 0;  // Compartilhado por todas instâncias
    private int id;
    
    public Counter() {
        count++;
        id = count;
    }
    
    public static int getCount() {
        return count;  // Método estático
    }
    
    public int getId() {
        return id;
    }
    
    // Bloco estático (executado uma vez)
    static {
        System.out.println("Classe Counter inicializada");
    }
}

// Uso
Counter c1 = new Counter();
Counter c2 = new Counter();
System.out.println(Counter.getCount());  // 2
```

---

## Compilação e Execução

### Compilando

```bash
# Arquivo único
javac Main.java

# Múltiplos arquivos
javac *.java

# Especificando diretório de saída
javac -d bin src/*.java

# Com classpath
javac -cp ".;lib/*" src/Main.java
```

### Executando

```bash
# Arquivo único
java Main

# Com pacote
java com.example.Main

# Passando argumentos
java Main arg1 arg2 arg3

# Com classpath
java -cp ".;lib/*" com.example.Main

# Definindo heap size
java -Xmx1024m -Xms512m Main
```

### Maven

```bash
# Compilar
mvn clean compile

# Testar
mvn test

# Empacotar
mvn package

# Instalar
mvn install

# Executar
mvn exec:java -Dexec.mainClass="com.example.Main"
```

### Exemplo Completo de Compilação Manual

```bash
# Estrutura
src/
  com/
    example/
      Person.java
      Main.java

# Compilar
cd src
javac com/example/*.java

# Estrutura após compilação
src/
  com/
    example/
      Person.java
      Person.class
      Main.java
      Main.class

# Executar
java com.example.Main

# Remover .class gerados
del com\example\*.class (Windows)
rm com/example/*.class (Linux/Mac)
```

---

## Para Lembrar

✅ **Boas Práticas:**
- Use nomes significativos para classes, métodos e variáveis
- Encapsule dados com modificadores de acesso apropriados
- Siga a convenção PascalCase para classes e camelCase para métodos
- Documente seu código com comentários e JavaDoc
- Trate exceções adequadamente
- Evite null quando possível, use Optional

❌ **Evitar:**
- Variáveis públicas (violam encapsulamento)
- Métodos muito longos
- Magic numbers (use constantes)
- Ignorar exceções
- Nomes ambíguos

---

## Recursos Adicionais

- [Oracle Java Documentation](https://docs.oracle.com/javase/)
- [Java API Documentation](https://docs.oracle.com/en/java/)
- [Baeldung Java Tutorials](https://www.baeldung.com/)
- [GeeksforGeeks Java](https://www.geeksforgeeks.org/java/)

