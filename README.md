Run dependency graph
```commandline
    mvn depgraph:aggregate  
    dot -Tpng target/dependency-graph.dot -o dependency-graph.png
```

### Assignment Week 3 (29-31 Oct 2024)
- [x] Register GCP
- [x] Install docker 
- [x] Install postgres
- [x] Implement the domain. Implement all of those things. Just domain core and domain application service
    - [x] Implement the design in there
    - [x] Implement all of them in there every component in the design
    - [x] Core domain entity
      - [x] Create all core domain entity logic. Builder
      - [ ] Create Exception
      - [x] Create core domain event 
    - [x] Domain Service with Implementation
      - [x] Create Warehouse Domain Service Impl
      - [x] Create Inventory Domain Service Impl
      - [x] Create Interface in Warehouse Domain
      - [x] Crete Interface in Inventory Domain
- [ ] Integrate with SpringBoot, Lombok, and Avro
  - [x] Install Spring
  - [x] Install Lombok
  - [ ] Install Avro
  - [x] Learning Basic Spring
  - [x] Implement Basic Spring in this project
  - [x] Learning Lombok
  - [x] Implement Basic Lombok in this project
- [x] Check Domain Core logic again. Fit in requirement or not
- [ ] Minimum level -> show already define in warehouse-domain completed 
  - [ ] warehouse-domain-core
    - [x] Fixing Stock Logic Entity
    - [x] Fixing Stock Event
    - [x] Fixing Stock Implementation
  - [ ] warehouse-application-service
    - [x] **Warehouse**
      - [x] Create DTO Command & Response
      - [x] Create Mapper 
      - [x] Create Helper
      - [x] Create Implementation
      - [x] Create Port      
    - [x] **Stock**
        - [x] Create DTO Command & Response
        - [x] Create Mapper
        - [x] Create Helper
        - [x] Create Implementation
        - [x] Create Port
  - [x] Just 1-2 unit test
  - [x] unit testing 5-10%. Next week. 
  - [x] create simple CI/CD pipeline 
  - [ ] Integrate with sonar cube 
- [x] Install Database. Integrate with DB. -> warehouse-container
- [x] Watching video recording where to implement repositories and API
- [x] Running Spring Web
- [x] Maximum Level -> Can Hit API with Spring 

## Assignment for 10 Nov Before SAGA material 
- [x] Recreate or Organize the module structure. Become multi module 
- [x] Can run spring boot REST API
- [x] Connect to database 
  - [x] Save data to database
- [x] Design communication between listener to make streamline data 
- [ ] Reference 
  - [ ] 7 Nov Lecturer Video 
- [ ] Running Kafka for Event Driven Arch
  - [ ] Must can run the kafka
  - [ ] Avro Model 
  - [ ] Publish Message to Kafka
  - [ ] Buat minimal satu service lagi. Using `report-service`
  - [ ] Listen Message To Kafka
- [ ] Materialized View Postgres
- [ ] Create GKE using Terraform 
