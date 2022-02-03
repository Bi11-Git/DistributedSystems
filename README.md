# distributedSystems
a team project for Distributed Systems Class HUA
# distributedSystems
a team project for Distributed Systems Class HUA
-----------------------------------------------------------------------

**online doc**https://docs.google.com/document/d/1jAbl3qfcJdOLAeb-BAcrI_uYFsfwyqYo3WkrFhEoOtY/edit

Οδηγίες εργασιών

https://docs.google.com/document/d/e/2PACX-1vSnSUfpPwum1Pt-48ttv7J5-vsQ5yYst9rufVGh96o8yFXkpXbE3xOdZPlN3trG3sHniWhD2ZAIm7fI/pub

Θέματα Εργασιών

https://docs.google.com/document/d/e/2PACX-1vReZn87dLrV-lEkipsHImlP2IcJOJLxk27cP1TZi0qSVJ4Rf6C7XmlKwqUR2ZxmImyRgmJ2UyACo5Ps/pub

Αναθέσεις Εργασιών

https://docs.google.com/spreadsheets/d/e/2PACX-1vT_mJFeT_xZjE6BTzqigJF4_jN2dddTgTPeIBm-LkgEbQKHithdiQol38gsP5OJLILtrP703hlZyH7N/pubhtml?gid=647520828&single=true
----------------------------------------------------------------------

Θα έχουμε ένα σύστημα στο οποίο:

Ο Μαθητής θα μπορεί:<br />
   &emsp; 1.Να κάνει εγγραφή στο σύστημα (με email, κωδικό, αριθμό τηλεφώνου,ονοματεπώνυμο, τάξη) <br />
   &emsp; 2.Να συνδέεται στο σύστημα(με email και κωδικό)<br />
   &emsp; 3.Να επιλέγει τάξη γυμνασίου στην οποία θέλει να εξασκηθεί <br />
   &emsp; 4.Να επιλέγει quiz ερωτήσεων, τα οποία χωρίζονται ανά κεφάλαιο <br />
   &emsp; 5.Να βλέπει ιστορικό με τα ποσοστά των quiz ανά κεφάλαιο <br />


Ο Καθηγητής θα μπορεί:<br />
   &emsp; 1.Να κάνει εγγραφή στο σύστημα ( email, κωδικό , αριθμό τηλεφώνου, ονοματεπώνυμο) <br />
   &emsp; 2.Να συνδέεται στο σύστημα (με email και κωδικό...στην επιλογή "Συνδέσου ως  Καθηγητής") <br />
   &emsp; 3.Να δημιουργήσει μια ερώτηση δηλώνοντας το κεφάλαιο <br />
   &emsp; 4.Να διαγράψει μια ερώτηση <br/>
   &emsp; 5.Να τροποποιήσει μια ερώτηση <br/>
   &emsp; 6.Να εμφανίσει ανα μαθητή το ιστορικό επίδοσης ανα ερώτηση <br /> 



Παραδοχές<br />
&emsp; 1. Κάθε μαθητής και κάθε καθηγητής μπορεί να έχει μόνο έναν συνδυασμό στοιχείων για να συνδεθεί<br />
&emsp; 2. Το σύστημα θα εμφανίζει τυχαία τις ερωτήσεις των quiz <br />
&emsp; 3. Ένας μαθητής θα μπορεί να κάνει όσες φορές θέλει ένα τύπο quiz (ανα κεφάλαιο) , και ένας τύπος quiz θα μπορεί να γίνεται απο πολλούς μαθητές<br />
&emsp; 4. Ο μαθητής μπορεί να επιλέξει να κάνει quiz ανεξάρτητα με την τάξη στην οποία βρίσκεται εφόσον επιλέγει με βάση το κεφάλαιο<br />



---------------------------------------------------CREATE TABLES--------------------------------------------------- 

create table question(<br />
                         &emsp;question_id INT NOT NULL AUTO_INCREMENT,<br />
                         &emsp;question_image VARCHAR(100),<br />
                         &emsp;question_text VARCHAR(100) NOT NULL,<br />
                         &emsp;question_option1 VARCHAR(100) NOT NULL,<br />
                         &emsp;question_option2 VARCHAR(100) NOT NULL,<br />
                         &emsp;question_option3 VARCHAR(100),<br />
                         &emsp;question_option4 VARCHAR(100),<br />
                         &emsp;question_script VARCHAR(100),<br />
                         &emsp;PRIMARY KEY ( question_id )<br />
);<br /><br />

create table subject(<br />
                        &emsp;subject_id INT NOT NULL AUTO_INCREMENT,<br />
                        &emsp;subject_name VARCHAR(50) NOT NULL,<br />
                        &emsp;subject_class VARCHAR(50) ,<br />
                        &emsp;PRIMARY KEY ( subject_id )<br />
);<br /><br />


create table user(<br />
                     &emsp;user_id INT NOT NULL AUTO_INCREMENT,<br />
                     &emsp;user_email VARCHAR(50) NOT NULL,<br />
                     &emsp;user_phone_number INT NOT NULL,<br />
                     &emsp;user_password VARCHAR(50) NOT NULL,<br />
                     &emsp;user_fullname VARCHAR(50) NOT NULL,<br />
                     &emsp;user_role VARCHAR(50) NOT NULL,<br />
                     &emsp;user_teacher VARCHAR(50),<br />
                     &emsp;PRIMARY KEY (user_id)<br />
);<br /><br />

create table grade(<br />
                      &emsp;grade_of_question INT NOT NULL,<br />
                      &emsp;grade_question_id INT NOT NULL,<br />
                      &emsp;grade_user_id INT NOT NULL,<br />
                      &emsp;FOREIGN KEY (grade_question_id) REFERENCES question(question_id),<br />
                      &emsp;FOREIGN KEY (grade_user_id) REFERENCES user(user_id),<br />
                      &emsp;PRIMARY KEY (grade_question_id,grade_user_id)<br />
);<br /><br />
