INSERT INTO excursion_photos (excursion_id, photo_url) VALUES
(1, 'src/main/resources/photo/экскурсия1.jpeg'),
(2, 'src/main/resources/photo/эускурсия2.jpg'),
(3, 'src/main/resources/photo/экскурсия3.jpg'),
(4, 'src/main/resources/photo/экскурсия4.jpg'),
(5, 'src/main/resources/photo/экскурсия5.jpg');

INSERT INTO hotel_photos (hotel_id, photo_url) VALUES
(1, 'src/main/resources/photo/отель1.jpg'),
(2, 'src/main/resources/photo/отель2.jpg'),
(3, 'src/main/resources/photo/отель3.jpg'),
(4, 'src/main/resources/photo/отель4.jpg');

INSERT INTO excursion (name, city, address, date_end, date_start, user_ratings_count, average_rating, price, description, photo) VALUES
('Экскурсия в Музей истории искусств', 'Москва', 'ул. Примерная, д. 123', '2023-06-15 10:00:00', '2023-06-15 9:00:00', 25, 4.5, 1500.00, 'Знакомство с историей искусственного творчества в России.', 'src/main/resources/photo/экскурсия1.jpeg'),
('Пешеходная экскурсия по историческому центру города', 'Санкт-Петербург', 'пл. Примерная, 1', '2023-07-10 15:30:00', '2023-07-10 13:30:00', 15, 4.2, 1200.00, 'Ознакомление с историческими достопримечательностями города.', 'src/main/resources/photo/экскурсия2.jpg'),
('Велосипедная экскурсия по окрестностям', 'Краснодар', 'ул. Основная, 45', '2023-09-05 09:00:00', '2023-09-05 07:00:00', 10, 4.0, 800.00, 'Путешествие на велосипедах с остановками у красивых видовых точек.', 'src/main/resources/photo/экскурсия3.jpg'),
('Гастрономический тур по ресторанам города', 'Сочи', 'наб. Примерный, 12', '2023-08-20 18:00:00', '2023-08-20 15:00:00', 20, 4.6, 1800.00, 'Попробуйте лучшие блюда от местных шеф-поваров.', 'src/main/resources/photo/экскурсия4.jpg');

INSERT INTO hotel (name, city, address, wifi, parking, restaurant, user_ratings_count, average_rating, room_price, description, photo) VALUES
('Отель Звездный', 'Москва', 'ул. Пушкина, д. 10', TRUE, TRUE, TRUE, 120, 4.8, 250.00, 'Современный отель с удобствами и отличным сервисом', 'src/main/resources/photo/отель1.jpg'),
('Пляжный отдых', 'Сочи', 'пр. Ленина, д. 5', TRUE, TRUE, TRUE, 90, 4.5, 180.00, 'Уютный отель на берегу моря', 'src/main/resources/photo/отель2.jpg'),
('Горные апартаменты', 'Красная Поляна', 'ул. Горная, д. 15', TRUE, TRUE, FALSE, 80, 4.2, 220.00, 'Просторные апартаменты в горах для спокойного отдыха', 'src/main/resources/photo/отель3.jpg'),
('Отель Река', 'Санкт-Петербург', 'наб. реки Фонтанки, 5', TRUE, FALSE, TRUE, 110, 4.6, 190.00, 'Отель с прекрасным видом на реку и близостью к достопримечательностям','src/main/resources/photo/отель4.jpg' ),
('Шале в лесу', 'Екатеринбург', 'лесное шоссе, 10 км', TRUE, TRUE, FALSE, 70, 4.0, 150.00, 'Уединенные шале среди живописного леса', 'src/main/resources/photo/отель5.jpg');

INSERT INTO users (username, email, registration_date, score) VALUES
('Anna', 'anna@example.com', '2022-03-31', 1000),
('Peter', 'peter@example.com', '2022-03-25', 950),
('Maria', 'maria@example.com', '2022-03-28', 1100),
('John', 'john@example.com', '2022-03-30', 850),
('Elena', 'elena@example.com', '2022-03-27', 1200);

