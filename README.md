# Automation testing using REST Assured and Cucumber


<br>

![alt text](https://clickup.com/landing/images/integrations/clickup-api-beta.png)

## Testing REST API basic functionality for ClickUp Api

Full documentation - https://clickup.com/api
<br>
<br>

**Prerequisites**

- JDK 11^
- Maven 3.6.1^

**Project setup**

- clone repository<br>
- open as maven project & reload project <br>
- add build configuration [test] <br>
- run test <br>


**RestApi Functionality tested:**

- ability to create new folder using space ID (assert if created with right name)
- ability to get and save folder ID and name
- ability to create new list using folder ID (assert if created with right name and in correct folder)
- ability to get and save list ID, name, folder ID and task count
- ability to add task using list ID (assert if created with right name)
- ability to get and save task ID and name
- ability to delete task (assert if task has been deleted)
