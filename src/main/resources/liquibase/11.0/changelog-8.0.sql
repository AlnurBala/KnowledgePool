CREATE TABLE Discounts
(
    discount_id         SERIAL PRIMARY KEY,
    course_id           INT,
    discount_percentage DECIMAL(5, 2),
    start_date          DATE,
    end_date            DATE,
    recipient_email     VARCHAR(255),
    FOREIGN KEY (course_id) REFERENCES Courses (course_id)
);