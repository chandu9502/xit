import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams,useNavigate } from 'react-router-dom';

function UpdateUsers() {
  const { id } = useParams();
  const [eno, setId] = useState('');
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [number, setNumber] = useState('');
  const navigate=useNavigate()
  useEffect(() => {
    axios.get('http://localhost:3001/getuser/'+id)
      .then(result=> {console.log(result)
        setId(result.data.eno);
        setName(result.data.name);
        setEmail(result.data.email)
        setNumber(result.data.number)
      })
      .catch(err => console.error(err));
  }, [id]);
  const submitHandler=(e)=>{
    e.preventDefault();
    alert('success');
        axios.put("http://localhost:3001/updateuser/"+id, { eno, name, email, number })
            .then(response => {
                console.log(response.data);
                
                navigate('/')
            })
            .catch(err=>console.log(err))
  }
  return (
    <div className="container align-items-center">
      <h2 className='text-center m-2'>Update User!!</h2>
      <div className='d-flex bg-warning justify-content-center mt-1'>
        <form onSubmit={submitHandler}>
          <div className="mb-3">
            <label htmlFor="formGroupExampleInput" className="form-label">ID</label>
            <input type="number" className="form-control" id="formGroupExampleInput" value={eno} onChange={(e) => setId(e.target.value)} />
          </div>
          <div className="mb-3">
            <label htmlFor="formGroupExampleInput2" className="form-label">Name</label>
            <input type="text" className="form-control" id="formGroupExampleInput2" value={name} onChange={(e) => setName(e.target.value)} />
          </div>
          <div className="mb-3">
            <label htmlFor="formGroupExampleInput2" className="form-label">Email</label>
            <input type="email" className="form-control" id="formGroupExampleInput2" value={email} onChange={(e) => setEmail(e.target.value)} />
          </div>
          <div className="mb-3">
            <label htmlFor="formGroupExampleInput2" className="form-label">Number</label>
            <input type="number" className="form-control" id="formGroupExampleInput2" value={number} onChange={(e) => setNumber(e.target.value)} />
          </div>
          <button type="submit" className="btn btn-primary">Update</button>
        </form>
      </div>
    </div>
  );
}

export default UpdateUsers;
