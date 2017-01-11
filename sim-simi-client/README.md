# Sim-Simi REST Client Demo

## Required
* Spring Boot 1.4.3
* [OKHttp3](https://square.github.io/okhttp/3.x/okhttp/)
* [Retrofit](http://square.github.io/retrofit/)

## Sample
```
    @Inject
    private SimSimiService simSimiService;

    public String chatSimSimi(String msg) throws IOException {
        Response<SimSimiResponse> simSimiResponse = simSimiService.chat("Hi~").execute();
        return simSimiResponse.body().getResponse();
    }
```
