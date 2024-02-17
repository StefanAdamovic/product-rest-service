Product REST Service
The service is accessible at http://localhost:8888/api.predic8.de. The RESTful endpoints under this base URL are as follows:


Create a Product
POST /api.predic8.de/shop/v2/products
Summary: Create product
Status: 201 Created

Get All Products
GET /api.predic8.de/shop/v2/products
Summary: Get all products
Status: 200 OK

Get Product by ID
GET /api.predic8.de/shop/v2/products/{id}
Summary: Get product by ID
Status: 200 OK

Update Product by ID
PUT /api.predic8.de/shop/v2/products/{id}
Summary: Update product by ID

Status: 200 OK
Delete Product by ID

DELETE /api.predic8.de/shop/v2/products/{id}
Summary: Delete product by ID

Status: 200 OK
Swagger Integration
Swagger UI is available at http://localhost:8888/api.predic8.de/swagger-ui.html, providing interactive API documentation.
