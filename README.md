# Pretius
## Zadanie Rekrutacyjne


### Budowanie programu
    
Proces budowy rozpoczynamy wpisując komende w folderze głównym: <br/>
`mvn clean install` <br/>
w przybadku braku narzędzia maven można skorzystać z wersji przesyłanej wraz z kodem: <br/>
`./mvnw clean install` <br/>
    
### Startowanie Aplikacji
    
Po zakończeniu procesu budowy pojawi się folder target, a w nim plik exchanger-1.0.0.RELEASE.jar <br/>
Aplikacjie można wystartować poleceniem: <br/>
`java -jar exchanger-1.0.0.RELEASE.jar`<br/>
Aplikacjia do działania nie potrzebuje zewnetrznego serwera aplikacyjnego (serwer wbudowany jest w projekt).<br/>
Aplikacjia domyślnie uruchamia się na porcie 8080,
aby zmienic port nalerzy wpisać wartość portu w pliku application.properties
