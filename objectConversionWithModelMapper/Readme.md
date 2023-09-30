# ModelMapper Example

# 1- Matching Strategies:

## 1-1- Standard
The Standard matching strategy allows for source properties to be intelligently matched to destination properties, requiring that all destination properties be matched and all source property names have at least one token matched. The following rules apply:
* Tokens can be matched in any order
* All destination property name tokens must be matched
* All source property names must have at least one token matched
The standard matching strategy is configured by **default**, and while it is not exact, it is ideal to use in most scenarios.

## 1-2- Loose
The Loose matching strategy allows for source properties to be loosely matched to destination properties by requiring that only the last destination property in a hierarchy be matched. The following rules apply:
* Tokens can be matched in any order
* The last destination property name must have all tokens matched
* The last source property name must have at least one token matched
The loose matching strategy is ideal to use for source and destination object models with property hierarchies that are very dissimilar. It may result in a higher level of ambiguous matches being detected, but for well-known object models it can be a quick alternative to defining mappings.

## 1-3- Strict
The strict matching strategy allows for source properties to be strictly matched to destination properties. This strategy allows for complete matching accuracy, ensuring that no mismatches or ambiguity occurs. But it requires that property name tokens on the source and destination side match each other precisely. The following rules apply:
* Tokens are matched in strict order
* All destination property name tokens must be matched
* All source property names must have all tokens matched
The strict matching strategy is ideal to use when you want to ensure that no ambiguity or unexpected mapping occurs without having to inspect a TypeMap. The drawback is that the strictness may result in some destination properties remaining unmatched.


# Project summary:
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

## Dependencies
This project requires the following dependencies:
* Spring Boot
* ModelMapper
* Jakarta Persistence
Please refer to the source code for more details and implementation specifics.



