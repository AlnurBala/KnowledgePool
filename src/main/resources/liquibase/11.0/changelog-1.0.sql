CREATE TABLE Users
(
    user_id         SERIAL PRIMARY KEY,
    first_name      VARCHAR(255),
    last_name       VARCHAR(255),
    email_address   VARCHAR(255),
    password        VARCHAR(255),
    payment_details VARCHAR(255),
    role            VARCHAR(255)
);

