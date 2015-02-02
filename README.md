# restlr
A RESTful API in Java using Jersey

### CRUDS via cUrl Examples
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
