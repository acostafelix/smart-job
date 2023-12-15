DROP TABLE phones;
DROP TABLE users;
CREATE TABLE IF NOT EXISTS users(id VARCHAR PRIMARY KEY,
   name VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   created DATE,
   modified DATE,
   last_login DATE,
   isactive BOOLEAN,
   token VARCHAR );
   

CREATE TABLE IF NOT EXISTS phones(id VARCHAR PRIMARY KEY,
   user_id VARCHAR(255),
   number VARCHAR(255),
   city_code VARCHAR(255),
   country_code VARCHAR(255),
   foreign key (user_id) references users(id));