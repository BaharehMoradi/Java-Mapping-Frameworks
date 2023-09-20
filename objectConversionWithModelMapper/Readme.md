# ModelMapper Example

This project demonstrates the usage of ModelMapper in a Java Spring REST application for mapping Product entities. It provides endpoints for adding, retrieving, listing, and deleting products.

## Endpoints

### Add a Product
- URL: POST /api/addProduct
- Request Body: JSON
  ```json
  {
    "productName": "Example Product",
    "productPrice": 9.99,
    "productQuantity": 10,
    "productBrand": "Brand XYZ",
    "productWeight": 0.5,
    "productColor": "Red"
  }
- Response: Returns the persisted product with generated productID.

### Get a Product
- URL: GET /api/getProduct
- Request Parameter: Integer (productID)
- Response: Returns the product with the specified productID.

### Get All Products
- URL: GET /api/getAllProduct
- Response: Returns a list of all products.

### Delete a Product
- URL: DELETE /api/deleteProduct
- Request Parameter: Integer (productID)
- Response: No content if product is deleted successfully.

# Dependencies
## This project requires the following dependencies:
* Spring Boot
* ModelMapper
* Jakarta Persistence
Please refer to the source code for more details and implementation specifics.

Note: This is a basic example and you can further enhance the README.md file with more details, instructions, and other relevant information based on your project requirements.

