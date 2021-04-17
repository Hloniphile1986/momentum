Momentum App
===============
1. The App is on spring boot 2
2. Url to swagger ui is http://localhost:8080/swagger-ui.html#/product-resource
3. On start up the App will populate one customer on customer table.
4. To populate the product list you hit populate (/product/populate) resource service on the swagger ui, the service take integer as in input to specify how many products to be created,
after populating the data you can use the viewAll (/product/viewAl) resource to see the populated products.

4. The default customer get created on start up and it has the number of points by default. 
5. The /product/productCodes resource take the list off product codes and it will check if the customer has the enough to add/buy the product and takes the points per product from customer's point, therefore the customer points can be used up.
6. The health endpoints also active like (http://localhost:8080/actuator/health) which will tell status of the app weather is UP or Down.
