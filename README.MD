# Exploratory project in order to practice REST API with Java Jersey

# Implemented Routes

## GET
	
- All aliens
	
	Headers:
	 - Content-Type application/json | application/xml
	 - Accept		application/json | application/xml
	
	```bash
	http://localhost:8080/demorest/webresources/aliens
	```
	
	**Example of 200 Response**
	```json
	{
	  "alien": [
	    {
	      "id": "101",
	      "name": "Vitoro",
	      "points": "56"
	    },
	    {
	      "id": "102",
	      "name": "Atropolus",
	      "points": "89"
	    },
	    {
	      "id": "103",
	      "name": "Lotureos",
	      "points": "9"
	    },
	    {
	      "id": "104",
	      "name": "Rifero",
	      "points": "88"
	    }
	  ]
	}
	```
	
- Alien by ID
	
	Headers:
	 - Content-Type application/json | application/xml
	 - Accept		application/json | application/xml
	
	
	```bash
	http://localhost:8080/demorest/webresources/aliens/alien/103
	```
	**Example of 200 Response**
	```json
	{
	  "id": "103",
	  "name": "Lotureos",
	  "points": "9"
	}
	```
	
## POST

Headers:
 - Content-Type application/json | application/xml
 - Accept		application/json | application/xml
	 
**Example of Request Body - JSON**
```json
{
  "id": "105",
  "name": "Trower",
  "points": "100"
}
```
	
**Example of Request Body - XML**
```xml
<alien>
  <id>105</id>
  <name>Trower</name>
  <points>100</points>
</alien>
```