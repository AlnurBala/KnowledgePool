CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY,
    user_id INT,
    course_id INT,
    date DATE,
    time TIME,
    amount DECIMAL,
    payment_method VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);