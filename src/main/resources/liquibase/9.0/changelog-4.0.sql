CREATE TABLE Courses
(
    course_id     INT PRIMARY KEY,
    title         VARCHAR(255),
    description   TEXT,
    duration      INTEGER,
    status        VARCHAR(50),
    upload_date   DATE,
    price         INTEGER,
    instructor_id INTEGER,
    category_id   INTEGER,
    FOREIGN KEY (instructor_id) REFERENCES project.instructors (instructor_id),
    FOREIGN KEY (category_id) REFERENCES project.categories (category_id)
);