DELETE FROM year;
INSERT INTO year (id_year, value_year, is_active_year)
VALUES
(7, "2022", false),
(6, "2021", false),
(5, "2020", false),
(4, "2019", true),
(3, "2018", false),
(2, "2017", false),
(1, "2016", false);

DELETE FROM type_epargne;
INSERT INTO type_epargne (id_type, value_type)
VALUES
(1, "Livret A"),
(2, "PEL 1"),
(3, "PEL 2"),
(4, "Assurance Vie");