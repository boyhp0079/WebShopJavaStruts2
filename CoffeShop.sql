Create table Product(
	pid int IDENTITY(1,1) PRIMARY KEY,
	[name] varchar(30),
	img VARCHAR(512),
	price float,
	category varchar(30)
)

Create table Users(
	userid int IDENTITY(1,1) PRIMARY KEY,
	username varchar(30),
	[password] varchar(30),
	urole int,
)
Create table BuyLog(
	id int IDENTITY(1,1) PRIMARY KEY,
	userid int FOREIGN KEY REFERENCES Users(userid),
	pid int FOREIGN KEY REFERENCES Product(pid),
	amount int
)
  insert into Product([name],img,price,category)
  values ('Product 1','https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg',20.99,'Food'),
		('Product 2','https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg',10.99,'Drink'),
		('Product 3','https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg',15.99,'Others'),
		('Product 4','https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg',20.99,'Food'),
		('Product 5','https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg',10.99,'Drink'),
		('Product 6','https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg',15.99,'Others')
  insert into Users(username,[password],urole)
  values ('admin','1234',2),
		('user','1234',1),
		('admin2','1234',2),
		('user1','1234',1)
		
  FROM [CoffeeShop].[dbo].[BuyLog]
  insert into Buylog(userid,pid,amount)
	values(3,1,1),
		  (3,2,1),
		  (3,3,2),
		  (3,4,2),
		  (4,1,1),
		  (4,2,1),
		  (4,3,1),
		  (4,4,1)

	SELECT Users.username, Product.[name],Product.price*Buylog.amount as total,Buylog.amount
	FROM Buylog
	JOIN Users ON Users.userid = Buylog.userid
	JOIN Product ON Product.pid = Buylog.pid
	where Users.userid = 3

	  ALTER TABLE BuyLog
ADD buydate Datetime DEFAULT(getdate());