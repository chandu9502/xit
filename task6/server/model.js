const express=require('express')
const mongoose = require('mongoose')

const Employee=mongoose.Schema({
    eno:{
        type:Number,
        required:true
    },
    name:{
        type:String,
        required:true
    },
    email:{
        type:String,
        required:true
    },
    number:{
        type:Number,
        required:true
    },
})
module.exports=mongoose.model('emp',Employee)