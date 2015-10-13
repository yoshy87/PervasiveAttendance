# Pervasive Attendance

Android application called "Pervasive attendance" developed for the project of the 

[Pervasive System elective class] (http://ru1.cti.gr/~ichatz/index.php/Site/PervasiveSystems), University of Sapienza, Rome. Spring 2015, http://cclii.dis.uniroma1.it/?q=en/msecs



[Claudio Di Pilla] (https://www.linkedin.com/profile/view?id=AAIAABRbp4cBr7mJCESzs6vE0AVbhF_VePScp3g&trk=nav_responsive_tab_profile)

[Maurizio Tesori] (https://www.linkedin.com/profile/view?id=ADEAAA2E3MoB2nyx9SVcZjYuLF3KdpjTG0N-LmM&authType=NAME_SEARCH&authToken=NjzT&locale=it_IT&srchid=3415509831443193160785&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A3415509831443193160785%2CVSRPtargetId%3A226811082%2CVSRPcmpt%3Aprimary%2CVSRPnm%3Atrue%2CauthType%3ANAME_SEARCH)

Claudio Arcese

#General description

Along our university career can happen that some courses are mandatory, perhaps

with a signature for the presence.

Our idea is to develop an application that allows students to put the signature 

using their mobile phone with the NFC technology (to professor's phone), 

but also give your opinion (with the rating) about the lesson you are 

attending or about the topic of the lesson. All in one!

All these informations are sent to Parse database (http://www.parse.com).


#CLARIFICATIONS:
To understand better all the project is important to specify the material used to develop this application :

	- Eclipse IDE (with ADT) with android SDK 
	- parse.com libraries to connect the application to parse.com
	- two mobile phones (lg l7 and sony experia c205) to test our application
	- a lot of patience and desire to do :)

#Graphics architecture

- a .jpg picture with the flow of the activities of our application 
	(for a complete overview of the application)

	flow student

![studentside](https://cloud.githubusercontent.com/assets/11192198/8747291/cbccd650-2c91-11e5-9d08-281cd33a6757.jpg)

flow professor

![professorside](https://cloud.githubusercontent.com/assets/11192198/8747301/e3ad14ce-2c91-11e5-8218-6882a4d89a09.jpg)

professor student

![professorstudent](https://cloud.githubusercontent.com/assets/11192198/8747319/0579ef3c-2c92-11e5-9676-cdd8c21fec0b.jpg)



#How it works?

First of all you need to install the file .apk

Then you will see you first screen (like the picture down):


![loginsignup](https://cloud.githubusercontent.com/assets/11192198/8747081/e773983c-2c8f-11e5-825c-0a5ee364e13b.jpg)

In this activity you have the possibility to sign up to the application (if it

is your first time) or make the login. If you are already registered, just 
fill the fields and you can start using the application. On the other hand
you go in this new screen.

![signup](https://cloud.githubusercontent.com/assets/11192198/8747187/be4c796e-2c90-11e5-90fa-97be58ad461d.jpg)


You put some information about you and then you are logged in. So you can start
using the application.We have two different login: one for the normal user (Student)
and the other for the professor.

![corso](https://cloud.githubusercontent.com/assets/11192198/8747193/d558af1a-2c90-11e5-8e86-f5643581231c.jpg)

First thing is to choose the course you are attending.
Then the screen became different from the student to the professor.

STUDENT SIDE:

![welcome studente](https://cloud.githubusercontent.com/assets/11192198/8747203/fb429af6-2c90-11e5-929d-43555e85ce97.jpg)

When you are here, you can choose to send the signature to your professor to record
your presence. Rate the lesson you are attending, or check the percentage of
presence that allow you to make the exam.

![rating](https://cloud.githubusercontent.com/assets/11192198/8747209/119c9dec-2c91-11e5-89c5-f5b878f204ad.jpg)


This is the rating activity when you can rate the listening, the interest and 
the understanding of the lesson.The information you submit will be sent and will
be recordered in a anonymous way in order to help the teachers to improve 
the course.

![signature student](https://cloud.githubusercontent.com/assets/11192198/8747212/261027f8-2c91-11e5-9ed8-636fc3a81015.jpg)


In this case you will be able to send the signature to the professor using only
the NFC technology (approaching your phone to that of professor)


![check activity](https://cloud.githubusercontent.com/assets/11192198/8747218/37db76c2-2c91-11e5-8a13-1f4dd3e88582.jpg)

In this screen you can check how much lesson do you follow, so if you can make the
exam at the end of the lessons

PROFESSOR SIDE: 


![welcome professore](https://cloud.githubusercontent.com/assets/11192198/8747232/519a002e-2c91-11e5-8beb-cf8ee45b55b8.jpg)

This is the welcome screen of the professor. In this activity
the professor can receive the first signature and the 
second signature of the students at the beginning and at the 
end of the lesson

![ricezione signature prof](https://cloud.githubusercontent.com/assets/11192198/8747246/67c242e4-2c91-11e5-8315-076a8f95e5a5.jpg)



these are the screen that allow professor to receive the two
signature from the student and save them into parse.com

That's all!




I hope you enjoy our application and for any advice or questions 
contact us as well.

Enjoy!




















