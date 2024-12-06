
# Avocado API Project : CS6905 - The TiaShack Interface

## Project Overview  
The Avocado API Project implements three types of APIs—GraphQL, SOAP, and REST—for interacting with avocado sales data stored in a PostgreSQL database. [The Avocado Prices Dataset](https://www.kaggle.com/datasets/neuromusic/avocado-prices) is used to create the APIs. The aim of this project is to implement identical APIs in the three paradigms in order to compare their performance. 

## Project Structure  
The codebase is organized into the following packages:  

### Folder Structure  
1. **`model`**: Contains entity classes for ORM (Object-Relational Mapping) to represent the database structure. It also includes models that help structure data for specific use cases.
2. **`repository`**: Interacts with the database by extending Spring Data JPA repositories for CRUD operations and custom queries.  
3. **`api`**: Contains API controllers and services for each API type:  
    - **soap**: Implements SOAP-based web services.  
    - **rest**: Implements REST endpoints for CRUD operations.  
    - **graphql**: Implements GraphQL queries and mutations.  
4. **`service`**: Contains the business logic, acting as a bridge between the repository layer and the API controllers. All APIs call methods defined in the service class.

## Environment Details  
The versions of the tools used are:
- **JDK**: 23  
- **Maven**: 3.9.9  
- **PostgreSQL**: 17  
- **Apache JMeter**: 5.6.3

## Spring Boot Dependencies  
The project includes the following dependencies:  
- **Spring for GraphQL**  
- **Spring Web**  
- **Spring Data JPA**  
- **PostgreSQL Driver**  
- **Apache CXF**

## Service Methods
All API implementations (REST, SOAP and GraphQL) call the following methods defined in the service class. This ensures consistency across all three APIs.

The methods defined in the service class are:

### `getAllAvocadoSales()`

- **Description**: Retrieves all avocado sale records.
- **Transactional**: Read-only.
- **Returns**: A list of all `AvocadoSale` objects.

---

### `getAvocadoSaleById(Long id)`

- **Description**: Retrieves an avocado sale record by its ID.
- **Transactional**: Read-only.
- **Parameters**: `id` (Long) - The ID of the avocado sale.
- **Returns**: An `Optional<AvocadoSale>` object.

---

### `getAvocadoSalesByType(String type)`

- **Description**: Retrieves avocado sales filtered by type.
- **Transactional**: Read-only.
- **Parameters**: `type` (String) - The type of avocado (e.g., "Organic", "Conventional").
- **Returns**: A list of `AvocadoSale` objects of the specified type.

---

### `getAvocadoSalesWithinPriceRange(double minPrice, double maxPrice)`

- **Description**: Retrieves avocado sales within a specified price range.
- **Transactional**: Read-only.
- **Parameters**: 
  - `minPrice` (double) - Minimum price.
  - `maxPrice` (double) - Maximum price.
- **Returns**: A list of `AvocadoSale` objects within the price range.

---

### `createAvocadoSale(AvocadoSale avocadoSale)`

- **Description**: Creates a new avocado sale record.
- **Transactional**: Write operation.
- **Parameters**: `avocadoSale` (AvocadoSale) - The avocado sale to be created.
- **Returns**: The created `AvocadoSale` object.

---

### `updateAvocadoSale(Long id, Map<String, Object> updates)`

- **Description**: Updates an existing avocado sale with new data.
- **Transactional**: Write operation.
- **Parameters**: 
  - `id` (Long) - The ID of the avocado sale.
  - `updates` (Map<String, Object>) - A map of field names and their updated values.
- **Returns**: The updated `AvocadoSale` object or `null` if the sale is not found.

---

### `calculateAveragePriceByRegion()`

- **Description**: Calculates the average price of avocados by region.
- **Transactional**: Read-only.
- **Returns**: A list of `RegionAveragePrice` objects, each containing a region and its average price.

---

### `deleteAvocadoSale(Long id)`

- **Description**: Deletes an avocado sale record by its ID.
- **Transactional**: Write operation.
- **Parameters**: `id` (Long) - The ID of the avocado sale to delete.
- **Returns**: None.

## Importing Data  
To populate the database with avocado sales data from the CSV file in the ```assets``` folder, use the following SQL command:  
```sql
\copy avocado_sales(ID, Date, AveragePrice, TotalVolume, PLU4046, PLU4225, PLU4770, TotalBags, SmallBags, LargeBags, XLargeBags, Type, Year, Region) 
FROM '<path-to-csv>' 
WITH (FORMAT csv, HEADER); 
```

## Running the Application  

Follow these steps to start the Avocado API application:  

1. Clone the project repository to your local machine:
    ```bash
    git clone https://github.com/tia-s/avocado-api
    ```

2.  Move to the cloned directory:
    ```bash
    cd avocado-api
    ```
3. Download the avocado.csv file from the ```assets``` folder

4. Create a PostgreSQL database and the avocado_sales table populated with data from avocado.csv:

    ```sql
    CREATE DATABASE <database_name>;

    USE DATABASE <database_name>;

    CREATE TABLE avocado_sales(ID INT, Date DATE, AveragePrice DECIMAL(5,2), TotalVolume DECIMAL(10,2), PLU4046 DECIMAL(10,2), PLU4225 DECIMAL(10,2), PLU4770 DECIMAL(10,2), TotalBags DECIMAL(10,2), SmallBags DECIMAL(10,2), LargeBags DECIMAL(10,2), XLargeBags DECIMAL(10,2), Type VARCHAR(20), Year INT, Region VARCHAR(50));

    \copy avocado_sales(ID, Date, AveragePrice, TotalVolume, PLU4046, PLU4225, PLU4770, TotalBags, SmallBags, LargeBags, XLargeBags, Type, Year, Region) FROM '<path_to_avocado.csv>' WITH (FORMAT csv, HEADER);
    ```

5. Modify application.yaml (in src/main/resources) to reflect the database configuration:
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/<your_database_name>
    spring.datasource.username=<your_username>
    spring.datasource.password=<your_password>
    ```

6. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Running the Functional API Tests

1. Download the Avocado API Postman Collection from the ```assets``` folder.

2. Import the collection into Postman.

## Running the Performance API Tests

1. Download Apache JMeter https://jmeter.apache.org/download_jmeter.cgi

2. Run Apache JMeter by navigating to its bin folder and running server.bat

3. Download the Avocado API Test Plan (avocado_api_jmeter_test_plan.jmx) from the ```assets``` folder 

4. Open the test plan in Apache JMeter

5. In each thread group, update the number of threads, ramp-up period and loop count/duration based on the test type being ran (eg. baseline test, soak test, etc.). *The default values (2 threads, 1s ramp-up period, and 1 loop count) can be used to perform a sample run in the Apache JMeter UI to ensure that the environment is configured correctly before executing the actual tests.*

6. To run a test, execute the following command in a terminal:
    ```bash
    jmeter -n -t <path_to_avocado_api_test_plan.jmx> -l <path_to_result_file> -e -o <path_to_report_folder>
    ```
