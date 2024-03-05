const express=require('express')
const app=express()
const cors=require('cors')
app.use(cors())
const Employee=require('./model')
const mongoose=require('mongoose')
app.use(express.json())
mongoose.connect('mongodb+srv://chandu2002:chandu2002@cluster0.n1mep3k.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0')
.then(()=>{console.log('DB Connected...')}).catch((err)=>{console.log(err.message)})
app.post('/createuser',(req,res)=>{
        Employee.create(req.body)
        .then(users=>res.json(users))
        .catch(err=>res.json(err))
})
app.get('/users',(req,res)=>{
    Employee.find({})
    .then(users=>res.json(users))
    .catch(err=>console.log(err))
})
app.get('/getuser/:id',(req,res)=>{
    const id=req.params.id
    const data=Employee.findById({_id:id})
    .then(users=>res.json(users))
        .catch(err=>res.json(err))
    
})
app.put('/updateuser/:id',(req,res)=>{
    const id=req.params.id;
    Employee.findByIdAndUpdate({_id:id},{eno:req.body.eno,
        name:req.body.name,
        email:req.body.email,
        number:req.body.number
    })
    .then(users=>res.json(users))
        .catch(err=>res.json(err))
    
})
app.delete('/deleteuser/:id',(req,res)=>{
    const id=req.params.id;
    Employee.findByIdAndDelete({_id:id})
    .then(users=>res.json(users))
        .catch(err=>res.json(err))
})
app.listen(3001,()=>console.log('Server running..'))