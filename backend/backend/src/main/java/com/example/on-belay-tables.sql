--table for a student
CREATE TABLE student( 
    id Serial Unique Primary Key,
    session_key text,
    f_name text,
    l_name text,
    username text,
    p_word text,
    email text,
    programming_langs text,
    desired_location text,
    linkedin_url text,
    resume_url text,
    github_url text,
    portfolio_url text
);

CREATE TABLE recruiter(
        id Serial Unique Primary Key,
        f_name text,
        l_name text,
        title text,
        session_key text,
        username text,
        p_word text,
        email text,
        position_level text,
        company_name text,
        company_location text,
        langs_used text,
        website_url text
);

-- INSERT INTO student(f_name, l_name, username, p_word, email) VALUES ('Trey', 'Shelton', 'treyshel', 'BASECAMP', 'tshelton@basecampcodingacademy.org');
-- INSERT INTO student(f_name, l_name, username, p_word, email) VALUES ('Vale', 'Alvarez', 'valvarez', 'papaV', 'valvarez@basecampcodingacademy.org');

-- INSERT INTO student_desc(student_id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (1, 'https://www.linkedin.com/feed/', 'https://www.resume.com/trey/', 'https://www.github.com/treyshel/', 'https://www.treyshel.github.io');
-- INSERT INTO student_desc(student_id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (2, 'https://www.linkedin.com/feed/', 'https://www.resume.com/vale/', 'https://www.github.com/vale/', 'https://www.valvarez.github.io');

-- INSERT INTO student_achievements(student_id, programming_langs, bio, academics, desired_location) VALUES (1, 'python', 'Software Developer', 'Pontotoc High', 'Mississippi');
-- INSERT INTO student_achievements(student_id, programming_langs, bio, academics, desired_location) VALUES (2, 'java', 'Software Engineer', 'LHS', 'Georgia');