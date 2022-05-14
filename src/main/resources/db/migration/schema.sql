CREATE TABLE tt_user
(
    id           UUID    NOT NULL,
    version BIGINT NOT NULL,
    firstName   VARCHAR NOT NULL,
    lastName    VARCHAR NOT NULL,
    gender       VARCHAR NOT NULL,
    birthday     DATE    NOT NULL,
    email        VARCHAR NOT NULL,
    phoneNumber VARCHAR NOT NULL,
    PRIMARY KEY (id)
);