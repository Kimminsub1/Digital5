CREATE DATABASE shopping_ex;
CREATE TABLE member_ex(
	m_no INT(10) PRIMARY KEY,
    m_name VARCHAR(12) NOT NULL,
    m_tel VARCHAR(15) UNIQUE NOT NULL,
    m_add VARCHAR(100) NOT NULL,
    m_age INT(3) NOT NULL
);
DROP TABLE member_ex;

CREATE TABLE product_ex(
	p_no INT(10) PRIMARY KEY,
    p_name VARCHAR(60) UNIQUE NOT NULL,
    p_title VARCHAR(15) NOT NULL,
    p_desc VARCHAR(300),
    p_price INT NOT NULL,
    p_qty INT(10) NOT NULL
);
DROP TABLE product_ex;

CREATE TABLE order_ex(
  o_no INT(10) PRIMARY KEY,
  o_qty INT(10) NOT NULL,
  o_price INT NOT NULL,
  o_Date DATE DEFAULT CURRENT_DATE,
  m_no INT(10),
  p_no INT(10),
  FOREIGN KEY(m_no) REFERENCES member_ex(m_no),
  FOREIGN KEY(p_no) REFERENCES product_ex(p_no)
);
DROP TABLE order_ex;

CREATE TABLE pay_ex(
	m_no INT(10),
	o_no INT(10),
    pay_decide VARCHAR(20) NOT NULL,
    pay_price INT NOT NULL,
	pay_Date DATE DEFAULT CURRENT_DATE,
	PRIMARY KEY (m_no, o_no),
	FOREIGN KEY(m_no) REFERENCES member_ex(m_no),
	FOREIGN KEY(o_no) REFERENCES order_ex(o_no)
);
DROP TABLE pay_ex;

CREATE TABLE ship_ex(
	m_no INT(10),
	o_no INT(10),
    s_name VARCHAR(12) NOT NULL,
    s_tel VARCHAR(15) UNIQUE NOT NULL,
    s_add VARCHAR(100) NOT NULL,
  PRIMARY KEY (m_no, o_no),
  FOREIGN KEY (m_no, o_no) REFERENCES pay_ex(m_no, o_no) 
);
DROP TABLE ship_ex;