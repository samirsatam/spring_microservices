Change the microservice endpoint from m
http://localhost:8000/currency-exchange/from/USD/to/INR/
to 
-- Use Zuul API Gateway port 8765
-- Add the microservice applicationname to the URL.
-- Now the microservice is getting through the Zuul API Gateway.
http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR/
