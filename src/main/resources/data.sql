DROP TABLE IF EXISTS lead;

CREATE TABLE lead (
    lead_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob DATE NOT NULL ,
    email VARCHAR(255)  
);

INSERT INTO lead (lead_id, first_name, middle_name, last_name, mobile_number, gender, dob, email)
VALUES (5678, 'Vineet', '', 'KV', '8877887788', 'Male', '01/12/1999', 'v@gmail.com');

