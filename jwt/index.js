const jwt=require('jsonwebtoken');
const express=require('express');
const mongoose=require('mongoose');
const app=express();
app.use(express.json());

mongoose.connect('mongodb://127.0.0.1:27017/jwt')
.then(()=>{
    console.log("Successfully connected to database");
})
.catch(err=>{
    console.log(err);
})

const userSchema=new mongoose.Schema({
    id:{
        type:Number,
        unique:true
    },
    name:String,
    email:String,
    age:Number
});
const User=mongoose.model('User',userSchema);

app.post('/login',(req,res)=>{
    const user={
        username:"Junead",
        password:"Junead_20"
    }
    const token=jwt.sign({user},"Junead_20",{expiresIn:"3000s"})
    res.json({token})
})

function verify(req,res,next){
    const bearerHeader=req.headers['authorization'];
    if(typeof bearerHeader!=='undefined'){
        const bearer=bearerHeader.split(' ');
        const bearerToken=bearer[1];
        if(bearerToken){
            jwt.verify(bearerToken,"Junead_20",(err,authData)=>{
                if(err){
                    res.status(403).json({error:"Access denied"});
                }else{
                    req.authData=authData;
                    next();
                }
            });
        }else{
            res.status(403).json({error:"Access denied"});
        }
    }else{
        res.status(403).json({error:"Access denied"});
    }
}

app.post('/api/users',verify,async(req,res)=>{
    try {
        const lastUser=await User.findOne({id:{$exists:true}}).sort({id:-1});
        const newId=(lastUser?.id || 0)+1;

        const user=new User({
            id:newId,
            name:req.body.name,
            email:req.body.email,
            age:req.body.age
        });

        await user.save();

        res.status(201).json({
            message:"User created successfully",
            user:user
        });
    } catch (err) {
        res.status(500).json(err);
    }
});

app.get('/api/users',verify,(req,res)=>{
    User.find()
    .then(users=>{
        res.status(200).json({
            message:"Users retrieved successfully",
            users:users
        })
    })
    .catch(err=>{
        res.status(500).json({
            error:err
        })
    })
})

app.get('/api/users/:id',verify,(req,res)=>{
    const id=Number(req.params.id);

    User.findOne({id:id})
    .then(user=>{
        if(!user){
            return res.status(404).json({message:"User not found"})
        }
        res.status(200).json({
            message:"User retrieved successfully",
            user:user
        })
    })
    .catch(err=>{
        res.status(500).json({
            error:err
        })
    })
})

app.delete('/api/users/:id',verify,(req,res)=>{
    const id=Number(req.params.id);

    User.findOneAndDelete({id:id})
    .then(user=>{
        if(!user){
            return res.status(404).json({message:"User not found"})
        }
        res.status(200).json({
            message:"User deleted successfully",
            user:user
        })
    })
    .catch(err=>{
        res.status(500).json({
            error:err
        })
    })
})

app.patch('/api/users/:id',verify,(req,res)=>{
    const id=Number(req.params.id);

    User.findOneAndUpdate(
        {id:id},
        {
            name:req.body.name,
            email:req.body.email,
            age:req.body.age
        },
        {new:true}
    )
    .then(user=>{
        if(!user){
            return res.status(404).json({message:"User not found"})
        }
        res.status(200).json({
            message:"User updated successfully",
            user:user
        })
    })
    .catch(err=>{
        res.status(500).json({
            error:err
        })
    })
})

app.listen(3000,()=>{
    console.log("Server is running on port 3000");
})