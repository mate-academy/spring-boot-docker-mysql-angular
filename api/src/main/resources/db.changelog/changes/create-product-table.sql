-- liquibase formatted sql
-- changeset <konstantin.nikiforov>:<create-product-table>

CREATE TABLE IF NOT EXISTS product (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(256) NOT NULL,
    price decimal(19,2) NOT NULL,
    category_id bigint,
    CONSTRAINT client_pk PRIMARY KEY (id),
    CONSTRAINT category_id_fk FOREIGN KEY (category_id)
        REFERENCES category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- rollback DROP TABLE IF EXISTS product;
