--table for a student
CREATE TABLE student( 
    id Serial Unique Primary Key,
    session_key text,
    f_name text,
    l_name text,
    username text,
    p_word text,
    email text,
    position_level text,
    programming_langs text,
    desired_location text,
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

CREATE TABLE connections (
        id Serial Unique Primary Key,
        student_id Integer REFERENCES student (id) ON DELETE CASCADE,
        recruiter_id Integer REFERENCES recruiter (id) ON DELETE CASCADE
        );

-- INSERT INTO student(f_name, l_name, username, p_word, email) VALUES ('Trey', 'Shelton', 'treyshel', 'BASECAMP', 'tshelton@basecampcodingacademy.org');

INSERT INTO recruiter(f_name, l_name, title, session_key, username, p_word, email, position_level, company_name, company_location, langs_used, website_url) VALUES ('Glen', 'Evans', 'Mr.', '', 'BossMan98', 'BossMan98', 'imTHEboss@fnccorelogic.com', 'Senior Level', 'FNC Corelogic', 'Mississippi', 'C# / ASP.NET', 'www.corelogic.com');
INSERT INTO recruiter(f_name, l_name, title, session_key, username, p_word, email, position_level, company_name, company_location, langs_used, website_url) VALUES ('Carla', 'Lewis', 'Ms.', '', 'Clewis1', 'Clewis1', 'clewis1@cspire.com', 'Entry Level', 'C Spire', 'Mississippi', 'Java / Spring', 'www.cspire.com');
INSERT INTO recruiter(f_name, l_name, title, session_key, username, p_word, email, position_level, company_name, company_location, langs_used, website_url) VALUES ('Bethany', 'Cooper', 'Ms.', '', 'BCooper2', 'BCooper2', 'bcooper@fnccorelogic.com', 'Mid Level', 'FNC Corelogic', 'Mississippi', 'Scala / Play or Spring', 'www.corelogic.com');
INSERT INTO recruiter(f_name, l_name, title, session_key, username, p_word, email, position_level, company_name, company_location, langs_used, website_url) VALUES ('Zack', 'Bishop', 'Mr.', '', 'zbishop3', 'zbishop3', 'zbishop@renasant.org', 'Senior Level', 'Renasant', 'Alabama', 'C# / ASP.NET', 'www.renasant.com');

-- INSERT INTO student_desc(student_id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (1, 'https://www.linkedin.com/feed/', 'https://www.resume.com/trey/', 'https://www.github.com/treyshel/', 'https://www.treyshel.github.io');
-- INSERT INTO student_desc(student_id, linkedin_url, resume_url, github_url, portfolio_url) VALUES (2, 'https://www.linkedin.com/feed/', 'https://www.resume.com/vale/', 'https://www.github.com/vale/', 'https://www.valvarez.github.io');

-- INSERT INTO student_achievements(student_id, programming_langs, bio, academics, desired_location) VALUES (1, 'python', 'Software Developer', 'Pontotoc High', 'Mississippi');
-- INSERT INTO student_achievements(student_id, programming_langs, bio, academics, desired_location) VALUES (2, 'java', 'Software Engineer', 'LHS', 'Georgia');