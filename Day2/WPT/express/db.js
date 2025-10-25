const mysql = require('mysql');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',         // change if needed
  password: '',         // change if needed
  database: 'userdb'
});

connection.connect((err) => {
  if (err) {
    console.error('Database connection failed:', err.stack);
    return;
  }
  console.log('Connected to MySQL database.');
});

module.exports = connection;