CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    duration VARCHAR(255),
    instructor_id INT,
    price DECIMAL,
    FOREIGN KEY (instructor_id) REFERENCES Instructors(instructor_id)
);
