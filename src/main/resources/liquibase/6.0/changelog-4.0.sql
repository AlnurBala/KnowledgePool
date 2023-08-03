CREATE TABLE Courses
(
    course_id     INT PRIMARY KEY,
    title         VARCHAR(255),
    description   TEXT,
    duration      VARCHAR(255),
    instructor_id INT,
    price         DECIMAL,
    status        VARCHAR(255),
    category_id   INT,
    FOREIGN KEY (instructor_id) REFERENCES Instructors (instructor_id),
    FOREIGN KEY (category_id) REFERENCES Categories (category_id)
);