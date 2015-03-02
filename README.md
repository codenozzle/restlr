# restlr
A RESTful API in Java using Jersey

### App and UI
- The link below will take you to a UI based on a Bootstrap 3 theme. The UI interactions and ajax operations are from jQuery. Please note that this application is a work in progress and some features might not be fully functional yet.
  - Public App: [http://codenozzle.com/restlr/products.jsp](http://codenozzle.com/restlr/products.jsp)
  - Local App: [http://localhost:8080/restlr/products.jsp](http://localhost:8080/restlr/products.jsp)

### WADL (Web Application Description Language)
- Simplified WADL: [http://codenozzle.com/restlr/api/application.wadl](http://codenozzle.com/restlr/api/application.wadl)
- Detailed WADL: [http://codenozzle.com/restlr/api/application.wadl?detail](http://codenozzle.com/restlr/api/application.wadl?detail)

### Using cUrl to perform CRUDS operations against the API
|| Gets all resources
| ----------- | ----------- |
| GET | curl -H "Accept: application/json" http://localhost:8080/restlr/api/product/ |

|| Gets the count of all resources
| ----------- | ----------- |
| GET | curl http://localhost:8080/restlr/api/product/count |

|| Gets a single resource
----------- | ----------- | -----------
| GET | curl -H "Accept: application/json" http://localhost:8080/restlr/api/product/1 |

|| Searches all resources
----------- | ----------- | -----------
| GET | curl -H "Accept: application/json" http://localhost:8080/restlr/api/product/search?productSku=MB-284 |

|| Creates a single resource
----------- | ----------- | -----------
| POST | curl -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{ "active": true, "description": "Solid State Hard Drive", "price": 1000, "productName": "SSHD", "productSku": "SSHD-1234" }' http://localhost:8080/restlr/api/product/ |

|| Modifies a single resource
----------- | ----------- | -----------
| PUT | curl -H "Accept: application/json" -H "Content-Type: application/json" -X PUT -d '{ "price": 2000 }' http://localhost:8080/restlr/api/product/1 |

|| Deletes a single resource
----------- | ----------- | -----------
| DELETE | curl -H "Accept: application/json" -X DELETE http://localhost:8080/restlr/api/product/1 |

### Packages
- src/main/java/com/codenozzle/app/
  - Initializes RESTful service and loads test data 
- src/main/java/com/codenozzle/db/
  - Map-based object store to simulate a database
- src/main/java/com/codenozzle/messagewriter/
  - Defines media writers for custom marshalling
- src/main/java/com/codenozzle/model/
  - JAXB annotated POJOs used to marshall data into media formats
- src/main/java/com/codenozzle/api/
  - Defines paths, access, and media types for REST operations
