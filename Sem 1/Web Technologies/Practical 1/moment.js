// Using Moment.js for fetching time and date

const moment=require('moment');
const now = moment();

console.log('current data and time:',(now.format('YYYY-MM-DD HH:mm:ss')));