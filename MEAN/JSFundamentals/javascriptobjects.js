let students = [
    {name: 'Remy', cohort: 'Jan'},
    {name: 'Genevieve', cohort: 'March'},
    {name: 'Chuck', cohort: 'Jan'},
    {name: 'Osmund', cohort: 'June'},
    {name: 'Nikki', cohort: 'June'},
    {name: 'Boris', cohort: 'June'}
];

for (let each = 0; each < students.length; each++){
    console.log("Name: ", students[each].name, " cohort: ", students[each].cohort)
}

let users = {
    employees: [
        {'first_name':  'Miguel', 'last_name' : 'Jones'},
        {'first_name' : 'Ernie', 'last_name' : 'Bertson'},
        {'first_name' : 'Nora', 'last_name' : 'Lu'},
        {'first_name' : 'Sally', 'last_name' : 'Barkyoumb'}
    ],
    managers: [
       {'first_name' : 'Lillian', 'last_name' : 'Chambers'},
       {'first_name' : 'Gordon', 'last_name' : 'Poe'}
    ]
 };

for (let i in users){
    console.log(i.toUpperCase())
    count = 1
    for(let j in users[i]){
        let get = `${count} - ${users[i][j].last_name}, ${users[i][j].first_name} - ${users[i][j].last_name.length+users[i][j].first_name.length}`;
        console.log(get)
        count += 1
        //console.log(count, " - ", users[i][j].last_name, ", ", users[i][j].first_name, "- ", users[i][j].last_name.length+users[i][j].first_name.length)
    }
}