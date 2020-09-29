# flight-search-service

1. The project allows end users to search for flights with several filters and sorting options.
2. It uses H2 database to cache data to improve performance and reduce network calls over subsequent requests.
3. It calls 3 third party api's namely goibibo, yatra, and makemytrip and caches their response in the H2 DB.
4. The above 3 apis have been developed as microservices with mock data.
5. It also uses a eureka discovery server which monitors the 3 third party apis and also enables to perform load balancing on the instances.


Usage: the application can be accessed via postman by using requests as shown in below example:-

GET /bookmyflight/search/flights?source=kolkata&amp;destination=bangalore&amp;departureDate=2019-02-12T11:29:10.761Z&amp;sort=duration HTTP/1.1
Host: localhost:8080

Response:

{
    "flights": [
        {
            "number": "103_AI",
            "airline": "Air India",
            "arrivalAirport": "Bangalore",
            "arrivalTime": "2020-09-29T18:30:00.000+00:00",
            "departureAirport": "Kolkata",
            "departureTime": "2020-09-29T18:30:00.000+00:00",
            "price": 6000,
            "noOfStops": 1,
            "route": "Bangalore->Kolkata",
            "duration": 4
        }
    ],
    "noOfFlights": 1
}
