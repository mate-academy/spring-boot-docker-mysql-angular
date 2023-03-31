-- liquibase formatted sql
-- changeset <konstantin.nikiforov>:<inject-initial-products>

INSERT INTO product (name, price, category_id)
values
       ('Product 1', 50, (select id from category where name = 'Category 1')),
       ('Product 2', 100, (select id from category where name = 'Category 1'));

INSERT INTO product (name, price, category_id)
values
    ('Product 1', 50, (select id from category where name = 'Category 2')),
    ('Product 2', 100, (select id from category where name = 'Category 2')),
    ('Product 3', 150, (select id from category where name = 'Category 2'));

INSERT INTO product (name, price, category_id)
values
    ('Product 1', 50, (select id from category where name = 'Category 3')),
    ('Product 2', 100, (select id from category where name = 'Category 3')),
    ('Product 3', 150, (select id from category where name = 'Category 3')),
    ('Product 4', 200, (select id from category where name = 'Category 3'));

-- rollback delete from product where id > 0;
