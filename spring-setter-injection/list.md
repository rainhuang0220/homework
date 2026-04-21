# Spring Setter Injection Assignment - Speech Script

---

## 开场介绍

**（走向屏幕，准备展示）**

_Ladies and gentlemen, today I will demonstrate my Spring Framework assignment, which shows Setter-Based Dependency Injection using XML configuration._

---

## 第一部分：展示 GitHub 仓库和提交历史

**（打开 GitHub 仓库页面，指向 commit history）**

---

**【切换到 GitHub 仓库页面】**

_Now, let me show you my GitHub repository._

_I have pushed all my code to GitHub. As you can see in the commit history, I followed the assignment requirements strictly and made exactly five separate commits throughout the development process._

---

**【讲解第一个提交】**

_Let me walk you through each commit one by one._

_First commit is titled "Initial commit -- project setup and pom.xml". This includes the Maven configuration file pom.xml, which defines our project dependencies including Spring Framework version 5.3.30. I also added the README.md file to briefly describe the project purpose._

---

**【讲解第二个提交】**

_Second commit is "Add Address.java". This is the simple Address class with one private field called city, along with its getter and setter method. This represents the first dependency we will inject._

---

**【讲解第三个提交】**

_Third commit is "Add Student.java". This class has two private fields: name as a String primitive, and address as an object of type Address. This class also includes a display method to print both values to the console. Notice that I did not create the Address object inside this class using the new keyword._

---

**【讲解第四个提交】**

_Fourth commit is "Add applicationContext.xml with setter injection configuration". This is the core Spring XML configuration file that wires everything together. I will explain this in detail in the next section._

---

**【讲解第五个提交】**

_Fifth and final commit is "Add Main.java and confirm app runs successfully". This contains the main method that loads the Spring context from the XML file, retrieves the student bean, and calls the display method to verify everything works correctly._

_This commit-by-commit approach demonstrates proper use of Git version control. Each commit represents a logical step in the development process, making it easy to track changes and understand the project evolution._

---

## 第二部分：讲解 XML 配置文件

**（打开 applicationContext.xml 文件）**

---

**【打开 XML 文件】**

_Now let me explain the Spring XML configuration file in detail._

_First, let me explain the overall structure. At the top, we have the XML declaration with UTF-8 encoding. Then we define the beans namespace from Spring. We also include the schema location which tells Spring how to validate this XML file._

---

**【讲解 Bean 定义】**

_Now let's look at the bean definitions. Here we have two beans._

_The first bean has the ID "address" and the class "com.demo.Address". The ID is like a unique identifier that we can use to reference this bean elsewhere. The class attribute specifies which Java class this bean should instantiate. So this creates an Address object with ID "address"._

_The second bean has the ID "student" and the class "com.demo.Student". Similarly, this creates a Student object with ID "student"._

---

**【讲解 property 标签和 setter 注入原理】**

_Now, let's look at the property tags inside each bean. The property tag is the key to setter injection. When Spring sees a property tag, it calls the corresponding setter method on that bean to inject a value._

---

**【讲解 Address Bean 的 property】**

_Let's look at the address bean first. It has one property: property name="city" value="Beijing". The name attribute "city" corresponds to the setCity method in the Address class. Spring will call setCity and pass in "Beijing" as the argument. Since "Beijing" is a String primitive value, I use the value attribute to specify it._

---

**【讲解 Student Bean 的第一个 property（name）】**

_Now let's look at the student bean. It has two properties._

_The first property is name="name" value="Tom". This calls the setName method on the Student object and injects the string "Tom". Again, since it is a primitive String, we use the value attribute._

---

**【讲解 Student Bean 的第二个 property（address）】**

_The second property is name="address" ref="address". This is interesting. Here I use the ref attribute instead of value. The ref attribute tells Spring to inject another bean. In this case, I am referencing the Address bean we defined earlier by its ID. So instead of creating a new Address object, Spring injects the existing Address bean that we defined at the top. This is how object references are injected._

---

**【总结 value 和 ref 的区别】**

_Let me summarize the key difference between value and ref: value is used for primitive values like String, int, or boolean. ref is used for referencing other Spring beans, which are objects._

---

**【强调纯 XML 配置】**

_Another important point: Notice that I did not use any annotations like @Component or @Autowired in my Java classes. This assignment specifically requires XML configuration only, so all dependency injection is handled through this XML file. This is called constructor-free, annotation-free XML-based dependency injection._

---

## 第三部分：运行程序并展示输出

**（运行 Main.java，展示控制台输出）**

---

**【运行程序】**

_Now let me run the application to demonstrate that everything works correctly._

_I right-click on Main.java and select Run._

---

**【展示输出结果】**

_As you can see in the console, the output shows:_

_Student Name: Tom_

_City: Beijing_

_This confirms that both the primitive name value and the Address object reference were successfully injected through setter methods._

---

## 第四部分：解释为何不使用 new 关键字

**（指向 Student.java 中的 address 字段）**

---

**【解释依赖注入原理】**

_Finally, let me explain why we did not write "new Address()" inside Student.java._

_The answer is simple: We let Spring handle the object creation and injection through Dependency Injection. The address field is just a private variable with its setter method. Spring calls the setAddress method to inject the Address object from the XML configuration._

---

**【解释松耦合的好处】**

_This makes the code loosely coupled. Student does not need to know how the Address object is created or where it comes from. If we wanted to use a different Address implementation, we only need to change the XML configuration, not the Java code._

_This is the core benefit of Dependency Injection: separation of concerns and flexibility._

---

## 结束语

_That concludes my demonstration. Thank you for watching!_

---































## 附录：关键英文词汇对照

- Setter-Based Dependency Injection = 基于 Setter 的依赖注入
- XML Configuration = XML 配置
- Primitive Value = 基本类型值
- Object Reference = 对象引用
- Setter Injection = Setter 注入
- Bean = Bean 组件
- Loosely Coupled = 松耦合
- Dependency Injection = 依赖注入























