# Java-Project
# Getting Started

*Install java 11 jdk


# Run

*Go to main file and run it - NewsApplication.class

# Dependencies

*mysql-connector-java

*spring-boot-starter-web

*spring-boot-starter-data-jpa 

# DDL Script for mysql

* create database
CREATE DATABASE news_db;

* create two tables (news and category tables)

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `description` longtext,
  `title` varchar(255) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
    PRIMARY KEY (id)
);

# Insert sample data for category table

INSERT INTO `category` (`category_name`) VALUES
('Sport'),
('Tech'),
('Film'),
('Political'),
('Education'),
('Music'),
('Science');

# Rest end point with example

# Main endpoint - http://localhost:8080/api

1. Create news - POST request - http://localhost:8080/api/news

example - http://localhost:8080/api/news

body (application/json)- 
{
	"title": "Giant pristine coral reef discovered off Tahiti",
	"date": "2022-01-23",
	"description": "Marine explorers have discovered a 'pristine' 3km (2-mile) coral reef at depths of 30m (100ft) off the coast of Tahiti, French Polynesia.It is one of the largest discovered at that depth, says the United Nations Educational, Scientific and Cultural Organization, which led the mission.Dr Julian Barbiere, from Unesco, said there were probably many more of these ecosystems we just don't know about.We should be working to map them and to protect them,' he said.",
	"category": {
		"id": 7,
		"categoryName" : "Science"
	}
}

2. Update news - PUT request - http://localhost:8080/api/news/{newsId}

example - http://localhost:8080/api/news/1

body (application/json) -
{
	"title": "Giant pristine",
	"date": "2022-01-23",
	"description": "Marine explorers have discovered a 'pristine' 3km (2-mile) coral reef at depths of 30m (100ft) off the coast of Tahiti, French Polynesia.It is one of the largest discovered at that depth, says the United Nations Educational, Scientific and Cultural Organization, which led the mission.Dr Julian Barbiere, from Unesco, said there were probably many more of these ecosystems we just don't know about.We should be working to map them and to protect them,' he said.",
	"category": {
		"id": 7,
		"categoryName" : "Science"
	}
}

3. list with filter - GET request - http://localhost:8080/api/news?{parameters}

example - http://localhost:8080/api/news?categoryId=7&title=Giant pristine&date=2022-01-23

4. show one news - GET request - http://localhost:8080/api/news/{newsId}

example - http://localhost:8080/api/news/2

5. delete news - DELETE request - http://localhost:8080/api/news/{newsId}

example - http://localhost:8080/api/news/2

