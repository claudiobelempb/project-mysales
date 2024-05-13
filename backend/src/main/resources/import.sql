--tb_category
INSERT INTO tb_category(name) VALUES ('Consumiveis');
INSERT INTO tb_category(name) VALUES ('Material de Escritório');
INSERT INTO tb_category(name) VALUES ('Lubrificante');
INSERT INTO tb_category(name) VALUES ('Vestuário');
INSERT INTO tb_category(name) VALUES ('Electrónico');
INSERT INTO tb_category(name) VALUES ('Computadores');

--tb_supplier
INSERT INTO tb_supplier(name) VALUES ('Distribuição Informática');
INSERT INTO tb_supplier(name) VALUES ('Companhia de Hardware');
INSERT INTO tb_supplier(name) VALUES ('Personal Computer Corp.');
INSERT INTO tb_supplier(name) VALUES ('Papalaco & Papeis');
INSERT INTO tb_supplier(name) VALUES ('KW Vestuários');
INSERT INTO tb_supplier(name) VALUES ('Comércio de Bens Usados');
INSERT INTO tb_supplier(name) VALUES ('Sup. Alimentos');
INSERT INTO tb_supplier(name) VALUES ('Silva Materiais - Carros');
INSERT INTO tb_supplier(name) VALUES ('Alimentos SUD');

--tb_product
INSERT INTO tb_product(sku, name, price, stock, description, created_at, category_id, supplier_id) VALUES ('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Pizza Moda da Casa', 59.9, 2,  'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.', '2020-09-10', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Refrigerante 2l', 130, 15, '2020-09-10', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Sumo Santal 500ml', 30, 1, '2021-04-29', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Chips Simba', 35, 10, '2021-03-02', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'NikNaks', 50, 2, '2021-05-03', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Sumo Compal 500ml', 45, 45, '2020-06-07', '', 1, 9);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Cakes Dolc', 70, 2, '2019-02-23', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Chocalate ViRs', 200, 0, '2018-10-15', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Sorvete 2l', 600, 0, '2021-01-02', '', 1, 7);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Chocalate YTE', 345, 0, '2021-02-13', '', 1, 9);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Bolacha Jonhson', 100, 6, '2020-12-22', '', 1, 9);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Aluminum ruler 30cm', 185, 7, '2020-11-27', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Sublinhador COLORIDO(CB-B046)', 156, 8, '2021-03-14', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Tesoura  (CB-B045)', 110, 98, '2021-04-02', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Marcadores nao Permanentes coloridos(CB-B047)', 75, 4, '2021-06-03', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Separador de Documentos(alfabetico) A4(CB-B003)', 450, 0, '2020-07-07', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Saca Agrafo  CY 2221(CB-B042)', 150, 3, '2019-03-23', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Roll up 2m com logo do clube', 700, 12, '2018-11-15', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Resma 210x297-80g A4(CB-B037)', 390, 9, '2021-12-02', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Resma -difinir gramagem A3(CB-B036)', 490, 5, '2021-05-30', '', 2, 4);
INSERT INTO tb_product(sku, name, price, stock, created_at, description, category_id, supplier_id) VALUES('66c6f671-c2e1-4d60-a16c-ebc3be0d6870', 'Óleo monograduado', 980, 15, '2021-04-03', '', 3, 8);
