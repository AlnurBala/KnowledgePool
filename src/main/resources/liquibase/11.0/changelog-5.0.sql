CREATE TABLE Course_Reviews
(
    review_id SERIAL PRIMARY KEY,
    course_id INT,
    user_id   INT,
    review    TEXT,
    rating    NUMERIC,
    FOREIGN KEY (course_id) REFERENCES Courses (course_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
