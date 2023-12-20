
CREATE TABLE IF NOT EXISTS ExpenseCategory(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
name VARCHAR(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS Expense(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL ,
description VARCHAR(50) NOT NULL,
amount Double NOT NULL,
date DATETIME NOT NULL,
category_id INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES ExpenseCategory(id)
)
INSERT INTO ExpenseCategory (name) VALUES
('Food'),
('Transportation'),
('Utilities'),
('Entertainment'),
('Healthcare'),
('Education'),
('Shopping'),
('Travel'),
('Housing'),
('Miscellaneous');

INSERT INTO Expense (description, amount, date, category_id) VALUES
('Lunch', 15.99, '2022-01-15 12:30:00', 1),
('Gas', 30.00, '2022-01-16 08:45:00', 2),
('Electricity Bill', 100.00, '2022-01-17 09:00:00', 3),
('Movie Tickets', 25.00, '2022-01-18 19:00:00', 4),
('Doctor Visit', 50.00, '2022-01-20 14:30:00', 5),
('Textbooks', 75.99, '2022-01-21 10:00:00', 6),
('Clothing', 50.00, '2022-01-22 15:30:00', 7),
('Flight Tickets', 300.00, '2022-01-25 11:00:00', 8),
('Rent', 800.00, '2022-01-28 09:00:00', 9),
('Gadgets', 200.00, '2022-01-30 16:00:00', 10);