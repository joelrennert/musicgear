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
('Guitar', 'DIY Telecaster', 'Modded kit build', FALSE),
('Guitar', 'Yamaha Acoustic', 'Acoustic Guitar', FALSE),
('Guitar', 'Yamaha Classical', 'Classical guitar', FALSE),
('Synthesizer', 'Novation MiniNova', 'Digital polysynth', FALSE),
('Synthesizer', 'Behringer Neutron', 'Analog Monosynth', FALSE),
('Synthesizer', 'Eurorack Modules', 'Lots to list here', FALSE),
('Audio', 'Ampex Reel to Reel','1960s amp', TRUE),
('Audio', 'Technics SA-205', '1970s receiver', TRUE),
('Audio', 'Tascam 424 mk1', '1990s 4-track', TRUE),
('Audio', 'Yamaha EQ-70', '1990s Graphic EQ', TRUE),
('Midi', 'Arturia KeyStep', 'Midi Controller', FALSE),
('Midi', 'Arturia BeatStep', 'Midi Controller', FALSE),
('Mic', 'Astatic Harp Mic', '1950s harp mic', TRUE)


-- ***** INSERT TEST DATA
-- Not sure if I need this quite yet