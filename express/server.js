const express=require('express');
const fs=require('fs');
const app=express();
app.use(express.json());
function getcourses(){
    try{
        const data=fs.readFileSync('./courses.json','utf8');
        return data.trim()?JSON.parse(data):[];
    }catch(err){
        return [];
    }
}
function savecourses(courses){
    fs.writeFileSync('./courses.json',JSON.stringify(courses,null,2));
}
app.get('/courses',(req,res)=>{
    const courses=getcourses();
    res.json(courses);
});
app.get('/courses/:id',(req,res)=>{
    const courses=getcourses();
    const course=courses.find(c=>c.id===parseInt(req.params.id));
    if(!course){
        return res.status(404).json({message:'Course not found'});
    }
    res.json(course);
});
app.post('/courses',(req,res)=>{
    const courses=getcourses();
    const maxId=courses.reduce(
        (max,course)=>Math.max(max,course.id||0),
        0
    );
    const newCourse={
        id:maxId+1,
        name:req.body.name,
        instructor:req.body.instructor,
        hours:req.body.hours,
        price:req.body.price
    };
    courses.push(newCourse);
    savecourses(courses);
    res.status(201).json(newCourse);
});
app.put('/courses/:id',(req,res)=>{
    const courses=getcourses();
    const index=courses.findIndex(c=>c.id===parseInt(req.params.id));
    if(index===-1){
        return res.status(404).json({message:'Course not found'});
    }
    courses[index]={
        ...courses[index],
        ...req.body
    };
    savecourses(courses);
    res.json(courses[index]);
});
app.delete('/courses/:id',(req,res)=>{
    const courses=getcourses();
    const id=parseInt(req.params.id);
    const filteredCourses=courses.filter(c=>c.id!==id);
    if(filteredCourses.length===courses.length){
        return res.status(404).json({message:'Course not found'});
    }
    savecourses(filteredCourses);
    res.json({message:'Course deleted successfully'});
});
app.listen(3000,()=>{
    console.log('Server running on port 3000');
});