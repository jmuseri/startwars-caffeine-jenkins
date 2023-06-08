# Star Wars Character Service

This is a Java Spring Boot application that provides information about Star Wars characters using the Star Wars API (SWAPI). It utilizes caching with Caffeine, logging with SLF4J and Lombok, and follows a microservices architecture.

## Technologies Used

- Java 11
- Spring Boot 2.5.2
- Caffeine for caching
- SLF4J and Lombok for logging
- SWAPI (Star Wars API) for character data

## Features

- Retrieves information about Star Wars characters from the SWAPI
- Caches character data using Caffeine for improved performance
- Supports logging of requests and responses for debugging and monitoring purposes

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installation

1. Clone the repository:

git clone https://github.com/your-username/your-repository.git


2. Navigate to the project directory:

cd your-repository


3. Build the project using Maven:

mvn clean install

4. Run the application:

mvn spring-boot:run


## Usage

### Retrieving Star Wars Character Information

To retrieve information about a Star Wars character, make a GET request to the following endpoint:

http://localhost:8080/characters/{id}

Replace `{id}` with the desired character ID.

The response will contain details about the character in JSON format.

## Contributing

Contributions are welcome! If you find any issues or want to add new features, please submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
