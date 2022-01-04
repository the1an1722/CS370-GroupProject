# Desktop Pet

Course: CSCI 370 Software Engineering

Instructor: Professor Chia-Ling Tsai 

Group Member: Bingming Zhang, Jaejun Lee and Shengliang Yu 

**Table of Contents**

[***Introduction:](#_heading=h.gjdgxs)	***1******

[***Glossary:](#_heading=h.30j0zll)	***2******

[***Requirement document](#_heading=h.1fob9te)	***2******

[***Use cases and the use case diagrams](#_heading=h.3znysh7)	***3******

[***User Interface Design](#_heading=h.2et92p0)	***9******

[***Architectural Design](#_heading=h.tyjcwt)	***10******

[***Relational Database schema](#_heading=h.3dy6vkm)	***12******

[***Structural modeling](#_heading=h.1t3h5sf)	***12******

[***Interaction modeling](#_heading=h.4d34og8)	***14******

[**Testing results](#_heading=h.8rk6fj2iw7ym)	**16****

[**Test Case:](#_heading=h.osmrbjs9s147)	**18****

[***Ethical considerations](#_heading=h.2s8eyo1)	***19******

[***Programming environment:](#_heading=h.17dp8vu)	***19******

[***Screen shots of GUIs](#_heading=h.3rdcrjn)	***19******

[***Data description](#_heading=h.26in1rg)	***21******

[***Ethical considerations](#_heading=h.lnxbz9)	***21******

[***User’s Guide](#_heading=h.35nkun2)	***21******

[***Planning for Version 2.0](#_heading=h.1ksv4uv)	***22******


**Assignment#1 Domain analysis and requirements specification**
# **Introduction:**
`	`By the definition of the word pet, it means an animal that an animal lover keeps in his or her home for the pleasure of himself and the animals. However, no matter how much they like animals, there are people who cannot raise them due to financial or physical problems. For example, parental objections, lack of funds because their job is not stable yet or allergies. That is why we would like to introduce a virtual pet to such people. Since this pet is on the computer, there are no issues with taking up space in the house or blowing fur, and there is no family objection. Also, financially, it can be solved only with electricity prices. 

In the case of this virtual pet, it not only has the cute side as a pet, but also provides various functions. You can use the computer mouse to play with this virtual pet and interact like a real pet, such as feeding. Even this pet is also responsible for providing convenience to users such as calculators. Therefore, users can experience the feeling of keeping pets in their own private space, and at the same time give people a feeling of being a supporter who takes care of the user's convenience. And because it is a helpful program, even users who do not like pets will have this virtual pet, because reality and virtual reality are different. Basically, the reason people don't like pets is because they are inconvenient to keep. Things like taking shit out of the house, barking, or destroying things in the house. However, this pet will not have any of these problems at all, because these problems have no choice, which will make the user feel tired or uncomfortable.

# **Glossary:**
**Portability** – the ability to easily move to another platform.

**Functional requirements** – The requirements that expand from user requirement and define 

what the system should do for system developers.

**Non-functional requirements** – The requirements that state the constraints characteristics of 

the system. 

**Source** – The devices where the inputs were read from. 

**Performance** – the speed of an application to finish a given task.

**Frame** – It is a software component specification to achieve specific professional standards 

or complete specific tasks.

**Portability** – In software engineering, porting is a software development program that 

transfers an executable program from its original environment to another 	environment so that it can be re-operated.

**Inputs** – Receive user input data and instructions

**Outputs** - Feedback the data and instructions entered by the user to the user through 

background calculations

**System tray -** miniature icons located in the windows taskbar, at the bottom right corner of the computer screen.
# **Requirement document** 
1. The user shall move the desktop pet around the desktop.

    1.1 The user shall move the desktop pet with the mouse. (Functional)

    1.2 The system shall stay at the position that the user provides. (Functional)

    1.3 The system shall execute immediately after user input. (Non-functional)

2. The user shall be able to feed the desktop pet.

    2.1 The user shall have item options to feed the desktop pet. (Functional)

    2.2 The user shall be able to see the images of food items in the feed menu. (Functional)

    2.3 The system shall respond with eating frames immediately after user request. (Non- functional)

    2.4 The system shall prompt the status to the user after the feeding. (Functional)

3. The user shall be able to bathe the desktop pet.

    3.1 The user shall have item options to bath the desktop pet. (Functional)

    3.2 The user shall be able to see the images of bath items in the bath menu. (Functional)

    3.3 The system shall respond with bathing frames immediately after user request. (Non- functional)

    3.4 The system shall prompt the status to the user after the bathing. (Functional)
    
4. The user shall be able to access the utility tool from the desktop pet (like a calculator).

    4.1 The user shall be able to select the utility tool by mouse. (Functional)

    4.2 The user shall be able to easily navigate the tool. (Non-functional)

    4.3 The system shall provide the tool the user needs after the request. (Non-functional)

5. The user shall hide/show the desktop pet.

    5.1 The system shall not process. (Non-functional)

    5.2 The user shall be able to hide the desktop pet through the menu or the system tray.. (Functional)
    
    5.3 The user shall be able to show the desktop pet from the system tray. (Functional)





#
# **Use cases and the use case diagrams** 

**Use Case for 1.**

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 001](https://user-images.githubusercontent.com/60747086/148117753-7a2128f1-54f9-445c-91e0-f343c63dd870.jpeg)

**Description**: The application will move around on the desktop if the user clicks and holds the 

left mouse button on the application.

**Trigger:** User left mouse button

**Actors:** User and the application

**Preconditions**: None

**Proconditions:** The application’s position is changed.

**Steps of execution:** 

1. User holds the left click on the application

2. Move the application around the desktop

2A. The application is offscreen after moving around

**Extensions:**

1. The application prompted a greeting and farewell when it started and closed.
2. The application executes drag animation when it is moved around.




**Use case for 2.**

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 002](https://user-images.githubusercontent.com/60747086/148118010-9ce306b6-5f29-46c6-9f3f-d778388da3b1.jpeg)

**Description:** The application allows the user to feed the desktop pet with different food options. The application will prompt a selection menu for the user to pick.

**Trigger:** 

1. User’s left and right mouse button

**Actors:** User and the application

**Preconditions:** None

**Proconditions:** The application will execute the eating frame after the user selection.

**Steps of execution:** 

1. User right click the application

2. User selects feed option from the list

3. User selects the food from the pop-up menu 

**Extensions:**

1. Users can see the gauge value.

2. The application has a friendship gauge and processes different animations based on the friendship level.



**Use Case for 3.**

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 002](https://user-images.githubusercontent.com/60747086/148118010-9ce306b6-5f29-46c6-9f3f-d778388da3b1.jpeg)

**Description**: User is able to bathe the desktop pet with the option to select. The application will respond to the user with bathing frames.

**Trigger**: User selection from the option list.

**Actors**: User and the application

**Preconditions**: The option list and the mouse input

**Proconditions**: The application bathing animation is played.

**Steps of execution:** 

1. User right click the application once

2. Application selects the option from the list.

       2.1 The option is not selectable for the user.

3. The application plays the bathing animation. 

**Extensions**:

1. The application plays different animations based on the friendship level. 

2. The application has a friendship level.






**Use Case for 4.**

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 002](https://user-images.githubusercontent.com/60747086/148118010-9ce306b6-5f29-46c6-9f3f-d778388da3b1.jpeg)

**Description**: The application will pop up a calculator window after the user's request. 

**Trigger**: User selection from the option list.

**Actors**: User and the application

**Preconditions**: The option list and the mouse input

**Proconditions**: A calculator window pops up 

**Steps of execution:** 

1. User right click the application once
2. User selects the calculator option from the list.
3. The calculator window pops up for user

**Extensions**:

1. More operation is added in the calculator
2. More tools are added into the menu.



**Use Case for 5.**

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 003](https://user-images.githubusercontent.com/60747086/148118459-502483b4-292a-4a28-8030-738d9ba43aca.jpeg)
**Description**: User is able to hide or show the application through the right click menu or tray.

**Trigger**: User selection from the option list or tray.

**Actors**: User and the application

**Preconditions**: The option list and the mouse input

**Proconditions**: The desktop pet will hide or show.

**Steps of execution:** 

1. User right click the application once

2. User selects the hide option.

3. The application disappears from the window

       3.1 The application didn’t disappear

4. User selects the show from the tray. 

5. The application shows up on the window

       5.1 The application fails to show up.

**Extensions**:

1. The application will halt every process when it is in hidden status.




**Assignment#2 GUI and Architectural Design**
# **User Interface Design** 

1. Pet UI: 


![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 004](https://user-images.githubusercontent.com/60747086/148118422-c591ceaf-7c73-494e-97ed-62bc18630198.png)

2a. We plan to make a more complete desktop pet, imitating the original electronic pet's hunger, health, mood, gold coin system, learning and growth system, adding mana to the background of the drama, movie, etc., and so on. In the end, it was made into an installable C/S architecture game, so that people who like to keep pets but can’t own pets can also have pets.


2b. We have thought about writing in multiple languages, such as C++, C#, Python, but I chose the Java that I am most familiar with. The IDE used is JetBrains Intellij IDEA, create a common Java project


# **Architectural Design**

2c. Layer Model:


![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 005](https://user-images.githubusercontent.com/60747086/148118365-e2043473-28cb-415b-a56d-c0ed7a78c283.jpeg)


2c. UI Design:


![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 006](https://user-images.githubusercontent.com/60747086/148118396-9359e1ab-b59a-480f-bf6d-7e2dfec4ce0e.jpeg)
- The Header has ‘Exit’, ‘Minimize’, and ‘Hide’ along with the name of the Desktop Pet.
- The speaking setting is a tab that displays the list of messages owned by the pet-the pet will randomly display the content of the speaking
- Show and hide can change the settings of desktop pets, for example
- Manually hide it in the background, and the user wants to show it on his monitor.
- The rules are only allowed to be seen. It will be filled when the user clicks on the pet, feeds, and bathes. After the hunger bar is full, the growth bar will also work.
- Calculator tab opens the application on the pet window.


**Assignment#3 System models and class design**
# **Relational Database schema**
1. Since our program can be executed locally, it can be operated without networking, so there is no need for database operations

# **Structural modeling**
2a. Class Diagram and Definition:

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 007](https://user-images.githubusercontent.com/60747086/148118323-803003b8-2db3-4e5b-8c1a-9a690cdc19bd.png)




2a. Generalization Hierarchies:

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 008](https://user-images.githubusercontent.com/60747086/148118291-409331c4-f5f3-4808-ac9a-999aff18e488.png)


2a. Aggregation associations:


![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 009](https://user-images.githubusercontent.com/60747086/148120107-cd933a85-3228-4f80-b875-91b672d941e5.png)




#
# **Interaction modeling**
**Sequence Diagram:**

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 010](https://user-images.githubusercontent.com/60747086/148118185-a15461a5-8b86-49fa-844e-29a29d1934bd.jpeg)

1.User drags the desktop pet on the window screen.

2.The application will stay at the location.

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 011](https://user-images.githubusercontent.com/60747086/148118214-d22ac998-f3c6-48b6-922b-a588e7ab452c.jpeg)

1. The user right clicks on the desktop pet.

2. When the menu is shown, the user can select one food item from the food list to eat

3. The desktop pet will gain its stamina after feeding.  


![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 012](https://user-images.githubusercontent.com/60747086/148120035-4820b042-bc46-40e6-ade0-3f0caf1283de.jpeg)

1. The user right clicks on the desktop pet.

2. When the menu is shown, the user can select one bath item from the bath list to bath the desktop pet.


3. The desktop pet will gain its cleanliness after feeding. 

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 013](https://user-images.githubusercontent.com/60747086/148119914-53518148-9698-4f50-854e-d651be4354f3.jpeg)

1. The user right clicks on the desktop pet.

2. When the menu is shown, the user can select the calculator and calculate with given math operations.

3. There are two types of answers (as shown in the “alt box”). The answer can be a mathematical answer or computation error. 

![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 014](https://user-images.githubusercontent.com/60747086/148119865-c2f379d8-224f-4c89-b817-025b865b1cec.jpeg)

1. There are two ways to hide the desktop pet (shown in the “alt” box). One way is to right click on the desktop pet to get the menu list and select the hide or select the hide from the system tray.

2. User can also select the show from the system tray (shown in second “alt” box)




# **						 							

**Test Plan:**

**Introduction:**

`	`It describes the plan for testing the functions of the desktop pet. This Test Plan supports the following objectives:

1. Identify existing project information and the software that should be tested.
1. List the recommended test requirements
1. Describe the testing strategies to be used
1. List the test activities

**Scope:**

`	`It describes the integration and system tests that will be conducted on the desktop pet. The interfaces that will be tested:

1. Movement of the Desktop pet
1. Open the App right away after the user requests
1. Feeding
1. Show the message that alert the user where is the desktop pet when the user uses another program



#						 						
# **Testing results** 
**Unit testing:**

Function: Move\_around()

Class: Desktop pet

Input: Position of the desktop

Expected output: Desktop pet at the given position when position is partially or fully within 

the desktop ranges

Expected output: Desktop pet rejects the request if the position is fully outside of the desktop range



#		
Function: feed ()

Class: Desktop pet

Input: Selection list

Expected output: Desktop pet’s hunger and fatigue value change if value is within the range

Expected output: Desktop pet rejects if the value will pass the limit

Expected output: Desktop pet will idle if it never receives.


#
Function: Hide() & Show()

Class: Desktop pet

Input: Selection list

Expected output: Desktop pets will be displayed or hidden according to the user's choice


#
Function: bath ()

Class: Desktop pet

Input: Selection list

Expected output: Expected output: If the value is within the range, the cleanliness and fatigue values of the desktop pet will change

Expected output: Desktop pet rejects if the value will pass the limit

Expected output: Desktop pet will idle if it never receives.


#
Function: Calculator() & Computing()

Class: Calculator

Input: Selection list

Expected output: The calculator will calculate the algorithm entered by the user

Expected output: The format for output number is double


#
Function: Exit()

Class: Desktop Pet

Input: Selection list

Expected output: Desktop pets will exit according to the user's choice

#
**Test Strategies:**

Test Objective: Ensure the proper application (calculator to be processed)

Technique: execute the use case, valid and invalid data to verify how it works

`		   `The assumption results are getting when the valid data is used

`		   `The error or warning messages would be displayed when the invalid data is used

Completion Criteria: All tests that have been planned are done

`					`All defects have been solved

Test Objective: The method of accessing will work appropriately when switching or shut 

down the app. The objects and characteristics, such as the size, position, state, 	 etc., conform the standards

Technique: Tests for each window app and application itself to get the same value that is expected

Completion Criteria: Each of them is verified successfully that could be acceptable standard



# ***Test Case*:**
**Description:** This test case simulates one of the actions that the desktop pet would perform each time when the user starts the application. The user can modify the setting of this pet.

|<p>**Step**</p><p>**Number**</p>|**Step Description**|**Expected Result**|<p>**Transaction**</p><p>**Name**</p>|
| :- | :- | :- | :- |
|**01**|Invoke the application from the desktop icon with the message shown.|Main menu screen and simple random message are displayed.|User\_input|
|**02**|Select any icon from the menu|The setting screen is displayed|Select\_menu|
|**03**|Modify the default value as the user prefers|The properties of setting would be changed and display the value on screen|Modify\_setting|
|**04**|Choose the application that the user wants|Exact applications, such as calculators are shown on the screen.|Press\_app|
|**05**|Move backward|Main menu screen is displayed|Return\_to\_main\_menu|



|**Test Case Type**|**Description**|**Test Step**|**Expected Result**|**Status**|
| :- | :- | :- | :- | :- |
|**Functionality**|<p>The message and</p><p>application that the</p><p>user wants to process</p><p>should work after the</p><p>desktop pet is started</p>|<p>Have click on</p><p>various time on</p><p>the desktop pet</p><p>icon</p>|<p>All attempts in the</p><p>request should be</p><p>appropriate</p>|<p>Pass</p><p>or</p><p>Fail</p>|
|**Security**|<p>Verify the desktop pet</p><p>is not working on</p><p>another application</p>|<p>Check the location</p><p>of desktop pet</p><p>while many</p><p>applications are</p><p>Working at the</p><p>same time</p>|<p>The desktop pet</p><p>does not disrupt any </p><p>kind of rules for </p><p>privacy</p>|<p>Pass</p><p>or</p><p>Fail</p>|
|**Usability**|<p>Ensure all icons on the</p><p>desktop pet working</p><p>properly</p>|<p>Process all icons</p><p>on the main menu</p><p>page</p>|<p>Icons will take users</p><p>to another </p><p>setting menu or </p><p>application </p><p>according to what </p><p>the icon says</p>|<p>Pass</p><p>or</p><p>Fail</p>|


# **Programming environment:**
**Programming language:** Java
**External software packages/libraries and irrolesinthedevelopmentofthe system:**  JDK 8


# **Screen shots of GUIs**			

Food Stock UI:
`	`
![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 015](https://user-images.githubusercontent.com/60747086/148119703-80a2efdd-58e2-474b-8c5e-8616c27608c4.png)
![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 016](https://user-images.githubusercontent.com/60747086/148119821-32d8ca67-ecdf-4815-8aa2-3385796fc4ae.png)

Bath Stock UI:
![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 017](https://user-images.githubusercontent.com/60747086/148119659-782cfa3d-00bb-4938-88be-76f0680deb4e.png)

Calculator UI:	
![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 018](https://user-images.githubusercontent.com/60747086/148119625-d553ac67-07b4-4e53-9d37-6d1b20cbf64d.png)

System Tray UI:		
![Aspose Words 01de2569-846a-4721-b5c5-d8374de83acd 019](https://user-images.githubusercontent.com/60747086/148119609-723fe13e-7aa6-427b-9417-bfeae9808bdb.png)

# **Data description** 
We are not using a database to store data, so we are not associated with the data


# **Ethical considerations** 
- Privacy: Apps without obtaining the user’s prior permission and providing access to the user cannot send data about the user to provide information about how and where the data is used
- Only ask for permission when you need it.
- Authorize your users to protect themselves.
- Stop increasing participation.


# **User’s Guide** 
- When the user opens the desktop pet.
- The user can click on the main body of the pet, and the pet will feedback happy actions and prompt the mood value to increase.
- The user can move the pet by pressing and holding the main body of the pet
- The user can right-click the main body of the pet, and then a small window will pop up, which displays feeding, bathing, calculator, hide, display and exit.
- When the user clicks on feeding, it will enter another layer of window-food inventory. When the user selects one of the foods, the inventory will be reduced by 1, and the eating action will be played at the same time, giving feedback information to the user, and the pet will increase the physical value. When the physical strength reaches the maximum value (100), it will no longer be able to eat and give feedback to the user.
- When the user clicks on the bath, it will enter another window-Toiletries inventory. If the user selects one of the products, the inventory will decrease by 1, and the bathing action will be played at the same time. The pet will increase the cleanliness of the pet by giving feedback to the user. When the cleanliness reaches the maximum value (100), it will no longer be able to take a bath and give feedback information to the user.
- When the user clicks the calculator function time, the calculator will pop up and the user can perform calculations by clicking the button.
- When the user clicks to hide, the pet will be hidden in the background.
- When the user clicks first, the pet will be displayed from the background.
- When the user clicks to exit, the pet will play a farewell action and feedback information to the user, and then exit the program.
- There are also functions of hiding, showing and exiting in the system tray. These functions are the same as above.
- There is self-talk in the system tray. When the user turns it on, the pet will randomly send messages to the user


# **Planning for Version 2.0**
We plan to add a cloud database in the second version, so that desktop pets can register their accounts online. And want to add the function that allows pets to work and go to school. Adding overwork will make the pet sick. After being sick, the pet needs to be treated with medication. If you plan to give up the treatment, the pet will die. I hope that the second edition will meet with you soon.**	
