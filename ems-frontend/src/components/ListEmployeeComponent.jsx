const ListEmployeeComponent = () => {
  const dummyData = [
    {
      id: 1,
      firstName: "Gerald",
      lastName: "Oliva",
      email: "go@gmail.com",
    },
    {
      id: 2,
      firstName: "Gerald2",
      lastName: "Oliva2",
      email: "go2@gmail.com",
    },
    {
      id: 3,
      firstName: "Gerald3",
      lastName: "Oliva3",
      email: "go3@gmail.com",
    },
  ];

  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee email</th>
          </tr>
        </thead>
        <tbody>
          {dummyData.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
