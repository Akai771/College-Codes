const oracledb = require('oracledb');
const tableName = 'Employee3';

async function run() {
    const connection = await oracledb.getConnection({
        user: 'system',
        password: 'admin',
        connectString: 'localhost:1521/XE' // or your service name
    });
    
    console.log("Successfully connected to database");
    // Create table
    const createTable = `CREATE TABLE ${tableName}(
            id NUMBER GENERATED ALWAYS AS IDENTITY, 
            name VARCHAR2(100), 
            email VARCHAR2(100), 
            location VARCHAR2(100)
    )`;
        
        await connection.execute(createTable);
        console.log("Table created successfully");

        // Insert data (individual inserts in Oracle)
        const values = [
            ["A", 'a@gmail.com', "Mumbai"],
            ["B", 'b@gmail.com', "Mulund"],
            ["C", 'c@gmail.com', "Mulund"],
            ["K", 'k@gmail.com', "Delhi"],
            ["L", 'l@gmail.com', "Mulund"]
        ];

        for (const row of values) {
            await connection.execute(
                `INSERT INTO ${tableName} (name, email, location) VALUES (:1, :2, :3)`,
                row,
                { autoCommit: true }
            );
        }
        console.log(`${values.length} Rows inserted into the table`);

        // Select
        const result = await connection.execute(`SELECT * FROM ${tableName}`);
        console.log(result.rows);

        // Update
        const updateResult = await connection.execute(
            `UPDATE ${tableName} SET location='Bandra' WHERE location='Mumbai'`,
            [],
            { autoCommit: true }
        );
        console.log(`${updateResult.rowsAffected} Rows updated in the table`);

        // Delete (uncomment to use)
        // const deleteResult = await connection.execute(
        //     `DELETE FROM ${tableName} WHERE location='Delhi'`,
        //     [],
        //     { autoCommit: true }
        // );
        // console.log(`${deleteResult.rowsAffected} Rows deleted in the table`);
    await connection.close();
}

run();