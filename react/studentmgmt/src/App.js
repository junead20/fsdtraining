import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';

const istudents=[{name:"Junead",age:20,grade:"S"},{name:"Aditya", age:21, grade:"A"},{name:"Sai", age:22, grade:"B"}];

function App() {

  let [students,setStudents]=useState(istudents);
  let [editIndex,setEditIndex]=useState(null);
  let [search,setSearch]=useState("")
  let [ascending,setAscending]=useState(true);
  let [formData,setFormData]=useState({name:"",age:"",grade:""});

  const handleDelete=(i)=>{
    const updatedStudents=students.filter((s,index)=>index!==i);
    setStudents(updatedStudents);
  }

  const handleChange=(e)=>{
    setFormData({...formData,[e.target.name]:e.target.value});
  }

  
  const handleAdd=()=>{
    setStudents([...students,formData]);
    setFormData({name:"",age:"",grade:""});
  }

  const handleEdit=(i)=>{
    setEditIndex(i);
    setFormData(students[i])
  }

  const handleUpdate=()=>{
    const updatedStudents=students.map((s,i)=>i==editIndex?formData:s)
    setStudents(updatedStudents)
    setEditIndex(null)
    setFormData({name:"",age:"",grade:""})
  }

  const handleSort=()=>{
    const sorted=filteredStudents.sort((a,b)=>ascending?a.name.localeCompare(b.name):b.name.localeCompare(a.name));
    setStudents(sortedStudents);
  }

  const filteredStudents=()=>students.filter((s)=>s.name.toLowerCase().includes(search.toLowerCase()))
  const sortedStudents=[...filteredStudents()].sort((a,b)=>ascending?a.name.localeCompare(b.name):b.name.localeCompare(a.name));

  return (
    <div className="App">
      <input className='form-control' name="search" value={search} placeholder='Type to search' onChange={(e)=>setSearch(e.target.value)}></input>
      <div className='form'>
        <h2>{editIndex==null?"Add Student":"Edit Student"}</h2>
        <input className='form-control m-2' name='name' placeholder='Name' value={formData.name} onChange={handleChange}></input>
        <input className='form-control m-2' name='age' placeholder='Age' value={formData.age} onChange={handleChange}></input>
        <input className='form-control m-2' name='grade' placeholder='Grade' value={formData.grade} onChange={handleChange}></input>
        {editIndex==null?<button className='btn btn-success m-3' onClick={()=>handleAdd()}>Add Student</button>
          :<button className='btn btn-primary' onClick={()=>handleUpdate()}>Update Student</button>}
      </div>
      <h2>Student List</h2>
      <table className="table table-bodered">
        <thead>
          <tr>
            <th style={{cursor:"pointer"}} onClick={()=>setAscending(!ascending)}>Name<i className={ascending?"bi bi-arrow-up":"bi bi-arrow-down"}></i></th>
            <th>Age</th>
            <th>Grade</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {sortedStudents.map((s,index)=>(
            <tr>
              <td>{s.name}</td>
              <td>{s.age}</td>
              <td>{s.grade}</td>
              <td><button className='btn btn-primary m-2' onClick={()=>handleEdit(index)}>Edit</button>
              <button className='btn btn-danger m-2' onClick={()=>handleDelete(index)}>Delete</button></td>
            </tr>
          ))}
        </tbody>

      </table>
    </div>
  );
}

export default App;