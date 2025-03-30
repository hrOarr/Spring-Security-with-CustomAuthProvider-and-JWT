<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">SPRING-SECURITY-WITH-JWT</h1></p>
<p align="center">
	<em>Secure, Scalable, and Flexible Authentication System</em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/hrOarr/Spring-Security-with-JWT?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/hrOarr/Spring-Security-with-JWT?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/hrOarr/Spring-Security-with-JWT?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/hrOarr/Spring-Security-with-JWT?style=default&color=0080ff" alt="repo-language-count">
</p>

<br>

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Contributing](#contributing)
- [Acknowledgments](#acknowledgments)

---

##  Introduction

In modern applications, securing APIs and user authentication is a crucial aspect of system design. This project implements **Spring Security with JWT (JSON Web Token) authentication**, supporting multiple authentication providers.

#### About Cryptography, JWT, Encryption Algorithms
##### 1. Cryptography in Security
Cryptography is the practice of securing communication and data through encoding and decoding techniques. Common cryptographic techniques:
- Hashing → Irreversible transformation (e.g., SHA-256, bcrypt)
- Encryption → Reversible encoding (e.g., AES, RSA)
- Digital Signatures → Ensure authenticity using public/private keys

##### 2. JSON Web Token (JWT)
A JWT consists of three parts, separated by dots (.):
```
Header.Payload.Signature
```
**Header** – Contains metadata like algorithm (HS256, RS256) and token type.

**Payload** – Holds claims (user info, roles, expiry time, etc.).

**Signature** – Secures the token by verifying its integrity.

##### 3. Encryption Algorithms
- Symmetric Encryption (Single Key)
- Asymmetric Encryption (Public & Private Keys)

---

##  Features
#### 1. Multiple Authentication Providers
- **DAO Authentication Provider** – Authenticates users from the database (username & password).
- **Custom Authentication Provider** – Supports additional authentication mechanisms

#### 2. JWT-Based Authentication
- Implements **stateless authentication** using **JSON Web Tokens (JWT)**.
- Uses **signed JWTs** to prevent tampering.
- Supports **token expiration & refresh mechanisms**.

#### 3. Secure API Authorization
- **Role-based access control (RBAC)** for different user roles.
- Uses **JWT claims** to determine access permissions.
- Protects API endpoints with **Spring Security filters**.

#### 4. Stateless and Scalable Security
- No session storage required (**session-less authentication**).
- Works well with **microservices & distributed systems**.
- API requests include JWT in **Authorization Header (`Bearer <token>`)**.

#### 6. CSRF Protection
- Eliminates **CSRF (Cross-Site Request Forgery) risks** by avoiding cookies.

#### 7. Security Best Practices
- **BCrypt password hashing** for user credentials.
- Implements **refresh token mechanism** for secure session extension.
- Handles **invalid or expired JWT tokens gracefully**.

---

##  Project Structure

```
└── Spring-Security-with-JWT/
    ├── README.md
    ├── SpringSecurity.iml
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── src
        ├── main
        └── test
```
---
##  Getting Started

###  Prerequisites

Before getting started with Spring-Security-with-JWT, ensure you meet the following requirements:

- **Programming Language:** Java
- **Frameworks:** Spring Boot
- **Project Management Tools:** Maven


###  Installation

Install Spring-Security-with-JWT using one of the following methods:

**Build from source:**

1. Clone the Spring-Security-with-JWT repository:
```sh
❯ git clone https://github.com/hrOarr/Spring-Security-with-JWT
```

2. Navigate to the project directory:
```sh
❯ cd Spring-Security-with-JWT
```

##  Contributing

- **🐛 [Report Issues](https://github.com/hrOarr/Spring-Security-with-JWT/issues)**: Submit bugs found or log feature requests for the `Spring-Security-with-JWT` project.
- **💡 [Submit Pull Requests](https://github.com/hrOarr/Spring-Security-with-JWT/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/hrOarr/Spring-Security-with-JWT
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/hrOarr/Spring-Security-with-JWT/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=hrOarr/Spring-Security-with-JWT">
   </a>
</p>
</details>

---

##  Acknowledgments

- https://www.toptal.com/spring/spring-security-tutorial
- https://medium.com/@tericcabrel/implement-jwt-authentication-in-a-spring-boot-3-application-5839e4fd8fac

---


