# JavaMySQL

[![Java CI with Maven](https://github.com/MCTzOCK/JavaMySQL/actions/workflows/maven.yml/badge.svg)](https://github.com/MCTzOCK/JavaMySQL/actions/workflows/maven.yml)

# Installation

Add this to your pom.xml and run ``mvn install``:

```xml
<dependency>
  <groupId>de.mctzock</groupId>
  <artifactId>javamysql</artifactId>
  <version>1.0-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```
# Example

```java
package org.example.loginsystem;

// Main class
import de.mctzock.javamysql.MySQL;

public class Main {
  
  public static void main(String[] args) {
    // Initialize MySQL Connection
    MySQL mysql = new MySQL(
      "SELECT * FROM `users` WHERE `name` = 'MCTzOCK'",  // sql query / statement
      "localhost", // host
      "3306", // port
      "mctzock", // username
      "a_very_secure_password",  // password
      "users", // database
      "useSSL=false" // connection parameters
    );
    
    ResultSet result = mysql.executeQuery();
    
    // Handle result
    /* ... */
    
    // Close MySQL Connection
    mysql.close();
  }
}

```

# Java Docs

The JavaDocs can be found [here](https://mctzock.github.io/JavaMySQL)
