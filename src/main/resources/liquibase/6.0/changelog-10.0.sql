CREATE TABLE files
(
    file_id      SERIAL PRIMARY KEY,
    file_name    VARCHAR(255) NOT NULL,
    file_type    VARCHAR(50)  NOT NULL,
    file_content BYTEA        NOT NULL,
    file_size    VARCHAR(20)  NOT NULL,
    upload_date  TIMESTAMP    NOT NULL
);


