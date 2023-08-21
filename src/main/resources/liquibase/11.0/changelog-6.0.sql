CREATE TABLE Enrollments
(
    enrollment_id   SERIAL PRIMARY KEY,
    course_id       INT,
    user_id         INT,
    enrollment_date DATE,
    progress        DECIMAL(5, 2),
    FOREIGN KEY (course_id) REFERENCES Courses (course_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);