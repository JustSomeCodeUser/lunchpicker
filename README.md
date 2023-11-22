# Lunchpicker API

Lunchpicker is a Spring Boot application designed to help teams decide on a lunch location collectively. It provides a simple API to submit, retrieve, and randomly select restaurant choices.

## API Documentation

Access the full API documentation and test the endpoints using the Postman collection: [Lunchpicker Postman Collection](https://api.postman.com/collections/6728125-bcafe4b1-adb4-49f3-985a-2eb91aa71429?access_key=PMAT-01HFVDE135YPPFK90FBHK88570)

### Endpoints

1. **Submit a Restaurant Choice**
   - **Method**: POST
   - **URL**: `/api/choices`
   - **Body**:
     - `name` (String, mandatory): Name of the restaurant.
     - `googleMapsUrl` (String, optional): URL to the restaurant's location on Google Maps.
     - `creatorName` (String, optional): The name of the person who suggested the restaurant.
     - `caption` (String, optional): An additional comment or caption about the restaurant.

2. **Retrieve All Choices**
   - **Method**: GET
   - **URL**: `/api/choices`

3. **Retrieve a Random Choice**
   - **Method**: GET
   - **URL**: `/api/choices/random`

4. **Update a Restaurant Choice**
   - **Method**: PUT
   - **URL**: `/api/choices/{id}`
   - **Path Variables**: `id` (Long, mandatory): The unique identifier of the restaurant choice.
   - **Body** (same as POST)

5. **Delete a Restaurant Choice**
   - **Method**: DELETE
   - **URL**: `/api/choices/{id}`
   - **Path Variables**: `id` (Long, mandatory)

### Fields Description

- `name`: The name of the restaurant. This field is mandatory and cannot be blank.
- `googleMapsUrl`: URL to the restaurant's location on Google Maps. This field is optional.
- `creatorName`: The name of the person who suggested the restaurant. This field is optional.
- `caption`: Additional comment or caption about the restaurant. This field is optional.

## Building and Running with Docker

### Prerequisites

- Docker and Java 17 installed on your machine (Linux or Windows)

### Steps

1. Clone the repository to your local machine.

2. Navigate to the root directory of the project.

3. Run the following command to build the Docker image:

   ```bash
   docker build -t lunchpicker .

4. Once the build completes, run the Docker container:
  
  ```bash
  docker run -p 8888:8888 lunchpicker
  ```
5. Alternatively, skip 3 & 4 and just run the built-and-run.sh or built-and-run.bat if you are using a Windows machine.
6. Access the application at http://localhost:8888.

Note: The application is configured to run on port 8888. Ensure this port is free on your host machine or modify the port mapping in the docker run command as needed.
