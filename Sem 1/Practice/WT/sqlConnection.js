const mysql = require(mysql);
const connection = mysql.connection({
    host: 'System',
    user: 'root',
    password: "tiger",
    port: 3306,
    database: 'testdb'
});

const tableName = 'user'

conncetion.connect((err)=>{
    if(err){
        console.error("Error connecting to database");
        return;
    }
    console.log("Successfully Connected to database");

    const createTable = "create table userInfo (id int, name varchar(15), phone int)";
    connection.query(createTable, (err, result)=>{
        if(err){
            console.error(`There is an error: ${err} `);
            return;
        }
        console.log("Table created successfully")
    })

    const insertQuery = `insert into table userInfo (name, email) values?`;
    values =[
        [1, "Alice", 1234567890],
        [2, "Bob", 9876543210],
    ]
    connection.query(insertQuery, (err, result)=>{
        if(err){
            console.error(`There is an error: ${err} `);
            return;
        }
        console.log(`${result.affectedRows} rows inserted into the table`)
    })

    const selectQuery = "select * from userInfo";
    connection.query(selectQuery, (err, result)=>{
        if(err){
            console.error(`There is an error: ${err} `);
            return;
        }
        console.log(result)
    })

    const updateQuery= "update userInfo set phone = 9098765432 where name = 'Alice'";
    connection.query(updateQuery, (err, result)=>{
        if(err){
            console.error(`There is an error: ${err} `);
            return;
        }
        console.log(`${result.affectedRows} have been updated`)
    })

    const alterTable = "alter table userInfo add email varchar(10)";
    connection.query(alterTable, (err, result)=>{
        if(err){
            console.error(`There is an error: ${err} `);
            return;
        }
        console.log(`Table has been altered`)
    })

    const deleteQuery = ""
})