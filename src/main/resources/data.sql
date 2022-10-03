INSERT INTO restaurant (id, postal_code, complement, restaurant_name) VALUES
(1L, '0000001', 'Complemento Endereço Restaurante 1', 'Restaurante 1'),
(2L, '0000002', 'Complemento Endereço Restaurante 2', 'Restaurante 2');

INSERT INTO consumer (id, postal_code, complement, consumer_name) VALUES
(1L, '0000001', 'near somewhere ', 'Cliente 1'),
(2L, '0000002', 'near somewhere ', 'Cliente 2');

INSERT INTO product (id, available, product_name, unit_price, restaurant_id) VALUES
(1L, true, 'Hamburguer', 25.0, 1L),
(2L, true, 'Cheese', 6.0, 1L),
(3L, true, 'Cookie', 8.0, 2L);

INSERT INTO bag (id, forms_payment, closed_bag, total_price, consumer_id) VALUES
(1L, 0, false, 0.0, 1L);