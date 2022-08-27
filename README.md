# JAVA
Adobe Java Bootcamp


Banuprakash C

Full Stack Architect, 

Co-founder Lucida Technologies Pvt Ltd., 

Corporate Trainer,

Email: banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/Java

===================================

Softwares Required:
1) Java 8+
	https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html

2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2022-06/r/eclipse-ide-enterprise-java-and-web-developers

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i <container_name>  bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```

Day 1

OOP ==>  real-world applications

	Object ==> state and behaviour /actions/ messages

	AC [temp, fan speed; on/off(), increase(), decrease()]
	TV [ channel, volume; on/off(), changeChannel(),,]
	Fan, Computer,...

	Object communicates with other object by sending a message.
	What messages an object can recive is exposed thro its interface.

	Template to build an object / Blue print ==> class, function, Type

	BankingAccount ==> state ==> balance; behaviour ==> credit(); debit();

SOLID design Princples:

S ==> Single Responsibility
O ==> Open Close Principle ==> Closed for Change and Open for extension
L ==> Liskov Substitution Principle
I ==> Interface seggregation
D ==> Dependency Injection ===> Inversion Of Control

===============================================================

Java ==> Technology ==> Platform Provides Apis and Runtime to execute bytecode

Bytecode ==> compiled code ; portable; architecture neutral and platform indepenent

Source Code ==> compile ==> Bytecode ==> can be taken to differenet devices and executed

Mac / Windows machine write source code ==> compile ==> bytecode ==> Settop box/ attendence swipe machine / elevator / Linux machine

source code Java [ JDK ] ==> javac ==> bytecode
Source code Kotlin [ KDK ] ==> Kotlin Compiler ==> bytecode
Source Code Groovy [ Groovy DK] ==> Groovy compiler ==> bytecode


============================================

Account.java

public class Account {
	private double balance;

	public void deposit(double amt) {
		this.balance += amt;
	}

	public double getBalance() {
		return this.balance;
	}
}

javac Account.java ==> Account.class [ Bytecode]


public class AccountTest {
	public static void main(String[] args) {
		Account rahulAcc = new Account();
		Account swethaAcc = new Account();
		rahulAcc.deposit(5000);
		System.out.println(rahulAcc.getBalance());
		swethaAcc.deposit(45000);
	}
}

javac AccountTest.java ==> AccountTest.class [bytecode]

===========

Logically grouping of Objects/classes in enterprise application

1) entity / domain / model class ==> business data ==> data which is long lived, beyond the life of application
	RDBMS/ NoSQL like MongoDB / file system

	Uber ==> Customer; Vehicle; Driver; Trip; Payment
	Swiggy ==> customer; FoodItem; Order; orderItem; Payment

	Generally entity is one per table; columns of database table ==> java fields

	Avoid writing buiness logic in entity class;
	generally entity classes will have fields; constructor; getters/setters; hashCode() and equals()

	Customer.class
	Item.class
	Order.class
	...

2) DAO classes ==> Data Access Object ==> contains CRUD operations to persistent store
	
	class CustomerDao {
		CREATE ==> insert into
		READ ==> select * from
		UPDATE ==> update table
		DELETE ==> delete table
	}

	should not contain UI or business logic code ==> Single Responsibillty

3) Service classes ==> Facade over DAO and business logic
	Normally provide more coarse graind interface to DAO fine-grained operations

	class BankingService {
		// atomic opertion
		void transferFunds(Account fromAcc, Account toAcc, double amt) {
			1) use AccountDAO ==> select balance from fromAcc;
			logic to check sufficient balance exists or not
			2) use AccountDao ==> update fromAcc
			3) use AccountDao ==> update toAcc
			4) use TransactionDAO ==> insert into transACTION table
			5) send SMS
		}
	}	

4) UI classes
	Web / Andrioid / Standalone

5) Utility classes ==> helper classes

6) Exception classes ==> to represent abnormal condition in application

==============

In java we use packages to logically group classes

packages are folders in java

=============================================================

Comments for developers who have access to code
// single line comment

/*
 multi-line comment
 
*/


JavaDoc comments ==> API comments
comments for API users; need not have access to code
/**

*/



ICICIBank application ==> VeriSign ==> APIs boolean verifyPin(pin)

============



AccountClient.java

10th line breakpoint

Debug As ==> Java Application ==> Switch

RightClick ==> AccountClient.main ==> Edit step filters ==> use step filters ==> select all


f5 and f6

once debug is complete

Perspective ==> java

===========================================

Garbage Collection

new keyword to allocate memory on heap area

we don't have "free" or "delete" to release memory ==> Garbage collector takes care of removing unused objects

GC ==> is a low priorty thread in JRE

Short term GC ==> Scavanger GC ==> Reference Handler

Full term GC ==> segment by segment lock, mark, sweep, compact ==> for every nth cycle of short term GC, long term GC runs

============

System.gc(); a request to start GC ==> not a command

rahulAcc = null;

==================================

Constructors
1) intialize the state of object
2) same name as that of class
3) can be overladed
4) compiler creates default constructor ==> NoArgs constructor if we don't write any of our own.

===============

Requirement: need to have a count of how many instances of Account is created?

static variable ==> shared by all objects of class
static methods ==> class method <className>.method() ==> "this" pointer will not be passed to static methods

to access static variable prefer writing static methods

====================================

Relationship between objects.

1) Generalization and Specialization
2) Realization
3) Association
4) Uses A 


Apply DRY ==> Don't repeat yourself


Java Development tools
* Checkstyle and PMD / FindBugs/ SpotBugs ==> SonarQube
* Maven ==> dependency management; automate running tasks
* Jenkins ==> CI/CD
* git

Checkstyle ==> static code analysis ==> coding conventions ==> Naming / whitespace / comments

PMD / FindBugs/ SpotBugs ==> static code analysis ==> good programming practices ==> empty condition statment; empty catch block; unreachable code; copy & paste code

if(condtion){

} else {
	logic
}

try {
	// logic
}catch(Exception ex){}

method() {
	return x;
	System.out.println("Hello"); unreachable code
}


 * Generalization and Specialization

 class Object {

 }

 class Product { // implicitly extends Object

 }

 class Mobile extends Product { // mobile is a specialized product

 }

 class Tv extends Product { // tv is a specialized product

 }



====

Mobile in my pocket which HAS A Tata Sky APP

========================


* constructors in Inheritance [Generalization and Specialization]

class Product { // implicitly extends Object
	public Product() {
		print P1
	}
	public Product(int id, String name) {
		print P2
	}
 }

 class Mobile extends Product { // mobile is a specialized product
 	public Mobile() {
 		print M1
 	}

 	public Mobile(int id, String name, String connectivity) {
 		print M2
 	}
 }


 new Mobile(); // ? Object(), Product () P1 , Mobile() M1

 new Mobile(123, "iPhone 13", "5G"); // ? P1, M2

=============================

Note: Constructors are not inherited

class Product { // implicitly extends Object
	public Product() {
		print P1
	}
	public Product(int id, String name) {
		print P2
	}
 }

 class Mobile extends Product { // mobile is a specialized product
 	public Mobile() {
 		print M1
 	}

 	public Mobile(int id, String name, String connectivity) {
 		super(id, name); // way to chain base class constructor
 		print M2
 	}
 }


 new Mobile(); // ? Object(), Product () P1 , Mobile() M1

 new Mobile(123, "iPhone 13", "5G"); // ? P2, M2

==============



class Product { // implicitly extends Object
	 
	public Product(int id, String name) {
		print P2
	}
 }

 class Mobile extends Product { // mobile is a specialized product
 	public Mobile() {
 		print M1
 	}

 	public Mobile(int id, String name, String connectivity) {
 		super(id, name); // way to chain base class constructor
 		print M2
 	}
 }


 new Mobile(); // ? Compiler error ==> Product doesn't have default constructor

 new Mobile(123, "iPhone 13", "5G"); // ? P2, M2

 ========================

 Methods in Inheritance


class Product { // implicitly extends Object
	 
	public double getPrice( ) {
		return 999.00;
	}
 }

 class Mobile extends Product { // mobile is a specialized product
 	public double getPrice( ) {
		return 100.00;
	}

	public String getConnectivity() {
		return "3G"
	}
 }

Mobile m = new Mobile();
m.getPrice(); // ? 100.00 ==> overriding ==> 
m.getConnectivty(); // 3G

Product p = new Mobile(); // valid ==> upcasting
p.getPrice(); // 100.00 In Java all methods are virtual by default ==> dynamic binding

p.getConnectivty(); // ERROR

======================================
connectivity.equals("4G"); if connectivity is not set ==> NullPointerException

"4G".equals(connectivity); if connectivity is not set ==> false

without upcasting:

Tv[] tvs = ....
Mobile[] mobiles = ..
WasingMachine[] wms = 
for(Tv t : tvs) {

}

for(Mobile m : mobiles) {

}

for(WasingMachime wm : wms) {

}

===

instanceof vs getClass()

Product p = new Tv(133, "Sony Bravia", 135000.00, "LED"); 

(p instanceof Tv) ==> true
(p instanceof Product) ==> true
(p instanceof Object) ==> true
(p instanceof Mobile) ==> false


(p.getClass() == Tv.class) ==> true
(p.getClass() == Product.class) ==> false
(p.getClass() == Object.class) ==> false

===========
abstract class ==> too generic ==> doesn't exist in real world
Why such a class? ==> having common state and behaviour of specialized class and appying DRY principle

public abstract class Product {

==================

public abstract boolean isExpensive(); // pure virtual functions

force all inherited classes to compulsorly override the method

========================================

* Object is the root class for every object in Java
* Java doesn't support multiple inheritance

========================================

Important methods of Object
1) toString()
2) equals()
3) hashCode()
4) wait()
5) notify()

 public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
 }

 System.out.println(p); // object passed as argument to println
// com.adobe.prj.entity.Tv@6d06d69c ==> toString()

===

for code testing we do override toString()

Product.java ==> Source ==> Generate toString()
@Override
public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
}

=====================

Object Identity

== vs equals() method

	two different objects ==> same content

	Product p1 = new Tv(133, "Sony Bravia", 135000.00, "LED");  

	Product p2 = new Tv(133, "Sony Bravia", 135000.00, "LED");  

	Product p = p1;
	
	(p1 == p2) ==> false ==> address locations are different

	(p == p1) ==> true

	int x = 10;
	int y = 10;

	x == y ==> true

	---

	(p1.equals(p2)) ==> should evaluate to true

==========

entity classes should have fields; constructor; getters; setters; hashCode and equals; toString()

==================================================
mvrepository.com

. Project Lombok 


Spice up your java: Automatic Resource Management, automatic generation of getters, setters, equals, hashCode and toString, and more!


java -jar lombok-1.18.24.jar

@Data is same as

all the below:
@Getter
@Setter
@ToString
@EqualsAndHashCode

========================



JRE and JVM

instance variables, static variables, constructors, instance methods, static methods

package

Generalization and Specialization ==> inheritance ==> extends ==> IS A Relationship

override

OCP, Lombok

===

Day 2

Generics ==> Compile time feature in Java

class Rectangle <T> {
	T width;
	T breadth;
	//
}

Generic Type is limited to Object type. can't be primitive


Rectangle<Integer> r1 = new Rectangle<Integer>(4,5);

Rectangle<Double> r2 = new Rectangle<Double>(1.4,3.5);

Rectangle<String> r3 = new Rectangle<String>("A","B");

TypeWrapper Classes: Integer, Float, Double, Character, ....

int x = 10;

Integer iX = x; // boxing

int y = iX; // unboxing



class Rectangle <T extends Number> {
	T width;
	T breadth;
	//
}

Rectangle<String> r3 = new Rectangle<String>("A","B"); // error

==========================================================================

* Realization Relationship
==> one element /object specifies the protocol/rules which other element/object implements  

interface interfaceName {
	abstract methods()
}

all methods in interface are public and abstract by default

interface EmployeeDao {
	void addEmployee(Employee e);
	Employee getEmployee(int id);
}


Why Interfaces?
1) DESiGN
2) IMPLMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE Coupling

In client code Issues with:
MobileDao mobileDao = new MobileDaoMongoImpl();

1) No abstraction
2) Switching between strategies needs changes in all client codes [web, Android, Standalone,..]

Solution: use Factory Pattern

=================================

I don't want to change any code; but switch between different strategies

Solution: Configuration files [ XML / properties / JSON /...]

Classloader loads a class if it is referenced in code

Account a = new Account();
Product p = new Mobile();

Account, Product, Mobile class are loaded into JVM

Programatically loading of classes into JVM

Class.forName("java.util.Date"); // loads Date class into JVM

================================================

interface Dance {
	dance();
}

interface Swim {
	swim();
}

interface Fight {
	fight();
}

// Actor is capable to Dance
class Actor implements Dance {
	dance() {
		///
	}
}

// Hero is a actor; knows to dance
class Hero extends Actor implements Swim, Fight {
	fight() {}
	swim() {}
}

=============================================

interface Flyable {
	void fly();
}

class Bird implements Flyable {
	//state
	// behaviour
	public void fly() {
		// wings
	}
}


class AeroPlane implements Flyable {
	// state
	// behaviour
	public void fly() {
		// engine
	}
}

Bird eagle = new Bird();
Bird crow = new Bird();

AeroPlane boeing = new AeroPlane();

---
I just need fly(); i don't have extra state and behaviour ==> Should I create a Class?

Don't do this:
class Dummy1 implements Flyable {
	public void fly() {
		//
	}
}

class Dummy2 implements Flyable {
	public void fly() {
		//
	}
}

Solution: Anonymous class

Flyable f = new Flyable() {
	public void fly() {
		jump from 10th floor
	}
};

f.fly();

=================================================

Java Collection Framework
 ==> Provides data container
 Array is a data container; should be the first choice
 Limitations:
 1) Size is fixed
 2) adding / removing from arbitrary position is difficult
 3) contiguos memory location

 JCF has:
 1) interfaces
 2) implementation class
 3) Algorithm classes / Utility class

Compare objects:
Comparable vs Comparator

1) Comparable is for natural comparision ==> String ==> Lexical ordering; why not lengthwise?
Employee ==> based on id
Product ==> based on id

2) Comparable logic is part of class itself [ String has compareTo, Product has compareTo]

int compareTo(Object other) {

}

obj1.compareTo(obj2);


--
Comparator
1) comparision based on client requirement ==> different fields
2) logic is part of client code

compare(Object o1, Object o2){

}

compare(o1,o2);

===========

List is a data container:
1) ordered
2) supports index based operations
3) supports duplicate elements
4) re-ordered ==> sort, shuffle, reverse


List list = new ArrayList();
or
List list = new LinkedList();

Avoid
ArrayList list = new ArrayList();

---
Not Typesafe collection:
List list = new ArrayList();
list.add("a");
list.add(22);
list.add(new Date());

if( list.get(2) instanceof Date) {
	Date d = (Date) list.get(2);
}

Use Generic collections --> TypeSafe Collection
List<Product> products = new ArrayList<Product>();

=====================

High Order Functions are functions which accept functions as argument

java 8 streams

* HOF on stream
1) filter ==> accepts Predicate Function
2) map ==> Function to transform
3) forEach ==> Consumer
4) reduce ==> aggregate
5) collect
6) skip
7) flatMap
8) limit
....

https://rxmarbles.com/

Functional Interfaces ==> interfaces with only one method to implement ==> can use lambda


public interface Predicate<T> {
	 boolean test(T t);
}

public interface Function<T, R> {
	 R apply(T t);
}

public interface Consumer<T> {
	void accept(T t);
}

Intermediary functions:
map, filter, skip, limit

Terminal functions:
collect, forEach, reduce


==============

Set data container
* Not ordered ==> ordering dependens on which type of implementation
* no duplicates
* index based operation is not supported

Set <--- HashSet
Set <-- TreeSet
Set <-- LinkedHashSet

================

HashSet ==> uses hashCode() and equals() to identify duplicates and for ordering elements in container

HashCode:
* Number representation of Object
* similar objects should have same hashcode 
* Possibility is objects which are not similar can also have same hashcode


bad hashcode

public class Rectangle {
	public int hashCode() {
		return width * breadth;
	}
}

Rectangle 4,5 ==> 20
Rectangle 5,4 ==> 20
Rectangle 10,2 ==> 20
Rectangle 2,10 ==> 20
Rectangle 20,1 ==> 20
Rectangle 1,20 ==> 20

===========

Map is a Key/value pair
* Dictionary
* Registry

key ==> unique
value ==> can be duplicate

HashMap

=========

Task:
TreeSet, PriorityQueue , ArrayBlockingQueue

========================================

Annotation ==> metadata

1) Who uses It? ==> Compiler / ClassLoader / Runtime 
2) Where can I apply it? ==> class level / method level / constructor / fields / parameters

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}


==> after compilation ==> @Override info is removed from .class file

public class Product {
	isExpensive() {}
}

public class Mobile extends Product {
	isExpensives() { // I assumed override implmentation

	}
}

Early Detection: @Override

public class Product {
	isExpensive() {}
}

public class Mobile extends Product {
	@Override
	isExpensives() { // Compilation error

	}
}

=============================================


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Mobile {
	String type();
}

@Mobile(type="samsung")
public class PubG extends Game {
	// code
}

Samung ==> Custom ClassLoader ==> check @Mobile ==> decide to load into mobile or not

Settop box, Tv ==> custom classloader

======================

We don't write our own compiler and classloaders we can write annotations to be used by RUNTIME

Simulate ORM ==> Object Relational Mapping

generate DDL and DML based on annoations

===

Methods:
name();

Property ==> getter and setters

name = "A";
x = name();

=======================

Spring, ORM, Testing Library

======================

public class Demo {
	@Test()
	m1() {

	}

	@Test()
	m2() {

	}

	m3() {

	}
}

Using Reflection aPI and annotation, invoke methods which have @Test

================

JDBC and Web Development, Maven

https://sqlzoo.net/

Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers.

Docker images:


docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql
 
Above:
mysql ==> image
local-mysql ==> name of the container
-e ==> environment variable
-p ==> expose:actualport

---

docker exec -it local-mysql bash

# mysql -u "root" -p
Enter Password: Welcome123

 
mysql> create database sample_db;
Query OK, 1 row affected (0.01 sec)

mysql> use sample_db;
Database changed
mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name varchar(50), price double, category varchar(50));
Query OK, 0 rows affected (0.05 sec)

mysql> insert into products values (0, 'iPhone 13', 120000.00, 'mobile');
Query OK, 1 row affected (0.03 sec)

mysql> insert into products values (0, 'Samsung OLED', 135000.00, 'tv');
Query OK, 1 row affected (0.01 sec)

mysql> select * from products;
+----+--------------+--------+----------+
| id | name         | price  | category |
+----+--------------+--------+----------+
|  1 | iPhone 13    | 120000 | mobile   |
|  2 | Samsung OLED | 135000 | tv       |
+----+--------------+--------+----------+

==============

Day 3

Recap:

Realization Relationship; interface

* class implements interface
* one class can implement multiple interfaces
* interface can extend another interface
* Anonymous classes ==> creating objects of interface / abstract class by defining abstract methods inline
* Lambda expression ==> if interface is @FunctionalInterface [ interface with only one method to implement]
we can use Lambda instead of Anonymous class.
Depending on the context Lambda can just a function or an object of interface.

products.stream().filter(p -> p.getCategory().equals("tv"))

Predicate will not be a object of interface Predicate, rather just a function on stack

* JCF ==> Comparable and Comparator; Arrays and Collections; List, ArrayList and LinkedList
	Set, HashSet, Map, HashMap

* stream ==> HOF; map, filter, reduce, forEach, collect, flatMap,skip, limit, ...

* Annotation; 
	RetentionPoilcy decides who has to use the annotation ==> COMPILER, CLASSLOADER, RUNTIME
	Where can i apply? TARGET ==> TYPE, METHOD, FIELD, constructor, ..

* Docker, installed MySQL container

============================================================================

Exceptions and ExceptionHandling

Exception: any abnormal condition that arises during program execution. In Java Exception is an object
* What went wrong?
* Why?
* Where?

Custom DefaultExceptionHandler per thread
```

