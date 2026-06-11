function fetchUserName(userId){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            const userName = 'User' + userId;
            resolve(userName);
        },1000);
    });
}
function fetchUserDetails(fetchUserName){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            const userDetails = {name: 'Junead', age: 21, city: 'Sangareddy'};
            resolve(userDetails);
        },1000);
    });
}
fetchUserName(1)
.then(userName=>{
    console.log('User Name:', userName);
    return fetchUserDetails(userName);
})
.then(userDetails=>{
    console.log('User Details:', userDetails);
})
.catch(error=>{
    console.error('Error:', error);
});