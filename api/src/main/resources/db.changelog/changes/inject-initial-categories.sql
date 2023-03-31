-- liquibase formatted sql
-- changeset <konstantin.nikiforov>:<inject-initial-categories>

INSERT INTO category (name)
values
       ('Category 1'),
       ('Category 2'),
       ('Category 3');

-- rollback delete from category where id > 0;;
