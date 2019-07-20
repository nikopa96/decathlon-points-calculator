DROP SCHEMA PUBLIC CASCADE;

CREATE TABLE sport (
  id BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  unit VARCHAR(5) NOT NULL,
  category VARCHAR(64) NOT NULL,
  coefficient_a FLOAT NOT NULL,
  coefficient_b FLOAT NOT NULL,
  coefficient_c FLOAT NOT NULL,
);

INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (1, '100 m', 's', 'running', 25.4347, 18, 1.81);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (2, 'Long jump', 'm', 'jumping', 0.14354, 220, 1.4);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (3, 'Shot put', 'm', 'throwing', 51.39, 1.5, 1.05);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (4, 'High jump', 'm', 'jumping', 0.8465, 75, 1.42);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (5, '400 m', 's', 'running', 1.53775, 82, 1.81);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (6, '110 m hurdles', 's', 'running', 5.74352, 28.5, 1.92);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (7, 'Discus throw', 'm', 'throwing', 12.91, 4, 1.1);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (8, 'Pole vault', 'm', 'jumping', 0.2797, 100, 1.35);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (9, 'Javelin throw', 'm', 'throwing', 10.14, 7, 1.08);
INSERT INTO sport(id, name, unit, category, coefficient_a, coefficient_b, coefficient_c) VALUES (10, '1500 m', 's', 'running', 0.03768, 480, 1.85);
