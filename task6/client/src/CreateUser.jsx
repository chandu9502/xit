import React, { useState } from 'react';
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
function CreateUser() {
    const[eno,setId]=useState()
    const[name,setName]=useState()
    const[email,setEmail]=useState()
    const[number,setNumber]=useState()
    const navigate=useNavigate()
    
    const submitHandler = (e) => {
        e.preventDefault();
        axios.post("http://localhost:3001/createuser", { eno, name, email, number })
            .then(response => {
                console.log(response.data);
                alert('success');
                navigate('/')
            })
            .catch(err=>console.log(err))
    };
    
    
  return (
   <div className="container align-items-center">
    <h2 className='text-center m-2'>Add User!!</h2>
    <div className='d-flex bg-warning justify-content-center mt-1 ' >
        
    <form onSubmit={submitHandler}>
     <div className="mb-3">  
     
  <label htmlFor="formGroupExampleInput" className="form-label">ID</label>
  <input type="number" name="eno" value={eno} onChange={e=>setId(e.target.value)} className="form-control" id="formGroupExampleInput" placeholder="Example id"/>
</div>
<div className="mb-3">
  <label htmlFor="formGroupExampleInput2" className="form-label">Name</label>
  <input type="text" name='name'value={name} onChange={e=>setName(e.target.value)} className="form-control" id="formGroupExampleInput2" placeholder="Enter Name"/>
</div>
<div className="mb-3">
  <label htmlFor="formGroupExampleInput2" className="form-label">Email</label>
  <input type="email" name="email"  value={email} onChange={e=>setEmail(e.target.value)} className="form-control" id="formGroupExampleInput2" placeholder="Enter email"/>
</div>
<div className="mb-3">
  <label htmlFor="formGroupExampleInput2" className="form-label">Number</label>
  <input type="number" name="number" value={number} onChange={e=>setNumber(e.target.value)} className="form-control" id="formGroupExampleInput2" placeholder="Enter Number"/>
</div>
<button className="btn btn-primary ">Submit</button>
</form>
    </div>
    </div>
  );
}

export default CreateUser;
