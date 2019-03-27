insert into movie(id,name_russian,name_native,release_year,rating,price,country,description)
values(1,'Список Шиндлера','Schindlers List','1993',8.7,150.50,'США','Фильм рассказывает реальную историю загадочного Оскара Шиндлера, члена нацистской партии, преуспевающего фабриканта, спасшего во время Второй мировой войны почти 1200 евреев.');

insert into poster(movie_id,picture_path) values(1,'https://images-na.ssl-images-amazon.com/1.jpg');

commit;
