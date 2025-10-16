const mysql = require("mysql2/promise");

(async () => {
  const connection = await mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "System",
    database: "testdb",
  });

  console.log("Successfully connected to the database");

  const tableName = "user";

  try {
    await connection.query(`CREATE TABLE IF NOT EXISTS ${tableName}(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))`);
    console.log("Table created successfully");

    const result = await connection.query(`INSERT INTO ${tableName}(name,email) VALUES ?`, [[["Alice", "alice@example.com"], ["Bob", "bob@example.com"]]]);
    console.log(`${result[0].affectedRows} Rows inserted`);

    const [rows] = await connection.query(`SELECT * FROM ${tableName}`);
    console.log(rows);

    const updateResult = await connection.query(`UPDATE ${tableName} SET email = 'alice@gmail.com' WHERE name = 'Alice'`);
    console.log(`${updateResult[0].affectedRows} Rows updated`);

    await connection.query(`ALTER TABLE ${tableName} ADD phone INT`);
    console.log("Table altered");

    const deleteResult = await connection.query(`DELETE FROM ${tableName} WHERE name = 'Bob'`);
    console.log(`${deleteResult[0].affectedRows} Rows deleted`);

    await connection.query(`DROP TABLE ${tableName}`);
    console.log("Table deleted");
  } catch (err) {
    console.error(`Error: ${err}`);
  } finally {
    await connection.end();
  }
})();