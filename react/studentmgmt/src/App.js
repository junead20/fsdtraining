import React, { useState, useEffect } from "react";

function App() {
  const [students, setStudents] = useState(() => {
    const savedStudents = localStorage.getItem("students");
    return savedStudents ? JSON.parse(savedStudents) : [];
  });

  const [name, setName] = useState("");
  const [course, setCourse] = useState("");
  const [grade, setGrade] = useState("");
  const [editId, setEditId] = useState(null);

  useEffect(() => {
    localStorage.setItem("students", JSON.stringify(students));
  }, [students]);

  const addStudent = () => {
    if (
      name.trim() === "" ||
      course.trim() === "" ||
      grade.trim() === ""
    ) {
      alert("Please enter all fields");
      return;
    }

    if (editId === null) {
      const newStudent = {
        id: Date.now(),
        name,
        course,
        grade,
      };

      setStudents([...students, newStudent]);
    } else {
      setStudents(
        students.map((student) =>
          student.id === editId
            ? { ...student, name, course, grade }
            : student
        )
      );

      setEditId(null);
    }

    setName("");
    setCourse("");
    setGrade("");
  };

  const editStudent = (student) => {
    setName(student.name);
    setCourse(student.course);
    setGrade(student.grade);
    setEditId(student.id);
  };

  const deleteStudent = (id) => {
    setStudents(students.filter((student) => student.id !== id));
  };

  return (
    <div
      style={{
        maxWidth: "700px",
        margin: "40px auto",
        textAlign: "center",
        fontFamily: "Arial",
      }}
    >
      <h1>Student Management System</h1>

      <input
        type="text"
        placeholder="Student Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
        style={{ padding: "10px", margin: "5px", width: "200px" }}
      />

      <input
        type="text"
        placeholder="Course"
        value={course}
        onChange={(e) => setCourse(e.target.value)}
        style={{ padding: "10px", margin: "5px", width: "200px" }}
      />

      <input
        type="text"
        placeholder="Grade"
        value={grade}
        onChange={(e) => setGrade(e.target.value)}
        style={{ padding: "10px", margin: "5px", width: "200px" }}
      />

      <br />

      <button
        onClick={addStudent}
        style={{
          padding: "10px 20px",
          marginTop: "10px",
          cursor: "pointer",
        }}
      >
        {editId === null ? "Add Student" : "Update Student"}
      </button>

      <hr />

      <h2>Student List</h2>

      {students.length === 0 ? (
        <p>No students added.</p>
      ) : (
        <table
          border="1"
          cellPadding="10"
          style={{
            width: "100%",
            borderCollapse: "collapse",
          }}
        >
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Grade</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>{student.grade}</td>
                <td>
                  <button onClick={() => editStudent(student)}>
                    Edit
                  </button>

                  <button
                    onClick={() => deleteStudent(student.id)}
                    style={{ marginLeft: "10px" }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default App;