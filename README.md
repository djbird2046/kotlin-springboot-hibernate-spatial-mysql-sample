## A Sample with Kotlin, Gradle, SpringBoot, Hibernate Spatial and MySQL5.7 

### Usage
- Run MySQL, create a table as ```schema.sql``` and config datasource ```application.yml```
- Run this application
- Create Location: ```POST``` access http://localhost:8080/location, with body
    ```json
    {
        "longitude": 113.23,
        "latitude": 23.16
    }
    ```
- Fetch Location: ```GET``` access http://localhost:8080/location

#### Result
- ##### Create Location Result
Web result: 
```json
{
    "id": 1,
    "location": {
        "longitude": 113.23,
        "latitude": 23.16
    },
    "createAt": "2020-07-09T11:52:11.436"
}
```

Server log:
```log
Hibernate: insert into tb_location (create_at, location) values (?, ?)
2020-07-09 11:52:11.492 TRACE 82726 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [TIMESTAMP] - [2020-07-09T11:52:11.436]
2020-07-09 11:52:11.496 TRACE 82726 --- [nio-8080-exec-1] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [ARRAY] - [POINT (113.23 23.16)]
```
- ##### Fetch Location Result
Web result: 
```json
[
    {
        "id": 1,
        "location": {
            "longitude": 113.23,
            "latitude": 23.16
        },
        "createAt": "2020-07-09T11:52:11"
    }
]
```

Server log:
```log
Hibernate: select locationda0_.id as id1_0_, locationda0_.create_at as create_a2_0_, locationda0_.location as location3_0_ from tb_location locationda0_
2020-07-09 11:53:21.476 TRACE 82726 --- [nio-8080-exec-3] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_0_] : [BIGINT]) - [1]
2020-07-09 11:53:21.478 TRACE 82726 --- [nio-8080-exec-3] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([create_a2_0_] : [TIMESTAMP]) - [2020-07-09T11:52:11]
2020-07-09 11:53:21.480 TRACE 82726 --- [nio-8080-exec-3] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([location3_0_] : [ARRAY]) - [POINT (113.23 23.16)]
```