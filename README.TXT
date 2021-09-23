Jungle Application

Flow to execute
1. It will parse the JSON data into Arrays and process.
2. Application will ask to introduce by console to find animal by name (you can type the name or just characters that can contain the name
    For example: You can find by Rabbit or r and will show all animals that contains an "r"
3. Application will ask you to introduce by console to find animal by type of food. As the example above, works in the same way (name or character that contains the type of food )
And the program ends ( I didn't do an Exit because it's not nice for an user )

-I spent 4h in total, because I needed to remember how I managed JSON some years ago, fighting with the syntax and so on hehe
-I didn't do how to add more type of foods because I didn't have time to implement all the DB model in fisically (automatic sql inserts that puts the info once the app is up and running). So I just parsed the data. That can be done in Hibernate with specific insert queries
-A lot of things can be improved, no Annotations were used as well as mapping DTO as well and JSON parse could be improved but I worked with JSON 3 years ago so I spent some time remembering how to parse the info ( also, a hardcoded JSON is ugly hehe )