public class Example {

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler((t,ex) -> {
			System.out.println("Boom: -("  + ex.getMessage());
		});
		System.out.println("Hello!!!");
			doTask();
		System.out.println("Bye!!!");
	}

	private static void doTask() {
		int x = 10;
		int y = 0;
		int res = x / y;
		System.out.println("Result " + res);
	}

}

```

Exceptions can be classified as Unchecked and Checked type of exception

Throws keyword to inform caller that certain type of exception might occur when a method is called:

```
public class Example {

	public static void main(String[] args) {
		System.out.println("Hello!!!");
			try {
				doTask();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		System.out.println("Bye!!!");
	}

	private static void doTask() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("a.txt");
		System.out.println("Result ");
	}

}
```

JDBC ==> Java Database connectivity ==> integration APIs ==> RDBMS
JDBC provides set of interfaces; implmentation classes are provided by database vendors [oracle, mySQL,Postgress] ==> provided in the form of "jar" files

String name; ==> Oracle ==> VARCHAR2
String name; ==> MySQL ==> VARCHAR
String name; ==> SQLServer ==> TEXT

Steps:

1) Load database vendor provided classes in "jar" into JVM

Class.forName("driverName");
Class.forName("oracle.jdbc.Driver");
Class.forName("com.mysql.jdbc.Driver");

Driver names generally will be in properties file
DRIVER=com.mysql.jdbc.Driver

2) Establish a database connection

Connection con = DriverManager.getConnection(URL, USERNAME, PWD);

getConnection() is a factory method; based on URL it creates MySQLConnection / OracleConnection /..
java.sql.Connection is a interface

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@154.123.32.17:1521:sample_db", "scott", "tiger");

Connection con = DriverManager.getConnection("jdbc:mysql://154.123.32.17:3306/sample_db", "root", "Welcome123");

3) SEND SQL statements [ Avoid DDL; use only DML]
3 interfaces 
3.1) Statement
	if SQL is fixed; same SQL for all request
	Example: select * from products
3.2) PreparedStatement
	If SQL needs IN parameters
	Example: select * from products where id = ?
	insert into users values (? , ?, ? , ?)

	Avoid: using Statement by String concatination =>
	 String SQL = "select * from products where id =" + id;

	String query = "SELECT * FROM accounts WHERE custID='" + request.getParameter("id") + "'";
	http://example.com/app/accountView?id=' or '1'='1

	"SELECT * FROM accounts WHERE custID= or 1 = 1"

3.3) CallableStatement
	to invoke StoredProcedures of RDBMS

	create procedure transactions (....)
		select
		update
		update 
		insert
	end procedure

	Java:
	call{{transctions(...)}}

==
Statement and PreparedStatement has 2 methods to Send SQL:
1) int executeUpdate(SQL); // insert, delete and update ==> returns no of rows effected
2) ResultSet exceuteQuery(SQL); // select 
===

ResultSet is a cursor to snapshot of records fetched

4) Release resources in finally block ==> close DB connection

============================

Maven ==> build tool; manage dependencies; automate running task; clean, build, package, deploy

ANT, Gradle

Project Structure ==> Std ==> easily import in different IDEs

===================================

Any changes to pom.xml
Maven ==> update project ==> Force Update ==> OK


drop table products;

create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, quantity int);

insert into products values (0, 'iPhone 13', 98000.00, 100);



https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml

================

JEE --> Java Enterprise Edition
* Web components
* JNDI
* Enterprise Java Bean [ RMI-IIOP]
* JMS
* MailService

Java Web Components:
* Servlet Technology
1) Servlet
2) Filter
3) Listeners
5) JSP

===

* Client makes a request
* picks a thread for the client from thread pool
* for each request [ HttpServletRequest and HttpServletResponse objects are created]
* Request object encapsulates data from client [ client specific + Browser data + OS data]
* Response object is used to write back to client
* request and response objects are injected to Servlet based on URL pattern; servlet uses them process the data and uses
response to write back to client
* Engine destroyes "request" and "response" objects created for the client
* Thread is released back to the pool


public class LoginServlet implements Servlet {
	
}

OR

public class LoginServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)  {

  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)  {

  }
}
 
HTTP methods:
GET ==> request from Address bar or Hyperlink ==> get resource
POST ==> client sends payload to server [ form data]
PUT
PATCH
DELETE
OPTIONS
TRACE

===

Configure:
Deployment Descriptor ==> web.xml

<servlet>
	<servlet-name>First</servlet-name>
	<servlet-class>com.adobe.prj.web.LoginServlet</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>First</servlet-name>
	<url-pattern>/login</url-pattern>
</servlet-mapping>

without web.xml and using annotations:

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)  {

  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)  {

  }
}

http://localhost:8080/login

==============================

Servlet engines to execute Servlet
* Tomcat
* Jetty

Servlet api ==> Jar which contains HttServelt, HttpServletREquest, ...

===

War Plugin
<packaging>war</packaging>

mvn package ==> database.war

<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
	<scope>provided</scope>
</dependency>

Above dependices are required for compilation ==> don't include them in final bundle [ jar / war]
these dependences are provided by engine [ jetty / tomcat]


<scope>test</scope>

==
```
<form action="/products" method="post">
		Name <input type="text" name="name" /> <br />
		Price <input type="number" name="price"> <br />
		Quantity <input type="number" name="qty"> <br />
		<button type="submit">Add Product</button>
