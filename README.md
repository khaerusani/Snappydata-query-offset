# Snappydata Offset query Example
This code for implement offset query with Snappydata. I hope this can help. "offset" and "fetch next" query supported by rowstore, not spark engine 

## Tutorial
- Install Snappy Data. [INSTALL](https://snappydatainc.github.io/snappydata/install/)
- Make Table 'star' in 'edu' (EDU.STAR) ROW type table. like this :

| id | visible_magnitude | bayer_naming | name     | distance | link                  |
|----|-------------------|--------------|----------|----------|-----------------------|
| 1  | -1.47             | α CMa        | Sirius   | 8        | http://tiny.cc/bcv13y |
| 2  | −0.72             | α Car        | Canopus  | 310      | http://tiny.cc/4dv13y |
| 3  | −0.04 var         | α Boo        | Arcturus | 37       | http://tiny.cc/pev13y |

## Run Program
- mvn spring-boot:run

## Open Swagger
- http://localhost:1995/swagger-ui.html


## About 
* @author  Khaerusani
* @version 1.0
* @since   2019-03-13
* @description Nothing description

