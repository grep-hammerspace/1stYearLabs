## Data Structures and Algorithms

This repo consists of code used to practice coding for year 1 labs. It is built with Java 21 and Maven.

This repo contains class stubs (what you fill out when doing the labs), unit tests (which you can run to check your work) and answers (which you can look at if you get stuck or want to see how I solved the problem)
### Structure 

This repo is laid out in the following way:

```
src/
    main/
        java/
            org/
                example/
                    answers/
                        week1/
                            <answers for week 1>
                        week2/
                            <answers for week 2>
                        week3/
                            <answers for week 3>
                    dsa/
                        week1/
                            <class-stubs for week 1>
                        week2/
                            <class-stubs for week 2>
                        week3/
                            <class-stubs for week 3>
    test/
        java/
            org/
                example/
                    dsa/
                        week1/
                            <unit-tests for week 1>
                        week2/
                            <unit-tests  for week 2>
                        week3/
                            <unit-tests for week 3>
```

### Running Tests

The test are setup to fail by default, you just need to implement methods and run tests, try to get as many as possible passing!
If you want to see what it looks like to step through the answers, swap the import in any test file from `org.example.dsa.X` to `org.example.answers.X`