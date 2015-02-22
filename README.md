# restlr
A RESTful API in Java using Jersey

### Packages
- src/main/java/com/codenozzle/app/
  - Initializes RESTful service and loads test data 
- src/main/java/com/codenozzle/db/
  - Map-based object store to simulate a database
- src/main/java/com/codenozzle/model/
  - JAXB annotated POJOs used to marshall data into media formats
- src/main/java/com/codenozzle/api/
  - Defines paths, access, and media types for REST operations

### App and UI
- The link below will take you to a UI based on a Bootstrap 3 theme. The UI interactions and ajax operations are from jQuery. Please note that this application is a work in progress and some features might not be fully functional yet.
  - App Link: [http://localhost:8080/restlr/products.jsp](http://localhost:8080/restlr/products.jsp)

### Using cUrl to perform CRUDS operations against the API
|| Gets all resources
| ----------- | ----------- |
| GET | curl -H "Accept: application/json" http://localhost:8080/restlr/api/product/ |

|| Gets a single resource
----------- | ----------- | -----------
| GET | curl -H "Accept: application/json" http://localhost:8080/restlr/api/product/1 |

|| Searches all resources
----------- | ----------- | -----------
| GET | curl -H "Accept: application/json" http://localhost:8080/restlr/api/product/search?productSku=HD-7906 |

|| Creates a single resource
----------- | ----------- | -----------
| POST | curl -H "Accept: application/json" -X POST -d "productSku=PR-2349&productName=Product&description=Description&price=19.99&active=true" http://localhost:8080/restlr/api/product/ |

|| Modifies a single resource
----------- | ----------- | -----------
| PUT | curl -H "Accept: application/json" -X PUT -d "price=2000.00" http://localhost:8080/restlr/api/product/1 |

|| Deletes a single resource
----------- | ----------- | -----------
| DELETE | curl -H "Accept: application/json" -X DELETE http://localhost:8080/restlr/api/product/1 |
