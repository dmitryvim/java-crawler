# how to run

To build the app please use gradle (Linux/Macos)

```bash
./gradlew build
```

To run the application, start it with java

```bash
java -jar build/libs/java-crawler.jar
```

# problems and todos

1. replace URL connection to Selenium driver in order to manage javascript load
2. add tests to the processor in order to check orchestration
3. move start page to command line arguments 
4. move allowed websites to configuration
5. maybe use selenium to read `<a href>` links and put PageLoader.class + PageParser.class functions in the same class
6. prettify json