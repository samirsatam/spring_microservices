# restful-webservices
Playground for Udemy course and Microservices books
Other Notes
@JsonIgnore add this tag for enabling static filtering. The Json output will not have the specific field.
@JsonIgnoreProperties Same as above.

Explained in Step 25 in the udemy course.
For Dynamic Filtering, use the MappingJacksonValue class that allows for adding a filter.
Return the MappingJacksonValue from the rest method, make sure to add a @JsonFilter on the bean as well.

