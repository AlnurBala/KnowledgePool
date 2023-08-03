CREATE TABLE Course_Reviews (
    review_id INT PRIMARY KEY,
    course_id INT,
    user_id INT,
    review TEXT,
    rating INT,
    FOREIGN KEY (course_id) REFERENCES Courses(course_id),
    FOREIGN KEY (user_id)REFERENCES Users(user_id)
);
