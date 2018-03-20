--table for the basecamp students
CREATE TABLE student( 
    id Serial Unique Primary Key,
    f_name text,
    l_name text,
    username text,
    p_word text,
    email text 
);


--student's contact
CREATE TABLE student_desc(
    id Serial Unique Primary Key, 
    student_id Integer references student(id),
    linkedin_url text,
    resume_url text,
    github_url text,
    portfolio_url text
);

--student's achievements
CREATE TABLE student_achievements(
    id Serial Unique Primary Key, 
    student_id Integer references student(id),
    programming_langs text,
    bio text,
    academics text,
    desired_location text
);

INSERT INTO student(id, f_name, l_name, username, p_word, email) VALUES (1, 'Trey', 'Shelton', 'treyshel', 'BASECAMP', 'tshelton@basecampcodingacademy.org');
INSERT INTO student(id, f_name, l_name, username, p_word, email) VALUES (2, 'Vale', 'Alvarez', 'valvarez', 'papaV', 'valvarez@basecampcodingacademy.org');

INSERT INTO student_desc(id, student_id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (1, 1, 'https://www.linkedin.com/feed/', 'https://www.resume.com/trey/', 'https://www.github.com/treyshel/', 'https://www.treyshel.github.io');
INSERT INTO student_desc(id, student_id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (2, 2, 'https://www.linkedin.com/feed/', 'https://www.resume.com/vale/', 'https://www.github.com/vale/', 'https://www.valvarez.github.io');

INSERT INTO student_achievements(id, student_id, programming_langs, bio, academics, desired_location) VALUES (1, 1, 'python', 'Software Developer', 'Pontotoc High', 'Mississippi');
INSERT INTO student_achievements(id, student_id, programming_langs, bio, academics, desired_location) VALUES (2, 2, 'java', 'Software Engineer', 'LHS', 'Georgia');