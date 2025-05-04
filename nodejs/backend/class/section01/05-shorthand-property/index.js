function callProfile(profile) {
   console.log(profile);
   console.log(profile.name);
   console.log(profile.age);
}

const name = '철수';
const age = 12;

// const profile = {
//    name:name,
//    age:age,
//    createAt:createAt,
// };

//shorthand-property(key=value, value명시 생략 가능)
const profile = { name, age };

callProfile(profile);
