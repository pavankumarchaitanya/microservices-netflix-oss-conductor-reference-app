This repository holds reference implementation of microservices that use Netflix OSS conductor to choreograph tasks.


Please refer: 

1. https://stackoverflow.com/questions/29117570/orchestrating-microservices#
2. https://netflix.github.io/conductor/

Setting Up: 
1. conductor-bootstrap-service : The bootstrap-service sets up the tasks and workflows in the conductor instance. It hosts restful endpoints that process requests to operate on the conductor api.
