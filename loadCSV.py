from Lib import csv
import pymysql
import pymysql.cursors
#import mysql.connector

def bills_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS bills")
	sql = "CREATE TABLE bills(ID int, total_price int, tip float)"
	cursor.execute(sql)
	add_new_row = "INSERT INTO bills (ID, total_price, tip) VALUES (%s, %s, %s)"
	with open('Bills.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1], row[2])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load bills Complete")
bills_connection()

def includes_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS includes")
	sql = "CREATE TABLE includes(bill_ID int, item VARCHAR(50), quantity int)"
	cursor.execute(sql)
	add_new_row = "INSERT INTO includes (bill_ID, item, quantity) VALUES (%s, %s, %s)"
	with open('Includes.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1], row[2])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load includes Complete")
includes_connection()

def bars_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS bars")
	sql = "CREATE TABLE bars(name VARCHAR(100), location VARCHAR(50), opening_hours VARCHAR(10), closing_hours VARCHAR(10))"
	cursor.execute(sql)
	add_new_row = "INSERT INTO bills (ID, total_price, tip) VALUES (%s, %s, %s, %s)"
	with open('Bars.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1], row[2], row[3])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load bars Complete")
bars_connection()

def billed_to_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS billed_to")
	sql = "CREATE TABLE billed_to(bill_ID int, drinker VARCHAR(50))"
	cursor.execute(sql)
	add_new_row = "INSERT INTO billed_to (bill_ID, drinker) VALUES (%s, %s)"
	with open('Billed_to.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load billed_to Complete")
billed_to_connection()

def drinkers_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS drinkers")
	sql = "CREATE TABLE drinkers(name VARCHAR(50), address VARCHAR(50))"
	cursor.execute(sql)
	add_new_row = "INSERT INTO drinkers (name, address) VALUES (%s, %s)"
	with open('Drinkers.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load drinkers Complete")
drinkers_connection()

def frequents_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS frequents")
	sql = "CREATE TABLE frequents(drinker VARCHAR(50), bar VARCHAR(50))"
	cursor.execute(sql)
	add_new_row = "INSERT INTO frequents (drinker, bar) VALUES (%s, %s)"
	with open('Frequents.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load frequents Complete")
frequents_connection()

def issues_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS issues")
	sql = "CREATE TABLE issues(bill_ID int, bar VARCHAR(50), time VARCHAR(50), day VARCHAR(50))"
	cursor.execute(sql)
	add_new_row = "INSERT INTO issues (bill_ID, bar, time, day) VALUES (%s, %s, %s, %s)"
	with open('Issues.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1], row[2], row[3])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load issues Complete")
issues_connection()

def items_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS items")
	sql = "CREATE TABLE items(name VARCHAR(50), manufacturer VARCHAR(50))"
	cursor.execute(sql)
	add_new_row = "INSERT INTO items (name, manufacturer) VALUES (%s, %s)"
	with open('Items.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load items Complete")
items_connection()

def sells_connection():
	db = pymysql.connect('jake-thomas-database.cb00wwcerjsx.us-east-2.rds.amazonaws.com',
	'StinkyboyNtoad','pleaseTakeMySocks','CS336Project', 3306)

	cursor = db.cursor()
	cursor.execute("DROP TABLE IF EXISTS sells")
	sql = "CREATE TABLE sells(bar VARCHAR(50), item VARCHAR(50), price int)"
	cursor.execute(sql)
	add_new_row = "INSERT INTO sells (bar, item, price) VALUES (%s, %s, %s)"
	with open('Sells.csv', 'r') as csvFile:
		csv_data = csv.reader(csvFile, delimiter = ",")
		
		firstLine = True
		for row in csv_data:
			if firstLine:
				firstLine = False
				continue
			val = (row[0], row[1], row[2])
			cursor.execute(add_new_row,val)
	db.commit()
	cursor.close()
	print("Load sells Complete")
sells_connection()