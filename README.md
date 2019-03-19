# Mutant Finder
Application to find out if a human being is a mutant, by analizing its DNA.

DNAs will be represented as array Strings, which represent a table of NxN size.

A human is a mutant if its DNA has a sequence of four or more equal letters, in horizontal, vertical or obliquos way.

### Example
```
Mutant DNA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"} 
Non Mutant DNA = {"ATGC","GTCA","CCCC","ATGC"}
```
## Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

**[Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)**

**[Maven](https://maven.apache.org/download.cgi)**

### Building the project

Full build
```
mvn install
```

Skip Tests
```
mvn install -DskipTests
```

Any of the above commands will bring you a deployable war, which can be found in *target* folder

### Running locally

```
mvn spring-boot:run -DskipTests
```

The above command will leave you an application running in **[http://localhost:8080](http://localhost:8080)**

If you try to reach it, after starting it you'll get a *White Label Error Page*. It's the default Tomcat page for mapping errors. The reason is there's no service running in the root endpoint.

## Running the tests

```
mvn test
```

To get metrics about coverage
```
mvn test jacoco:report
```

After running this last one command, you can now take a look to *target/site/jacoco/index.html* page to see the generated report.

Minimum coverage is set to 80%. You can check if the code match this rule with

```
mvn clean verify
```

**Important:** If the code doesn't match the expected minimum coverage, build will fail.

You can change the minimum ratio by modifing the *jacoco-check* goal in the *pom* file.

More information about setting the JaCoCo agent can be found in the **[official documentation link](https://www.eclemma.org/jacoco/trunk/doc/index.html)**

## API Resources

 - POST /mutant
 - GET /stats

### POST /mutant

**Header:** Content-type Application/json

**Body**
```
{
  "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
```

**Responses**

**200 OK** If the human results to be a mutant

**403 Forbidden** Otherwise

### GET /stats

**Header:** Content-type Application/json

**Response Body**
```
{
  "countMutantDna": 40
  "countHumanDna": 100
  "ratio": 0.4
}
```
## Running Application

There is a running application of this project in Google App Engine.

You can access it in the following address: **[https://mutantfinder-234900.appspot.com](https://mutantfinder-234900.appspot.com)**

You'll get a WhiteLabel Error Page cause there is nothing running in root.

You can consume the services described above.

- POST /mutant **[https://mutantfinder-234900.appspot.com/mutant](https://mutantfinder-234900.appspot.com/mutant)**

- GET /stats **[https://mutantfinder-234900.appspot.com/stats](https://mutantfinder-234900.appspot.com/stats)**

For consuming the POST service you'll need an API Developement Platform, **[Postman](https://www.getpostman.com/)** is recommended.

## Author

**Martín Eduardo Margonari**
