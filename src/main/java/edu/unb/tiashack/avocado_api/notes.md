### Environment Details:
- JDK 23
- Maven 3.9.9
- PostgreSQL 17

### SpringBoot Dependencies:
- Spring for GraphQL
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Web Services (using this over Apache CXF since this is directly integrated within SpringBoot)

### Copy data from CSV FIle:
```sql
\copy avocado_sales(ID, Date, AveragePrice, TotalVolume, PLU4046, PLU4225, PLU4770, TotalBags, SmallBags, LargeBags, XLargeBags, Type, Year, Region) FROM '<path-to-csv>' WITH (FORMAT csv, HEADER);
```

### Packages:
1. model: for ORM
2. repository: interacts with model
3. api: implementation of controllers/services for each api 
    - soap
    - rest
    - graphql