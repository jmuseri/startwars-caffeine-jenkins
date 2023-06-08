# Star Wars Character API

This project is a Java Spring Boot application that provides an API for retrieving information about Star Wars characters. It leverages external APIs to fetch character data and implements caching for improved performance.

## Technologies Used

- Java 11: Programming language used for the backend development.
- Spring Boot: Framework used for building the RESTful API and managing application components.
- Caffeine: Caching library used to cache character data and reduce external API calls.
- RestTemplate: Client library used for making HTTP requests to external APIs.
- Spring Cache: Spring's caching abstraction used to integrate caching functionality.
- Swagger/OpenAPI: Specification and tooling for building and documenting RESTful APIs.
- Lombok: Library for reducing boilerplate code in Java classes.
- SLF4J: Logging framework used for logging requests and responses.

## Features

- Retrieve information about Star Wars characters by their ID.
- Caches character data to reduce external API calls and improve performance.
- Automatically refreshes cached data after a specified duration.
- Logs API requests and responses for debugging and monitoring.

## Getting Started

To run the Star Wars Character API locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/star-wars-api.git`
2. Navigate to the project directory: `cd star-wars-api`
3. Build the project: `./mvnw clean install`
4. Start the application: `./mvnw spring-boot:run`
5. The API will be available at `http://localhost:8080`.

## API Documentation

The API is documented using Swagger/OpenAPI. Once the application is running, you can access the Swagger UI to explore and interact with the API endpoints. Open your browser and navigate to `http://localhost:8080/swagger-ui.html`.

## Configuration

The project's configuration can be modified by editing the `application.properties` file. Here are some important properties:

- `api.url`: The base URL of the external API for retrieving character data.
- `cache.maximumSize`: The maximum number of characters to cache.
- `cache.expireAfterWrite`: The duration after which cached character data will expire.

## Contributing

Contributions are welcome! If you find any issues or want to add new features, feel free to open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
