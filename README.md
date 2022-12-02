# Midterm OOP

Authors: Пеняга Назарій, Петричко Віталій, Ніколайченко Іван, Омельчук Олег

### This is the solution to retrieve company data


#### Use Case Diagram (1 point) ![img.png](usage_diagram.png)

#### Class Diagram (1 point) ![img.png](class_diagram.png)

#### Code (3 points)

#### Demo (3 points)

#### Links
● Home page: http://35.209.68.86:8080<br>
● All saved companies : http://35.209.68.86:8080/company/getAll
![img.png](homepage.png)


#### Used patterns description (2 points)

Using the chain of responsibility lets us pass requests along a chain of handlers. We use three handlers (retrievers – called in our program) that, one by one, find the needed information in PDL, BrandFetch...; of course, if we don’t have this domain in our DB and stop when all data is fulfilled, in this case we get output from DB.
<br>So the next pattern is Strategy. Strategy is a behavioral design pattern that lets you define a family of algorithms and put each into a separate class. In our case, we have a family of algorithms, each of which searches for information differently.</br>
The next and last pattern is a singleton. Singleton is a creational design pattern that lets you ensure that a class has only one instance. We use a notation @Autowired that creates a single instance of a class (for example, DataService), which is, in fact, a singleton pattern.