</form>

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {

	}
}

===
<a href="products">Get Products</a>

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

	}
}

```

Right click project==> Run As ==> Maven Build
Goals: jetty:run
or
Goals: jetty:run -Djetty.http.port=9999

http://localhost:8080

==============

JSP ==> templates [ static + dynamic content]

JSP ==> JSPC ==> Servlet ==> servlet is deployed on Servlet engine

Similar to:
ASP
ASP.NET
Jinja2
EJS
Mustache
HandleBars

=========

MVC Architecure ==> Self Learn

========================================

* JDBC ==> Integration API to connect to RDBMS ==> Connection, DriverManager, Statement, PreparedStatement and ResultSet

* JEE - Web application development ==> Servlet Container / Web Container / Servlet engine
	Servlet Technology ==> Servlet / JSP / Filter / Listener

* MVC --> Model View Controller
	Model ==> Business data and logic
	View ==> HTML, CSS , JS and JSP
	Controller => Servlet ==> only application logic [ flow of application]

================

Day 4

Spring Framework and Java Persistence API [ORM] Framework

* Spring Framework  
1) Lightweight container for building enterprise applications
Spring Container at the core provides Life-Cycle management of a bean and Dependency Injection [ InversionOfControl]

Java 1.2 ==> Bean is a re-usable software component
Spring ==> Bean is an object managed by Spring Container

2) EAI ==> Enterprise application Integration
	Spring acts like framework of frameworks
3) Simplifies Web application development ==> MVC Architecure
4) Supports Declarative Transaction
5) AOP ==> Aspect Oriented Programming
and many more...


Metadata for Spring can be in XML or Annotation

```
public interface EmployeeDao {
	void addEmployee(Employee e);
}

public class EmployeeDaoJdbcImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		... JDBC 
	}
}


public class EmployeeDaoFileImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		... FileOutputStream
	}
}

public class SampleService {
	private EmployeeDao empDao;
	public void setEmployeeDao(EmployeeDao edao) {
		this.empDao = edao;
	}

	public void insert(Employee e) {
		this.empDao.addEmployee(e);
	}
}

===

beans.xml

<beans>
	<bean id="jdbc" class="com.adobe.prj.dao.EmployeeDaoJdbcImpl" />
	<bean id="file" class="com.adobe.prj.dao.EmployeeDaoFileImpl" />
	<bean id="service" class="com.adobe.prj.service.SampleService">
		<property name="employeeDao" ref="jdbc" />
	</bean>
</beans>

```

Constructor DI:
```
public class SampleService {
	private EmployeeDao empDao;
	public SampleService(EmployeeDao edao) {
		this.empDao = edao;
	}

	public void insert(Employee e) {
		this.empDao.addEmployee(e);
	}
}

<beans>
	<bean id="jdbc" class="com.adobe.prj.dao.EmployeeDaoJdbcImpl" />
	<bean id="file" class="com.adobe.prj.dao.EmployeeDaoFileImpl" />
	<bean id="service" class="com.adobe.prj.service.SampleService">
		<constructor-arg index="0" ref="jdbc" />
	</bean>
