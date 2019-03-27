DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS poster;

CREATE TABLE
  movie (
  id           NUMERIC,
  name_russian VARCHAR(1000),
  name_native  VARCHAR(1000),
  release_year VARCHAR(1000),
  rating       NUMERIC,
  price        NUMERIC,
  country      VARCHAR(1000),
  description  VARCHAR(1000)
);

CREATE TABLE
  poster (
  movie_id     NUMERIC,
  picture_path VARCHAR(1000)
);