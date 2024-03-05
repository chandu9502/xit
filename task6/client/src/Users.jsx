import {useEffect, useState}from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function Users() {
    const[users,setUsers]=useState([])
    useEffect(()=>{
        axios.get('http://localhost:3001/users').then(result=>setUsers(result.data))
        .catch(err=>console.log(err))
    },[])
    const handleDelete=(id)=>{
        axios.delete('http://localhost:3001/deleteuser/'+id)
        .then(res=>{console.log(res)
        window.location.reload()})
        .catch(err=>console.log(err))
    }
  return (
    <div className="d-flex vh-100 bg-primary justify-content-center align-items-center">
        <div className='w-70 bg-white rounded p-3'>
            <Link to="/create" className='btn btn-success mb-2'>Add +</Link>
        <table className='table table-stripped'>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Number</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            {
                users.map((user)=>{
                     return( <tr key={user.eno}>
                        <td>{user.eno}</td>
                        <td>{user.name}</td>
                        <td>{user.email}</td>
                        <td>{user.number}</td>
                        <td>
                        <Link to={`/update/${user._id}`} className='btn btn-success'>Edit</Link>
                            <button className='btn btn-danger' onClick={(e)=> handleDelete(user._id)}>Delete</button>
                            </td>
                    </tr>
                     ); })
            }
        </tbody>
        </table>

      </div>
    </div>
  );
}

export default Users;
