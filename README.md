# Spring test

## Installazione

Generare il .war attraverso il comando Maven e successivamente installarlo su Tomcat.

```bash
mvn clean package
```

## Utilizzo

Aprire Tomcat da browser al suo url (default http://localhost:8080). L'applicazione si trova sotto il nome "3spring" (stesso nome del .war generato).

```bash
http://localhost:8080/3spring
```

Le credenziali di accesso sono due
```bash
Username: Bret
Password: password

Username: Antonette
Password: 12345
```

## Nota 
Nella consegna del test vi era riportata una api Rest errata
```bash
http://jsonplaceholder.typicode.com/posts/{user_id}
```
Questa API visualizza il post con quell'id e non il post di quell'utente. 
Tutti post dell'utente {user_id} si ottengono utilizzando l'api.
```bash
http://jsonplaceholder.typicode.com/posts?user={user_id}
```