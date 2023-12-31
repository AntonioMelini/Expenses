
CREATE TABLE IF NOT EXISTS ExpenseCategory(
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Expense(
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
description VARCHAR(50) NOT NULL,
amount Double NOT NULL,
date VARCHAR(30) NOT NULL,
category_id INT NOT NULL,
FOREIGN KEY (category_id) REFERENCES ExpenseCategory(id)
);


INSERT INTO ExpenseCategory (name) VALUES
('Food');
DELETE FROM ExpenseCategory WHERE id IN(2,3,4,5,6,7,8,9,10);


INSERT INTO Expense (description,amount,date, category_id) VALUES
('burger',159.36,'2023/12/21 15:26:10',1);

DELETE FROM Expense WHERE id IN(2,3,4,5,6,7,8,9,10);