</beans>
```

====

Using Annotation in Spring; Spring instantiates classes which has one of these annotations at class level
1) @Component
2) @Repository
3) @Service
4) @Configuration
5) @Controller
6) @RestController

Spring wires dependencies using @Autowired

```

public interface EmployeeDao {
	void addEmployee(Employee e);
}

@Respository
public class EmployeeDaoJdbcImpl implements EmployeeDao {
	public void addEmployee(Employee e) {
		... JDBC 
	}
}
 
@Service
public class SampleService {

	@Autowired
	private EmployeeDao empDao;
	
	public void insert(Employee e) {
		this.empDao.addEmployee(e);
	}
}
```

@Autowired ==> Bytecode Instrumentation ==> ByteBuddy or JavaAssist or CGLib



Spring Boot Framework ==> Framework on top of Spring Framework ==> simplfies development
This is highly opiniated framework where lots of configurations comes out of the box

Examples of when highly opiniated:
1) If we choose to integrate with ORM; Spring Boot configures Hibernate as ORM
2) Create database pool of connections using HikariCP
	DriverManagerConnectionPool, c3p0, HikariCP
3) For Web application development:
	3.1) configures Tomcat out of the box as embedded server
	3.2) Java <--> JSON ==> Jackson Library
		other options; GSON ; Gettison; Moxy

=============


SpringApplication.run(DemoApplication.class, args);
creates a Spring Container

@SpringBootApplication
1) @ComponentScan
	scans for above mentioned 6 annotations and creates objects of them	

	scan from existing package [com.example.demo] and sub-packages

You can expclitly mention different packages
	@ComponentScan(basePackages={"com.adobe", "com.user"})

2) @EnableAutoConfiguration
	this creates instances of built-in utilities provided in jar files [ helpers]

3) @Configuration

============

Problem:
	@Autowired
	private EmployeeDao employeeDao;

Field employeeDao in com.example.demo.service.SampleService required a single bean, but 2 were found:
	- employeeDaoJdbcImpl: defined in file [ EmployeeDaoJdbcImpl.class]
	- employeeDaoMongoImpl: defined in file [ EmployeeDaoMongoImpl.class]

Solution 1: @Primary

@Primary
@Repository
public class EmployeeDaoMongoImpl implements EmployeeDao {

;;

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

----

Soultion 2: @Qualifer

@Repository("jdbc")
public class EmployeeDaoJdbcImpl implements EmployeeDao {

@Repository("mongo")
public class EmployeeDaoMongoImpl implements EmployeeDao {


@Service
public class SampleService {
	@Autowired
	@Qualifier("jdbc")
	private EmployeeDao employeeDao;

===========================


Solution 3: @Profile


@Profile("prod")
@Repository("mongo")
public class EmployeeDaoMongoImpl implements EmployeeDao {

@Profile("dev")
@Repository("jdbc")
public class EmployeeDaoJdbcImpl implements EmployeeDao {


@Service
public class SampleService {
	@Autowired
	private EmployeeDao employeeDao;

application.properties
spring.profiles.active=prod

OR
Command Line Argument

DemoApplication ==> Run As => Run Configuration ==> Arguments ==> Program Arguments
--spring.profiles.active=prod

===========================================

We have 3rd party classes to be wired into Spring application; these classes doesn't have any of the above mentioned "6" annotations

===========================

ORM and JPA

Object Relational Mapping ==> ORM 
Framework on top of JDBC for CRUD operations 
Based on Mapping ==> ORM generates SQL and uses JDBC to interact with database

ORM frameworks:
1) Hibernate
2) TopLink
3) EclipseLink
4) JOOQ
5) JDO
and many more..

JPA ==> Java Persistence API is a specification for ORM

if we are using Spring Framework and not Spring Boot with JPA

```
@Configuration
public class AppConfig {
	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver"); // loads the jdbc driver
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/sample_db");
		cpds.setUser("root");
		cpds.setPassword("Welcome123");
		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		return cpds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean emf(DataSource ds) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJPAVendor(new HibernateJPAVendor());
		emf.setPackagesToScan("com.adobe.prj.entity");
		emf.setDataSource(ds);
		..
		return emf;
	}
}


@Respository
public class ProductDaoJdbcImpl implements ProductDao {
	@PersistenceContext
	EntityManager em;

	public void addProdict(Product p) {
 		em.persist(p);
	}

	public Product getProduct(int id) {
 		return em.find(Product.class , id);
	}
}

