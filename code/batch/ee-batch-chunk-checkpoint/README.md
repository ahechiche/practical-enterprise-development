Basic Chunk job example with checkpoint class
=====================================
Example taken from [Practical Enterprise Application Development](http://www.itbuzzpress.com/ebooks/java-ee-7-development-on-wildfly.html)

This example demonstrates the basic usage of Batch API with a Chunk job example with checkpoint class

###### Install the CSV file in the location specified by your job.xml (in this example /tmp) 
```shell
cp input.csv /tmp
```

###### Build and Deploy
```shell
mvn clean install wildfly:deploy  
```

###### Test
```shell
http://localhost:8080/ee-batch-chunk-checkpoint/
```
 
