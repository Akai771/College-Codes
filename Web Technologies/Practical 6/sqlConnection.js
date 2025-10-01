const mysql = require("mysql2");
const connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "tiger",
  database: "testdb",
});

const tableName = "user";

connection.connect((err) => {
  if (err) {
    console.error(`Error connecting to database: ${err}`);
    return;
  }
  console.log("Successfully connected to the database");

  const createTable = `create table if not exists ${tableName}(id int auto_increment PRIMARY KEY, name varchar(100), email varchar(100))`;
  connection.query(createTable, (err, result) => {
    if (err) {
      console.error(
        `There is an error executing query : Create Table : ${err}`
      );
      return;
    }
    console.log("Table created successfully");
  });

  const insertQuery = `insert into ${tableName}(name,email) values?`;
  const values = [
    ["Alice", "alice@example.com"],
    ["Bob", "bob@example.com"],
  ];
  connection.query(insertQuery, [values], (err, result) => {
    if (err) {
      console.error(
        `There is an error executing query : Insert Query : ${err}`
      );
      return;
    }
    console.log(`${result.affectedRows} Rows inserted in to the table.`);
  });

  const selectQuery = `select * from ${tableName}`;
  connection.query(selectQuery, (err, result) => {
    if (err) {
      console.error(
        `There is an error executing query : Select Query : ${err}`
      );
      return;
    }
    console.log(result);
  });

  const updateQuery = `update ${tableName} set email = 'alice@gmail.com' where name = 'Alice'`;
  connection.query(updateQuery, (err, result) => {
    if (err) {
      console.error(
        `There is an error executing query : Update Query : ${err}`
      );
      return;
    }
    console.log(`${result.affectedRows} Rows updated in the table.`);
  });

  const alterQuery = `alter table ${tableName} add phone int`;
  connection.query(alterQuery, (err, result) => {
    if (err) {
      console.error(`There is an error executing query : Alter Query : ${err}`);
      return;
    }
    console.log("Table has been altered");
  });

  const deleteQuery = `delete from ${tableName} where name = 'Bob'`;
  connection.query(deleteQuery, (err, result) => {
    if (err) {
      console.error(
        `There is an error executing query : Delete Query : ${err}`
      );
      return;
    }
    console.log(
      `${result.affectedRows} Rows were affected and values were successfully deleted`
    );
  });

  const dropTable = `drop table ${tableName}`;
  connection.query(dropTable, (err) => {
    if (err) {
      console.error(`There is an error executing query : Drop Query : ${err}`);
      return;
    }
    console.log(`Table successfully deleted.`);
  });
});
