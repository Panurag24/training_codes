create database mphasis;
use mphasis;

-- Create the Book Details table
CREATE TABLE Book_Details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_title VARCHAR(255),
    book_publisher VARCHAR(255),
    book_isbn VARCHAR(20),
    book_number_of_pages INT,
    book_year INT
);

-- Insert some records into the Book Details table
INSERT INTO Book_Details (book_title, book_publisher, book_isbn, book_number_of_pages, book_year) 
VALUES 
('The Great Gatsby', 'Scribner', '9780743273565', 180, 1925),
('To Kill a Mockingbird', 'J. B. Lippincott & Co.', '9780061120084', 281, 1960),
('1984', 'Secker & Warburg', '9780451524935', 328, 1949),
('Pride and Prejudice', 'T. Egerton, Whitehall', '9780679783268', 279, 1813);
select * from Book_Details;