```
==================


Spring Boot with Spring Data JPA

application.properties needs DB related config ==> Spring Data JPA creates DataSource, EntityManagerFactory,..

spring.jpa.hibernate.ddl-auto=update

* If table exists for class mapping use it
* if required alter column
* if table doesn't exist create table

---

spring.jpa.hibernate.ddl-auto=create

* every time application runs drop and re-create tables ==> good for testing

---

spring.jpa.hibernate.ddl-auto=verify

* map to existing tables in DB; if no mapping table found ==> error


==================


spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

em.find(Product.class , id);

log SQL generated for ORM operation

========

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

em.find(Product.class , id); has to generate SQL compatable to MySQL8

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle9Dialect

=======

using Spring Data JPA

public interface ProductDao extends JpaRepository<Product, Integer>{
	
}

internally a @Repository class implementing this interface is generated by SpringDataJPA
which contains methods for CRUD operations

===

OrderApp 

entities
* Customer
* Product
* Order
* Item
* Address
* Payment

=====

Order has 4 items

em.persist(o);
em.persist(i1);
em.persist(i2);
em.persist(i3);
em.persist(i4);

---

em.delete(o);
em.delete(i1);
em.delete(i2);
em.delete(i3);
em.delete(i4);


==============

Cascade
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="order_fk")
private List<Item> items = new ArrayList<>();

em.persist(o); ==. persists order and all its items

em.delete(o); ==> delete order and all its items

In fact with this apporach i don't need ItemDAO

=====================

Order looks like :

{
	"customer": {"email": "b@adobe.com"}, // login
	"items" : [
		{"product": {id: 2}, qty: 3},
		{"product": {id: 1}, qty: 1},
	]
}

====

Association:
ManyToOne ==> EAGER Fetch by default
select
        order0_.oid as oid1_2_,
        order0_.customer_fk as customer4_2_,
        order0_.order_date as order_da2_2_,
        order0_.total as total3_2_ 
    from
        orders order0_
Hibernate: 
    select
        customer0_.email as email1_0_0_,
        customer0_.first_name as first_na2_0_0_,
        customer0_.last_name as last_nam3_0_0_ 
    from
        customers customer0_ 
    where
        customer0_.email=?

OneToMany ==> Lazy Fetch by default

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name="order_fk")
private List<Item> items = new ArrayList<>();

===============================================================

Task 1:

Movie
id
name
year_of_release


Customer
email
name


MovieReview

review_id | movie_id | comments | customer_email | comment_date

Use case :
1) add movie
2) add customer
3) review movie

-----

Task 2:

Customer
email
name


Vehicle
reg_no
type
cost_per_day

Driver
licence_no
name

Rental
rental_id
customer_fk
driver_fk
rented_from_date
rented_return_date

Use case:
1) add customer from database
2) add vehicle from database
3) add driver from database

* Rent a Vehilce
	rental_id   customer_fk   driver_fk   rented_from_date    rented_return_date
	12          a@adobe.com   UP12A45     19-08-2022          NULL
	use System date from rented_from_Date

* Return a Vehicle
	select retntals based on id
	and set rental_return_date ==> system date ==> Dirty checking

============================================



ORM ==> Object Relational Mapping
JPA ==> Java Persistence API
Spring, Spring Boot and Spring Data JPA

interface MovieDao extends JpaRepository<Movie, Integer> {
	// by default all methods for CRUD operations are supported
}

@Transactional
method() {
	1) any entity pulled from backend, if it undergoes a change ; automatically it
	is updated to DB ==> dirty checking

	2) opertions within this method is atomic ==> If no exception occurs; commit else rollback

	3) place where we need to perform custom ADD, DELETE or Update => other than built-in JpaRepository methods
}

@OneToMany
@ManyToOne

Foreign Key mapping in Java ==> @JoinColumn

=================================================================

Day 5

Composite PK

@Embeddable
public class Name implements Serializable {
	private String firstName;
	private String lastName;
	private String middleName;
	...
}


@Entity
@Table(name="users")
public class User {
	@EmbeddedId
	private Name name; // firstName, | lastName | middleName ==> Composite PK
}

=================================

RESTful Web services

REpresentational State Transfer 

* Resource ==> Any info on server which has a name

* State of Resource at any particular time is Representation
==> the data
==> metadata

* Representation can be served in various formats ==> XML / JSON / CSV/ ...

---

* Use Nouns to represent a resource [ "customers" , "products", "orders"]

* Use HTTP methods for verbs [ CRUD operations]

GET ==> get resources
POST ==> create a new resource
PUT ==> modify a resource
DELETE ==> remove a resource

Example:

1)
GET
http://localhost:8080/api/products
 get all products

2) use path variable for resource based on ID or sub-resource

GET
http://localhost:8080/api/products/4
get product whose id is "4"

GET
http://localhost:8080/api/custoemrs/banu@gmail.com/orders

get all orders of "banu@gmail.com"

3) use Query parameters (?) for filter

GET
http://localhost:8080/api/products?page=1&size=20
http://localhost:8080/api/products?low=1000&high=5000

4) 
POST
http://localhost:8080/api/products

Payload from client contains new product data to be added to "products" resources

5) 
PUT
http://localhost:8080/api/products/3
Payload from client contains new product data to be update to "products" resources whose id is "3"

6) 
DELETE
http://localhost:8080/api/products/3

delete products resource whose id is "3"

----------

GET and DELETE ==> No Payload ==> Safe to use methods

PUT and POST ==> contains payload ==> Not Safe methods

=================================

@RestController
@RequestMapping("api/products")
class ProductController {

	@GetMapping()
	m1() {}

	@PostMapping() 
	m2() {}

	@PutMapping() 
	m3() {}
}



@RestController
@RequestMapping("api/orders")
class OrderController {

	@GetMapping()
	m1() {}

	@PostMapping() 
	m2() {}

	@PutMapping() 
	m3() {}
}


===

Http Headers:

Accept: application/json

This is to inform the server that payload should be sennt by the server to client in "json" format


Accept: text/xml
This is to inform the server that payload should be sent by the server to client in "xml" format

====

Content-type:application/json
this is to inform the server that payload sent by client is "json" to server

=============================================

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

including above depdencny "spring boot" confures:
1) Tomcat embedded web server running on port 8080
if you need to use any other port
application.properties
server.port=9999

2) includes "Jackson" libraries for HttpMessage Handlers
Java <--> JSON

================
Browser:

http://localhost:8080/api/products
http://localhost:8080/api/products/2
http://localhost:8080/api/orders

http://localhost:8080/api/products?low=100&high=1000


POSTMAN:

=======================

Order in JSON:

{
  "customer": {"email": "a@adobe.com"},
   "items" : [
   	{"product": {"id": 1}, "qty": 1},
   	{"product": {"id": 5}, "qty": 2},
   	{"product": {"id": 3}, "qty": 5}
   ]
}

===

"orderDate":"2022-08-22T08:46:07.392+00:00"

after application.properties
spring.jackson.date-format=dd-MMMM-yyyy hh:mm

"orderDate":"19-August-2022 10:43"

=======================

	products

	pid   name  quantity ver
	23    A     102       0


	User 1:
		select * from products where id = 23;

		Buys 2 products

		update products set qty = 100, ver = ver + 1 where ver = 0 and id = 23;
	User 2:
		select * from products where id = 23;

		Buy 1 product

		update products set qty = 99, ver = ver + 1 where ver = 0 and id = 23;


Assume User 2 commits first

	products

	pid   name  quantity   ver
	23    A     101         1


 User 1 trys to commit:
 	SQL fails because version is already changed ==> StaleObject

================

Rental Application:
New Spring Starter Project with ==> lombok, MysQL, jpa and web dependinces

==========================
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;
	
	private String name;
	
	private String client;
	
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;
	
}



{
  "name": "ICICI Dashboard",
  "client": "ICICI",
   "startDate": "12-03-2022",
   "endDate": "30-12-2022"
}

============

Complete the employee Project app;
1) adding employee
	EmployeeDao, ProjectManagementService, EmployeeController

2) Assign Employee to Project
	{
		"employee": {"eid": 135},
		"project": {"projectId": 1},
		"role": "Team Lead",
		"startDate": "...",
		"endDate": "...."
	}

===================

Exceptions and RestController

OrderService:
public Product getProductById(int id) throws ResourceNotFoundException {
	  Optional<Product> opt = productDao.findById(id);
	  if(opt.isPresent()) {
		  return opt.get();
	  } else {
		  throw new ResourceNotFoundException("Product with id " + id + " doesn't exist!!!");
	  }
}

@Transactional
	public Product updateProduct(int id, double price) throws ResourceNotFoundException {
		productDao.updateProduct(id, price); // Custom Query ==> ProductDao
		return getProductById(id);
}

===

ProductController:
@GetMapping("/{id}")
public @ResponseBody Product getProduct(@PathVariable("id") int id) throws ResourceNotFoundException {
		return service.getProductById(id);
}


@PutMapping("/{id}")
public @ResponseBody Product update(@PathVariable("id") int id, @RequestBody Product p) throws ResourceNotFoundException {
	return service.updateProduct(id, p.getPrice());
}

===


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("message", ex.getMessage());
		body.put("status", "404");
		body.put("timestamp", new Date());
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	}
}

===

 
http://localhost:8080/api/products/25


{"message":"Product with id 25 doesn't exist!!!","status":"404","timestamp":"22-August-2022 10:57"}

===

Validation:

Validation to POST method

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>

 

Common Validation Annotations
Some of the most common validation annotations are:

@NotNull: to say that a field must not be null.
@NotEmpty: to say that a list field must not empty.
@NotBlank: to say that a string field must not be the empty string (i.e. it must have at least one character).
@Min and @Max: to say that a numerical field is only valid when it’s value is above or below a certain value.
@Pattern: to say that a string field is only valid when it matches a certain regular expression.
@Email: to say that a string field must be a valid email address.

Product.java
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Name is required")
	private String name;
	
	@Min(value=10, message = "Price ${validatedValue} should be greater than {value}")
	private double price;
	
	@Min(value=1, message = "Quantity ${validatedValue} should be greater than {value}")
	private int quantity;

===========

@Validated
public class ProductController {
	@PostMapping()
	public  ResponseEntity<Product>  addProduct(@RequestBody @Valid Product p) {
		 service.addProduct(p);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}

===
POSTMAN:
POST  http://localhost:8080/api/projects

{
   "name": "",
   "price": -34,
   "quantity": 0
}

Console:
DefaultHandlerExceptionResolver : 
 MethodArgumentNotValidException: com.adobe.prj.api.ProductController.addProduct(com.adobe.prj.entity.Product) with 3 errors: 

 [Field error in object 'product' on field 'name': rejected value []; codes [NotBlank.product.name,NotBlank.name,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.name,name]; arguments []; default message [name]]; default message [Name is required]] 

 [Field error in object 'product' on field 'price': rejected value [-34.0]; codes [Min.product.price,Min.price,Min.double,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.price,price]; arguments []; default message [price],10]; default message [Price -34.0 should be greater than 10]] 

 [Field error in object 'product' on field 'quantity': rejected value [0]; codes [Min.product.quantity,Min.quantity,Min.int,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.quantity,quantity]; arguments []; default message [quantity],1]; default message [Quantity 0 should be greater than 1]] ]



	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, Object> body = new LinkedHashMap<>();
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());
		
		body.put("errors",errors);
		body.put("status", "400");
		body.put("timestamp", new Date());
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	}

{
    "errors": [
        "Price -34.0 should be greater than 10",
        "Quantity 0 should be greater than 1",
        "Name is required"
    ],
    "status": "400",
    "timestamp": "22-August-2022 11:20"
}

=======================================

Need to pass data for product without using validation

class ProductDTO {
	name
	price
}

{
	"name": "",
	"price": 
}

addProductDTO(ProductDTO dto) {

}

====

EmployeeProject.java
{
		"employee": {"eid": 135},
		"project": {"projectId": 1},
		"role": "Team Lead",
		"startDate": "...",
		"endDate": "...."
}

instead of that 

public class EmployeeProjectDTO {
	int eid;
	int pid;
	String role;
	Date startDate;
	Date endDate;
}

--------

{
		"eid": 135,
		"pid": 1,
		"role": "Team Lead",
		"startDate": "...",
		"endDate": "...."
}

within Controller:

copy from DTO to EmployeeProject

================

Testing and Security


Day 6

Bi-directional Relationship





@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {
	@Id
	private String email;
	
	@Column(name="first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name="last_name", length = 50)
	private String lastName;
}



@Entity
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
	 	
	@ManyToOne()
	@JoinColumn(name = "customer_fk")
	private Customer customer;



===

Doing bi-directional ==> mention JoinColumn in ManyToOne side and in OneToMany(mappedby="field")

=================================

Propagation
* REQUIRED
* REQUIRES_NEW
* SUPPORTED
* NOT_SUPPORTED
* NEVER


By default Propagation is REQUIRED

@Transactional
m1() {

	m2()
}


@Transactional(REQUIRES_NEW)
m2() {

}

================

Ordering

TxType REQUIRED is best option
adding Order and items and updating product should be in a single transcation

@Transactional
public void placeOrder(Order o) {
	...
	updateProduct(p);
}

@Transactional
public void updateProduct(Product p) {

}

====

Holiday 

@Transactional
public void bookings(..) {
	bookFlight();
	bookHotel();
	bookCruise();
}

@Transactional(REQUIRES_NEW)
bookFlight() {

}


@Transactional(REQUIRES_NEW)
bookHotel() {

}


@Transactional(REQUIRES_NEW)
bookCruise() {

}

==================

* OneToMany
* ManyToOne
* OneToOne
* ManytoMany

----

@Component
@Service
@RestController
@Configuration

---

Spring Data JPA ==> no need for @Respository ==> SDJ genrates classes for JPARepository interface

we can write custom methods in interface with @Query [ @Modifying ==> custom insert, delete and update queries]==> can use JPQL or SQL

---

Normally @Transactional ==> @Service code

-------------

@Controller ==> Traditional web applications ==> Server Side REndering with JSP pages
@Controller returns JSP page

@Controller
@RequestMapping("/test")
public class SampleController {

	@GetMapping()
	public String doTask() {
		// logic
		return "print.jsp";
	}
}

----------

@RestController
@RequestMapping("api/products")
public class ProductController {

	@GetMapping()
	public @ResponseBody List<Product> getProducts() {

	}
}

@ResponseBody will convert List<Product> to XML or JSON based on Accept:application/json

* @RestController
* @RequestMapping
* @ResponseBody
* @RequestBody
* @PathVariable
* @RequestParam
* @GetMapping()
* @PostMapping()
* @PutMapping()
* @DeleteMapping()

* @ControllerAdvice
* @ExceptionHandler

* ResponseEntity ==> ResponseBody + additional headers

===========

Testing
* Unit testing ==> JUnit and TestNG
* Integration testing
* End-to-End Testing
* UAT


====


public class Utility {
	public static int findSum(int[] elems) {
		int result = 0;
			for (int i = 0; i < elems.length; i++) {
				result += elems[i];
			}
		return result;
	}
}



public class UtilityTest {
 	@Test
	public void testFindSum() {
		int[] data = {5,4,1};
		int expected = 10;
		assertEquals(expected, Utility.findSum(data));
	}
}


=============
AAA ==> Assemble Action Assert

Unit testing RestController

Testing modules with dependencies

* Spring Testing provides:
1) Mockito ==> Mocking library [ EasyMock and JMock are alternative Mocking library]
2) JsonPath ==> test JSON response
3) hamcrest ==> assertion library

============
 
public class Math {
	public static double PI = 3.14159;

}


import static pk.Math.PI;

class Sample {
	m() {
		area = PI * 2 * radius;
	}
}

==============================

Documentation of REST APIs

* RAML
/books:
  /{bookTitle}:
    get:
      description: Retrieve a specific book title
      responses:
        200:
          body:
            application/json:
              example: |
                {
                  "data": {
                    "id": "SbBGk",
                    "title": "Stiff: The Curious Lives of Human Cadavers",
                    "description": null,
                    "datetime": 1341533193,
                    "genre": "science",
                    "author": "Mary Roach",
                    "link": "http://e-bookmobile.com/books/Stiff"
                  },
                  "success": true,
                  "status": 200
                }

* Swagger -> open API

<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-ui</artifactId>
	<version>1.6.7</version>
</dependency>

http://localhost:8080/swagger-ui/index.html

JSON-docs + UI using jQuery

http://localhost:8080/v3/api-docs

@Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Adobe Order application")
                        .description("RESTful  API")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Arun")
                                .url("https://adobe.com")
                                .email("me@gmail.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }

https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html
https://springdoc.org/

application.properties
springdoc.paths-to-match=/api/*


@RestController
@RequestMapping("/admin")
public class AdminController {

}

===================

CROSS ORIGIN REQUEST

@CrossOrigin()
public class ProductController {

================================================================

Spring Security

* Authorization
* Authenctication
* ExceptionHandling

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>

by including security dependency we get:
1) login page [ http://localhost:8080/login]
2) logout page [ http://localhost:8080/logout ]
3) all resources are protected resources
4) creates a single user with username => "user" and generated passwrod
Using generated security password: 66bdcd71-8369-4fbc-958e-6e1795a82c9a


Cookie: JSESSIONID: 4E7AD4167ED937F7637B2C4653B10BBE

4E7AD4167ED937F7637B2C4653B10BBE

======

DelegatingProxyFilter ==> UsernameAndPasswrodAuthenticationFilter ==> attemptAuthentication()
==> reads username and password => creates Authentication object ==> passed to AuthenticationManager authenticate() Builtin [ JDBCAuthenticationManager, InMemory, LDAP ] ==> successfulAuthentiation()
==> stores Authenication object in SecurityContext identified by JSESSIONID / user
sends JSESSIONID as Cookie to the browser.

Subsequent requests ==> Cookie is sent by Browser ==> Filter checks SecurityContext with this JSessionID
and validates

========================

jdbcauth.zip ==> extract

Eclipse ==> import ==> General ==> Existing projects into workspace ==> select "jdbc" extracted folder

https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/appendix-schema.html

create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);


===

H2 --> In Memory database
When application runs: it executes
1) schema.sql
2) data.sql

https://bcrypt-generator.com/

Characteristics of RESTful web services is 
* Stateless
* Client-server 

====

Token based authentication

JSON Web Tokens

application.jwt.secretKey=securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecure
application.jwt.tokenPrefix=Bearer 
application.jwt.tokenExpirationAfterDays=10



Header
Accept: application/json
content-type:application/json
Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

==============
 

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

//  @Value("${application.jwt.secretKey}")
    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;
 @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(this.getSecretKey().getBytes());
    }

============

Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn0seyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV0sImlhdCI6MTY2MTI0ODA2OSwiZXhwIjoxNjYyMDU3MDAwfQ.mmF1iGsI1aqKEhEr6Cr0ZZ7COPFjz9C6kRfZW3cOCw9RbexL7tn3Tex-Ffebu9dQRa1U-dlIGh7uT9ElnUS5Jg

===========================


Mini-Project perspective

RESTful API

* RestController
* Service
* JpaRepository interfaces ==> custom queries ==> joins ==> DTO
* Prefer DTO if issue with direct handling of @Entity
* Prefer DTO to carry data from backend to JSON ==> where it can have joined table data

* Swagger OpenAPI ==> Spring Restful Documentantion
* Use POSTMAN to test
* At least one RestController do unit testing ==> Mockito, Hamcrest, JUnit, Jsonpath

* Always validated input data ==> @Min @Max @Future @Past @NotBlank

* globalException handler @ExceptionHandler

* JWT for security 

====================





