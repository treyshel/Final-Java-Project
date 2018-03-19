--table for the basecamp students
CREATE TABLE students( 
    id Serial Unique Primary Key,
    f_name text,
    l_name text,
    email text 
);


--student's contact/work
CREATE TABLE student_desc(
    id Serial Unique Primary Key, 
    linkedin_url text,
    resume_url text,
    github_url text,
    portfolio_url text
);

INSERT INTO students(id, f_name, l_name, email) VALUES (1, 'Trey', 'Shelton', 'tshelton@basecampcodingacademy.org');
INSERT INTO students(id, f_name, l_name, email) VALUES (2, 'Vale', 'Alvarez', 'valvarez@basecampcodingacademy.org');

INSERT INTO student_desc(id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (1, 'https://www.linkedin.com/feed/', 'https://www.resume.com/trey/', 'https://www.github.com/treyshel/', 'https://www.treyshel.github.io');
INSERT INTO student_desc(id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (2, 'https://www.linkedin.com/feed/', 'https://www.resume.com/vale/', 'https://www.github.com/vale/', 'https://www.valvarez.github.io');
