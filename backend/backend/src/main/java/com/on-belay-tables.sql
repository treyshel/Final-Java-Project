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
