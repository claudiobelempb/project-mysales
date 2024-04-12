INSERT INTO tb_category(name) VALUES ('Livros');
INSERT INTO tb_category(name) VALUES ('Eletrônicos');
INSERT INTO tb_category(name) VALUES ('Computadores');

--tb_product
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('3a973c8f-d5a5-4a0a-950f-b4e79a35a895', 'Pizza Bacon', 49.9, 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Pizza Moda da Casa', 59.9,  'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('7a384618-b209-4978-b611-85e0026102e8', 'Pizza Portuguesa', 45.0,  'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('40b302b2-31ff-451f-85c2-c7a163bf41af', 'Risoto de Carne', 52.0,  'Risoto de carne com especiarias e um delicioso molho de acompanhamento.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('51db1297-5173-4f3d-a327-478c0101aee4', 'Risoto Funghi', 59.95,  'Risoto Funghi feito com ingredientes finos e o toque especial do chef.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('185eefbd-97b7-467f-8cc5-708551a70de3', 'Macarrão Espaguete',35.9, 'Macarrão fresco espaguete com molho especial e tempero da casa.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('9f6ccaed-9e01-43cc-8baf-9343fcd3ccb8', 'Macarrão Fusili', 38.0,  'Macarrão fusili com toque do chef e especiarias.', NOW());
INSERT INTO tb_product (sku, name, price, description, created_at) VALUES ('946e72ea-7f99-47e3-9e9f-02cc39d09b89', 'Macarrão Penne', 37.9, 'Macarrão penne fresco ao dente com tempero especial.', NOW());
