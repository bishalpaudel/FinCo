# Project Title

Financial Framework

## Project Description

A simple framework that provides abstraction for financial applications such as bank or credit card company. The UML design is under UML folder. The design provides more details on the struture of the framework.

## Getting Started

To run this project, simply clone the repository and run `FinCo.java`.

### Prerequisites

* Java 8

### Design Patterns used

#### Abstract Factory Pattern (GoF)
Abstract factory pattern is used for the instantiation of a set of dependent group of objects to achieve inversion of control (IOC) for the framework. Abstract factory pattern is used to inject dependencies (DI) for different customers, accounts, and DAOs.

#### Singleton Pattern (GoF)
Singleton pattern is used to hold single instances of DAO, Factory and Customer.

#### Party Pattern (Explained by Martin Fowler)
This pattern provides the single abstraction of customer for person and organization as a Party.

#### Account Pattern (Explained by Martin Fowler)
This pattern abstracts
Different type of account can have the single abstraction of account and can operate different account related operations. 

#### Iterator Pattern (GoF)
This pattern facilitates the iteration of a list of customers from DAO.

#### Command Pattern (GoF)
This pattern is used to provide single command like functionality, and undo-redo (TODO, not yet implemented here) features. It provides the abstraction for actions such as add account, add interest, deposit money, withdraw money, etc.

#### Strategy Pattern (GoF)
This pattern provides the choice of strtegy for different types of report generation such as monthly billing report, account summary report, etc.

#### Observer Pattern (GoF)
This pattern is used to notify views of any change in the accounts or customers.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Intellij Idea](https://www.jetbrains.com/idea/) - IDE
* [StarUML](http://staruml.io/) - UML Class and Sequence Dragramming

## Authors

* **Bishal Paudel** - [BishalPaudel](https://github.com/bishalpaudel)
* **Akash KC** - [BishalPaudel](https://github.com/bishalpaudel)
* **Devi Bahadur Khadka** - [BishalPaudel](https://github.com/bishalpaudel)

See also the list of [contributors](https://github.com/bishalpaudel/FinCo/contributors) who participated in this project.

## Disclaimer
This project is created for educational and learning purposes only. Until this time, this project cannot be used for commercial purposes. We hope to continue and improve this project in the future.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details