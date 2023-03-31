-- liquibase formatted sql
-- changeset <konstantin.nikiforov>:<create-category-table>

CREATE TABLE IF NOT EXISTS category (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(256) NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- rollback DROP TABLE IF EXISTS category;
