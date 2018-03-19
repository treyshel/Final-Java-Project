--table for the basecamp students
CREATE TABLE students ( 
    id Serial Unique Primary Key,
    f_name text,
    l_name text,
    email text, 

);


--student's contact/work
CREATE TABLE student_desc (
    id Serial Primary Key,    email text, 
    linkedin_url text,
    resume_url text,
    github_url text,
    portfolio_url text
);

INSERT INTO students(f_name, l_name) VALUES ('Trey', 'Shelton');
INSERT INTO students(f_name, l_name) VALUES ('Vale', 'Alvarez');
INSERT INTO students(linkedin_url, resume_url, github_url, portfolio_url) VALUES ('https://www.linkedin.com/feed/', 'https://www.resume.com/trey/', 'https://www.github.com/treyshel/', 'https://www.treyshel.github.io');
INSERT INTO students(linkedin_url, resume_url, github_url, portfolio_url) VALUES ('https://www.linkedin.com/feed/', 'https://www.resume.com/vale/', 'https://www.github.com/vale/', 'https://www.valvarez.github.io');
