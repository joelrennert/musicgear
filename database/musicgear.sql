-- *************************************
-- ***** music gear - Joel Rennert *****
-- *************************************

-- A very basic database to store information about music gear

-- ***** DROP TABLES
DROP TABLE IF EXISTS gear;

-- *****  CREATE TABLES
CREATE TABLE gear (
    gear_id serial NOT NULL,
    type varchar(100) NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(400) NOT NULL,
    is_vintage BOOLEAN
);

-- ***** INSERT DATA
INSERT INTO gear(type, name, description, is_vintage) VALUES
('Guitar', 'DIY Telecaster', 'Built from kit and added humbucker in neck position', FALSE),
('Guitar', 'Yamaha Acoustic', 'Nice guitar, needs strings', FALSE),
('Guitar', 'Yamaha Classical', 'Nice classical guitar', FALSE),
('Synthesizer', 'Novation MiniNova', 'Digital polysynth has seen better days', FALSE),
('Synthesizer', 'Behringer Neutron', 'Analog Monosynth racked in eurorack cabinet', FALSE),
('Synthesizer', 'Eurorack Modules', 'Lots to list here', FALSE),
('Other', 'Ampex Reel to Reel','Vintage from late 1960’s reel to reel amplifier section', TRUE),
('Other', 'Technics SA-205', 'Vintage AM/FM stereo receiver', TRUE),
('Other', 'Tascam 424 mk1', 'Vintage early 90s 4-track cassette recorder', TRUE),
('Other', 'Yamaha EQ-70', 'Vintage 90s Graphic EQ', TRUE),
('Other', 'Arturia KeyStep', 'ehh', FALSE),
('Other', 'Arturia BeatStep', 'ehh', FALSE),
('Other', 'Astatic Harp Mic', '1950s harp/harmonica microphone', TRUE)


-- ***** INSERT TEST DATA
-- Not sure if I need this quite yet