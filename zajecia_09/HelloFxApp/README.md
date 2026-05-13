# Konfiguracja projektu z JavaFX

1. Pobierz SDK JavaFX z Gluon (https://gluonhq.com/products/javafx/) lub Oracle zgodny z wersją JDK i rozpakuj w wybranym katalogu
2. Dodaj biblioteki JavaFX do projektu w IntelliJ IDEA:   
`File -> Project Structure -> Libraries`  
wskzaując katalog z paczkami jar z rozpakowanego SDK `ścieżka/do/javafx-sdk-XX/lib`
3. Ustaw ścieżkę do modułów javafx w opcjach uruchamiania IntelliJ IDEA   
    `Build -> Edit Configurations-> VM options`  
dodajemy opcje: 
`--module-path "ścieżka/do/javafx-sdk-XX/lib" --add-modules javafx.controls,javafx.fxml`