----xxxxxxxxx
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS question_statistics;
--this needs to be last, foreign key constraint
DROP TABLE IF EXISTS questions;

CREATE TABLE categories (
  category_id integer NOT NULL,
  category_name varchar (70) NOT NULL,
  CONSTRAINT pk_categories_cateogry_id PRIMARY KEY(category_id)
);

INSERT INTO categories (category_id, category_name) VALUES (1, 'Music');
INSERT INTO categories (category_id, category_name) VALUES (2, 'History');
INSERT INTO categories (category_id, category_name) VALUES (3, 'Food');

CREATE TABLE questions (
  question_id serial NOT NULL,               -- Parent park
  question varchar(255) NOT NULL,         
  era varchar (20) NOT NULL,       -- Campground is open from month: 01=January, 02=February, ... 12=December
  points integer NOT NULL,         -- Campground is open to month: 01=January, 02=February, ... 12=December
  choice1 varchar (50) NOT NULL,
  choice2 varchar (50) NOT NULL,
  choice3 varchar (50) NOT NULL,
  choice4 varchar (50) NOT NULL,
  choice5 varchar (50) NOT NULL,
  answer integer NOT NULL,
  category_id integer NOT NULL,
  CONSTRAINT pk_questions_question_id PRIMARY KEY(question_id) -- ???
);
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('This music duo was formed at Temple University', '80s', 10, 'Ashford & Simpson',
 'Sam & Dave', 'Hall & Oats', 'Fresh & Prince', 'Smith & Wesson', 3, 1);

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Frontman of Harold Melvin and the Blue Notes', '70s', 10, 'Harold Melvin',
 'Will Smith', 'Teddy Prendergrass', 'Harold Charmichael', 'Wierd Harold', 3, 1);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Sang about Summer on the Belmont Plateau', '90s', 10, 'Wilson Goode',
 'Marvin Gaye', 'Cindy Lauper', 'Todd Rundgren', 'Will Smith', 5, 1);
 

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('She just wants to have fun', '80s', 10, 'Patti Labelle',
 'Pink', 'Cardi B', 'Cindy Lauper', 'Cindy Rella', 4, 1);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Creators of the Philly Sound', '70s', 10, 'Penn & Teller',
 'McFadden & Whitehead', 'Ashford & Simpson', 'Fresh Prince', 'Hall & Oates', 2, 1);

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('He shopped in the Human Mall', '80s', 10, 'King of Prussia',
 'Ben Franklin', 'Joe Frazier', 'Fresh Prince', 'Robert Hazard', 2, 1);

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Ben Franklin apprenticed in what trade?', 'Colonial', 10, 'Ferrier',
 'Printer', 'Electrician', 'Philanderer', 'Inventor', 2, 2);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('This Mayor bombed West Philly', '80s', 10, 'Milton Street',
 'Frank Rizzo', 'William Sonoma', 'Wilson Goode', 'Nicki Scarfo', 4, 2);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Betsy Ross made the Stars & Stripes on this Street', 'Colonial', 10, 'Walnut',
 'Broad', 'Passyunk', 'Market', 'Arch', 5, 2);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('The first computer was made in Philly, its name was:', '40s', 10, 'WATSON',
 'SIRI', 'ENIAC', 'BRAINIAC', 'DELL', 3, 2);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('The Declaration of Indepedence was ______ in Philadepelphia', 'Coloninal', 10, 'Written',
 'Improved', 'Faxed', 'Supplanted', 'Approved', 5, 2);

--music by Caitlin 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('This artist is from South Philadelphia and their song, "Dreams and Nightmares"', 'now', 10,
 'Lil Uzi Vert', 'Future','Meek Mill', 'Travis Scott', 'Lil Wayne', 3, 1);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('This band proclaims to have "came out swinging from a South Philly basement"', 'now', 10,
 'Neck Deep', 'The Wonder Years', 'Motion City Soundtrack', 'Circa Survive','Rocky Horror', 2, 1);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('This electronic dance music artist went to Temple University. Their label created a multiple city
 tour which started as a small scale block party with a rented tent, dunk tank, and BBQ on 12th and Spring Garden St.',
  'now', 10, 'Diplo', 'Jack Ü', 'Mr. Carmack', 'TroyBoi', 'Moby', 1, 1);

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES(' What term do Philadelphians use to describe their sandwiches? The term likely originated in the 1920s 
as a different word but was changed due the Philadelphia accent.', 'yo', 10, 'Jawn',
 'Sub', 'Grinder', 'Wawa', 'Hoagie', 5, 3);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('What is the name of the store that sells snacks and made-to-order meals which is held near and dear to the heart of all Philadelphians,
 especially after a night on the town?', 'yo', 10, 'Jawns',
 'Bookbinders', 'Wooder', 'Wawa', 'Genos', 4, 3);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Philadelphia is home to one of the most top rated all vegan restaurants in the country. This restaurant is also recognized as being one of the best restaurants in Philadelphia, period. 
What is the name of this restaurant?', 'yo', 10, 'Suraya', 'Crossroads', 'Fancy Radish', 'Vedge', 'Siracha', 4, 3);
 
INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('What is the oldest restaurant in Philadelphia that is still operating?', 'yo', 10, 
'Melrose Diner', 'McGillins Old Ale House', 'Victor Cafe', 'Dante & Luigis', 'Continental', 2, 3);

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES(' Which food item is Philadelphia most commonly known for?', 'yo', 10, 
'Hamburger', 'Italian Ice', 'Phlan', 'Soft Pretzel', 'Bagel', 4, 3);

INSERT INTO questions(question, era, points, choice1, choice2, choice3, choice4, choice5, answer, category_id)
VALUES('Which popular candy factory is located in Philadelphia?', 'yo', 10, 
'Tastykake', 'Baby Ruth', 'Peanut Chew', '5th Avenue', 'Bit-O-Honey', 3, 3);

CREATE TABLE question_statistics (
   question_id integer NOT NULL,
   times_asked integer NOT NULL,
   times_answered_correct integer NOT NULL
);

ALTER TABLE questions ADD FOREIGN KEY (category_id) REFERENCES categories(category_id);
ALTER TABLE question_statistics ADD FOREIGN KEY (question_id) REFERENCES questions(question_id);

