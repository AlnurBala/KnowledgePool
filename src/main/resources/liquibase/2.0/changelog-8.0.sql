CREATE TABLE Discounts
(
    discount_id         INT PRIMARY KEY,
    course_id           INT,
    discount_percentage DECIMAL(5, 2),
    start_date          DATE,
    end_date            DATE,
    FOREIGN KEY (course_id) REFERENCES Courses (course_id)
);