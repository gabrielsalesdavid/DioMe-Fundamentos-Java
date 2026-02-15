# Conceitos Fundamentais de Java

## 📚 Índice
1. [Orientação a Objetos](#orientação-a-objetos)
2. [Herança e Polimorfismo](#herança-e-polimorfismo)
3. [Encapsulamento](#encapsulamento)
4. [Interfaces e Lambda](#interfaces-e-lambda)
5. [Coleções](#coleções)
6. [Tratamento de Exceções](#tratamento-de-exceções)
7. [Generics](#generics)
8. [Streams API](#streams-api)
9. [Enums e Optional](#enums-e-optional)
10. [Concorrência (Threads)](#concorrência-threads)

---

## Orientação a Objetos

A Orientação a Objetos (OOP) é um paradigma que utiliza **objetos** e **classes** como blocos de construção fundamentais.

### Pilares da OOP

#### 1. **Encapsulamento**
Ocultação de dados internos, expondo apenas o necessário através de métodos públicos.

```java
public class Person {
    private String name;  // Privado - oculto
    private int age;      // Privado - oculto
    
    // Métodos públicos para acesso controlado
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }
}
```

#### 2. **Abstração**
Representação simplificada de objetos complexos, mostrando apenas os detalhes relevantes.

```java
abstract class Vehicle {
    abstract void start();
    abstract void stop();
    
    // Implementação compartilhada
    public void honk() {
        System.out.println("Beep!");
    }
}
```

#### 3. **Herança**
Mecanismo de reutilização de código onde uma classe herda características de outra.

```java
class Employee extends Person {
    private double salary;
    
    public void displayInfo() {
        System.out.println("Nome: " + getName());
        System.out.println("Salário: " + salary);
    }
}
```

#### 4. **Polimorfismo**
Capacidade de objetos de diferentes tipos responderem ao mesmo método de formas distintas.

```java
Person person = new Employee();      // Polimorfismo
Person person2 = new Manager();      // Mesmo tipo, comportamento diferente
```

---

## Herança e Polimorfismo

### Herança
Permite que uma classe herde propriedades e métodos de outra classe.

**Tipos de Herança:**
- **Herança Simples**: Uma classe herda de uma única classe
- **Hierarquia**: Múltiplos níveis de herança
- **Múltiplas Interfaces**: Uma classe implementa múltiplas interfaces

```java
// Classe Base
public class Employee {
    protected String name;
    protected double salary;
    
    public void work() {
        System.out.println("Trabalhando...");
    }
}

// Classe Derivada
public class Manager extends Employee {
    private int teamSize;
    
    public void managementTask() {
        System.out.println("Gerenciando equipe de " + teamSize);
    }
}

// Classe Derivada
public class Salesman extends Employee {
    private double commission;
    
    public void sellProduct() {
        System.out.println("Vendendo produto...");
    }
}
```

### Polimorfismo

**Sobrescrita de Métodos (Override)**
```java
class Employee {
    public void calculateBonus() {
        System.out.println("Bônus padrão");
    }
}

class Manager extends Employee {
    @Override
    public void calculateBonus() {
        System.out.println("Bônus com adição por gerenciamento");
    }
}

class Salesman extends Employee {
    @Override
    public void calculateBonus() {
        System.out.println("Bônus baseado em vendas");
    }
}
```

**Sobrecarga (Overload)**
```java
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }
    
    public double sum(double a, double b) {
        return a + b;
    }
    
    public int sum(int a, int b, int c) {
        return a + b + c;
    }
}
```

---

## Encapsulamento

O encapsulamento combina dados e métodos em uma unidade (classe), controlando o acesso por meio de modificadores.

### Modificadores de Acesso

| Modificador | Mesma Classe | Mesmo Pacote | Subclasse | Outros |
|-------------|:----:|:----:|:----:|:----:|
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| (padrão) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

### Exemplo Prático

```java
public class Person {
    private String name;        // Encapsulado
    private int age;            // Encapsulado
    protected String email;     // Acessível a subclasses
    public String id;           // Público (use com moderação)
    
    // Getters e Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }
}
```

### Records (Java 14+)
Forma concisa de criar classes de dados:

```java
public record Person(String name, int age, String email) {
    // Getters automáticos, constructor, equals, hashCode, toString
}

// Uso
Person person = new Person("João", 30, "joao@email.com");
System.out.println(person.name());  // "João"
```

---

## Interfaces e Lambda

### Interfaces
Contrato que define o que uma classe deve fazer, sem especificar como.

```java
public interface GeometricForm {
    double calculateArea();
    double calculatePerimeter();
}

public class Circle implements GeometricForm {
    private double radius;
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class Rectangle implements GeometricForm {
    private double width;
    private double height;
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
```

### Interfaces Funcionais
Interface com único método abstrato, ideal para Lambdas.

```java
@FunctionalInterface
public interface MusicPlayer {
    void play();
}

public interface VideoPlayer {
    void play();
    void pause();
    void stop();
}
```

### Expressões Lambda (Java 8+)
Forma concisa de implementar interfaces funcionais.

```java
// Sintaxe: (parâmetros) -> { corpo }

// Exemplo 1: Sem parâmetros
MusicPlayer player = () -> System.out.println("Tocando música...");
player.play();

// Exemplo 2: Com parâmetros
Operation add = (a, b) -> a + b;
System.out.println(add.perform(5, 3));  // 8

// Exemplo 3: Corpo múltiplo
Operation multiply = (a, b) -> {
    System.out.println("Multiplicando...");
    return a * b;
};
```

---

## Coleções

### Hierarquia de Coleções

```
Collection (interface)
├── Set (sem duplicatas, sem ordem)
│   ├── HashSet
│   ├── TreeSet
│   └── LinkedHashSet
├── List (com ordem)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
└── Queue (FIFO)
    ├── PriorityQueue
    └── Deque

Map (interface)
├── HashMap
├── TreeMap
├── LinkedHashMap
└── Hashtable
```

### Exemplos Práticos

**List - Ordenada, permite duplicatas**
```java
List<String> names = new ArrayList<>();
names.add("João");
names.add("Maria");
names.add("João");  // Duplicado permitido

System.out.println(names.size());  // 3
```

**Set - Sem duplicatas, sem ordem**
```java
Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("João");
uniqueNames.add("Maria");
uniqueNames.add("João");  // Ignorado

System.out.println(uniqueNames.size());  // 2
```

**Map - Pares chave-valor**
```java
Map<String, Integer> ages = new HashMap<>();
ages.put("João", 30);
ages.put("Maria", 28);

System.out.println(ages.get("João"));  // 30
```

### Collections Util
```java
// Busca
List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5);
Collections.sort(numbers);
System.out.println(numbers);  // [1, 1, 3, 4, 5]

// Reverter
Collections.reverse(numbers);

// Máximo
Integer max = Collections.max(numbers);

// Embaralhar
Collections.shuffle(numbers);
```

---

## Tratamento de Exceções

### Hierarquia de Exceções

```
Throwable
├── Error (grave, não tratar)
│   └── StackOverflowError
└── Exception (tratar)
    ├── IOException
    ├── SQLException
    └── RuntimeException (não obrigatório tratar)
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        └── ArithmeticException
```

### Bloco Try-Catch-Finally

```java
try {
    // Código que pode lançar exceção
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // Tratamento específico
    System.out.println("Erro: " + e.getMessage());
} catch (Exception e) {
    // Tratamento genérico
    System.out.println("Erro geral: " + e.getMessage());
} finally {
    // Sempre executado
    System.out.println("Operação finalizada");
}
```

### Try-With-Resources (Java 7+)
Fecha automaticamente recursos.

```java
try (FileInputStream fis = new FileInputStream("file.txt")) {
    // Usa o recurso
    int data = fis.read();
} catch (IOException e) {
    System.out.println("Erro ao ler arquivo");
}
// FileInputStream fechado automaticamente
```

### Criando Exceções Personalizadas

```java
public class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        super("Saldo insuficiente: " + amount);
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}

// Uso
public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
        throw new InsufficientFundsException(amount);
    }
    balance -= amount;
}
```

---

## Generics

Permite criar código reutilizável com tipos parametrizados.

### Sintaxe Básica

```java
// Classe genérica
public class Box<T> {
    private T content;
    
    public void put(T item) {
        this.content = item;
    }
    
    public T get() {
        return content;
    }
}

// Uso
Box<String> stringBox = new Box<>();
stringBox.put("Olá");
String value = stringBox.get();

Box<Integer> intBox = new Box<>();
intBox.put(42);
Integer number = intBox.get();
```

### Generics em Métodos

```java
public class GenericDAO<T> {
    private List<T> database = new ArrayList<>();
    
    public void create(T entity) {
        database.add(entity);
    }
    
    public T read(int id) {
        if (id >= 0 && id < database.size()) {
            return database.get(id);
        }
        return null;
    }
    
    public void update(int id, T entity) {
        if (id >= 0 && id < database.size()) {
            database.set(id, entity);
        }
    }
    
    public void delete(int id) {
        if (id >= 0 && id < database.size()) {
            database.remove(id);
        }
    }
}
```

### Wildcard (?)

```java
// ? - qualquer tipo
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

// ? extends - subtipo
public void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}

// ? super - supertipo
public void addNumbers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```

---

## Streams API

Processamento funcional de dados em sequências.

### Operações Intermediárias

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// filter - filtrar
numbers.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);  // 2, 4, 6, 8, 10

// map - transformar
numbers.stream()
    .map(n -> n * 2)
    .forEach(System.out::println);  // 2, 4, 6, 8, 10, 12...

// sorted - ordenar
numbers.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);

// distinct - remover duplicatas
Arrays.asList(1, 2, 2, 3, 3, 3)
    .stream()
    .distinct()
    .forEach(System.out::println);  // 1, 2, 3

// limit - limitar
numbers.stream()
    .limit(3)
    .forEach(System.out::println);  // 1, 2, 3

// skip - pular
numbers.stream()
    .skip(5)
    .forEach(System.out::println);  // 6, 7, 8, 9, 10
```

### Operações Terminais

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// forEach - iterar
numbers.stream().forEach(System.out::println);

// collect - coletar resultado
List<Integer> evens = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());

// reduce - reduzir a um valor
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);
System.out.println(sum);  // 15

// count, min, max, anyMatch, allMatch
long count = numbers.stream().count();
Optional<Integer> min = numbers.stream().min(Integer::compare);
Optional<Integer> max = numbers.stream().max(Integer::compare);
boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
```

---

## Enums e Optional

### Enums
Tipo que representa um conjunto fixo de constantes.

```java
public enum OperationEnum {
    ADD("+") {
        @Override
        public double execute(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public double execute(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public double execute(double a, double b) {
            return a * b;
        }
    };
    
    private String symbol;
    
    OperationEnum(String symbol) {
        this.symbol = symbol;
    }
    
    public abstract double execute(double a, double b);
    
    public String getSymbol() {
        return symbol;
    }
}

// Uso
OperationEnum op = OperationEnum.ADD;
System.out.println(op.execute(5, 3));  // 8
```

### StateEnum
```java
public enum StateEnum {
    ACTIVE("Ativo"),
    INACTIVE("Inativo"),
    PENDING("Pendente");
    
    private String description;
    
    StateEnum(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
```

### Optional
Alternativa a valores nulos.

```java
import java.util.Optional;

public class User {
    private String name;
    private String email;  // Pode ser nulo
    
    // Com Optional
    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

// Uso
User user = new User();
user.getEmail()
    .ifPresent(email -> System.out.println("Email: " + email));

String emailOrDefault = user.getEmail()
    .orElse("sem-email@default.com");

// Operações encadeadas
user.getEmail()
    .filter(e -> e.contains("@"))
    .map(String::toUpperCase)
    .ifPresent(System.out::println);
```

---

## Concorrência (Threads)

### Criando Threads

**Estendendo Thread**
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Uso
MyThread thread = new MyThread();
thread.start();
```

**Implementando Runnable**
```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Executando...");
    }
}

// Uso
Thread thread = new Thread(new MyRunnable());
thread.start();

// Com Lambda
Thread thread2 = new Thread(() -> System.out.println("Executando..."));
thread2.start();
```

### Sincronização

```java
public class Counter {
    private int count = 0;
    
    // Método sincronizado
    public synchronized void increment() {
        count++;
    }
    
    // Bloco sincronizado
    public void decrement() {
        synchronized (this) {
            count--;
        }
    }
    
    public int getCount() {
        return count;
    }
}
```

### Estados de Thread

```
    ┌─────────────┐
    │   NEW       │
    └──────┬──────┘
           │ start()
    ┌──────▼──────────┐
    │  RUNNABLE       │◄──────────────┐
    └──────┬──────────┘               │
           │ wait(), sleep()          │
    ┌──────▼──────────┐               │
    │  WAITING        │               │
    │  TIMED_WAITING  │───notify()────┤
    └──────┬──────────┘               │
           │ notificação              │
           │                          │
    ┌──────▼──────────────────────────┤
    │       BLOCKED                   │
    └────────────────────────────────┬┤
                                     │ run() finaliza
                                ┌────▼──────┐
                                │ TERMINATED│
                                └───────────┘
```

---

## Recursos Adicionais

- **Lombok**: Reduz boilerplate com anotações
- **BigDecimal**: Precisão em operações com decimais
- **Date/Calendar/LocalDateTime**: Manipulação de datas
- **StringBuilder/StringBuffer**: Manipulação eficiente de strings
- **I/O e NIO**: Leitura/escrita de arquivos

---

## Conclusão

Estes conceitos formam a base da programação Java moderna. Dominar estes pilares permite criar aplicações robustas, eficientes e mantíveis.
