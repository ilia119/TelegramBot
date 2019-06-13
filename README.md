# TelegramBot

Bot name: IgoroshkoBot  
Token: 845906650:AAFDjFc-FOuDqhCZH_7q_cb9Y6Nnx9m1qGY  


Application uses MySql database.  
DB name: telegrambot  
Table schema:  

    CREATE TABLE City (
      id bigint not null auto_increment,   
      name varchar(100) not null,   
      info varchar(200) not null,    
      primary key(id)  
    ) DEFAULT CHARSET=utf8;  


REST API:  

***Add a city:***  
  **POST** /city  
  {  
    "name": "Париж",  
    "info": "Нотр-дам сгорел. Нечего там делать"  
  }  
  
***Update a city:***  
  **POST** /city  
  {  
    "id": "1",  
    "name": "Париж",  
    "info": "Сходите в диснейленд"  
  }  
  
***Delete a city:***  
  **DELETE** /city  
  {  
    "id": "1"  
  }  
  
  
