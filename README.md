# overwatch-api
Overwach API exercise with Spring Boot

Typical Spring Boot application, start it running the OverwatchApiApplication.
It listens at the default port 8080.

At the first start it retrieves the data from the original overwatch api, and stores it in a h2 database in the ~ folder.
(This is only done at the first start if the database doesn't exist yet)

```
/api/heros - hero list
/api/heros/{hero_id} - hero data
/api/heros/{hero_id}/abilities - hero ability list
/api/abilities/ - ability list
/api/abilities/{ability_id} - ability data
```
