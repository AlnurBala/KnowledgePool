CREATE TABLE files
(
    id          SERIAL PRIMARY KEY,
    fileName    VARCHAR(255) NOT NULL,
    fileType    VARCHAR(50)  NOT NULL,
    fileContent BYTEA        NOT NULL,
    fileSize    VARCHAR(20)  NOT NULL,
    uploadDate  TIMESTAMP    NOT NULL
);


