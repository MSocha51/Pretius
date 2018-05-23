# Pretius
## Zadanie Rekrutacyjne


### Budowanie programu:
    Proces budowy rozpoczynamy wpisując komende w folderze głównym:
    `mvn clean install`
    w przybadku braku narzędzia maven można skorzystać z wersji przesyłanej wraz z kodem:
    `./mvnw clean install`
    
### Startowanie Aplikacji
    Po zakończeniu procesu budowy pojawi się folder target, a w nim plik exchanger-1.0.0.RELEASE.jar
    Aplikacjie można wystartować poleceniem:
    `java -jar exchanger-1.0.0.RELEASE.jar`
    Aplikacjia do działania nie potrzebuje zewnetrznego serwera aplikacyjnego (serwer wbudowany jest w projekt).
    Aplikacjia domyślnie uruchamia się na porcie 8080,
    aby zmienic port nalerzy wpisać wartość portu w pliku application.properties
